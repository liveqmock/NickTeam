package com.wuya.base.enumerate.finance;

/**
 * [财富账户明细状态－枚举]
 * 
 * @author nick
 * @version v1.0 2015-2-25
 */
public enum FinanceAccountDetailStatusEnum {
	WAIT_JUDGEMENT("waitJudgement", "待审核", 10), PASS_JUDGEMENT("passJudgement",
			"审核通过", 11), REFUSE_JUDGEMENT("refuseJudgement", "审核未通过", 12), ;

	private String code;

	private String msg;

	private Integer sequence;

	private FinanceAccountDetailStatusEnum(String code, String msg,
			Integer sequence) {
		this.code = code;
		this.msg = msg;
		this.sequence = sequence;
	}

	public String getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	public Integer getSequence() {
		return sequence;
	}

	/**
	 * [像下拉菜单内容一样获取]
	 * 
	 * @return
	 */
	public static String getAsDropDownOption() {
		String str = null;
		for (FinanceAccountDetailStatusEnum e : FinanceAccountDetailStatusEnum
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
		for (FinanceAccountDetailStatusEnum e : FinanceAccountDetailStatusEnum
				.values()) {
			if (e.getCode().equals(code)) {
				str = e.getMsg();
				break;
			}
		}
		return str;
	}

}
