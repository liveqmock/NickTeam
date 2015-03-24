package com.wuya.backend.po.share;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.wuya.backend.po.base.BaseBusinessPo;
import com.wuya.base.inter.IValidateable;
import com.wuya.base.util.NumberUtil;
import com.wuya.base.util.StringUtil;

/**
 * [客户跟进－实体类]
 * 
 * @author nick
 * @version v1.0 2015-2-21
 */
@Entity
@Table(name = "customer_follow", catalog = "wuya")
public class CustomerFollow extends BaseBusinessPo implements IValidateable {

	/**
	 * [对象序列化标识]
	 */
	private static final long serialVersionUID = -8680208432500622453L;

	/**
	 * [客户标识]
	 */
	@Column(name = "customerId", nullable = false)
	private Integer customerId;

	/**
	 * [客服标识]
	 */
	@Column(name = "serviceId", nullable = false)
	private Integer serviceId;

	/**
	 * [跟进目标标识]
	 */
	@Column(name = "targetId", nullable = false)
	private Integer targetId;

	/**
	 * [跟进类型－枚举类维护]
	 */
	@Column(name = "followType", length = 20, nullable = false)
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

	public String getFollowType() {
		return followType;
	}

	public void setFollowType(String followType) {
		this.followType = followType;
	}

	public Integer getTargetId() {
		return targetId;
	}

	public void setTargetId(Integer targetId) {
		this.targetId = targetId;
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
		CustomerFollow other = (CustomerFollow) obj;
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
		return "CustomerFollow [customerId=" + customerId + ", serviceId="
				+ serviceId + ", followType=" + followType + ", targetId="
				+ targetId + "]";
	}

	/**
	 * [合法性判断]
	 */
	public boolean validate() {
		if (NumberUtil.isEmptyOrZero(this.customerId)
				|| NumberUtil.isEmptyOrZero(this.serviceId)
				|| NumberUtil.isEmptyOrZero(this.targetId)
				|| StringUtil.isEmail(this.followType)) {
			return false;
		}
		return true;
	}

}
