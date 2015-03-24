package com.nick.backend.enumerate;

/**
 * [用户类型-枚举]
 * 
 * @author nick
 * @version v1.0 2015-3-24
 */
public enum UserTypeEnum {

	DEVELOPER("developer", "开发者", "platform");

	private String code;

	private String msg;

	private String domain;

	private UserTypeEnum(String code, String msg, String domain) {
		this.code = code;
		this.msg = msg;
		this.domain = domain;
	}

	public String getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	public String getDomain() {
		return domain;
	}

}
