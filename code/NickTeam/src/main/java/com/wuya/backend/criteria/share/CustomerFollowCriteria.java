package com.wuya.backend.criteria.share;

import com.wuya.base.criteria.BaseCriteria;

/**
 * [客户跟进－条件封装类]
 * 
 * @author nick
 * @version v1.0 2015-2-5
 */
public class CustomerFollowCriteria extends BaseCriteria {

	/**
	 * [对象序列化标识]
	 */
	private static final long serialVersionUID = 2024456805279665063L;

	/**
	 * [客户标识]
	 */
	private Integer customerId;

	/**
	 * [客服标识]
	 */
	private Integer serviceId;

	/**
	 * [跟进目标标识]
	 */
	private Integer targetId;

	/**
	 * [跟进类型－枚举类维护]
	 */
	private String followType;

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getServiceId() {
		return serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	public Integer getTargetId() {
		return targetId;
	}

	public void setTargetId(Integer targetId) {
		this.targetId = targetId;
	}

	public String getFollowType() {
		return followType;
	}

	public void setFollowType(String followType) {
		this.followType = followType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result
				+ ((followType == null) ? 0 : followType.hashCode());
		result = prime * result
				+ ((serviceId == null) ? 0 : serviceId.hashCode());
		result = prime * result
				+ ((targetId == null) ? 0 : targetId.hashCode());
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
		CustomerFollowCriteria other = (CustomerFollowCriteria) obj;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (followType == null) {
			if (other.followType != null)
				return false;
		} else if (!followType.equals(other.followType))
			return false;
		if (serviceId == null) {
			if (other.serviceId != null)
				return false;
		} else if (!serviceId.equals(other.serviceId))
			return false;
		if (targetId == null) {
			if (other.targetId != null)
				return false;
		} else if (!targetId.equals(other.targetId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CustomerFollowCriteria [customerId=" + customerId
				+ ", serviceId=" + serviceId + ", targetId=" + targetId
				+ ", followType=" + followType + "]";
	}

}
