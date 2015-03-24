package com.wuya.studentweb.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wuya.backend.po.user.Passport;
import com.wuya.studentweb.constant.SessionKeyConstant;

/**
 * [登录状态过滤器]
 * 
 * @author nick
 * @version v1.0 2015-2-12
 */
public class LoginStatusFilter implements Filter {

	/**
	 * [登录请求]
	 */
	public static final String LOGIN_ACTION = "/user/login.action";

	/**
	 * [注册请求]
	 */
	public static final String REGIST_ACTION = "/user/regist.action";

	/**
	 * [登录界面跳转请求]
	 */
	public static final String TO_LOGIN_ACTION = "/router/toLogin.action";

	/**
	 * [注册界面跳转请求]
	 */
	public static final String TO_SIGNUP_ACTION = "/router/toSignUp.action";

	/**
	 * [过滤器初始化]
	 */
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	/**
	 * [执行过滤]
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		System.out.println("进入登录检查过滤器");
		// 转换成http的servlet
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		httpResponse.setContentType("text/html");
		// 判断是否是登陆页面
		String basePath = httpRequest.getServletContext().getContextPath();
		String servletPath = httpRequest.getServletPath();
		System.out.println("访问地址======>" + servletPath);
		// 用户信息
		Passport passport = null;
		HttpSession session = httpRequest.getSession();
		passport = (Passport) session
				.getAttribute(SessionKeyConstant.PASSPORT_INFO);
		if (null != passport || LOGIN_ACTION.equals(servletPath)
				|| REGIST_ACTION.equals(servletPath)
				|| TO_LOGIN_ACTION.equals(servletPath)
				|| TO_SIGNUP_ACTION.equals(servletPath)) { // 用户已经登录或者只是登录请求
			System.out.println("已经登录或者登录请求");
			filterChain.doFilter(request, response);
		} else {
			System.out.println("用户未登录进行登录界面跳转");
			httpResponse.sendRedirect(basePath + TO_LOGIN_ACTION);
		}
	}

	/**
	 * [销毁]
	 */
	public void destroy() {

	}

}
