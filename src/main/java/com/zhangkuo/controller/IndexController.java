package com.zhangkuo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.zhangkuo.entity.Article;
import com.zhangkuo.entity.Category;
import com.zhangkuo.entity.Channel;
import com.zhangkuo.entity.Line;
import com.zhangkuo.service.ArticleService;
import com.zhangkuo.service.CategoryService;
import com.zhangkuo.service.ChannelService;
import com.zhangkuo.service.LienService;

/** 

* @author 作者 zk: 

* @version 创建时间：2019年11月14日 下午6:36:40 
* TODO

*/
@Controller
public class IndexController {
	
	@Autowired
	ChannelService channelService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ArticleService articleService;
	
	@Autowired
	LienService linkService;

	/**
	 * 
	 * @param request
	 * @param chnId  频道id
	 * @param page  文章页码
	 * @return
	 */
	@RequestMapping("channel")
	public String channel(HttpServletRequest request,
			@RequestParam(defaultValue = "1")int chnId,
			@RequestParam(defaultValue = "0")int categoryId,
			@RequestParam(
					defaultValue = "1")int page) {
		request.setAttribute("chnId", chnId);
		request.setAttribute("categoryId", categoryId);
		
		//获取最新频道
		List<Channel> channels = channelService.list();
		request.setAttribute("channels", channels);
		
		//获取这个频道下的所有分类
		List<Category> categories = categoryService.listByChannelId(chnId);
		request.setAttribute("categories", categories);
		//获取这个分类下的所有文章
		PageInfo<Article> articles = articleService.listByCat(chnId,categoryId,page);
		request.setAttribute("articles", articles);
		
		return "channelindex";
	}
	
	@RequestMapping(value = {"index","/"})
	public String index(HttpServletRequest request,HttpServletResponse response, @RequestParam(defaultValue = "1") int page) {
		
		//获取所有的频道
		List<Channel> channels = channelService.list();
		request.setAttribute("channels", channels);
		
		//获取热门文章
		PageInfo<Article> hotList = articleService.hostList(page);
		request.setAttribute("hotList", hotList);
		
		//获取最新文章
		List<Article> newArticles = articleService.getNewArticles(5);
		request.setAttribute("newArticles", newArticles);
		
		// 获取最新图片文章
		List<Article> imgArticles = articleService.getImgArticles(10);
		request.setAttribute("imgArticles", imgArticles);
		
		// 友情链接
		PageInfo<Line> info=  linkService.list(1);
		List<Line> linkList =  info.getList();
		
		request.setAttribute("linkList", linkList);
		
		return "index";
	}
}
