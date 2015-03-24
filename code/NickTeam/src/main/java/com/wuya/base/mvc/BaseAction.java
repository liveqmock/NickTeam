package com.wuya.base.mvc;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.wuya.base.enumerate.RequestTypeEnum;
import com.wuya.base.util.FrameUtil;

/**
 * [基类－控制器]
 * 
 * @author nick
 * @version v1.0 2014-8-6
 */
public class BaseAction {

	public static final String SERVICE_RESULT = "serviceResult";

	/**
	 * [HTTP范围枚举]
	 * 
	 * @author nick
	 * @version v1.0 2014-8-6
	 */
	enum HttpScopeEnum {
		REQUEST("request"), SESSION("session");

		private String scope;

		private HttpScopeEnum(String scope) {
			this.scope = scope;
		}

		public String getScope() {
			return scope;
		}

	}

	/**
	 * [获取request对象]
	 * 
	 * @return
	 */
	public HttpServletRequest getRequest() {
		ActionContext ctx = ActionContext.getContext();
		if (null != ctx && null != ctx.get(StrutsStatics.HTTP_REQUEST)) {
			return (HttpServletRequest) ctx.get(StrutsStatics.HTTP_REQUEST);
		} else {
			return null;
		}
	}

	/**
	 * [获取resonse对象]
	 * 
	 * @return
	 */
	public HttpServletResponse getResponse() {
		ActionContext ctx = ActionContext.getContext();
		if (null != ctx && null != ctx.get(StrutsStatics.HTTP_RESPONSE)) {
			return (HttpServletResponse) ctx.get(StrutsStatics.HTTP_RESPONSE);
		} else {
			return null;
		}
	}

	/**
	 * [获取session] [特别说明：struts2将session对象封装成了map实例，开发者在获取该map实例后，直接对其设值即可]
	 * 
	 * @return
	 */
	public Map<String, Object> getSessionMap() {
		ActionContext ctx = ActionContext.getContext();
		if (null != ctx && null != ctx.getSession()) {
			return ctx.getSession();
		} else {
			return null;
		}
	}

	/**
	 * [从request中获取参数]
	 * 
	 * @return
	 */
	public Object getParameterFromScope(String key, String scopeStr) {
		if (scopeStr.equals(HttpScopeEnum.REQUEST.getScope())) { // 从request中取
			return this.getParameterMapFromRequest().get(key);
		} else if (scopeStr.equals(HttpScopeEnum.SESSION.getScope())) { // 从session中取
			return getSessionMap().get(key);
		}
		return null;
	}
	
	/**
	 * [从request中获取参数]
	 * 
	 * @return
	 */
	public Object getValueFromScope(String key, String scopeStr) {
		if (scopeStr.equals(HttpScopeEnum.REQUEST.getScope())) { // 从request中取
			return getRequest().getAttribute(key);
		} else if (scopeStr.equals(HttpScopeEnum.SESSION.getScope())) { // 从session中取
			return getSessionMap().get(key);
		}
		return null;
	}

	/**
	 * [往指定的域中设值]
	 * 
	 * @param key
	 * @param value
	 * @param scopeStr
	 */
	public void setValueToScope(String key, Object value, String scopeStr) {
		if (scopeStr.equals(HttpScopeEnum.REQUEST.getScope())) { // 设值到request中去
			getRequest().setAttribute(key, value);
		} else if (scopeStr.equals(HttpScopeEnum.SESSION.getScope())) { // 设值到session中去
			getSessionMap().put(key, value);
		}
	}

	/**
	 * [获取request中的参数，并组织成map的结构]
	 * 
	 * @return
	 */
	public Map<String, Object> getParameterMapFromRequest() {
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		Enumeration<String> parameterNames = this.getRequest()
				.getParameterNames();
		while (parameterNames.hasMoreElements()) {
			String name = parameterNames.nextElement();
			parameterMap.put(name, this.getRequest().getParameter(name));
		}
		return parameterMap;
	}

	/**
	 * [获取request中的属性，并组织称map的结构]
	 * 
	 * @return
	 */
	public Map<String, Object> getAttributeMapFromRequest() {
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		Enumeration<String> parameterNames = this.getRequest()
				.getAttributeNames();
		while (parameterNames.hasMoreElements()) {
			String name = parameterNames.nextElement();
			parameterMap.put(name, this.getRequest().getAttribute(name));
		}
		return parameterMap;
	}

	/**
	 * 向客户端输出数据
	 * 
	 * @param message
	 * @throws Exception
	 */
	public void outputMessage(String message) throws Exception {
		FrameUtil.outputMessage(this.getResponse(), message);
	}

	/**
	 * 将一个对象以json格式输出到客户端
	 * 
	 * @param object
	 * @throws Exception
	 */
	public void outputJsonMessage(Object object) throws Exception {
		FrameUtil.outputJsonMessage(this.getResponse(), object);
	}

	/**
	 * 判断当前请求是否是ajax请求,如果传入的参数isajax==1表示为ajax请求，其他非ajax请求
	 * 
	 * @return
	 */
	public boolean isAjaxRequest() {
		return RequestTypeEnum.ISAJAX.getDescription().equals(
				getParameterMapFromRequest().get(
						RequestTypeEnum.ISAJAX.getCode()));
	}

	/**
	 * 判断当前请求是否通过easyui组件发出的,如果传入的参数iseasyui==1表示为是通过easyui组件发出的，不是则为其他非easyui请求
	 * 
	 * @return
	 */
	public boolean isEasyUIRequest() {
		return RequestTypeEnum.ISEASYUI.getDescription().equals(
				getParameterMapFromRequest().get(
						RequestTypeEnum.ISEASYUI.getCode()));
	}

}
