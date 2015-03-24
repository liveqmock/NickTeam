package com.wuya.backend.po.finance;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.wuya.backend.po.base.BasePo;
import com.wuya.backend.po.user.Passport;
import com.wuya.base.enumerate.CurrencyEnum;
import com.wuya.base.enumerate.finance.FinanceAccountDetailStatusEnum;
import com.wuya.base.enumerate.finance.FinanceAccountDetailTypeEnum;
import com.wuya.base.inter.IValidateable;
import com.wuya.base.util.NumberUtil;
import com.wuya.base.util.StringUtil;

/**
 * [财富账户明细－实体类]
 * 
 * @author nick
 * @version v1.0 2015-2-24
 */
@Entity
@Table(name = "finance_account_detail", catalog = "wuya")
public class FinanceAccountDetail extends BasePo implements IValidateable {

	/**
	 * [对象序列化标识]
	 */
	private static final long serialVersionUID = 1370299246391976811L;

	/**
	 * [对应通行证标识]
	 */
	@Column(name = "passportId", nullable = false)
	private Integer passportId;

	/**
	 * [财富账户标识]
	 */
	@Column(name = "accountId", nullable = false)
	private Integer accountId;

	/**
	 * [明细类型，可以是充值、提现、支付]
	 */
	@Column(name = "type", length = 20, nullable = false)
	private String type;

	/**
	 * [创建时间]
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createTime", nullable = false)
	private Date createTime;

	/**
	 * [状态、可以是待审核、已过审、未过审]
	 */
	@Column(name = "status", length = 20, nullable = false)
	private String status;

	/**
	 * [描述信息]
	 */
	@Column(name = "description", length = 200, nullable = true)
	private String description;

	/**
	 * [实际金额]
	 */
	@Column(name = "price", nullable = false)
	private Double price;

	/**
	 * [币种]
	 */
	@Column(name = "currency", length = 20, nullable = false)
	private String currency;

	/**
	 * [主目的标识]
	 */
	@Column(name = "forId", nullable = true)
	private Integer forId;

	/**
	 * [主目的类型]
	 */
	@Column(name = "forType", length = 20, nullable = true)
	private String forType;

	/**
	 * [子目的标识]
	 */
	@Column(name = "targetId", nullable = true)
	private Integer targetId;

	/**
	 * [子目的类型]
	 */
	@Column(name = "targetType", length = 20, nullable = true)
	private String targetType;

	/**
	 * [是否需要审核]
	 */
	@Column(name = "requireJudgement", length = 4, nullable = false)
	private String requireJudgement;

	/**
	 * [审核人标识]
	 */
	@Column(name = "judgerId", nullable = true)
	private Integer judgerId;

	/**
	 * [审核时间]
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "judgeTime", nullable = true)
	private Date judgeTime;

	/**
	 * [审核人所用的ip地址]
	 */
	@Column(name = "judgerIp", length = 20, nullable = true)
	private String judgerIp;

	// ================ 非持久化字段 开始 =================== //

	@Transient
	private String createTimeStr;

	@Transient
	private String currencyStr;

	@Transient
	private String statusStr;

	@Transient
	private String typeStr;

	@Transient
	private Passport passport;

	@Transient
	private String priceStr;

	// ================ 非持久化字段 结束 =================== //

	public Integer getAccountId() {
		return accountId;
	}

	public Integer getPassportId() {
		return passportId;
	}

