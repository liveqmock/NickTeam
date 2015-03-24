package com.wuya.studentweb.action;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.wuya.backend.criteria.project.ProjectHolderCriteria;
import com.wuya.backend.criteria.project.ProjectInfoCriteria;
import com.wuya.backend.criteria.project.ProjectOrderCriteria;
import com.wuya.backend.po.project.ProjectOrder;
import com.wuya.backend.po.user.Passport;
import com.wuya.backend.service.IProjectInfoService;
import com.wuya.backend.service.IShareInfoService;
import com.wuya.base.enumerate.HttpScopeEnum;
import com.wuya.base.enumerate.InvokeStateEnum;
import com.wuya.base.enumerate.project.ProjectOrderStatusEnum;
import com.wuya.base.enumerate.share.BusinessProcessOperaterTypeEnum;
import com.wuya.base.exception.WuYaException;
import com.wuya.base.mvc.BaseAction;
import com.wuya.base.result.EasyUiPagerResult;
import com.wuya.base.result.InvokeResult;
import com.wuya.base.util.NumberUtil;
import com.wuya.studentweb.constant.FrontErrorCode;
import com.wuya.studentweb.constant.SessionKeyConstant;

/**
 * [项目相关－控制器]
 * 
 * @author nick
 * @version v1.0 2015-2-3
 */
public class ProjectAction extends BaseAction {

	private ProjectOrder projectOrder;

	private ProjectInfoCriteria projectInfoCriteria;

	private ProjectHolderCriteria projectHolderCriteria;

	private ProjectOrderCriteria projectOrderCriteria;

	public ProjectOrder getProjectOrder() {
		return projectOrder;
	}

	public void setProjectOrder(ProjectOrder projectOrder) {
		this.projectOrder = projectOrder;
	}

	public ProjectInfoCriteria getProjectInfoCriteria() {
		return projectInfoCriteria;
	}

	public void setProjectInfoCriteria(ProjectInfoCriteria projectInfoCriteria) {
		this.projectInfoCriteria = projectInfoCriteria;
	}

	public ProjectHolderCriteria getProjectHolderCriteria() {
		return projectHolderCriteria;
	}

	public void setProjectHolderCriteria(
			ProjectHolderCriteria projectHolderCriteria) {
		this.projectHolderCriteria = projectHolderCriteria;
	}

	public ProjectOrderCriteria getProjectOrderCriteria() {
		return projectOrderCriteria;
	}

	public void setProjectOrderCriteria(
			ProjectOrderCriteria projectOrderCriteria) {
		this.projectOrderCriteria = projectOrderCriteria;
	}

	@Autowired
	private IProjectInfoService projectInfoService;

	@Autowired
	private IShareInfoService shareInfoService;

	/**
	 * [获取项目信息列表－支持分页]
	 * 
	 * @throws Exception
	 */
	public void getProjectInfoListWithPage() throws Exception {
		System.out.println(this.getParameterMapFromRequest());
		// 申明变量
		Integer rows = 0;
		Integer page = 0;
		EasyUiPagerResult result = null;
		// 获取请求参数
		rows = Integer.parseInt((String) this.getParameterFromScope("rows",
				HttpScopeEnum.REQUEST.getCode()));
		page = Integer.parseInt((String) this.getParameterFromScope("page",
				HttpScopeEnum.REQUEST.getCode()));
		// 判断参数合法性
		if (0 == rows || 0 == page) {
			result = null;
		} else {
			if (null == this.projectInfoCriteria) {
				this.projectInfoCriteria = new ProjectInfoCriteria();
			} else {
			}
			this.projectInfoCriteria.setRequirePage(true);
			this.projectInfoCriteria.setRows(rows);
			this.projectInfoCriteria.setPage(page);
			result = this.projectInfoService
					.getProjectInfoListWithPage(this.projectInfoCriteria);
		}
		this.outputJsonMessage(result);
	}

