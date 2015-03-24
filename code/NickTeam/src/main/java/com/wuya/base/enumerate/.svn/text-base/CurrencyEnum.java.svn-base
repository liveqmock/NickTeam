package com.wuya.base.enumerate;

/**
 * [货币类型－枚举]
 * 
 * @author nick
 * @version v1.0 2015-2-3
 */
public enum CurrencyEnum {
	RMB("rmb", "人民币");

	private String code;

	private String msg;

	private CurrencyEnum(String code, String msg) {
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
		for (CurrencyEnum e : CurrencyEnum.values()) {
			str += "<option value='" + e.getCode() + "'>" + e.getMsg()
					+ "</option>";
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
		for (CurrencyEnum e : CurrencyEnum.values()) {
			if (e.getCode().equals(code)) {
				str = e.getMsg();
				break;
			}
		}
		return str;
	}

}
