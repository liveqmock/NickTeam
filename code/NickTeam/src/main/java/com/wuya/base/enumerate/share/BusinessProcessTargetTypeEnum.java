package com.wuya.base.enumerate.share;

/**
 * [业务流程目标类型枚举]
 * 
 * @author nick
 * @version v1.0 2015-2-23
 */
public enum BusinessProcessTargetTypeEnum {
	PROJECT_ORDER("projectOrder", "项目订单");

	private String code;

	private String msg;

	private BusinessProcessTargetTypeEnum(String code, String msg) {
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
		for (BusinessProcessTargetTypeEnum e : BusinessProcessTargetTypeEnum
				.values()) {
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
		for (BusinessProcessTargetTypeEnum e : BusinessProcessTargetTypeEnum
				.values()) {
			if (e.getCode().equals(code)) {
				str = e.getMsg();
				break;
			}
		}
		return str;
	}

}
