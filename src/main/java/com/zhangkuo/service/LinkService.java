package com.zhangkuo.service;

import javax.validation.Valid;

import com.github.pagehelper.PageInfo;
import com.zhangkuo.entity.Link;

/** 

* @author 作者 zk: 

* @version 创建时间：2019年11月25日 下午2:57:55 

*/
public interface LinkService {

	PageInfo list(int page);

	Link get(int id);

	int delete(int id);

	int update(Link link);

	int add(Link link);
	
}
