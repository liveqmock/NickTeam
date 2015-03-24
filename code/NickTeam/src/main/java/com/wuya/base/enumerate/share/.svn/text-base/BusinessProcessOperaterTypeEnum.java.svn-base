package com.wuya.base.enumerate.share;

/**
 * [业务流程操作者类型枚举]
 * 
 * @author nick
 * @version v1.0 2015-2-23
 */
public enum BusinessProcessOperaterTypeEnum {
	MANAGER("manager", "管理员"), STUDENT("student", "学生");

	private String code;

	private String msg;

	private BusinessProcessOperaterTypeEnum(String code, String msg) {
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
		for (BusinessProcessOperaterTypeEnum e : BusinessProcessOperaterTypeEnum
				.values()) {
			str += "<option value='" + e.getCode() + "'>" + e.getMsg()
					+ "</option>";
		}
		return str;
	}
}
