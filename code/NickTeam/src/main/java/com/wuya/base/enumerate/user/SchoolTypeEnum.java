package com.wuya.base.enumerate.user;

/**
 * [学校类型－枚举]
 * 
 * @author nick
 * @version v1.0 2015-1-31
 */
public enum SchoolTypeEnum {
	JUNIOR("junior", "初中"), HIGH("high", "高中"), COLLEGE("college", "大学"), TRAINING(
			"training", "培训机构");

	private String code;

	private String msg;

	private SchoolTypeEnum(String code, String msg) {
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
		for (SchoolTypeEnum e : SchoolTypeEnum.values()) {
			str += "<option value='" + e.getCode() + "'>" + e.getMsg()
					+ "</option>";
		}
		return str;
	}

}
