package com.wuya.backend.criteria.share;

import com.wuya.base.criteria.BaseCriteria;

/**
 * [业务流程日志-条件封装类]
 * 
 * @author NICK
 * @version v1.0 2015-3-2
 */
public class BusinessProcessLogCriteria extends BaseCriteria {

	/**
	 * [对象序列化标识]
	 */
	private static final long serialVersionUID = -834983042722086725L;

	/**
	 * [操作人标识]
	 */
	private Integer operaterId;

	/**
	 * [操作人类型]
	 */
	private String operaterType;

	/**
	 * [目标标识]
	 */
	private Integer targetId;

	/**
	 * [目标类型]
	 */
	private String targetType;

	/**
	 * [迁移前状态]
	 */
	private String prevStatus;

	/**
	 * [迁移后状态]
	 */
	private String nextStatus;

	public Integer getOperaterId() {
		return operaterId;
	}

	public void setOperaterId(Integer operaterId) {
		this.operaterId = operaterId;
	}

	public String getOperaterType() {
		return operaterType;
	}

	public void setOperaterType(String operaterType) {
		this.operaterType = operaterType;
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

	public String getPrevStatus() {
		return prevStatus;
	}

	public void setPrevStatus(String prevStatus) {
		this.prevStatus = prevStatus;
	}

	public String getNextStatus() {
		return nextStatus;
	}

	public void setNextStatus(String nextStatus) {
		this.nextStatus = nextStatus;
	}

	@Override
	public String toString() {
		return "BusinessProcessLogCriteria [operaterId=" + operaterId
				+ ", operaterType=" + operaterType + ", targetId=" + targetId
				+ ", targetType=" + targetType + ", prevStatus=" + prevStatus
				+ ", nextStatus=" + nextStatus + "]";
	}

}
