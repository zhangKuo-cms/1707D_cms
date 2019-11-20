package com.zhangkuo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhangkuo.dao.ChannelMapper;
import com.zhangkuo.entity.Channel;
import com.zhangkuo.service.ChannelService;

/** 

* @author 作者 zk: 

* @version 创建时间：2019年11月14日 下午7:54:56 

*/
@Service
public class ChannelServiceImpl implements ChannelService{

	@Autowired
	ChannelMapper channelMapper;
	
	@Override
	public List<Channel> list() {
		// TODO Auto-generated method stub
		return channelMapper.list();
	}
	
}
