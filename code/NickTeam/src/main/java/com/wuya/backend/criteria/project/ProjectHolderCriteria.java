package com.wuya.backend.criteria.project;

import javax.persistence.Column;

import com.wuya.base.criteria.BaseCriteria;

/**
 * [项目主办方－条件封装]
 * 
 * @author nick
 * @version v1.0 2015-2-3
 */
public class ProjectHolderCriteria extends BaseCriteria {

	/**
	 * [对象序列化标识]
	 */
	private static final long serialVersionUID = -7532859486860537534L;

	/**
	 * [项目标识]
	 */
	@Column(name = "projectId", nullable = false)
	private Integer projectId;

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	@Override
	public String toString() {
		return "ProjectHolderCriteria [projectId=" + projectId + "]";
	}
	
}
