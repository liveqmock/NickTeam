package com.wuya.backend.criteria.share;

import com.wuya.base.criteria.BaseCriteria;

/**
 * [交通票-条件封装]
 * 
 * @author nick
 * @version v1.0 2015-3-5
 */
public class TransportTicketCriteria extends BaseCriteria {

	/**
	 * [对象序列化标识]
	 */
	private static final long serialVersionUID = 1880887033310002236L;

	/**
	 * [出发城市]
	 */
	private String startCity;

	/**
	 * [到达城市]
	 */
	private String endCity;

	/**
	 * [票类型]
	 */
	private String type;

	public String getStartCity() {
		return startCity;
	}

	public void setStartCity(String startCity) {
		this.startCity = startCity;
	}

	public String getEndCity() {
		return endCity;
	}

	public void setEndCity(String endCity) {
		this.endCity = endCity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "TransportTicketCriteria [startCity=" + startCity + ", endCity="
				+ endCity + ", type=" + type + "]";
	}

}
