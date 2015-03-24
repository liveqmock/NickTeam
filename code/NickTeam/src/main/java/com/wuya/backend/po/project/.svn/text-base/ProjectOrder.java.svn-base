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

import com.wuya.backend.po.base.BaseBusinessPo;
import com.wuya.backend.po.share.Cost;
import com.wuya.backend.po.share.Image;
import com.wuya.backend.po.user.Passport;
import com.wuya.base.enumerate.YesOrNoEnum;
import com.wuya.base.enumerate.project.InterviewFlagEnum;
import com.wuya.base.enumerate.project.ProjectOrderPayTypeEnum;
import com.wuya.base.enumerate.project.ProjectOrderStatusEnum;
import com.wuya.base.inter.IValidateable;
import com.wuya.base.util.NumberUtil;
import com.wuya.base.util.StringUtil;

/**
 * [项目订单-实体类]
 * 
 * @author nick
 * @version v1.0 2015-2-13
 */
@Entity
@Table(name = "project_order", catalog = "wuya")
public class ProjectOrder extends BaseBusinessPo implements IValidateable {

	/**
	 * [对象序列化标识]
	 */
	private static final long serialVersionUID = 9180158858571048499L;

	/**
	 * [主项目标识-主项目]
	 */
	@Column(name = "projectId", nullable = false)
	private Integer projectId;

	/**
	 * [子项目标识－子项目]
	 */
	@Column(name = "subProjectId", nullable = false)
	private Integer subProjectId;

	/**
	 * [项目主办方标识]
	 */
	@Column(name = "projectHolderId", nullable = false)
	private Integer projectHolderId;

	/**
	 * [通行证标识]
	 */
	@Column(name = "passportId", nullable = false)
	private Integer passportId;

	/**
	 * [客服人员标识]
	 */
	@Column(name = "serviceId", nullable = true)
	private Integer serviceId;

	/**
	 * [是否需要机票]
	 */
	@Column(name = "needAirTicket", nullable = true)
	private String needAirTicket;

	/**
	 * [机票标识]
	 */
	@Column(name = "airTicketId", nullable = false)
	private Integer airTicketId;

	/**
	 * [订单状态]
	 */
	@Column(name = "status", length = 20, nullable = false)
	private String status;

	/**
	 * [支付类型]
	 */
	@Column(name = "payType", length = 20, nullable = false)
	private String payType;

	/**
	 * [是否已经付了报名费]
	 */
	@Column(name = "isEntryFeePaid", length = 5, nullable = false)
	private String isEntryFeePaid;

	/**
	 * [是否已经付了项目费]
	 */
	@Column(name = "isProjectFeePaid", length = 5, nullable = false)
	private String isProjectFeePaid;

	/**
	 * [面试官标识]
	 */
	@Column(name = "interviewerId", nullable = false)
	private Integer interviewerId;

	/**
	 * [面试开始时间]
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "interviewStartTime", nullable = true)
	private Date interviewStartTime;

	/**
	 * [面试结束时间]
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "interviewEndTime", nullable = true)
	private Date interviewEndTime;

	/**
	 * [面试结果标志,未面试,面试通过,面试不通过]
	 */
	@Column(name = "interviewFlag", length = 20, nullable = false)
	private String interviewFlag;

	/**
	 * [面试结果信息]
	 */
	@Column(name = "interviewResult", length = 500, nullable = true)
	private String interviewResult;

	/**
	 * [参与面试的次数]
	 */
	@Column(name = "interviewTimes", nullable = false)
	private Integer interviewTimes;

	/**
	 * [订单备注]
	 */
	@Column(name = "remark", length = 500, nullable = true)
	private String remark;

	/* 非持久化字段-开始 */
	@Transient
	private ProjectInfo projectInfo;

	@Transient
	private ProjectInfo subProjectInfo;

	@Transient
	private Passport passport;

	@Transient
	private Passport interviewer;

	@Transient
	private ProjectHolder projectHolder;

	@Transient
	private String statusStr;

	@Transient
	private String needAirTicketStr;

	@Transient
	private List<Cost> costs;

	@Transient
	private String payTypeStr;

	@Transient
	private String isEntryFeePaidStr;

	@Transient
	private String isProjectFeePaidStr;

	@Transient
	private String interviewStartTimeStr;

