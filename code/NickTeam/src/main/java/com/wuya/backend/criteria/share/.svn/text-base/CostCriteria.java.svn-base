package com.wuya.backend.criteria.share;

import java.util.Arrays;

import com.wuya.base.criteria.BaseCriteria;

/**
 * [费用－条件封装类]
 * 
 * @author nick
 * @version v1.0 2015-2-5
 */
public class CostCriteria extends BaseCriteria {

	/**
	 * [对象序列化标识]
	 */
	private static final long serialVersionUID = 7696619774990605552L;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	@Override
	public String toString() {
		return "CostCriteria [targetId=" + targetId + ", targetType="
				+ targetType + ", notType=" + notType + ", notInTypes="
				+ Arrays.toString(notInTypes) + ", type=" + type + "]";
	}

}
