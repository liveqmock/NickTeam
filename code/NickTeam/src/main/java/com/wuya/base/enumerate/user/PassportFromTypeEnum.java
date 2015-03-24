package com.wuya.base.enumerate.user;

/**
 * [通行证来源类型－枚举]
 * 
 * @author nick
 * @version v1.0 2015-1-28
 */
public enum PassportFromTypeEnum {

	SCHOOL("school"), ORGANIZATION("organization"), TEACHER("teacher"), CLASSMATE(
			"classmate"), SENIOR("senior"), HOMEPAGE("homepage"), OTHER("other");

	private String code;

	private PassportFromTypeEnum(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
