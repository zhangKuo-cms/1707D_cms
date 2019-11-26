package com.zhangkuo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.zhangkuo.common.CmsAssert;
import com.zhangkuo.common.MsgResult;
import com.zhangkuo.entity.Article;
import com.zhangkuo.entity.Category;
import com.zhangkuo.entity.Comment;
import com.zhangkuo.service.ArticleService;
import com.zhangkuo.service.CategoryService;

/** 

* @author 作者 zk: 

* @version 创建时间：2019年11月14日 下午7:39:22 

*/
@Controller
@RequestMapping("article")
public class ArticleController {
	
	@Autowired
	ArticleService articleService;
	
	@Autowired
	CategoryService categoryService;
	
	//查看文章详情
	@RequestMapping("showdetail")
	public String showDetail(HttpServletRequest request,Integer id) {
		Article article = articleService.getById(id);
		CmsAssert.AssertTrueHtml(article!=null, "文章不存在");
		request.setAttribute("article", article);
		return "article/detail";
	}
	
	@RequestMapping("getCategoryByChannel")
	@ResponseBody
	public MsgResult getCategoryByChannel(int chnId) {
		List<Category> categories = categoryService.listByChannelId(chnId);
		return new MsgResult(1,"",categories);
	}
	
	@RequestMapping("commentlist")
	public String commentlist(HttpServletRequest request,int id,
			@RequestParam(defaultValue = "1")int page) {
		PageInfo<Comment> pageComment = articleService.commentlist(id, page);
		request.setAttribute("pageComment", pageComment);
		return "article/comments";
	}
}
