package com.wuya.base.enumerate.user;

/**
 * [证件类型－枚举]
 * 
 * @author nick
 * @version v1.0 2015-2-1
 */
public enum CertificateTypeEnum {
	IDENTITY("identity", "身份证", 1), PASSPORT("passport", "护照", 0), HKMACAO(
			"hkmacao", "港澳通行证", 1), TAIWAN("hkmacao", "大陆居民往来台湾通行证", 1);

	private String code;

	private String msg;

	private Integer num;

	private CertificateTypeEnum(String code, String msg, Integer num) {
		this.code = code;
		this.msg = msg;
		this.num = num;
	}

	public String getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	public Integer getNum() {
		return num;
	}

	/**
	 * [像下拉菜单内容一样获取]
	 * 
	 * @return
	 */
	public static String getAsDropDownOption() {
		String str = null;
		for (CertificateTypeEnum e : CertificateTypeEnum.values()) {
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
		for (CertificateTypeEnum e : CertificateTypeEnum.values()) {
			if (e.getCode().equals(code)) {
				str = e.getMsg();
				break;
			}
		}
		return str;
	}

}
