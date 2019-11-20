package com.zhangkuo.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.zhangkuo.entity.Article;

/** 

* @author 作者 zk: 

* @version 创建时间：2019年11月14日 下午7:24:46 

*/
public interface ArticleService {

	PageInfo<Article> hostList(int page);

	List<Article> getNewArticles(int i);

	Article getById(Integer id);

	PageInfo<Article> listByCat(int chnId, int categoryId, int page);

}
