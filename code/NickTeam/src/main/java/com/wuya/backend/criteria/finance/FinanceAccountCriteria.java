package com.wuya.backend.criteria.finance;

import com.wuya.base.criteria.BaseCriteria;

/**
 * [财富账户－条件封装]
 * 
 * @author nick
 * @version v1.0 2015-2-24
 */
public class FinanceAccountCriteria extends BaseCriteria {

	/**
	 * [对象序列化标识]
	 */
	private static final long serialVersionUID = -4235604046256821213L;

	/**
	 * [对应通行证标识]
	 */
	private Integer passportId;

	public Integer getPassportId() {
		return passportId;
	}

	public void setPassportId(Integer passportId) {
		this.passportId = passportId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((passportId == null) ? 0 : passportId.hashCode());
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
		FinanceAccountCriteria other = (FinanceAccountCriteria) obj;
		if (passportId == null) {
			if (other.passportId != null)
				return false;
		} else if (!passportId.equals(other.passportId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FinanceAccountCriteria [passportId=" + passportId + "]";
	}

}
