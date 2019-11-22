package com.zhangkuo.common;
/** 

* @author 作者 zk: 

* @version 创建时间：2019年11月21日 上午9:56:17 

*/
public class CmsAssert {
	
	public static void AssertTure(boolean express, String msg) {
		if (!express) {
			throw new CmcException(msg);
		}
	}
	
	/** 
	 * @Title: AssertTrueHtml 
	 * @Description: TODO
	 * @param b
	 * @param string
	 * @return: void
	 */
	public static void AssertTrueHtml(boolean express, String msg) {
		if (!express) {
			throw new CmcException(msg);
		}
	}
	
}
