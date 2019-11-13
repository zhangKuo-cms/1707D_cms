package com.zhangkuo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.zhangkuo.common.MsgResult;
import com.zhangkuo.entity.User;
import com.zhangkuo.service.UserService;

/** 

* @author 作者 zk: 

* @version 创建时间：2019年11月13日 上午11:25:47 

*/
@Controller
@RequestMapping("admin")
public class AdminController {
	
	@Autowired
	UserService userService;
	
	/**
	 * 首页
	 * @return
	 */
	@RequestMapping("index")
	public String index() {
		return "admin/index";
	}
	
	/**
	 * 文章列表
	 * @return
	 */
	@RequestMapping("articles")
	public String articles() {
		return "admin/articles/list";
	}
	
	/**
	 * 用户列表
	 * @param request
	 * @param name
	 * @param page
	 * @return
	 */
	@RequestMapping("user")
	public String user(HttpServletRequest request,
			@RequestParam(defaultValue = "")String name,
			@RequestParam(defaultValue = "1")Integer page) {
		 PageInfo<User> pageInfo = userService.getPageList(name,page);
		 request.setAttribute("info", pageInfo);
		return "admin/user/list";
	}
	
	@RequestMapping("lockuser")
	@ResponseBody
	public MsgResult lock(Integer userId, int status) {
		
		if (status != 0 && status != 1) {
			return new MsgResult(2, "参数无效", null);
		}
		
		User user = userService.getUserById(userId);
		
		if (user == null) {
			return new MsgResult(2, "用户不存在", null);
		}
		
		if (user.getLocked() == status) {
			return new MsgResult(2, "不需进行该操作", null);
		}
		
		int result = userService.updateStatus(userId,status);
		if (result>0) {
			return new MsgResult(1, "恭喜！处理成功!", null);
		}else {
			return new MsgResult(1, "非常抱歉，处理失败！请和管理员联系 ！", null);
		}
	}
}
