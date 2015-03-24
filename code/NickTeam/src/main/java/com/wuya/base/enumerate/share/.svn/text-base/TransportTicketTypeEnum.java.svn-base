package com.wuya.base.enumerate.share;

/**
 * [交通票类型-枚举]
 * 
 * @author nick
 * @version v1.0 2015-3-5
 */
public enum TransportTicketTypeEnum {

	AIR("air", "飞机票");

	private String code;

	private String msg;

	private TransportTicketTypeEnum(String code, String msg) {
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
		for (TransportTicketTypeEnum e : TransportTicketTypeEnum.values()) {
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
		for (TransportTicketTypeEnum e : TransportTicketTypeEnum.values()) {
			if (e.getCode().equals(code)) {
				str = e.getMsg();
				break;
			}
		}
		return str;
	}

}
