package com.zhangkuo.common;

import org.apache.commons.codec.digest.DigestUtils;

/** 

* @author 作者 zk: 

* @version 创建时间：2019年11月21日 下午1:23:58 

*/
public class Md5 {
	public static String password(String password, String salt) {
		return DigestUtils.md5Hex(password+":::"+salt);
	}
}