	@Transient
	private String interviewEndTimeStr;

	@Transient
	private String interviewFlagStr;

	@Transient
	private Image projectImage;

	/* 非持久化字段-结束 */

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public Integer getSubProjectId() {
		return subProjectId;
	}

	public void setSubProjectId(Integer subProjectId) {
		this.subProjectId = subProjectId;
	}

	public Integer getProjectHolderId() {
		return projectHolderId;
	}

	public void setProjectHolderId(Integer projectHolderId) {
		this.projectHolderId = projectHolderId;
	}

	public Integer getPassportId() {
		return passportId;
	}

	public void setPassportId(Integer passportId) {
		this.passportId = passportId;
	}

	public Integer getServiceId() {
		return serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNeedAirTicket() {
		return needAirTicket;
	}

	public void setNeedAirTicket(String needAirTicket) {
		this.needAirTicket = needAirTicket;
	}

	public ProjectInfo getProjectInfo() {
		return projectInfo;
	}

	public void setProjectInfo(ProjectInfo projectInfo) {
		this.projectInfo = projectInfo;
	}

	public ProjectInfo getSubProjectInfo() {
		return subProjectInfo;
	}

	public void setSubProjectInfo(ProjectInfo subProjectInfo) {
		this.subProjectInfo = subProjectInfo;
	}

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	public ProjectHolder getProjectHolder() {
		return projectHolder;
	}

	public void setProjectHolder(ProjectHolder projectHolder) {
		this.projectHolder = projectHolder;
	}

	public String getStatusStr() {
		if (StringUtil.isNotEmpty(this.status)) {
			for (ProjectOrderStatusEnum s : ProjectOrderStatusEnum.values()) {
				if (this.status.equals(s.getCode())) {
					statusStr = s.getMsg();
				}
			}
		}
		return statusStr;
	}

	public void setStatusStr(String statusStr) {
		this.statusStr = statusStr;
	}

	public String getNeedAirTicketStr() {
		if (StringUtil.isNotEmpty(this.needAirTicket)) {
			for (YesOrNoEnum y : YesOrNoEnum.values()) {
				if (this.needAirTicket.equals(y.getCode())) {
					needAirTicketStr = y.getMsg();
				}
			}
		}
		return needAirTicketStr;
	}

	public void setNeedAirTicketStr(String needAirTicketStr) {
		this.needAirTicketStr = needAirTicketStr;
	}

	public List<Cost> getCosts() {
		return costs;
	}

	public void setCosts(List<Cost> costs) {
		this.costs = costs;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getPayTypeStr() {
		if (StringUtil.isNotEmpty(this.payType)) {
			this.payTypeStr = ProjectOrderPayTypeEnum
					.getMsgByCode(this.payType);
		}
		return this.payTypeStr;
	}

	public void setPayTypeStr(String payTypeStr) {
		this.payTypeStr = payTypeStr;
	}

	public String getIsEntryFeePaid() {
		return isEntryFeePaid;
	}

	public void setIsEntryFeePaid(String isEntryFeePaid) {
		this.isEntryFeePaid = isEntryFeePaid;
	}

	public String getIsProjectFeePaid() {
		return isProjectFeePaid;
	}

	public void setIsProjectFeePaid(String isProjectFeePaid) {
		this.isProjectFeePaid = isProjectFeePaid;
	}

	public String getIsEntryFeePaidStr() {
		return YesOrNoEnum.getMsgByCode(this.isEntryFeePaid);
	}

	public void setIsEntryFeePaidStr(String isEntryFeePaidStr) {
		this.isEntryFeePaidStr = isEntryFeePaidStr;
	}

	public String getIsProjectFeePaidStr() {
		return YesOrNoEnum.getMsgByCode(this.isProjectFeePaidStr);
	}

	public void setIsProjectFeePaidStr(String isProjectFeePaidStr) {
		this.isProjectFeePaidStr = isProjectFeePaidStr;
	}

	public Integer getInterviewerId() {
		return interviewerId;
	}

	public void setInterviewerId(Integer interviewerId) {
		this.interviewerId = interviewerId;
	}

	public Passport getInterviewer() {
		return interviewer;
	}

	public void setInterviewer(Passport interviewer) {
		this.interviewer = interviewer;
	}

	public Date getInterviewStartTime() {
		return interviewStartTime;
	}

	public void setInterviewStartTime(Date interviewStartTime) {
		this.interviewStartTime = interviewStartTime;
	}

	public Date getInterviewEndTime() {
		return interviewEndTime;
	}

	public void setInterviewEndTime(Date interviewEndTime) {
		this.interviewEndTime = interviewEndTime;
	}

	public String getInterviewStartTimeStr() {
		if (null != this.interviewStartTime) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			this.interviewStartTimeStr = sdf.format(this.interviewStartTime);
		}
		return interviewStartTimeStr;
	}

	public void setInterviewStartTimeStr(String interviewStartTimeStr) {
		this.interviewStartTimeStr = interviewStartTimeStr;
	}

	public String getInterviewEndTimeStr() {
		if (null != this.interviewEndTime) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			this.interviewEndTimeStr = sdf.format(this.interviewEndTime);
		}
		return interviewEndTimeStr;
	}

