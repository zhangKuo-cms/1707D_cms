package com.zhangkuo.service;

import javax.validation.Valid;

import com.github.pagehelper.PageInfo;
import com.zhangkuo.entity.Line;

/** 

* @author 作者 zk: 

* @version 创建时间：2019年11月25日 下午2:57:55 

*/
public interface LienService {

	PageInfo list(int page);

	Line get(int id);

	int delete(int id);

	int update(Line link);

	int add(Line link);
	
}
