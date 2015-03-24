package com.wuya.base.enumerate.user;

/**
 * [学生所在年级-枚举]
 * 
 * @author nick
 * @version v1.0 2015-3-9
 */
public enum StudentGradeEnum {

	SEVEN(7, "初中一年级"), EIGHT(8, "初中二年级"), NINE(9, "初中三年级"), TEN(10, "高中一年级"), ELEVEN(
			11, "高中二年级"), TWELVE(12, "高中三年级"), ;

	private Integer code;

	private String msg;

	private StudentGradeEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
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
		for (StudentGradeEnum e : StudentGradeEnum.values()) {
			str += "<option value='" + e.getCode() + "'>" + e.getMsg()
					+ "</option>";
		}
		return str;
	}

	/**
	 * [根据代码获取对应的描述]
	 * 
	 * @param code
	 * @return
	 */
	public static String getMsgByCode(Integer code) {
		String str = null;
		for (StudentGradeEnum e : StudentGradeEnum.values()) {
			if (e.getCode().equals(code)) {
				str = e.getMsg();
				break;
			}
		}
		return str;
	}

}