	/**
	 * [获取项目主办方列表－支持分页]
	 * 
	 * @throws Exception
	 */
	public void getProjectHolderListWithPage() throws Exception {
		System.out.println(this.getParameterMapFromRequest());
		// 申明变量
		Integer rows = 0;
		Integer page = 0;
		EasyUiPagerResult result = null;
		// 获取请求参数
		rows = Integer.parseInt((String) this.getParameterFromScope("rows",
				HttpScopeEnum.REQUEST.getCode()));
		page = Integer.parseInt((String) this.getParameterFromScope("page",
				HttpScopeEnum.REQUEST.getCode()));
		// 判断参数合法性
		if (0 == rows || 0 == page) {
			result = null;
		} else {
			if (null == this.projectHolderCriteria) {
				this.projectHolderCriteria = new ProjectHolderCriteria();
			} else {
				if (this.projectHolderCriteria.isRequirePage()) {
					this.projectHolderCriteria.setRows(rows);
					this.projectHolderCriteria.setPage(page);
				}
			}
			result = this.projectInfoService
					.getProjectHolderListWithPage(this.projectHolderCriteria);
		}
		this.outputJsonMessage(result);
	}

	/**
	 * [创建项目订单]
	 * 
	 * @throws Exception
	 */
	public void createProjectOrder() throws Exception {
		// 申明变量
		Map<String, Object> sessionMap = null;
		boolean flag = false;
		Passport passport = null;
		InvokeResult result = null;
		// 获取请求参数
		sessionMap = this.getSessionMap();
		passport = (Passport) sessionMap.get(SessionKeyConstant.PASSPORT_INFO);
		// 检查参数合法性
		if (null == this.projectOrder || null == passport) {
			result = new InvokeResult(InvokeStateEnum.ERROR.getCode(),
					FrontErrorCode.E0014);
		} else {
			// 设定参数
			this.projectOrder.setCreateId(passport.getId());
			this.projectOrder.setPassportId(passport.getId());
			this.projectOrder.setStatus(ProjectOrderStatusEnum.WAIT_JUDGEMENT
					.getCode());
			try {
				flag = this.projectInfoService
						.createProjectOrder(this.projectOrder);
			} catch (Exception e) {
				if (e instanceof WuYaException) {
					result = new InvokeResult(InvokeStateEnum.ERROR.getCode(),
							((WuYaException) e).getMsg());
				}
			}
		}
		if (flag) {
			result = new InvokeResult(InvokeStateEnum.SUCCESS.getCode(), null);
		} else {
			if (null == result) {
				result = new InvokeResult(InvokeStateEnum.ERROR.getCode(),
						FrontErrorCode.E0015);
			}
		}
		this.outputJsonMessage(result);
	}

	/**
	 * [获取项目订单列表－支持分页]
	 * 
	 * @throws Exception
	 */
	public void getProjectOrderListWithPage() throws Exception {
		System.out.println(this.getParameterMapFromRequest());
		// 申明变量
		Integer rows = 0;
		Integer page = 0;
		EasyUiPagerResult result = null;
		// 判断参数合法性
		if (null == this.projectOrderCriteria) {
			result = null;
		} else {
			if (this.projectOrderCriteria.isRequirePage()) {
				rows = Integer.parseInt((String) this.getParameterFromScope(
						"rows", HttpScopeEnum.REQUEST.getCode()));
				page = Integer.parseInt((String) this.getParameterFromScope(
						"page", HttpScopeEnum.REQUEST.getCode()));
				if (0 == rows || 0 == page) {
					result = null;
				} else {
					this.projectOrderCriteria.setRequirePage(true);
					this.projectOrderCriteria.setRows(rows);
					this.projectOrderCriteria.setPage(page);
				}
			}
			result = this.projectInfoService
					.getProjectOrderListWithPage(this.projectOrderCriteria);
		}
		this.outputJsonMessage(result);
	}

