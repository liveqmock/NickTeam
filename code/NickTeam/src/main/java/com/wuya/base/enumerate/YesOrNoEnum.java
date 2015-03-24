package com.wuya.base.enumerate;

/**
 * [是否-枚举]
 * 
 * @author NICK
 * @version v1.0 2015-2-7
 */
public enum YesOrNoEnum {

	NO("n", "否"), YES("y", "是"), ;

	private String code;

	private String msg;

	private YesOrNoEnum(String code, String msg) {
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
		for (YesOrNoEnum e : YesOrNoEnum.values()) {
			if (YesOrNoEnum.NO.getCode().equals(e.getCode())) {
				str += "<option value='" + e.getCode()
						+ "' selected='selected'>" + e.getMsg() + "</option>";
			} else {
				str += "<option value='" + e.getCode() + "'>" + e.getMsg()
						+ "</option>";
			}
		}
		return str;
	}

	/**
	 * [根据代码获取描述]
	 * 
	 * @param code
	 * @return
	 */
	public static String getMsgByCode(String code) {
		String str = null;
		for (YesOrNoEnum e : YesOrNoEnum.values()) {
			if (e.getCode().equals(code)) {
				str = e.getMsg();
				break;
			}
		}
		return str;
	}

}
