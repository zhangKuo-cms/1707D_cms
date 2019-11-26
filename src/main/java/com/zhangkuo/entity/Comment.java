package com.zhangkuo.entity;

import java.util.Date;

/** 

* @author 作者 zk: 

* @version 创建时间：2019年11月14日 下午7:23:35 
.
*/
public class Comment {
	
	private int id;
	private int articleId;
	private int userId;
	private String content;
	private Date created;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	

}
