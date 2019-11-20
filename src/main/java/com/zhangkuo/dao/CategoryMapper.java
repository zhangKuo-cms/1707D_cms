package com.zhangkuo.dao;

import java.util.List;

import com.zhangkuo.entity.Category;

/** 

* @author 作者 zk: 

* @version 创建时间：2019年11月14日 下午8:06:11 

*/
public interface CategoryMapper {

	/**
	 * 获取分类
	 * @param chnId
	 * @return
	 */
	List<Category> listByChannelId(int chnId);

}
