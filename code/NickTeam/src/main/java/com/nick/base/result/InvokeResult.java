package com.nick.base.result;

/**
 * [调用结果]
 * 
 * @author nick
 * @version v1.0 2015-1-5
 */
public class InvokeResult implements java.io.Serializable {

	/**
	 * [对象序列化标识]
	 */
	private static final long serialVersionUID = -5608250716511913087L;

	/**
	 * [调用情况]
	 */
	private String invokeState;

	/**
	 * [调用结果]
	 */
	private Object result;

	/**
	 * [有参构造函数]
	 * 
	 * @param invokeState
	 * @param result
	 */
	public InvokeResult(String invokeState, Object result) {
		this.invokeState = invokeState;
		this.result = result;
	}

	public String getInvokeState() {
		return invokeState;
	}

	public void setInvokeState(String invokeState) {
		this.invokeState = invokeState;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "InvokeResult [invokeState=" + invokeState + ", result="
				+ result + "]";
	}

}
