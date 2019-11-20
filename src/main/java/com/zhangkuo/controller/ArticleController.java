package com.zhangkuo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhangkuo.entity.Article;
import com.zhangkuo.service.ArticleService;

/** 

* @author 作者 zk: 

* @version 创建时间：2019年11月14日 下午7:39:22 

*/
@Controller
@RequestMapping("article")
public class ArticleController {
	
	@Autowired
	ArticleService articleService;
	
	//查看文章详情
	@RequestMapping("showdetail")
	public String showDetail(HttpServletRequest request,Integer id) {
		Article article = articleService.getById(id);
		request.setAttribute("article", article);
		return "article/detail";
	}
}
