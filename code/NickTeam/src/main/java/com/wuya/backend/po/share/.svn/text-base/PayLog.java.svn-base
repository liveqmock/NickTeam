package com.wuya.backend.po.share;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.wuya.backend.po.base.BasePo;
import com.wuya.base.enumerate.CostTypeEnum;
import com.wuya.base.enumerate.CurrencyEnum;
import com.wuya.base.enumerate.share.PayLogTargetTypeEnum;
import com.wuya.base.inter.IValidateable;
import com.wuya.base.util.StringUtil;

/**
 * [支付日志]
 * 
 * @author NICK
 * @version v1.0 2015-3-7
 */
@Entity
@Table(name = "pay_log", catalog = "wuya")
public class PayLog extends BasePo implements IValidateable {

	/**
	 * [对象序列化标识]
	 */
	private static final long serialVersionUID = 5165511821912013088L;

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
	private Double price;

	/**
	 * [币种]
	 */
	@Column(name = "currency", length = 20, nullable = false)
	private String currency;

	/**
	 * [发生时间]
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createTime", nullable = false)
	private Date createTime;

	/**
	 * [费用类型]
	 */
	@Column(name = "type", length = 20, nullable = false)
	private String type;

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
			targetTypeStr = PayLogTargetTypeEnum.getMsgByCode(this.targetType);
		}
		return targetTypeStr;
	}

	public void setTargetTypeStr(String targetTypeStr) {
		this.targetTypeStr = targetTypeStr;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTypeStr() {
		return typeStr;
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

	public boolean validate() {
		if (null == this.targetId || 0 == this.targetId
				|| StringUtil.isEmpty(this.targetType)
				|| StringUtil.isEmpty(this.currency)) {
			return false;
		} else {
			return true;
		}
	}

}
