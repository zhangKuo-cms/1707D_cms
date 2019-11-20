package com.zhangkuo.entity;

import java.io.Serializable;

/** 

* @author 作者 zk: 

* @version 创建时间：2019年11月14日 下午7:23:28 

*/
public class Category implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = -1687037530456806915L;

	private Integer id;
	
	private String name;
	
	/**
	 * 频道id
	 */
	private int channelId;
	
	/**
	 * 频道
	 */
	private Channel channel;

	public Category() {
		super();
	}

	public Category(Integer id, String name, int channelId, com.zhangkuo.entity.Channel channel) {
		super();
		this.id = id;
		this.name = name;
		this.channelId = channelId;
		this.channel = channel;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getChannelId() {
		return channelId;
	}

	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", channelId=" + channelId + ", channel=" + channel + "]";
	}
}
