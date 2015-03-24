package com.wuya.base.enumerate.share;

/**
 * [客户跟踪类型－枚举]
 * 
 * @author nick
 * @version v1.0 2015-2-21
 */
public enum CustomerFollowTypeEnum {
	PROJECT_ORDER("pj_order", "项目订单");

	private String code;

	private String msg;

	private CustomerFollowTypeEnum(String code, String msg) {
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
		for (CustomerFollowTypeEnum e : CustomerFollowTypeEnum.values()) {
			str += "<option value='" + e.getCode() + "'>" + e.getMsg()
					+ "</option>";
		}
		return str;
	}
}
