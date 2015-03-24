package com.wuya.base.enumerate;

/**
 * [费用类型－枚举]
 * 
 * @author nick
 * @version v1.0 2015-2-3
 */
public enum CostTypeEnum {
	ENTRY_FEE("entryfee", "报名费"), PROJECT("project", "项目费用"), ACCOMMODATION(
			"accommodation", "住宿费用"), AIR_TICKET("airTicket", "机票费用");

	private String code;

	private String msg;

	private CostTypeEnum(String code, String msg) {
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
		for (CostTypeEnum e : CostTypeEnum.values()) {
			if (CostTypeEnum.AIR_TICKET.getCode().equals(e.getCode())) {
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
		for (CostTypeEnum e : CostTypeEnum.values()) {
			if (e.getCode().equals(code)) {
				str = e.getMsg();
				break;
			}
		}
		return str;
	}

}
