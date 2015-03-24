package com.wuya.studentweb.action;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.wuya.backend.service.IFinanceInfoService;
import com.wuya.base.mvc.BaseAction;
import com.wuya.studentweb.constant.PageNameConstant;

/**
 * [页面跳转－控制器]
 * 
 * @author nick
 * @version v1.0 2015-1-26
 */
public class RouterAction extends BaseAction {

	@Autowired
	private IFinanceInfoService financeInfoService;

	/**
	 * [跳转到学生主页]
	 * 
	 * @return
	 */
	public String toLogin() {
		return PageNameConstant.LOGIN;
	}

	/**
	 * [退出]
	 * 
	 * @return
	 */
	public String exist() {
		Map<String, Object> sessionMap = this.getSessionMap();
		sessionMap.clear();
		return PageNameConstant.LOGIN;
	}

	/**
	 * [跳转到学生主页]
	 * 
	 * @return
	 */
	public String toStudentIndex() {
		return PageNameConstant.STUDENT_INDEX;
	}

	/**
	 * [跳转到学生信息页]
	 * 
	 * @return
	 */
	public String toStudentInfo() {
		return PageNameConstant.STUDENT_INFO;
	}

	/**
	 * [跳转到注册页]
	 * 
	 * @return
	 */
	public String toSignUp() {
		return PageNameConstant.SIGN_UP;
	}

	/**
	 * [跳转到项目申请页面]
	 * 
	 * @return
	 */
	public String toProjectApply() {
		return PageNameConstant.PROJECT_APPLY;
	}

	/**
	 * [跳转到我的项目订单页面]
	 * 
	 * @return
	 */
	public String toMyProjectOrder() {
		return PageNameConstant.MY_PROJECT_ORDER;
	}

	/**
	 * [跳转到我的财富账户页面]
	 * 
	 * @return
	 */
	public String toMyFinance() {
		return PageNameConstant.MY_FINANCE;
	}

	/**
	 * [跳转到我的项目订单详细页面]
	 * 
	 * @return
	 */
	public String toMyProjectOrderDetail() {
		Integer orderId = null;
		Map<String, Object> requestMap = null;
		requestMap = this.getParameterMapFromRequest();
		orderId = Integer.parseInt((String) requestMap.get("orderId"));
		this.setValueToScope("orderId", orderId,
				com.wuya.base.enumerate.HttpScopeEnum.REQUEST.getCode());
		return PageNameConstant.MY_PROJECT_ORDER_DETAIL;
	}

	/**
	 * [跳转到充值步骤1页面]
	 * 
	 * @return
	 */
	public String toWithdraw() {
		Integer orderId = null;
		Map<String, Object> requestMap = null;
		requestMap = this.getParameterMapFromRequest();
		orderId = Integer.parseInt((String) requestMap.get("accountId"));
		this.setValueToScope("accountId", orderId,
				com.wuya.base.enumerate.HttpScopeEnum.REQUEST.getCode());
		return PageNameConstant.WITHDRAW;
	}

	/**
	 * [跳转到充值步骤1页面]
	 * 
	 * @return
	 */
	public String toRecharge1() {
		Integer orderId = null;
		Map<String, Object> requestMap = null;
		requestMap = this.getParameterMapFromRequest();
		orderId = Integer.parseInt((String) requestMap.get("accountId"));
		this.setValueToScope("accountId", orderId,
				com.wuya.base.enumerate.HttpScopeEnum.REQUEST.getCode());
		return PageNameConstant.RECHARGE_1;
	}

	/**
	 * [跳转到充值步骤2页面]
	 * 
	 * @return
	 */
	public String toRecharge2() {
		Integer detailId = null;
		Map<String, Object> requestMap = null;
		requestMap = this.getParameterMapFromRequest();
		detailId = Integer.parseInt((String) requestMap.get("detailId"));
		this.setValueToScope("detailId", detailId,
				com.wuya.base.enumerate.HttpScopeEnum.REQUEST.getCode());
		return PageNameConstant.RECHARGE_2;
	}

	/**
	 * [跳转到充值结束页面]
	 * 
	 * @return
	 */
	public String toFinishRecharge() throws Exception {
		Integer detailId = null;
		Map<String, Object> requestMap = null;
		requestMap = this.getParameterMapFromRequest();
		detailId = Integer.parseInt((String) requestMap.get("detailId"));
		this.setValueToScope("detailId", detailId,
				com.wuya.base.enumerate.HttpScopeEnum.REQUEST.getCode());
		this.financeInfoService.activeRechargeDetail(detailId);
		return PageNameConstant.FINISH_RECHARGE;
	}

	/**
	 * [跳转到充值结束页面]
	 * 
	 * @return
	 */
	public String toCertificateImageManager() throws Exception {
		Integer certificateId = null;
		Map<String, Object> requestMap = null;
		requestMap = this.getParameterMapFromRequest();
		certificateId = Integer.parseInt((String) requestMap
				.get("certificateId"));
		this.setValueToScope("certificateId", certificateId,
				com.wuya.base.enumerate.HttpScopeEnum.REQUEST.getCode());
		return PageNameConstant.CERTIFICATE_IMAGE_MANAGER;
	}

}
