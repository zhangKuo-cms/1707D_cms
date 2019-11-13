package com.zhangkuo.common;

import java.io.Serializable;

/** 

* @author 作者 zk: 

* @version 创建时间：2019年11月13日 下午1:32:19 

*/
public class MsgResult implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6121912754652417281L;
	
	int result;
	String errorMsg;
	Object data;
	
	public MsgResult(int result, String errorMsg, Object data) {
		super();
		this.result = result;
		this.errorMsg = errorMsg;
		this.data = data;
	}

	public MsgResult() {
		super();
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "MsgResult [result=" + result + ", errorMsg=" + errorMsg + ", data=" + data + "]";
	}
}
