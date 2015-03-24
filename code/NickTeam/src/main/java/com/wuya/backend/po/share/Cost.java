package com.wuya.backend.po.share;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.wuya.backend.po.base.BasePo;
import com.wuya.base.enumerate.CostTargetEnum;
import com.wuya.base.enumerate.CostTypeEnum;
import com.wuya.base.enumerate.CurrencyEnum;
import com.wuya.base.inter.IValidateable;
import com.wuya.base.util.StringUtil;

/**
 * [项目费用－持久化类]
 * 
 * @author nick
 * @version v1.0 2015-2-3
 */
@Entity
@Table(name = "cost", catalog = "wuya")
public class Cost extends BasePo implements IValidateable {

	/**
	 * [对象序列化标识]
	 */
	private static final long serialVersionUID = 5478422223736344886L;

	/**
	 * [目标标识]
	 */
	@Column(name = "targetId", nullable = false)
	private Integer targetId;

	/**
	 * [目标类型]
	 */
	@Column(name = "targetType", length = 20, nullable = false)
	private String targetType;

	/**
	 * [费用]
	 */
	@Column(name = "cost", nullable = false)
	private Double cost;

	/**
	 * [币种]
	 */
	@Column(name = "currency", length = 20, nullable = false)
	private String currency;

	/**
	 * [费用类型]
	 */
	@Column(name = "type", length = 20, nullable = false)
	private String type;

	/**
	 * [备注]
	 */
	@Column(name = "remark", length = 80, nullable = true)
	private String remark;

	/* 辅助字段 开始 */

	@Transient
	private String currencyStr;

	@Transient
	private String targetTypeStr;

	@Transient
	private String typeStr;

	/* 辅助字段 结束 */

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

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCurrencyStr() {
		if (StringUtil.isNotEmpty(this.currency)) {
			for (CurrencyEnum c : CurrencyEnum.values()) {
				if (this.currency.equals(c.getCode())) {
					currencyStr = c.getMsg();
				}
			}
		}
		return currencyStr;
	}

	public void setCurrencyStr(String currencyStr) {
		this.currencyStr = currencyStr;
	}

	public String getTargetTypeStr() {
		if (StringUtil.isNotEmpty(this.targetType)) {
			for (CostTargetEnum c : CostTargetEnum.values()) {
				if (this.targetType.equals(c.getCode())) {
					this.targetTypeStr = c.getMsg();
				}
			}
		}
		return targetTypeStr;
	}

	public void setTargetTypeStr(String targetTypeStr) {
		this.targetTypeStr = targetTypeStr;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getTypeStr() {
		return CostTypeEnum.getMsgByCode(this.type);
	}

	public void setTypeStr(String typeStr) {
		if (StringUtil.isNotEmpty(this.type)) {
			for (CostTypeEnum c : CostTypeEnum.values()) {
				if (this.type.equals(c.getCode())) {
					this.typeStr = c.getMsg();
				}
			}
		}
		this.typeStr = typeStr;
	}

	@Override
	public String toString() {
		return "Cost [targetId=" + targetId + ", targetType=" + targetType
				+ ", cost=" + cost + ", currency=" + currency + ", type="
				+ type + ", remark=" + remark + ", currencyStr=" + currencyStr
				+ ", targetTypeStr=" + targetTypeStr + ", typeStr=" + typeStr
				+ "]";
	}

	public boolean validate() {
		if (null == this.targetId || 0 == this.targetId
				|| StringUtil.isEmpty(this.targetType)
				|| StringUtil.isEmpty(this.currency)
				|| StringUtil.isEmpty(this.type)) {
			return false;
		} else {
			return true;
		}
	}

}
