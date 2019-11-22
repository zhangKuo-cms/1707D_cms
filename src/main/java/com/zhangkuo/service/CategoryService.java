package com.zhangkuo.service;

import java.util.List;

import com.zhangkuo.entity.Category;

/** 

* @author 作者 zk: 

* @version 创建时间：2019年11月14日 下午7:22:51 

*/
public interface CategoryService {

	/**
	 * 获取分类
	 * @param chnId  频道id
	 * @return
	 */
	List<Category> listByChannelId(int chnId);

}
