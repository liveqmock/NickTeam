package com.wuya.base.enumerate;

/**
 * [费用目标类型－枚举]
 * 
 * @author nick
 * @version v1.0 2015-2-3
 */
public enum CostTargetEnum {
	PROJECT("project", "项目费用"), PROJECT_ORDER("project_order", "项目订单费用"), ;

	private String code;

	private String msg;

	private CostTargetEnum(String code, String msg) {
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
		for (CostTargetEnum e : CostTargetEnum.values()) {
			str += "<option value='" + e.getCode() + "'>" + e.getMsg()
					+ "</option>";
		}
		return str;
	}
}
