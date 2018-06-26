package com.lik.crud.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lik
 *	通用的返回类
 */
public class Msg {
//	200 成功

	private int  code;
//	提示信息
	private String msg;
	
//	链式添加的方法
	public Msg add(String name,Object obj) {
		this.getExMap().put(name, obj);
		return this;
	}
//	常用成功方法
	public static Msg success() {
		Msg successMsg = new Msg();
		successMsg.setCode(200);
		successMsg.setMsg("请求成功");
		return successMsg;
	}
//	常用失败方法
	public static Msg failed() {
		Msg successMsg = new Msg();
		successMsg.setCode(400);
		successMsg.setMsg("请求失败");
		return successMsg;
	}
	
	public Msg() {
		super();
	}

	public Msg(int code, String msg, Map<String, Object> exMap) {
	super();
	this.code = code;
	this.msg = msg;
	this.exMap = exMap;
}

	@Override
	public String toString() {
		return "Msg [code=" + code + ", msg=" + msg + ", exMap=" + exMap + "]";
	}

	private Map<String, Object> exMap = new HashMap<>();

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Map<String, Object> getExMap() {
		return exMap;
	}

	public void setExMap(Map<String, Object> exMap) {
		this.exMap = exMap;
	}
}
