package com.nick.base.exception;

/**
 * [参数错误异常-异常封装类]
 * 
 * @author nick
 * @version v1.0 2015-1-24
 */
public class ParamErrorException extends NickException {

	/**
	 * [对象序列化标识]
	 */
	private static final long serialVersionUID = 7452104824469505828L;

	/**
	 * [无参构造函数]
	 * 
	 * @param msg
	 */
	public ParamErrorException(String msg) {
		super(msg);
	}

}
