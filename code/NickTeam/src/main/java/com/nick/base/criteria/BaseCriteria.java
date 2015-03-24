package com.nick.base.criteria;

/**
 * [基础查询类]
 * 
 * @author nick
 * @version v1.0 2015-2-3
 */
public class BaseCriteria implements java.io.Serializable {

	/**
	 * [对象序列化标识]
	 */
	private static final long serialVersionUID = 5736397056522332779L;

	/**
	 * [是否分页]
	 */
	private boolean requirePage;

	/**
	 * [页面大小]
	 */
	private Integer rows;

	/**
	 * [当前多少页]
	 */
	private Integer page;

	/**
	 * [当前数据行]
	 */
	private Integer firstIndex;

	/**
	 * [数据状态]
	 */
	private String dstatus;

	/**
	 * [标识]
	 */
	private Integer id;

	public boolean isRequirePage() {
		return requirePage;
	}

	public void setRequirePage(boolean requirePage) {
		this.requirePage = requirePage;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getFirstIndex() {
		return (this.page - 1) * this.rows;
	}

	public void setFirstIndex(Integer firstIndex) {
		this.firstIndex = firstIndex;
	}

	public String getDstatus() {
		return dstatus;
	}

	public void setDstatus(String dstatus) {
		this.dstatus = dstatus;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dstatus == null) ? 0 : dstatus.hashCode());
		result = prime * result
				+ ((firstIndex == null) ? 0 : firstIndex.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((page == null) ? 0 : page.hashCode());
		result = prime * result + (requirePage ? 1231 : 1237);
		result = prime * result + ((rows == null) ? 0 : rows.hashCode());
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
		BaseCriteria other = (BaseCriteria) obj;
		if (dstatus == null) {
			if (other.dstatus != null)
				return false;
		} else if (!dstatus.equals(other.dstatus))
			return false;
		if (firstIndex == null) {
			if (other.firstIndex != null)
				return false;
		} else if (!firstIndex.equals(other.firstIndex))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (page == null) {
			if (other.page != null)
				return false;
		} else if (!page.equals(other.page))
			return false;
		if (requirePage != other.requirePage)
			return false;
		if (rows == null) {
			if (other.rows != null)
				return false;
		} else if (!rows.equals(other.rows))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BaseCriteria [requirePage=" + requirePage + ", rows=" + rows
				+ ", page=" + page + ", firstIndex=" + firstIndex
				+ ", dstatus=" + dstatus + ", id=" + id + "]";
	}

}
