package com.wuya.base.enumerate.user;

/**
 * [通行证类型－枚举]
 * 
 * @author nick
 * @version v1.0 2015-1-28
 */
public enum PassportTypeEnum {

	STUDENT("student"), MANAGER("manager"), SERVICE("service");

	private String code;

	private PassportTypeEnum(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
