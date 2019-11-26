package com.zhangkuo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhangkuo.common.ConstantClass;
import com.zhangkuo.dao.ArticleMapper;
import com.zhangkuo.entity.Article;
import com.zhangkuo.entity.Comment;
import com.zhangkuo.service.ArticleService;

/** 

* @author 作者 zk: 

* @version 创建时间：2019年11月14日 下午7:54:56 

*/
@Service
public class ArticleServiceImpl implements ArticleService{

	@Autowired
	ArticleMapper articleMapper;
	
	@Override
	public List<Article> getNewArticles(int i) {
		// TODO Auto-generated method stub
		return articleMapper.getNewArticles(i);
	}
	
	@Override
	public PageInfo<Article> hostList(int page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page,ConstantClass.PAGE_SIZE);
		return new PageInfo<Article>(articleMapper.hostList());
	}
	
	@Override
	public Article getById(Integer id) {
		// TODO Auto-generated method stub
		return articleMapper.getById(id);
	}
	
	@Override
	public PageInfo<Article> listByCat(int chnId, int categoryId, int page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page,ConstantClass.PAGE_SIZE);
		return new PageInfo<Article>(articleMapper.listByCat(chnId,categoryId));
	}
	
	@Override
	public PageInfo<Article> listByUser(int page, Integer userId) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, ConstantClass.PAGE_SIZE);
		return new PageInfo<Article>(articleMapper.listByUser(userId));
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return articleMapper.delete(id);
	}

	@Override
	public Article checkExist(int id) {
		// TODO Auto-generated method stub
		return articleMapper.checkExist(id);
	}

	@Override
	public PageInfo<Article> getPageList(int status, Integer page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, ConstantClass.PAGE_SIZE);
		return new PageInfo<Article>(articleMapper.listByStatus(status));
	}

	@Override
	public Article getDetailById(int id) {
		// TODO Auto-generated method stub
		return articleMapper.getDetailById(id);
	}
	
	@Override
	public int apply(int id, int status) {
		// TODO Auto-generated method stub
		return articleMapper.apply(id, status);
	}
	
	@Override
	public int setHot(int id, int status) {
		// TODO Auto-generated method stub
		return articleMapper.setHot(id, status);
	}
	
	@Override
	public int add(Article article) {
		// TODO Auto-generated method stub
		return articleMapper.add(article);
	}

	@Override
	public int update(Article article) {
		// TODO Auto-generated method stub
		return articleMapper.update(article);
	}
	
	@Override
	public int faverite(Integer userId, int articleId) {
		// TODO Auto-generated method stub
		return articleMapper.faverite(userId, articleId);
	}
	
	@Override
	public List<Article> getImgArticles(int num) {
		// TODO Auto-generated method stub
		return articleMapper.getImgArticles(num);
	}
	
	@Override
	public int comment(Integer userId, int articleId, String content) {
		// TODO Auto-generated method stub
		//插入评论表一条数据
		int result = articleMapper.addComment(userId,articleId,content);
		if (result>0) {
			// 让文章表中的评论数量自增1
			articleMapper.increaseCommentCnt(articleId);
		}else {
			return 0;
		}
		return result;
	}
	
	@Override
	public PageInfo<Comment> commentlist(int articleId, int page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, 10);
		return new PageInfo<Comment>(articleMapper.commentlist(articleId));
	}
}
