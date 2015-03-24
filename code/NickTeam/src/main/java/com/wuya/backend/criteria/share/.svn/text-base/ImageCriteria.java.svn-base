package com.wuya.backend.criteria.share;

import com.wuya.base.criteria.BaseCriteria;

/**
 * [图片-查询条件封装]
 * 
 * @author NICK
 * @version v1.0 2015-2-25
 */
public class ImageCriteria extends BaseCriteria {

	/**
	 * [对象序列化标识]
	 */
	private static final long serialVersionUID = 1823276710379167216L;
	
	/**
	 * [目标标识]
	 */
	private Integer targetId;

	/**
	 * [目标类型]
	 */
	private String targetType;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((targetId == null) ? 0 : targetId.hashCode());
		result = prime * result
				+ ((targetType == null) ? 0 : targetType.hashCode());
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
		ImageCriteria other = (ImageCriteria) obj;
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
		return true;
	}

	@Override
	public String toString() {
		return "ImageCriteria [targetId=" + targetId + ", targetType="
				+ targetType + "]";
	}

}
