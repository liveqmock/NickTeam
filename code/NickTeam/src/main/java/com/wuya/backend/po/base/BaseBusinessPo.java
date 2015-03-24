package com.wuya.backend.po.base;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * [基础业务实体－实体类]
 * 
 * @author nick
 * @version v1.0 2015-1-24
 */
@MappedSuperclass
public class BaseBusinessPo implements java.io.Serializable {

	/**
	 * [对象序列化标识]
	 */
	private static final long serialVersionUID = -1801588251744972042L;

	/**
	 * [数据标识]
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	/**
	 * [数据状态]
	 */
	@Column(name = "dstatus", length = 20)
	private String dstatus;

	/**
	 * [创建人标识]
	 */
	@Column(name = "createId")
	private Integer createId;

	/**
	 * [创建时间]
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createTime")
	private Date createTime;

	/**
	 * [修改人标识]
	 */
	@Column(name = "updateId")
	private Integer updateId;

	/**
	 * [修改时间]
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updateTime")
	private Date updateTime;

	/**
	 * [删除人标识]
	 */
	@Column(name = "dropId")
	private Integer dropId;

	/**
	 * [删除时间]
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dropTime")
	private Date dropTime;

	/* 非持久化字段 开始 */

	@Transient
	private String createTimeStr;

	@Transient
	private String updateTimeStr;

	@Transient
	private String dropTimeStr;

	/* 非持久化字段 结束 */

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDstatus() {
		return dstatus;
	}

	public void setDstatus(String dstatus) {
		this.dstatus = dstatus;
	}

	public Integer getCreateId() {
		return createId;
	}

	public void setCreateId(Integer createId) {
		this.createId = createId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getUpdateId() {
		return updateId;
	}

	public void setUpdateId(Integer updateId) {
		this.updateId = updateId;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getDropId() {
		return dropId;
	}

	public void setDropId(Integer dropId) {
		this.dropId = dropId;
	}

	public Date getDropTime() {
		return dropTime;
	}

	public void setDropTime(Date dropTime) {
		this.dropTime = dropTime;
	}

	public String getCreateTimeStr() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (null != this.createTime) {
			this.createTimeStr = sdf.format(this.createTime);
		}
		return createTimeStr;
	}

	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}

	public String getUpdateTimeStr() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (null != this.updateTime) {
			this.updateTimeStr = sdf.format(this.updateTime);
		}
		return updateTimeStr;
	}

	public void setUpdateTimeStr(String updateTimeStr) {
		this.updateTimeStr = updateTimeStr;
	}

	public String getDropTimeStr() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (null != this.dropTime) {
			this.dropTimeStr = sdf.format(this.dropTime);
		}
		return dropTimeStr;
	}

	public void setDropTimeStr(String dropTimeStr) {
		this.dropTimeStr = dropTimeStr;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((createId == null) ? 0 : createId.hashCode());
		result = prime * result
				+ ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result
				+ ((createTimeStr == null) ? 0 : createTimeStr.hashCode());
		result = prime * result + ((dropId == null) ? 0 : dropId.hashCode());
		result = prime * result
				+ ((dropTime == null) ? 0 : dropTime.hashCode());
		result = prime * result
				+ ((dropTimeStr == null) ? 0 : dropTimeStr.hashCode());
		result = prime * result + ((dstatus == null) ? 0 : dstatus.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((updateId == null) ? 0 : updateId.hashCode());
		result = prime * result
				+ ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result
				+ ((updateTimeStr == null) ? 0 : updateTimeStr.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseBusinessPo other = (BaseBusinessPo) obj;
		if (createId == null) {
			if (other.createId != null)
				return false;
		} else if (!createId.equals(other.createId))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (createTimeStr == null) {
			if (other.createTimeStr != null)
				return false;
		} else if (!createTimeStr.equals(other.createTimeStr))
			return false;
		if (dropId == null) {
			if (other.dropId != null)
				return false;
		} else if (!dropId.equals(other.dropId))
			return false;
		if (dropTime == null) {
			if (other.dropTime != null)
				return false;
		} else if (!dropTime.equals(other.dropTime))
			return false;
		if (dropTimeStr == null) {
			if (other.dropTimeStr != null)
				return false;
		} else if (!dropTimeStr.equals(other.dropTimeStr))
			return false;
		if (dstatus == null) {
			if (other.dstatus != null)
				return false;
		} else if (!dstatus.equals(other.dstatus))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (updateId == null) {
			if (other.updateId != null)
				return false;
		} else if (!updateId.equals(other.updateId))
			return false;
		if (updateTime == null) {
			if (other.updateTime != null)
				return false;
		} else if (!updateTime.equals(other.updateTime))
			return false;
		if (updateTimeStr == null) {
			if (other.updateTimeStr != null)
				return false;
		} else if (!updateTimeStr.equals(other.updateTimeStr))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BaseBusinessPo [id=" + id + ", dstatus=" + dstatus
				+ ", createId=" + createId + ", createTime=" + createTime
				+ ", updateId=" + updateId + ", updateTime=" + updateTime
				+ ", dropId=" + dropId + ", dropTime=" + dropTime
				+ ", createTimeStr=" + createTimeStr + ", updateTimeStr="
				+ updateTimeStr + ", dropTimeStr=" + dropTimeStr + "]";
	}

}
