package com.nick.team.action;

import com.nick.base.mvc.BaseAction;
import com.nick.team.constant.PageNameConstant;

/**
 * [页面跳转控制器]
 * 
 * @author nick
 * @version v1.0 2015-3-24
 */
public class RouterAction extends BaseAction {

	/**
	 * [跳转到登录页面]
	 * 
	 * @return
	 */
	public String toLogin() {
		return PageNameConstant.LOGIN;
	}

}
