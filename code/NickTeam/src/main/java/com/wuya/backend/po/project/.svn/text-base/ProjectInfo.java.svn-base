package com.wuya.backend.po.project;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.wuya.backend.po.base.BasePo;
import com.wuya.backend.po.share.Cost;
import com.wuya.backend.po.share.Image;
import com.wuya.base.constant.CommonConstant;
import com.wuya.base.inter.IValidateable;
import com.wuya.base.util.StringUtil;

/**
 * [项目信息－持久化类]
 * 
 * @author nick
 * @version v1.0 2015-2-3
 */
@Entity
@Table(name = "project_info", catalog = "wuya")
public class ProjectInfo extends BasePo implements IValidateable {

	/**
	 * [对象序列化标识]
	 */
	private static final long serialVersionUID = 8978167133806429868L;

	/**
	 * [项目名称]
	 */
	@Column(name = "name", length = 30, nullable = true)
	private String name;

	/**
	 * [简介]
	 */
	@Column(name = "description", length = 300, nullable = true)
	private String description;

	/**
	 * [起始时间]
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "startDate", nullable = true)
	private Date startDate;

	/**
	 * [终止时间]
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "endDate", nullable = true)
	private Date endDate;

	/**
	 * [父级项目标识]
	 */
	@Column(name = "pid", nullable = false)
	private Integer pid;

	/**
	 * [期数]
	 */
	@Column(name = "level", nullable = false)
	private Integer level;

	/**
	 * [是否上线]
	 */
	@Column(name = "isOnline", nullable = false)
	private String isOnline;

	/**
	 * [信息描述地址]
	 */
	@Column(name = "msgAddress", length = 500, nullable = true)
	private String msgAddress;

	/**
	 * [缩写]
	 */
	@Column(name = "shortName", length = 50, nullable = true)
	private String shortName;

	/**
	 * [申请数量]
	 */
	@Column(name = "applyCount", nullable = true)
	private Integer applyCount;

	/* 辅助字段 开始 */
	@Transient
	private String startDateStr;

	@Transient
	private String endDateStr;

	@Transient
	private List<ProjectInfo> subProjects;

	@Transient
	private List<Cost> costs;

	@Transient
	private Image image;

	/* 辅助字段 结束 */

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getIsOnline() {
		return isOnline;
	}

	public void setIsOnline(String isOnline) {
		this.isOnline = isOnline;
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

	public List<ProjectInfo> getSubProjects() {
		return subProjects;
	}

	public void setSubProjects(List<ProjectInfo> subProjects) {
		this.subProjects = subProjects;
	}

	public List<Cost> getCosts() {
		return costs;
	}

	public void setCosts(List<Cost> costs) {
		this.costs = costs;
	}

	/* 辅助字段 结束 */

	public Integer getApplyCount() {
		return applyCount;
	}

	public void setApplyCount(Integer applyCount) {
		this.applyCount = applyCount;
	}

	public String getMsgAddress() {
		return msgAddress;
	}

	public void setMsgAddress(String msgAddress) {
		this.msgAddress = msgAddress;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "ProjectInfo [name=" + name + ", description=" + description
				+ ", startDate=" + startDate + ", endDate=" + endDate
				+ ", pid=" + pid + ", level=" + level + ", isOnline="
				+ isOnline + ", msgAddress=" + msgAddress + ", shortName="
				+ shortName + ", applyCount=" + applyCount + ", startDateStr="
				+ startDateStr + ", endDateStr=" + endDateStr
				+ ", subProjects=" + subProjects + ", costs=" + costs
				+ ", image=" + image + "]";
	}

	public boolean validate() {
		if (null == this.pid || null == this.level
				|| StringUtil.isEmpty(this.isOnline)) {
			return false;
		} else {
			return true;
		}
	}

}
