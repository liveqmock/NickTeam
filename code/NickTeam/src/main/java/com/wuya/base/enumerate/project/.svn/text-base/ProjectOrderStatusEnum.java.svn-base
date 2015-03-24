package com.wuya.base.enumerate.project;

/**
 * [项目订单状态－枚举类]
 * 
 * @author nick
 * @version v1.0 2015-2-13
 */
public enum ProjectOrderStatusEnum {
	WAIT_JUDGEMENT("waitJudgement", "等待审核", 10), JUDGEMENT_ERROR(
			"judgementError", "审核失败", 11),

	WAIT_SIGN_PAY("waitSignPay", "待支付报名费", 20),

	WAIT_INTERVIEW("waitInterview", "审核通过-待面试", 30),
	INTERVIEW_SIGNED("interViewSigned", "已安排或调整面试官", 31),
	INTERVIEW_FAILED("interViewFailed", "面试失败", 32),

	WAIT_PROJECT_PAY("waitProjectPay", "面试通过,待全额支付", 40),

	FINISH("finish", "申请完成", 50),

	DROPED("droped", "已作废", 60), ;

	private String code;

	private String msg;

	private Integer seq;

	private ProjectOrderStatusEnum(String code, String msg, Integer seq) {
		this.code = code;
		this.msg = msg;
		this.seq = seq;
	}

	public String getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	public Integer getSeq() {
		return seq;
	}

	/**
	 * [像下拉菜单内容一样获取]
	 * 
	 * @return
	 */
	public static String getAsDropDownOption() {
		String str = null;
		for (ProjectOrderStatusEnum e : ProjectOrderStatusEnum.values()) {
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
		for (ProjectOrderStatusEnum e : ProjectOrderStatusEnum.values()) {
			if (e.getCode().equals(code)) {
				str = e.getMsg();
				break;
			}
		}
		return str;
	}

}
