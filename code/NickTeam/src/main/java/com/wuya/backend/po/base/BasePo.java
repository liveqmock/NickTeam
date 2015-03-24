package com.wuya.backend.po.base;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.wuya.base.enumerate.DataStatusEnum;

/**
 * [基础实体－实体类]
 * 
 * @author nick
 * @version v1.0 2015-1-24
 */
@MappedSuperclass
public class BasePo implements java.io.Serializable {

	public BasePo() {
		this.dstatus = DataStatusEnum.NORMAL.getCode();
	}

	/**
	 * [对象序列化标识]
	 */
	private static final long serialVersionUID = 7394695586435137359L;

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
	@Column(name = "dstatus", length = 20, nullable = false)
	private String dstatus;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dstatus == null) ? 0 : dstatus.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		BasePo other = (BasePo) obj;
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
		return true;
	}

	@Override
	public String toString() {
		return "BaseModel [id=" + id + ", dstatus=" + dstatus + "]";
	}

}
