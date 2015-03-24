package com.wuya.backend.po.user;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.wuya.backend.po.base.BasePo;
import com.wuya.base.inter.IValidateable;
import com.wuya.base.util.StringUtil;

/**
 * [教育信息－实体类]
 * 
 * @author nick
 * @version v1.0 2015-1-31
 */
@Entity
@Table(name = "user_education", catalog = "wuya")
public class UserEducation extends BasePo implements IValidateable {

	/**
	 * [对象序列化标识]
	 */
	private static final long serialVersionUID = 413923052758352487L;

	/**
	 * [学校名称]
	 */
	@Column(name = "schoolName", length = 20, nullable = false)
	private String schoolName;

	/**
	 * [教育类型]
	 */
	@Column(name = "type", length = 20, nullable = false)
	private String type;

	/**
	 * [开始日期]
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "startDate", nullable = false)
	private Date startDate;

	/**
	 * [结束日期]
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "endDate", nullable = false)
	private Date endDate;

	/**
	 * [对应通行证标识]
	 */
	@Column(name = "passportId", nullable = false)
	private Integer passportId;
	
	/* 辅助字段 开始 */
	@Transient
	private String startDateStr;
	
	@Transient
	private String endDateStr;
	/* 辅助字段 结束 */

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getPassportId() {
		return passportId;
	}

	public void setPassportId(Integer passportId) {
		this.passportId = passportId;
	}

	/* 辅助字段 开始 */
	public String getStartDateStr() {
		if (null != this.startDate) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			this.startDateStr = sdf.format(this.startDate);
		}
		return startDateStr;
	}

	public String getEndDateStr() {
		if (null != this.endDate) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			this.endDateStr = sdf.format(this.endDate);
		}
		return endDateStr;
	}

	/* 辅助字段 结束 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result
				+ ((schoolName == null) ? 0 : schoolName.hashCode());
		result = prime * result
				+ ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		UserEducation other = (UserEducation) obj;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (schoolName == null) {
			if (other.schoolName != null)
				return false;
		} else if (!schoolName.equals(other.schoolName))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserEducation [schoolName=" + schoolName + ", type=" + type
				+ ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}

	/**
	 * [自我验证接口]
	 */
	public boolean validate() {
		if (StringUtil.isEmpty(this.schoolName)
				|| StringUtil.isEmpty(this.type) || null == this.startDate
				|| null == this.endDate) {
			return false;
		} else {
			return true;
		}
	}

}
