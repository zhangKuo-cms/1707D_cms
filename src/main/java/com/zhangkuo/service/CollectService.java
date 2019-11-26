package com.zhangkuo.service;

import javax.validation.Valid;

import com.github.pagehelper.PageInfo;
import com.zhangkuo.entity.Collect;

/** 

* @author 作者 zk: 

* @version 创建时间：2019年11月25日 下午3:19:34 

*/
public interface CollectService {

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
	Collect get(int id);

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
	int update(Collect collect);

	/**
	 * 
	 * @param collect
	 * @return
	 */
	int add(Collect collect);

}
