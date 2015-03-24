package com.wuya.base.enumerate;

/**
 * [数据状态]
 * 
 * @author nick
 * @version v1.0 2015-1-24
 */
public enum DataStatusEnum {

	NORMAL("normal"), DROP("drop"),TEMP("temp");

	private String code;

	private DataStatusEnum(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

}
