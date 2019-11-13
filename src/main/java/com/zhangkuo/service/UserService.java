package com.zhangkuo.service;

import com.github.pagehelper.PageInfo;
import com.zhangkuo.entity.User;

/** 

* @author 作者 zk: 

* @version 创建时间：2019年11月13日 下午1:12:31 

*/
public interface UserService {

	PageInfo<User> getPageList(String name, Integer page);

	User getUserById(Integer userId);

	int updateStatus(Integer userId, int status);
	
}
