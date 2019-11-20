package com.zhangkuo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhangkuo.common.ConstantClass;
import com.zhangkuo.dao.ArticleMapper;
import com.zhangkuo.entity.Article;
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
	public PageInfo<Article> listByCat(int chnId, int categoryId, int page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page,ConstantClass.PAGE_SIZE);
		return new PageInfo<Article>(articleMapper.listByCat(chnId,categoryId));
	}
	
	@Override
	public PageInfo<Article> hostList(int page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page,ConstantClass.PAGE_SIZE);
		return new PageInfo<Article>(articleMapper.hostList());
	}

	@Override
	public List<Article> getNewArticles(int i) {
		// TODO Auto-generated method stub
		return articleMapper.getNewArticles(i);
	}

	@Override
	public Article getById(Integer id) {
		// TODO Auto-generated method stub
		return articleMapper.getById(id);
	}
}
