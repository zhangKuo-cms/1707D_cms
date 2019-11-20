package com.zhangkuo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhangkuo.dao.CategoryMapper;
import com.zhangkuo.entity.Category;
import com.zhangkuo.service.CategoryService;

/** 

* @author 作者 zk: 

* @version 创建时间：2019年11月14日 下午7:54:56 

*/
@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryMapper categoryMapper;
	
	@Override
	public List<Category> listByChannelId(int chnId) {
		// TODO Auto-generated method stub
		return categoryMapper.listByChannelId(chnId);
	}
	
}
