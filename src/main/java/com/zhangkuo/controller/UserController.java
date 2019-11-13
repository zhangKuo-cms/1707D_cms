package com.zhangkuo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** 

* @author 作者 zk: 

* @version 创建时间：2019年11月12日 下午1:26:47 

*/
@Controller
@RequestMapping("user")
public class UserController {
	
//	@Autowired
//	UserService userService;
	
	@RequestMapping("test")
	public String test(HttpServletRequest request) {
		request.setAttribute("info", "这是一个测试网页");
		return "test";
	}
	
}
