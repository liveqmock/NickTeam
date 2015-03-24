package com.wuya.backend.po.project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.wuya.backend.po.base.BasePo;
import com.wuya.base.inter.IValidateable;
import com.wuya.base.util.StringUtil;

/**
 * [项目主办人－持久化类]
 * 
 * @author nick
 * @version v1.0 2015-2-3
 */
@Entity
@Table(name = "project_holder", catalog = "wuya")
public class ProjectHolder extends BasePo implements IValidateable {

	/**
	 * [对象序列化标识]
	 */
	private static final long serialVersionUID = -1884734200464205503L;

	/**
	 * [主办方名称]
	 */
	@Column(name = "name", length = 30, nullable = false)
	private String name;

	/**
	 * [主办方地址]
	 */
	@Column(name = "address", length = 60, nullable = true)
	private String address;

	/**
	 * [主办方描述]
	 */
	@Column(name = "description", length = 300, nullable = true)
	private String description;

	/**
	 * [项目标识]
	 */
	@Column(name = "projectId", nullable = false)
	private Integer projectId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((projectId == null) ? 0 : projectId.hashCode());
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
		ProjectHolder other = (ProjectHolder) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (projectId == null) {
			if (other.projectId != null)
				return false;
		} else if (!projectId.equals(other.projectId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProjectHolder [name=" + name + ", address=" + address
				+ ", description=" + description + ", projectId=" + projectId
				+ "]";
	}

	public boolean validate() {
		if (StringUtil.isEmpty(name) || null == this.projectId
				|| 0 == this.projectId) {
			return false;
		} else {
			return true;
		}
	}

}
