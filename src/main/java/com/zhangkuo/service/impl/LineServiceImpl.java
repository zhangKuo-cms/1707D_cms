package com.zhangkuo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhangkuo.dao.LineMapper;
import com.zhangkuo.entity.Line;
import com.zhangkuo.service.LienService;

/** 

* @author 作者 zk: 

* @version 创建时间：2019年11月25日 下午7:32:42 

*/
@Service
public class LineServiceImpl implements LienService {

	@Autowired
	LineMapper linkMapper;
	
	@Override
	public PageInfo list(int page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, 10);
		
		return new PageInfo<Line>(linkMapper.list());
	}

	@Override
	public Line get(int id) {
		// TODO Auto-generated method stub
		return linkMapper.get(id);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return linkMapper.delete(id);
	}

	@Override
	public int update(Line link) {
		// TODO Auto-generated method stub
		return linkMapper.update(link);
	}

	@Override
	public int add(Line link) {
		// TODO Auto-generated method stub
		return linkMapper.add(link);
	}

}
