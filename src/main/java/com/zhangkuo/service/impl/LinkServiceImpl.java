package com.zhangkuo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhangkuo.dao.LinkMapper;
import com.zhangkuo.entity.Link;
import com.zhangkuo.service.LinkService;

/** 

* @author 作者 zk: 

* @version 创建时间：2019年11月25日 下午7:32:42 

*/
@Service
public class LinkServiceImpl implements LinkService {

	@Autowired
	LinkMapper linkMapper;
	
	@Override
	public PageInfo list(int page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, 10);
		
		return new PageInfo<Link>(linkMapper.list());
	}

	@Override
	public Link get(int id) {
		// TODO Auto-generated method stub
		return linkMapper.get(id);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return linkMapper.delete(id);
	}

	@Override
	public int update(Link link) {
		// TODO Auto-generated method stub
		return linkMapper.update(link);
	}

	@Override
	public int add(Link link) {
		// TODO Auto-generated method stub
		return linkMapper.add(link);
	}

}
