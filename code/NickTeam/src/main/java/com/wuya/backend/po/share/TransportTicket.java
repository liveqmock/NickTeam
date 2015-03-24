package com.wuya.backend.po.share;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.wuya.backend.po.base.BasePo;
import com.wuya.base.constant.CommonConstant;
import com.wuya.base.enumerate.CurrencyEnum;
import com.wuya.base.enumerate.share.TransportTicketTypeEnum;
import com.wuya.base.inter.IValidateable;
import com.wuya.base.util.NumberUtil;
import com.wuya.base.util.StringUtil;

/**
 * [交通票-实体类]
 * 
 * @author nick
 * @version v1.0 2015-3-5
 */
@Entity
@Table(name = "transport_ticket", catalog = "wuya")
public class TransportTicket extends BasePo implements IValidateable {

	/**
	 * [对象序列化标识]
	 */
	private static final long serialVersionUID = -2009586388882686877L;

	/**
	 * [出发城市]
	 */
	@Column(name = "startCity", length = 20, nullable = false)
	private String startCity;

	/**
	 * [出发站]
	 */
	@Column(name = "startStation", length = 20, nullable = false)
	private String startStation;

	/**
	 * [到达城市]
	 */
	@Column(name = "endCity", length = 20, nullable = false)
	private String endCity;

	/**
	 * [到达站]
	 */
	@Column(name = "endStation", length = 20, nullable = false)
	private String endStation;

	/**
	 * [价格]
	 */
	@Column(name = "price", nullable = false)
	private Double price;

	/**
	 * [币种]
	 */
	@Column(name = "currency", length = 20, nullable = false)
	private String currency;

	/**
	 * [票类型]
	 */
	@Column(name = "type", length = 20, nullable = false)
	private String type;

	/**
	 * [更新时间]
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updateTime", nullable = false)
	private Date updateTime;

	// ===================== 非持久化字段 开始 ======================== //

	@Transient
	private String typeStr;

	@Transient
	private String currencyStr;

	@Transient
	private String updateTimeStr;

	// ===================== 非持久化字段 结束 ======================== //

	public String getStartCity() {
		return startCity;
	}

	public void setStartCity(String startCity) {
		this.startCity = startCity;
	}

	public String getStartStation() {
		return startStation;
	}

	public void setStartStation(String startStation) {
		this.startStation = startStation;
	}

	public String getEndCity() {
		return endCity;
	}

	public void setEndCity(String endCity) {
		this.endCity = endCity;
	}

	public String getEndStation() {
		return endStation;
	}

	public void setEndStation(String endStation) {
		this.endStation = endStation;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getTypeStr() {
		return TransportTicketTypeEnum.getMsgByCode(this.type);
	}

	public void setTypeStr(String typeStr) {
		this.typeStr = typeStr;
	}

	public String getCurrencyStr() {
		return CurrencyEnum.getMsgByCode(this.currency);
	}

	public void setCurrencyStr(String currencyStr) {
		this.currencyStr = currencyStr;
	}

	public String getUpdateTimeStr() {
		SimpleDateFormat sdf = new SimpleDateFormat(CommonConstant.SDF_FORMAT);
		if (null != this.updateTime) {
			this.updateTimeStr = sdf.format(this.updateTime);
		}
		return updateTimeStr;
	}

	public void setUpdateTimeStr(String updateTimeStr) {
		this.updateTimeStr = updateTimeStr;
	}

	@Override
	public String toString() {
		return "TransportTicket [startCity=" + startCity + ", startStation="
				+ startStation + ", endCity=" + endCity + ", endStation="
				+ endStation + ", price=" + price + ", currency=" + currency
				+ ", type=" + type + ", updateTime=" + updateTime
				+ ", typeStr=" + typeStr + ", currencyStr=" + currencyStr
				+ ", updateTimeStr=" + updateTimeStr + "]";
	}

	/**
	 * [自我检测方法]
	 */
	public boolean validate() {
		if (StringUtil.isEmpty(this.startCity)
				|| StringUtil.isEmpty(this.startStation)
				|| StringUtil.isEmpty(this.endCity)
				|| StringUtil.isEmpty(this.endStation)
				|| NumberUtil.isEmptyOrZero(this.price)
				|| StringUtil.isEmpty(this.currency)) {
			return false;
		} else {
			return true;
		}
	}

}
