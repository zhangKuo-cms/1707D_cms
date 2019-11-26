package com.zhangkuo.service;

import javax.validation.Valid;

import com.github.pagehelper.PageInfo;
import com.zhangkuo.entity.Collection;

/** 

* @author 作者 zk: 

* @version 创建时间：2019年11月25日 下午3:19:34 

*/
public interface CollectionService {

	/**
	 * 
	 * @param id
	 * @param page
	 * @return
	 */
	PageInfo list(Integer userId, int page);

	/**
	 * 
	 * @param id
	 * @return
	 */
	Collection get(int id);

	/**
	 * 
	 * @param id
	 * @return
	 */
	int delete(int id);

	/**
	 * 
	 * @param collect
	 */
	int update(Collection collect);

	/**
	 * 
	 * @param collect
	 * @return
	 */
	int add(Collection collect);

}