	public void setInterviewEndTimeStr(String interviewEndTimeStr) {
		this.interviewEndTimeStr = interviewEndTimeStr;
	}

	public String getInterviewFlag() {
		return interviewFlag;
	}

	public void setInterviewFlag(String interviewFlag) {
		this.interviewFlag = interviewFlag;
	}

	public String getInterviewResult() {
		return interviewResult;
	}

	public void setInterviewResult(String interviewResult) {
		this.interviewResult = interviewResult;
	}

	public String getInterviewFlagStr() {
		return InterviewFlagEnum.getMsgByCode(this.interviewFlag);
	}

	public void setInterviewFlagStr(String interviewFlagStr) {
		this.interviewFlagStr = interviewFlagStr;
	}

	public Integer getInterviewTimes() {
		return interviewTimes;
	}

	public void setInterviewTimes(Integer interviewTimes) {
		this.interviewTimes = interviewTimes;
	}

	public Integer getAirTicketId() {
		return airTicketId;
	}

	public void setAirTicketId(Integer airTicketId) {
		this.airTicketId = airTicketId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Image getProjectImage() {
		return projectImage;
	}

	public void setProjectImage(Image projectImage) {
		this.projectImage = projectImage;
	}

	@Override
	public String toString() {
		return "ProjectOrder [projectId=" + projectId + ", subProjectId="
				+ subProjectId + ", projectHolderId=" + projectHolderId
				+ ", passportId=" + passportId + ", serviceId=" + serviceId
				+ ", needAirTicket=" + needAirTicket + ", airTicketId="
				+ airTicketId + ", status=" + status + ", payType=" + payType
				+ ", isEntryFeePaid=" + isEntryFeePaid + ", isProjectFeePaid="
				+ isProjectFeePaid + ", interviewerId=" + interviewerId
				+ ", interviewStartTime=" + interviewStartTime
				+ ", interviewEndTime=" + interviewEndTime + ", interviewFlag="
				+ interviewFlag + ", interviewResult=" + interviewResult
				+ ", interviewTimes=" + interviewTimes + ", remark=" + remark
				+ ", projectInfo=" + projectInfo + ", subProjectInfo="
				+ subProjectInfo + ", passport=" + passport + ", interviewer="
				+ interviewer + ", projectHolder=" + projectHolder
				+ ", statusStr=" + statusStr + ", needAirTicketStr="
				+ needAirTicketStr + ", costs=" + costs + ", payTypeStr="
				+ payTypeStr + ", isEntryFeePaidStr=" + isEntryFeePaidStr
				+ ", isProjectFeePaidStr=" + isProjectFeePaidStr
				+ ", interviewStartTimeStr=" + interviewStartTimeStr
				+ ", interviewEndTimeStr=" + interviewEndTimeStr
				+ ", interviewFlagStr=" + interviewFlagStr + ", projectImage="
				+ projectImage + "]";
	}

	public boolean validate() {
		if (NumberUtil.isEmptyOrZero(this.projectId)
				|| NumberUtil.isEmptyOrZero(this.subProjectId)
				|| NumberUtil.isEmptyOrZero(this.projectHolderId)
				|| NumberUtil.isEmptyOrZero(this.passportId)
				|| StringUtil.isEmpty(this.status)) {
			return false;
		} else {
			return true;
		}
	}

}
