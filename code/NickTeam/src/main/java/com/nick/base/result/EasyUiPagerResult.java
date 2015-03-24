package com.nick.base.result;

import java.util.List;

/**
 * [easyui分页结果]
 * 
 * @author NICK
 * @version v1.0 2015-2-3
 */
public class EasyUiPagerResult implements java.io.Serializable {

	/**
	 * [对象序列化标识]
	 */
	private static final long serialVersionUID = 3049963424876649593L;

	private Integer total;

	@SuppressWarnings("rawtypes")
	private List rows;

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	@SuppressWarnings("rawtypes")
	public List getRows() {
		return rows;
	}

	@SuppressWarnings("rawtypes")
	public void setRows(List rows) {
		this.rows = rows;
	}

	@Override
	public String toString() {
		return "EasyUiPagerResult [total=" + total + ", rows=" + rows + "]";
	}

}
