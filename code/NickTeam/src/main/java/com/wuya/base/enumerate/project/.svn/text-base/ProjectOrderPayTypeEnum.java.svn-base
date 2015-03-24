package com.wuya.base.enumerate.project;

/**
 * [项目订单付款类型-枚举]
 * 
 * @author nick
 * @version v1.0 2015-3-3
 */
public enum ProjectOrderPayTypeEnum {

	STEPABLE("stepable", "按流程"), INCLUDE_ENTRY_FREE("includeEntryFee",
			"报名费与项目费一起缴纳");

	private String code;

	private String msg;

	private ProjectOrderPayTypeEnum(String code, String msg) {
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
		for (ProjectOrderPayTypeEnum e : ProjectOrderPayTypeEnum.values()) {
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
		for (ProjectOrderPayTypeEnum e : ProjectOrderPayTypeEnum.values()) {
			if (e.getCode().equals(code)) {
				str = e.getMsg();
				break;
			}
		}
		return str;
	}

}
