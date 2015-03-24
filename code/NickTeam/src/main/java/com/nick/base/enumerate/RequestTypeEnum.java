package com.nick.base.enumerate;

/**
 * [请求参数枚举] <br/>
 * 1、带有“PART_”前缀的枚举参数主要用于综合体现所有派车状态，不作为单个派车单状态。<br/>
 * 2、派车单状态展现的优先级: 完成 -> 送达 -> 提货(送货中) -> 未提货
 * 
 * @author fish
 * @version v1.0 2015-01-07
 */
public enum RequestTypeEnum {

	ISAJAX("isajax", "1"), ISEASYUI("iseasyui", "1");

	private String code;
	private String description;

	private RequestTypeEnum(String code, String description) {
		this.code = code;
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean equals(String code) {
		if (code == null) {
			return false;
		}
		return code.equals(this.code);
	}

}
