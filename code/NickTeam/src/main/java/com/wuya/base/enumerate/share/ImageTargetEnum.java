package com.wuya.base.enumerate.share;

/**
 * [图片目标类型－枚举]
 * 
 * @author nick
 * @version v1.0 2015-2-25
 */
public enum ImageTargetEnum {
	RECHARGE_DETAIL("rechargeDetail", "充值明细"),
	CERTIFICATE("certificate", "证件信息"),
	PROJECT("project", "项目信息"),
	;

	private String code;

	private String msg;

	private ImageTargetEnum(String code, String msg) {
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
		for (ImageTargetEnum e : ImageTargetEnum.values()) {
			str += "<option value='" + e.getCode() + "'>" + e.getMsg()
					+ "</option>";
		}
		return str;
	}
}
