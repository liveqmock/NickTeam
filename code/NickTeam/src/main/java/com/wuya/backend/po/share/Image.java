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
import com.wuya.base.config.FtpServerEnum;
import com.wuya.base.config.HttpServerEnum;
import com.wuya.base.inter.IValidateable;
import com.wuya.base.util.NumberUtil;
import com.wuya.base.util.StringUtil;

/**
 * [图片－实体类]
 * 
 * @author nick
 * @version v1.0 2015-2-23
 */
@Entity
@Table(name = "image", catalog = "wuya")
public class Image extends BasePo implements IValidateable {

	/**
	 * [对象序列化标识]
	 */
	private static final long serialVersionUID = -1650041972146498372L;

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
	 * [服务器代号]
	 */
	@Column(name = "serverCode", length = 60, nullable = false)
	private String serverCode;

	/**
	 * [文件名]
	 */
	@Column(name = "fileName", length = 80, nullable = false)
	private String fileName;

	/**
	 * [文件格式]
	 */
	@Column(name = "fileFormat", length = 20, nullable = false)
	private String fileFormat;

	/**
	 * [创建时间]
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createTime", nullable = false)
	private Date createTime;

	// =======================非持久化字段 开始=====================//
	@Transient
	private String imagePath;

	@Transient
	private String dataFloder;

	// =======================非持久化字段 结束=====================//

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

	public String getServerCode() {
		return serverCode;
	}

	public void setServerCode(String serverCode) {
		this.serverCode = serverCode;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileFormat() {
		return fileFormat;
	}

	public void setFileFormat(String fileFormat) {
		this.fileFormat = fileFormat;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getImagePath() {
		// 获取ftp服务器并获取对应的http服务器信息
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		FtpServerEnum fse = FtpServerEnum.getByCode(this.serverCode);
		HttpServerEnum hse = HttpServerEnum.getByCode(fse.getHttpServerCode());
		this.imagePath = hse.getProtocol() + "://" + hse.getBaseAddress() + ":"
				+ hse.getPort() + "/" + hse.getPath() + "/" + hse.getSubpath()
				+ "/" + sdf.format(this.createTime) + "/" + this.fileName + "."
				+ fileFormat;
		return imagePath;
	}

	public String getDataFloder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		this.dataFloder = sdf.format(this.createTime);
		return dataFloder;
	}

	public void setDataFloder(String dataFloder) {
		this.dataFloder = dataFloder;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result
				+ ((fileFormat == null) ? 0 : fileFormat.hashCode());
		result = prime * result
				+ ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result
				+ ((serverCode == null) ? 0 : serverCode.hashCode());
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
		Image other = (Image) obj;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (fileFormat == null) {
			if (other.fileFormat != null)
				return false;
		} else if (!fileFormat.equals(other.fileFormat))
			return false;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!fileName.equals(other.fileName))
			return false;
		if (serverCode == null) {
			if (other.serverCode != null)
				return false;
		} else if (!serverCode.equals(other.serverCode))
			return false;
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

	/**
	 * [自我检查方法]
	 */
	public boolean validate() {
		if (NumberUtil.isEmptyOrZero(this.targetId)
				|| StringUtil.isEmpty(this.targetType)
				|| StringUtil.isEmpty(this.serverCode)
				|| StringUtil.isEmpty(this.fileName)
				|| StringUtil.isEmpty(this.fileFormat)) {
			return false;
		} else {
			return true;
		}
	}

}