	/**
	 * [获取项目订单列表－支持分页]
	 * 
	 * @throws Exception
	 */
	public void getMyRunningPorjectOrderListWithPage() throws Exception {
		System.out.println(this.getParameterMapFromRequest());
		// 申明变量
		Integer rows = 0;
		Integer page = 0;
		EasyUiPagerResult result = null;
		String[] notInStatus = { ProjectOrderStatusEnum.FINISH.getCode(),
				ProjectOrderStatusEnum.DROPED.getCode() };
		// 判断参数合法性
		if (null == this.projectOrderCriteria) {
			result = null;
		} else {
			if (this.projectOrderCriteria.isRequirePage()) {
				rows = Integer.parseInt((String) this.getParameterFromScope(
						"rows", HttpScopeEnum.REQUEST.getCode()));
				page = Integer.parseInt((String) this.getParameterFromScope(
						"page", HttpScopeEnum.REQUEST.getCode()));
				if (0 == rows || 0 == page) {
					result = null;
				} else {
					this.projectOrderCriteria.setRequirePage(true);
					this.projectOrderCriteria.setRows(rows);
					this.projectOrderCriteria.setPage(page);
				}
			}
			this.projectOrderCriteria.setNotInStatus(notInStatus);
			result = this.projectInfoService
					.getProjectOrderListWithPage(this.projectOrderCriteria);
		}
		this.outputJsonMessage(result);
	}

	/**
	 * [将订单状态回退到待审核状态]
	 * 
	 * @throws Exception
	 */
	public void returnProjectOrderStatusToWaitJudgement() throws Exception {
		// 申明变量
		InvokeResult result = null;
		Integer orderId = null;
		Map<String, Object> requestMap = null;
		boolean flag = false;
		Passport passport = null;
		// 获取请求参数
		passport = (Passport) this.getParameterFromScope(
				SessionKeyConstant.PASSPORT_INFO,
				HttpScopeEnum.SESSION.getCode());
		requestMap = this.getParameterMapFromRequest();
		orderId = Integer.parseInt((String) requestMap.get("orderId"));
		// 检查参数合法性
		if (NumberUtil.isEmptyOrZero(orderId)) {
			result = new InvokeResult(InvokeStateEnum.ERROR.getCode(), null);
		} else {
			try {
				flag = this.projectInfoService
						.returnProjectOrderStatusToWaitJudgement(orderId);
			} catch (Exception e) {
				if (e instanceof WuYaException) {
					result = new InvokeResult(InvokeStateEnum.ERROR.getCode(),
							((WuYaException) e).getMsg());
				}
			}
			// 纪录操作日志
			if (flag) {
				try {
					this.shareInfoService
							.createReturnProjectOrderToWaitJudgementLog(
									passport,
									BusinessProcessOperaterTypeEnum.STUDENT
											.getCode(), orderId);
				} catch (Exception e) {
					// 异常吸收
					e.printStackTrace();
				}
			}
		}
		if (flag) {
			result = new InvokeResult(InvokeStateEnum.SUCCESS.getCode(), null);
		} else {
			if (null == result) {
				result = new InvokeResult(InvokeStateEnum.ERROR.getCode(),
						FrontErrorCode.E0019);
			}
		}
		this.outputJsonMessage(result);
	}

	/**
	 * [支付项目订单的报名费用]
	 * 
	 * @throws Exception
	 */
	public void payProjectOrderEntryFree() throws Exception {
		System.out.println(this.getParameterMapFromRequest());
		// 申明变量
		InvokeResult result = null;
		Integer orderId = null;
		Integer passportId = null;
		Map<String, Object> requestMap = null;
		boolean flag = false;
		Passport passport = null;
		// 获取请求参数
		passport = (Passport) this.getParameterFromScope(
				SessionKeyConstant.PASSPORT_INFO,
				HttpScopeEnum.SESSION.getCode());
		requestMap = this.getParameterMapFromRequest();
		orderId = Integer.parseInt((String) requestMap.get("orderId"));
		passportId = Integer.parseInt((String) requestMap.get("passportId"));
		// 判断参数合法性
		if (NumberUtil.isEmptyOrZero(orderId)
				|| NumberUtil.isEmptyOrZero(passportId)) {
			result = null;
		} else {
			try {
				flag = this.projectInfoService.payProjectOrderEntryFree(
						orderId, passportId);
			} catch (Exception e) {
				if (e instanceof WuYaException) {
					result = new InvokeResult(InvokeStateEnum.ERROR.getCode(),
							((WuYaException) e).getMsg());
				}
			}
			// 纪录操作日志
			if (flag) {
				try {
					this.shareInfoService.createPayProjectOrderEntryFreeLog(
							passport,
							BusinessProcessOperaterTypeEnum.STUDENT.getCode(),
							orderId);
				} catch (Exception e) {
					// 异常吸收
					e.printStackTrace();
				}
			}
		}
		if (flag) {
			result = new InvokeResult(InvokeStateEnum.SUCCESS.getCode(), null);
		} else {
			if (null == result) {
				result = new InvokeResult(InvokeStateEnum.ERROR.getCode(),
						FrontErrorCode.E0020);
			}
		}
		this.outputJsonMessage(result);
	}

