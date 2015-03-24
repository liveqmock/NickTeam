package com.wuya.base.enumerate.finance;

/**
 * [财富账户明细类型－枚举]
 * 
 * @author nick
 * @version v1.0 2015-2-25
 */
public enum FinanceAccountDetailTypeEnum {
	RECHARGE("recharge", "充值"), WITHDRAW("withdraw", "取现"), ALLPAYMENT(
			"allPayment", "项目尾款"), ENTRY_FREE("entryfree", "报名费付款"), ORDER_DROP(
			"orderDrop", "订单作废还款"), ;

	private String code;

	private String msg;

	private FinanceAccountDetailTypeEnum(String code, String msg) {
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
		for (FinanceAccountDetailTypeEnum e : FinanceAccountDetailTypeEnum
				.values()) {
			str += "<option value='" + e.getCode() + "'>" + e.getMsg()
					+ "</option>";
		}
		return str;
	}

	/**
	 * [根据代码获取描述]
	 * 
	 * @param code
	 * @return
	 */
	public static String getMsgByCode(String code) {
		String str = null;
		for (FinanceAccountDetailTypeEnum e : FinanceAccountDetailTypeEnum
				.values()) {
			if (e.getCode().equals(code)) {
				str = e.getMsg();
				break;
			}
		}
		return str;
	}
}