	public void setPassportId(Integer passportId) {
		this.passportId = passportId;
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Integer getForId() {
		return forId;
	}

	public void setForId(Integer forId) {
		this.forId = forId;
	}

	public String getForType() {
		return forType;
	}

	public void setForType(String forType) {
		this.forType = forType;
	}

	public Integer getTargetId() {
		return targetId;
	}

	public void setTargetId(Integer targetId) {
		this.targetId = targetId;
	}

	public String getTargetType() {
		return targetType;
	}

	public void setTargetType(String targetType) {
		this.targetType = targetType;
	}

	public String getRequireJudgement() {
		return requireJudgement;
	}

	public void setRequireJudgement(String requireJudgement) {
		this.requireJudgement = requireJudgement;
	}

	public Integer getJudgerId() {
		return judgerId;
	}

	public void setJudgerId(Integer judgerId) {
		this.judgerId = judgerId;
	}

	public Date getJudgeTime() {
		return judgeTime;
	}

	public void setJudgeTime(Date judgeTime) {
		this.judgeTime = judgeTime;
	}

	public String getJudgerIp() {
		return judgerIp;
	}

	public void setJudgerIp(String judgerIp) {
		this.judgerIp = judgerIp;
	}

	public String getCreateTimeStr() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (null != this.createTime) {
			this.createTimeStr = sdf.format(this.createTime);
		}
		return createTimeStr;
	}

	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}

	public String getStatusStr() {
		this.statusStr = FinanceAccountDetailStatusEnum
				.getMsgByCode(this.status);
		return statusStr;
	}

	public void setStatusStr(String statusStr) {
		this.statusStr = statusStr;
	}

	public String getTypeStr() {
		this.statusStr = FinanceAccountDetailTypeEnum.getMsgByCode(this.type);
		return statusStr;
	}

	public void setTypeStr(String typeStr) {
		this.typeStr = typeStr;
	}

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	public String getCurrencyStr() {
		this.currencyStr = CurrencyEnum.getMsgByCode(this.currency);
		return currencyStr;
	}

	public void setCurrencyStr(String currencyStr) {
		this.currencyStr = currencyStr;
	}

	public String getPriceStr() {
		return NumberUtil.doubleTo2String(this.price);
	}

	public void setPriceStr(String priceStr) {
		this.priceStr = priceStr;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((accountId == null) ? 0 : accountId.hashCode());
		result = prime * result
				+ ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result
				+ ((createTimeStr == null) ? 0 : createTimeStr.hashCode());
		result = prime * result
				+ ((currency == null) ? 0 : currency.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((forId == null) ? 0 : forId.hashCode());
		result = prime * result + ((forType == null) ? 0 : forType.hashCode());
		result = prime * result
				+ ((judgeTime == null) ? 0 : judgeTime.hashCode());
		result = prime * result
				+ ((judgerId == null) ? 0 : judgerId.hashCode());
		result = prime * result
				+ ((judgerIp == null) ? 0 : judgerIp.hashCode());
		result = prime * result
				+ ((passportId == null) ? 0 : passportId.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime
				* result
				+ ((requireJudgement == null) ? 0 : requireJudgement.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result
				+ ((statusStr == null) ? 0 : statusStr.hashCode());
		result = prime * result
				+ ((targetId == null) ? 0 : targetId.hashCode());
		result = prime * result
				+ ((targetType == null) ? 0 : targetType.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((typeStr == null) ? 0 : typeStr.hashCode());
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
		FinanceAccountDetail other = (FinanceAccountDetail) obj;
		if (accountId == null) {
			if (other.accountId != null)
				return false;
		} else if (!accountId.equals(other.accountId))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (createTimeStr == null) {
			if (other.createTimeStr != null)
				return false;
		} else if (!createTimeStr.equals(other.createTimeStr))
			return false;
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (forId == null) {
			if (other.forId != null)
				return false;
		} else if (!forId.equals(other.forId))
			return false;
		if (forType == null) {
			if (other.forType != null)
				return false;
		} else if (!forType.equals(other.forType))
			return false;
		if (judgeTime == null) {
			if (other.judgeTime != null)
				return false;
		} else if (!judgeTime.equals(other.judgeTime))
			return false;
		if (judgerId == null) {
			if (other.judgerId != null)
				return false;
		} else if (!judgerId.equals(other.judgerId))
			return false;
		if (judgerIp == null) {
			if (other.judgerIp != null)
				return false;
		} else if (!judgerIp.equals(other.judgerIp))
			return false;
		if (passportId == null) {
			if (other.passportId != null)
				return false;
		} else if (!passportId.equals(other.passportId))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (requireJudgement == null) {
			if (other.requireJudgement != null)
				return false;
		} else if (!requireJudgement.equals(other.requireJudgement))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (statusStr == null) {
			if (other.statusStr != null)
				return false;
		} else if (!statusStr.equals(other.statusStr))
			return false;
		if (targetId == null) {
			if (other.targetId != null)
				return false;
		} else if (!targetId.equals(other.targetId))
			return false;
		if (targetType == null) {
			if (other.targetType != null)
				return false;
		} else if (!targetType.equals(other.targetType))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (typeStr == null) {
			if (other.typeStr != null)
				return false;
		} else if (!typeStr.equals(other.typeStr))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FinanceAccountDetail [passportId=" + passportId
				+ ", accountId=" + accountId + ", type=" + type
				+ ", createTime=" + createTime + ", status=" + status
				+ ", description=" + description + ", price=" + price
				+ ", currency=" + currency + ", forId=" + forId + ", forType="
				+ forType + ", targetId=" + targetId + ", targetType="
				+ targetType + ", requireJudgement=" + requireJudgement
				+ ", judgerId=" + judgerId + ", judgeTime=" + judgeTime
				+ ", judgerIp=" + judgerIp + ", createTimeStr=" + createTimeStr
				+ ", statusStr=" + statusStr + ", typeStr=" + typeStr + "]";
	}

	/**
	 * [自我验证方法]
	 */
	public boolean validate() {
		if (NumberUtil.isEmptyOrZero(this.passportId)
				|| NumberUtil.isEmptyOrZero(this.accountId)
				|| StringUtil.isEmpty(this.type)
				|| StringUtil.isEmpty(this.status)
				|| StringUtil.isEmpty(this.currency)
				|| StringUtil.isEmpty(this.requireJudgement)) {
			return false;
		} else {
			return true;
		}
	}

}
