package com.zhangkuo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhangkuo.controller.CollectionController;
import com.zhangkuo.dao.CollectionMapper;
import com.zhangkuo.entity.Collection;
import com.zhangkuo.service.CollectionService;

/** 

* @author 作者 zk: 

* @version 创建时间：2019年11月25日 下午7:39:11 

*/
@Service
public class CollectionServiceImpl implements CollectionService {

	@Autowired
	CollectionMapper collectMapper;
	
	@Override
	public PageInfo list(Integer userId, int page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, 10);
		return new PageInfo<Collection>(collectMapper.list(userId));
	}

	@Override
	public Collection get(int id) {
		// TODO Auto-generated method stub
		return collectMapper.get(id);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return collectMapper.delete(id);
	}

	@Override
	public int update(Collection collect) {
		// TODO Auto-generated method stub
		return collectMapper.update(collect);
	}

	@Override
	public int add(Collection collect) {
		// TODO Auto-generated method stub
		return collectMapper.add(collect);
	}

}
