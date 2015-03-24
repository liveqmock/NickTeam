package com.wuya.backend.criteria.share;

import java.util.Arrays;

import com.wuya.base.criteria.BaseCriteria;

/**
 * [支付日志-条件封装]
 * 
 * @author NICK
 * @version v1.0 2015-3-7
 */
public class PayLogCriteria extends BaseCriteria {

	/**
	 * [对象序列化标识]
	 */
	private static final long serialVersionUID = -4309129956897287190L;

	/**
	 * [目标标识]
	 */
	private Integer targetId;

	/**
	 * [目标类型]
	 */
	private String targetType;

	/**
	 * [排除费用类型]
	 */
	private String notType;

	/**
	 * [排除多个类型]
	 */
	private String[] notInTypes;

	/**
	 * [费用类型]
	 */
	private String type;

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

	public String getNotType() {
		return notType;
	}

	public void setNotType(String notType) {
		this.notType = notType;
	}

	public String[] getNotInTypes() {
		return notInTypes;
	}

	public void setNotInTypes(String[] notInTypes) {
		this.notInTypes = notInTypes;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "PayLogCriteria [targetId=" + targetId + ", targetType="
				+ targetType + ", notType=" + notType + ", notInTypes="
				+ Arrays.toString(notInTypes) + ", type=" + type + "]";
	}

}
