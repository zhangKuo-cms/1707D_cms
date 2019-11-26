package com.zhangkuo.entity;

/** 

* @author 作者 zk: 

* @version 创建时间：2019年11月14日 下午7:23:35 
.
*/
public class Image {
	
	private String url;
	private String desc;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	@Override
	public String toString() {
		return "Image [url=" + url + ", desc=" + desc + "]";
	}
	
	

}
