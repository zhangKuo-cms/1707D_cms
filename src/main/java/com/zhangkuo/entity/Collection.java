package com.zhangkuo.entity;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

/** 

* @author 作者 zk: 

* @version 创建时间：2019年11月14日 下午7:23:35 
.
*/
public class Collection {
	
 private int	id;
 
 private int	userId;
 
 @Length(min=2,max=128)
 private String url;
 
 @Length(min=2,max=30)
 private String name;
 
 private Date created;
 
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Date getCreated() {
	return created;
}
public void setCreated(Date created) {
	this.created = created;
}
	

}
