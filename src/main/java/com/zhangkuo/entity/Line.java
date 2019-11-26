package com.zhangkuo.entity;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;
/** 

 * @author 作者 zk: 

 * @version 创建时间：2019年11月14日 下午7:23:35 
.
 */

public class Line {
	
	int  id;
	
	@Length(max=255,min=5,message="长度超出范围")
	//@URL
	String url;
	
	@Length(max=10,min=2)
	String name;
	
	Date created;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
