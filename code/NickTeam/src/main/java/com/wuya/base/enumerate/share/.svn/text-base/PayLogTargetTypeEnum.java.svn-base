package com.wuya.base.enumerate.share;

/**
 * [付款日志目标类型-枚举]
 * 
 * @author NICK
 * @version v1.0 2015-3-7
 */
public enum PayLogTargetTypeEnum {
	PROJECT_ORDER("project_order", "项目订单费用"), ENTRY_FEE("entry_fee", "报名费用");

	private String code;

	private String msg;

	private PayLogTargetTypeEnum(String code, String msg) {
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
		for (PayLogTargetTypeEnum e : PayLogTargetTypeEnum.values()) {
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
		for (PayLogTargetTypeEnum e : PayLogTargetTypeEnum.values()) {
			if (e.getCode().equals(code)) {
				str = e.getMsg();
				break;
			}
		}
		return str;
	}

}
