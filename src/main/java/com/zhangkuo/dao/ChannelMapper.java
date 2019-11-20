package com.zhangkuo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.zhangkuo.entity.Channel;

/** 

* @author 作者 zk: 

* @version 创建时间：2019年11月14日 下午8:05:13 

*/
public interface ChannelMapper {

	@Select("SELECT * FROM cms_channel ORDER BY id")
	List<Channel> list();

}
