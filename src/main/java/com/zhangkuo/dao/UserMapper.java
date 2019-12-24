package com.zhangkuo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zhangkuo.entity.User;

/** 

* @author 作者 zk: 

* @version 创建时间：2019年11月13日 下午1:42:40 

*/
public interface UserMapper {

	List<User> list(String name);

	User getById(Integer userId);

	@Update("UPDATE cms_user SET locked=${status} WHERE id=${userId}")
	int updateStatus(@Param("userId")Integer userId, 
			@Param("status")int status);

	@Select("SELECT * FROM cms_user WHERE username = #{value} limit 1 ")
	User findByName(String username);

	int add(User user);
	
}