	/**
	 * [支付项目订单的全部费用]
	 * 
	 * @throws Exception
	 */
	public void payProjectOrderAllFree() throws Exception {
		System.out.println(this.getParameterMapFromRequest());
		// 申明变量
		InvokeResult result = null;
		Integer orderId = null;
		Integer ticketId = null;
		Map<String, Object> requestMap = null;
		boolean flag = false;
		Passport passport = null;
		// 获取请求参数
		passport = (Passport) this.getParameterFromScope(
				SessionKeyConstant.PASSPORT_INFO,
				HttpScopeEnum.SESSION.getCode());
		requestMap = this.getParameterMapFromRequest();
		orderId = Integer.parseInt((String) requestMap.get("orderId"));
		ticketId = Integer.parseInt((String) requestMap.get("ticketId"));
		// 判断参数合法性
		if (NumberUtil.isEmptyOrZero(orderId)) {
			result = null;
		} else {
			try {
				if (0 == ticketId) {
					flag = this.projectInfoService.payProjectOrderFee(
							passport.getId(), orderId, false, 0);
				} else {
					flag = this.projectInfoService.payProjectOrderFee(
							passport.getId(), orderId, true, ticketId);
				}
			} catch (Exception e) {
				if (e instanceof WuYaException) {
					result = new InvokeResult(InvokeStateEnum.ERROR.getCode(),
							((WuYaException) e).getMsg());
				}
			}
			// 纪录操作日志
			if (flag) {
				try {
					this.shareInfoService.createPayProjectOrderAllFeeLog(
							passport,
							BusinessProcessOperaterTypeEnum.STUDENT.getCode(),
							orderId);
				} catch (Exception e) {
					// 异常吸收
					e.printStackTrace();
				}
			}
		}
		if (flag) {
			result = new InvokeResult(InvokeStateEnum.SUCCESS.getCode(), null);
		} else {
			if (null == result) {
				result = new InvokeResult(InvokeStateEnum.ERROR.getCode(),
						FrontErrorCode.E0023);
			}
		}
		this.outputJsonMessage(result);
	}

	/**
	 * [获取我的正在运行的项目订单数量]
	 * 
	 * @throws Exception
	 */
	public void getMyOperateablePorjectOrderCount() throws Exception {
		System.out.println(this.getParameterMapFromRequest());
		// 申明变量
		InvokeResult result = null;
		Passport passport = null;
		Integer num = 0;
		// 获取请求参数
		passport = (Passport) this.getParameterFromScope(
				SessionKeyConstant.PASSPORT_INFO,
				HttpScopeEnum.SESSION.getCode());
		// 判断参数合法性
		if (null == passport) {
			result = null;
		} else {
			try {
				num = this.projectInfoService
						.getMyOperateablePorjectOrderCount(passport.getId());
				result = new InvokeResult(InvokeStateEnum.SUCCESS.getCode(),
						num);
			} catch (Exception e) {
				if (e instanceof WuYaException) {
					result = new InvokeResult(InvokeStateEnum.ERROR.getCode(),
							((WuYaException) e).getMsg());
				} else {
					result = new InvokeResult(InvokeStateEnum.ERROR.getCode(),
							0);
				}
			}
		}
		this.outputJsonMessage(result);
	}

}
