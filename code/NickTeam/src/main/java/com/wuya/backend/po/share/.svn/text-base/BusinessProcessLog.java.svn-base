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
import com.wuya.base.enumerate.project.ProjectOrderStatusEnum;
import com.wuya.base.enumerate.share.BusinessProcessTargetTypeEnum;
import com.wuya.base.inter.IValidateable;
import com.wuya.base.util.NumberUtil;
import com.wuya.base.util.StringUtil;

/**
 * [业务流程日志－实体类]
 * 
 * @author nick
 * @version v1.0 2015-2-23
 */
@Entity
@Table(name = "business_process_log", catalog = "wuya")
public class BusinessProcessLog extends BasePo implements IValidateable {

	/**
	 * [对象序列化标识]
	 */
	private static final long serialVersionUID = -3471478839350385256L;

	/**
	 * [操作人标识]
	 */
	@Column(name = "operaterId", nullable = false)
	private Integer operaterId;

	/**
	 * [操作人类型]
	 */
	@Column(name = "operaterType", length = 20, nullable = false)
	private String operaterType;

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
	 * [迁移前状态]
	 */
	@Column(name = "prevStatus", length = 20, nullable = false)
	private String prevStatus;

	/**
	 * [迁移后状态]
	 */
	@Column(name = "nextStatus", length = 20, nullable = false)
	private String nextStatus;

	/**
	 * [创建时间]
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createTime", nullable = false)
	private Date createTime;

	// ============ 非持久化字段 开始 ====================== //

	@Transient
	private String targetTypeStr;

	@Transient
	private String prevStatusStr;

	@Transient
	private String nextStatusStr;

	@Transient
	private String createTimeStr;

	// ============ 非持久化字段 结束 ====================== //
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getTargetTypeStr() {
		return BusinessProcessTargetTypeEnum.getMsgByCode(this.targetType);
	}

	public void setTargetTypeStr(String targetTypeStr) {
		this.targetTypeStr = targetTypeStr;
	}

	public String getPrevStatusStr() {
		if (BusinessProcessTargetTypeEnum.PROJECT_ORDER.getCode().equals(
				this.targetType)) {
			this.prevStatusStr = ProjectOrderStatusEnum
					.getMsgByCode(this.prevStatus);
		}
		return prevStatusStr;
	}

	public void setPrevStatusStr(String prevStatusStr) {
		this.prevStatusStr = prevStatusStr;
	}

	public String getNextStatusStr() {
		if (BusinessProcessTargetTypeEnum.PROJECT_ORDER.getCode().equals(
				this.targetType)) {
			this.nextStatusStr = ProjectOrderStatusEnum
					.getMsgByCode(this.nextStatus);
		}
		return nextStatusStr;
	}

	public void setNextStatusStr(String nextStatusStr) {
		this.nextStatusStr = nextStatusStr;
	}

	public String getCreateTimeStr() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (null != this.createTime) {
			this.createTimeStr = sdf.format(this.createTime);
		} else {
			this.createTimeStr = null;
		}
		return createTimeStr;
	}

	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}

	@Override
	public String toString() {
		return "BusinessProcessLog [operaterId=" + operaterId
				+ ", operaterType=" + operaterType + ", targetId=" + targetId
				+ ", targetType=" + targetType + ", prevStatus=" + prevStatus
				+ ", nextStatus=" + nextStatus + ", createTime=" + createTime
				+ "]";
	}

	/**
	 * [自我检测方法]
	 */
	public boolean validate() {
		if (NumberUtil.isEmptyOrZero(this.operaterId)
				|| NumberUtil.isEmptyOrZero(targetId)
				|| StringUtil.isEmpty(this.operaterType)
				|| StringUtil.isEmpty(this.targetType)
				|| StringUtil.isEmpty(this.prevStatus)
				|| StringUtil.isEmpty(this.nextStatus)) {
			return false;
		}
		return true;
	}

}
