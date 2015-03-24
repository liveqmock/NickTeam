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
import com.wuya.base.constant.CommonConstant;
import com.wuya.base.enumerate.user.CertificateTypeEnum;
import com.wuya.base.inter.IValidateable;
import com.wuya.base.util.StringUtil;

/**
 * [用户证件－实体类]
 * 
 * @author nick
 * @version v1.0 2015-1-31
 */
@Entity
@Table(name = "user_certificate", catalog = "wuya")
public class UserCertificate extends BasePo implements IValidateable {

	/**
	 * [对象序列化标识]
	 */
	private static final long serialVersionUID = -7386574336695451863L;

	/**
	 * [证件号]
	 */
	@Column(name = "num", length = 30, nullable = false)
	private String num;

	/**
	 * [证件描述]
	 */
	@Column(name = "description", length = 60)
	private String description;

	/**
	 * [证件类型]
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

	@Transient
	private String typeStr;

	/* 辅助字段 结束 */

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/* 辅助字段 开始 */
	public String getStartDateStr() {
		if (null != this.startDate) {
			SimpleDateFormat sdf = new SimpleDateFormat(
					CommonConstant.SDF_FORMAT_1);
			this.startDateStr = sdf.format(this.startDate);
		}
		return startDateStr;
	}

	public String getEndDateStr() {
		if (null != this.endDate) {
			SimpleDateFormat sdf = new SimpleDateFormat(
					CommonConstant.SDF_FORMAT_1);
			this.endDateStr = sdf.format(this.endDate);
		}
		return endDateStr;
	}

	/* 辅助字段 结束 */

	public String getTypeStr() {
		return CertificateTypeEnum.getMsgByCode(this.type);
	}

	public void setTypeStr(String typeStr) {
		this.typeStr = typeStr;
	}

	public boolean validate() {
		if (StringUtil.isEmpty(this.num) || StringUtil.isEmpty(this.type)
				|| null == this.startDate || null == this.endDate) {
			return false;
		} else {
			return true;
		}
	}

}
