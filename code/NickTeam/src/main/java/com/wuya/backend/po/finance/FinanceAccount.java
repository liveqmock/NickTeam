package com.wuya.backend.po.finance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.wuya.backend.po.base.BasePo;
import com.wuya.base.inter.IValidateable;
import com.wuya.base.util.NumberUtil;

/**
 * [财富账户]
 * 
 * @author nick
 * @version v1.0 2015-2-24
 */
@Entity
@Table(name = "finance_account", catalog = "wuya")
public class FinanceAccount extends BasePo implements IValidateable {

	/**
	 * [对象序列化标识]
	 */
	private static final long serialVersionUID = -5112630493278729L;

	/**
	 * [对应通行证标识]
	 */
	@Column(name = "passportId", nullable = false)
	private Integer passportId;

	/**
	 * [可用余额]
	 */
	@Column(name = "canUseMoney", nullable = false)
	private Double canUseMoney;

	/**
	 * [已冻结的资金]
	 */
	@Column(name = "frozenMoney", nullable = false)
	private Double frozenMoney;

	// ================ 非持久化字段 开始 =================== //
	@Transient
	private String canUseMoneyStr;

	@Transient
	private String frozenMoneyStr;

	// ================ 非持久化字段 结束 =================== //

	public Integer getPassportId() {
		return passportId;
	}

	public void setPassportId(Integer passportId) {
		this.passportId = passportId;
	}

	public Double getCanUseMoney() {
		return canUseMoney;
	}

	public void setCanUseMoney(Double canUseMoney) {
		this.canUseMoney = canUseMoney;
	}

	public Double getFrozenMoney() {
		return frozenMoney;
	}

	public void setFrozenMoney(Double frozenMoney) {
		this.frozenMoney = frozenMoney;
	}

	public String getCanUseMoneyStr() {
		return NumberUtil.doubleTo2String(this.canUseMoney);
	}

	public void setCanUseMoneyStr(String canUseMoneyStr) {
		this.canUseMoneyStr = canUseMoneyStr;
	}

	public String getFrozenMoneyStr() {
		return NumberUtil.doubleTo2String(this.frozenMoney);
	}

	public void setFrozenMoneyStr(String frozenMoneyStr) {
		this.frozenMoneyStr = frozenMoneyStr;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((canUseMoney == null) ? 0 : canUseMoney.hashCode());
		result = prime * result
				+ ((frozenMoney == null) ? 0 : frozenMoney.hashCode());
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
		FinanceAccount other = (FinanceAccount) obj;
		if (canUseMoney == null) {
			if (other.canUseMoney != null)
				return false;
		} else if (!canUseMoney.equals(other.canUseMoney))
			return false;
		if (frozenMoney == null) {
			if (other.frozenMoney != null)
				return false;
		} else if (!frozenMoney.equals(other.frozenMoney))
			return false;
		if (passportId == null) {
			if (other.passportId != null)
				return false;
		} else if (!passportId.equals(other.passportId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FinanceAccount [passportId=" + passportId + ", canUseMoney="
				+ canUseMoney + ", frozenMoney=" + frozenMoney + "]";
	}

	/**
	 * [自我验证方法]
	 */
	public boolean validate() {
		if (NumberUtil.isEmptyOrZero(this.passportId)) {
			return false;
		} else {
			return true;
		}
	}

}
