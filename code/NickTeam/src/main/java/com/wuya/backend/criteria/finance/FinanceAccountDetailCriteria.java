package com.wuya.backend.criteria.finance;

import com.wuya.base.criteria.BaseCriteria;

/**
 * [财富账户明细－条件封装]
 * 
 * @author nick
 * @version v1.0 2015-2-24
 */
public class FinanceAccountDetailCriteria extends BaseCriteria {

	/**
	 * [对象序列化标识]
	 */
	private static final long serialVersionUID = 7444393380536637813L;

	/**
	 * [财富账户标识]
	 */
	private Integer accountId;

	/**
	 * [明细类型，可以是充值、提现、支付]
	 */
	private String type;

	/**
	 * [状态、可以是待审核、已过审、未过审]
	 */
	private String status;

	// =================== 开关条件 开始 =============== //
	
	private String requirePassport;

	// =================== 开关条件 失败 =============== //

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRequirePassport() {
		return requirePassport;
	}

	public void setRequirePassport(String requirePassport) {
		this.requirePassport = requirePassport;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((accountId == null) ? 0 : accountId.hashCode());
		result = prime * result
				+ ((requirePassport == null) ? 0 : requirePassport.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		FinanceAccountDetailCriteria other = (FinanceAccountDetailCriteria) obj;
		if (accountId == null) {
			if (other.accountId != null)
				return false;
		} else if (!accountId.equals(other.accountId))
			return false;
		if (requirePassport == null) {
			if (other.requirePassport != null)
				return false;
		} else if (!requirePassport.equals(other.requirePassport))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FinanceAccountDetailCriteria [accountId=" + accountId
				+ ", type=" + type + ", status=" + status
				+ ", requirePassport=" + requirePassport + "]";
	}

}
