package com.wuya.base.enumerate.user;

/**
 * [性别－枚举]
 * 
 * @author nick
 * @version v1.0 2015-2-1
 */
public enum SexEnum {
	MALE("male", "男"), FEMAIL("femail", "女");

	private String code;

	private String msg;

	private SexEnum(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	/**
	 * [像下拉菜单内容一样获取]
	 * 
	 * @return
	 */
	public static String getAsDropDownOption() {
		String str = null;
		for (SexEnum e : SexEnum.values()) {
			str += "<option value='" + e.getCode() + "'>" + e.getMsg()
					+ "</option>";
		}
		return str;
	}
}
