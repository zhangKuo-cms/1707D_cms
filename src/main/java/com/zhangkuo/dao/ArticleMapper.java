package com.zhangkuo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhangkuo.entity.Article;

/** 

* @author 作者 zk: 

* @version 创建时间：2019年11月14日 下午7:58:13 

*/
public interface ArticleMapper {

	/**
	 * 根据频道获取文章
	 * @param chnId
	 * @param categoryId
	 * @return
	 */
	List<Article> listByCat(@Param("chnId")int chnId, @Param("categoryId")int categoryId);

	/**
	 * 获取热门文章
	 * @return
	 */
	List<Article> hostList();

	/**
	 * 获取最新文章
	 * @param i 获取的个数
	 * @return
	 */
	List<Article> getNewArticles(int i);

	/**
	 * 获取文章
	 * @param id
	 * @return
	 */
	Article getById(Integer id);
	
}
