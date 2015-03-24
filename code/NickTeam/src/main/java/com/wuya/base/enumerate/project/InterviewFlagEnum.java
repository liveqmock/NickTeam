package com.wuya.base.enumerate.project;

/**
 * [面试标志-枚举]
 * 
 * @author nick
 * @version v1.0 2015-3-4
 */
public enum InterviewFlagEnum {

	WAIT("wait", "未面试"), PASS("pass", "通过面试"), FAILED("failed", "未通过面试");

	private String code;

	private String msg;

	private InterviewFlagEnum(String code, String msg) {
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
		for (InterviewFlagEnum e : InterviewFlagEnum.values()) {
			if (InterviewFlagEnum.WAIT.getCode().equals(e.getCode())) {
				continue;
			} else {
				str += "<option value='" + e.getCode() + "'>" + e.getMsg()
						+ "</option>";
			}
		}
		return str;
	}

	/**
	 * [根据代码获取对应的描述]
	 * 
	 * @param code
	 * @return
	 */
	public static String getMsgByCode(String code) {
		String str = null;
		for (InterviewFlagEnum e : InterviewFlagEnum.values()) {
			if (e.getCode().equals(code)) {
				str = e.getMsg();
				break;
			}
		}
		return str;
	}

}
