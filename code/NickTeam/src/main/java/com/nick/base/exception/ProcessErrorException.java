package com.nick.base.exception;

/**
 * [业务执行异常－异常封装类]
 * 
 * @author nick
 * @version v1.0 2015-1-24
 */
public class ProcessErrorException extends NickException {

	/**
	 * [对象序列化标识]
	 */
	private static final long serialVersionUID = 2903624926504817473L;

	/* 无参构造函数 */
	public ProcessErrorException(String msg) {
		super(msg);
	}

}
