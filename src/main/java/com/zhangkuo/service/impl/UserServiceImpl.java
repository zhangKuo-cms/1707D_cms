package com.zhangkuo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhangkuo.common.CmsAssert;
import com.zhangkuo.common.ConstantClass;
import com.zhangkuo.common.Md5;
import com.zhangkuo.dao.UserMapper;
import com.zhangkuo.entity.User;
import com.zhangkuo.service.UserService;

/** 

* @author 作者 zk: 

* @version 创建时间：2019年11月13日 下午1:42:03 

*/
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;
	
	@Override
	public PageInfo<User> getPageList(String name, Integer page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, ConstantClass.PAGE_SIZE);
		return new PageInfo<User>(userMapper.list(name));
	}

	@Override
	public User getUserById(Integer userId) {
		// TODO Auto-generated method stub
		return userMapper.getById(userId);
	}

	@Override
	public int updateStatus(Integer userId, int status) {
		// TODO Auto-generated method stub
		return userMapper.updateStatus(userId, status);
	}
	
	@Override
	public User findByName(String username) {
		// TODO Auto-generated method stub
		return userMapper.findByName(username);
	}

	@Override
	public int register(User user) {
		// TODO Auto-generated method stub
		User existUser = findByName(user.getUsername());
		CmsAssert.AssertTure(existUser==null, "该用户名已经存在");
		
		//加盐
		user.setPassword(Md5.password(user.getPassword(),
				user.getUsername().substring(0,2)));
		return userMapper.add(user);
	}

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		User loginUser = findByName(user.getUsername());
		if (loginUser==null) {
			return null;
		}
		//计算加盐后的密码
		String pwdSaltMd5 = Md5.password(user.getPassword(),
				user.getUsername().substring(0,2));
		//数据库中密码与用户输入的密码一致  则登录成功
		if (pwdSaltMd5.equals(loginUser.getPassword())) {
			return loginUser;
		}
		//登陆失败
		return null;
	}
}
