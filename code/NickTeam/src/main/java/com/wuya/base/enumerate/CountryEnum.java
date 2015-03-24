package com.wuya.base.enumerate;

/**
 * [国家枚举]
 * 
 * @author nick
 * 
 */
public enum CountryEnum {
	CHINA("china", "中国"),
	;

	private String code;

	private String msg;

	private CountryEnum(String code, String msg) {
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
		for (CountryEnum e : CountryEnum.values()) {
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
	public static String getMsgByCode(String code) {
		String str = null;
		for (CountryEnum e : CountryEnum.values()) {
			if (e.getCode().equals(code)) {
				str = e.getMsg();
				break;
			}
		}
		return str;
	}
}