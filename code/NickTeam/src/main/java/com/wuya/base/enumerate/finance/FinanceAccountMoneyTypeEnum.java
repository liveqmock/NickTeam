package com.wuya.base.enumerate.finance;

/**
 * [财富账户金额类型－枚举]
 * 
 * @author nick
 * @version v1.0 2015-2-25
 */
public enum FinanceAccountMoneyTypeEnum {

	CANUSE("canuse", "可用余额"),
	FROZEN("frozen", "冻结金额"),
	;

	private String code;

	private String msg;


	private FinanceAccountMoneyTypeEnum(String code, String msg) {
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
		for (FinanceAccountMoneyTypeEnum e : FinanceAccountMoneyTypeEnum
				.values()) {
			str += "<option value='" + e.getCode() + "'>" + e.getMsg()
					+ "</option>";
		}
		return str;
	}
}
