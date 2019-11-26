package com.zhangkuo.entity;

import org.hibernate.validator.constraints.Length;
/** 

 * @author 作者 zk: 

 * @version 创建时间：2019年11月14日 下午7:23:35 
.
 */

public class Url {
	
	@Length(max=20,min=5)
	private String url;
	
	@Length(max=8,min=3)
	private String name;

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
	
	

}
