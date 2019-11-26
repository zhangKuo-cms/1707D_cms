package com.zhangkuo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhangkuo.controller.CollectController;
import com.zhangkuo.dao.CollectMapper;
import com.zhangkuo.entity.Collect;
import com.zhangkuo.service.CollectService;

/** 

* @author 作者 zk: 

* @version 创建时间：2019年11月25日 下午7:39:11 

*/
@Service
public class CollectServiceImpl implements CollectService {

	@Autowired
	CollectMapper collectMapper;
	
	@Override
	public PageInfo list(Integer userId, int page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, 10);
		return new PageInfo<Collect>(collectMapper.list(userId));
	}

	@Override
	public Collect get(int id) {
		// TODO Auto-generated method stub
		return collectMapper.get(id);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return collectMapper.delete(id);
	}

	@Override
	public int update(Collect collect) {
		// TODO Auto-generated method stub
		return collectMapper.update(collect);
	}

	@Override
	public int add(Collect collect) {
		// TODO Auto-generated method stub
		return collectMapper.add(collect);
	}

}
