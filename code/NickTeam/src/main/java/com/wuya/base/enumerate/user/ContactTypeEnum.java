package com.wuya.base.enumerate.user;

/**
 * [联系人类型－枚举]
 * 
 * @author nick
 * @version v1.0 2015-2-1
 */
public enum ContactTypeEnum {

	FATHER("father", "父亲"), MONTHER("monther", "母亲"), CLASSMATE("classmate",
			"同学"),OTHER("other","其他");

	private String code;

	private String msg;

	private ContactTypeEnum(String code, String msg) {
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
		for (ContactTypeEnum e : ContactTypeEnum.values()) {
			str += "<option value='" + e.getCode() + "'>" + e.getMsg()
					+ "</option>";
		}
		return str;
	}
}
