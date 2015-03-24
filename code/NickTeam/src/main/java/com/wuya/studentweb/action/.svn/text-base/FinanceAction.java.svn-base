package com.wuya.studentweb.action;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.wuya.backend.criteria.finance.FinanceAccountCriteria;
import com.wuya.backend.criteria.finance.FinanceAccountDetailCriteria;
import com.wuya.backend.po.finance.FinanceAccountDetail;
import com.wuya.backend.po.user.Passport;
import com.wuya.backend.service.IFinanceInfoService;
import com.wuya.base.enumerate.HttpScopeEnum;
import com.wuya.base.enumerate.InvokeStateEnum;
import com.wuya.base.exception.WuYaException;
import com.wuya.base.mvc.BaseAction;
import com.wuya.base.result.EasyUiPagerResult;
import com.wuya.base.result.InvokeResult;
import com.wuya.base.util.NumberUtil;
import com.wuya.studentweb.constant.FrontErrorCode;
import com.wuya.studentweb.constant.SessionKeyConstant;

/**
 * [财富相关－控制器]
 * 
 * @author nick
 * @version v1.0 2015-2-3
 */
public class FinanceAction extends BaseAction {

	private FinanceAccountDetail financeAccountDetail;

	private FinanceAccountCriteria financeAccountCriteria;

	private FinanceAccountDetailCriteria financeAccountDetailCriteria;

	public FinanceAccountDetail getFinanceAccountDetail() {
		return financeAccountDetail;
	}

	public void setFinanceAccountDetail(
			FinanceAccountDetail financeAccountDetail) {
		this.financeAccountDetail = financeAccountDetail;
	}

	public FinanceAccountCriteria getFinanceAccountCriteria() {
		return financeAccountCriteria;
	}

	public void setFinanceAccountCriteria(
			FinanceAccountCriteria financeAccountCriteria) {
		this.financeAccountCriteria = financeAccountCriteria;
	}

	public FinanceAccountDetailCriteria getFinanceAccountDetailCriteria() {
		return financeAccountDetailCriteria;
	}

	public void setFinanceAccountDetailCriteria(
			FinanceAccountDetailCriteria financeAccountDetailCriteria) {
		this.financeAccountDetailCriteria = financeAccountDetailCriteria;
	}

	@Autowired
	private IFinanceInfoService financeInfoService;

	/**
	 * [获取财富账户列表－支持分页]
	 * 
	 * @throws Exception
	 */
	public void getFinanceAccountWithPage() throws Exception {
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
			if (null == this.financeAccountCriteria) {
				this.financeAccountCriteria = new FinanceAccountCriteria();
			} else {
			}
			if (this.financeAccountCriteria.isRequirePage()) {
				this.financeAccountCriteria.setRows(rows);
				this.financeAccountCriteria.setPage(page);
			}
			result = this.financeInfoService
					.getFinanceAccountWithPage(this.financeAccountCriteria);
		}
		this.outputJsonMessage(result);
	}

	/**
	 * [创建充值明细]
	 * 
	 * @throws Exception
	 */
	public void createChargeDetail() throws Exception {
		System.out.println(this.getParameterMapFromRequest());
		// 申明变量
		InvokeResult result = null;
		Integer detailId = null;
		Map<String, Object> sessionMap = null;
		Passport passport = null;
		// 获取请求参数
		sessionMap = this.getSessionMap();
		passport = (Passport) sessionMap.get(SessionKeyConstant.PASSPORT_INFO);
		// 判断参数合法性
		if (null == this.financeAccountDetail) {
			result = new InvokeResult(InvokeStateEnum.ERROR.getCode(), null);
		} else {
			try {
				this.financeAccountDetail.setPassportId(passport.getId());
				detailId = this.financeInfoService
						.createTempRechargeDetail(this.financeAccountDetail);
			} catch (Exception e) {
				if (e instanceof WuYaException) {
					result = new InvokeResult(InvokeStateEnum.ERROR.getCode(),
							((WuYaException) e).getMsg());
				}
			}
		}
		if (NumberUtil.isNotEmptyOrZero(detailId)) {
			result = new InvokeResult(InvokeStateEnum.SUCCESS.getCode(),
					detailId);
		} else {
			if (null == result) {
				result = new InvokeResult(InvokeStateEnum.ERROR.getCode(),
						FrontErrorCode.E0016);
			}
		}
		this.outputJsonMessage(result);
	}

	/**
	 * [创建提现明细]
	 * 
	 * @throws Exception
	 */
	public void createWithdrawDetail() throws Exception {
		System.out.println(this.getParameterMapFromRequest());
		// 申明变量
		InvokeResult result = null;
		Integer detailId = null;
		Map<String, Object> sessionMap = null;
		Passport passport = null;
		// 获取请求参数
		sessionMap = this.getSessionMap();
		passport = (Passport) sessionMap.get(SessionKeyConstant.PASSPORT_INFO);
		// 判断参数合法性
		if (null == this.financeAccountDetail) {
			result = new InvokeResult(InvokeStateEnum.ERROR.getCode(), null);
		} else {
			try {
				this.financeAccountDetail.setPassportId(passport.getId());
				detailId = this.financeInfoService
						.createWithdrawDetail(this.financeAccountDetail);
			} catch (Exception e) {
				if (e instanceof WuYaException) {
					result = new InvokeResult(InvokeStateEnum.ERROR.getCode(),
							((WuYaException) e).getMsg());
				}
			}
		}
		if (NumberUtil.isNotEmptyOrZero(detailId)) {
			result = new InvokeResult(InvokeStateEnum.SUCCESS.getCode(),
					detailId);
		} else {
			if (null == result) {
				result = new InvokeResult(InvokeStateEnum.ERROR.getCode(),
						FrontErrorCode.E0024);
			}
		}
		this.outputJsonMessage(result);
	}

	/**
	 * [获取财富账户明细列表－支持分页]
	 * 
	 * @throws Exception
	 */
	public void getFinanceAccountDetailListWithPage() throws Exception {
		System.out.println(this.getParameterMapFromRequest());
		// 申明变量
		Integer rows = 0;
		Integer page = 0;
		EasyUiPagerResult result = null;
		// 判断参数合法性
		if (null == this.financeAccountDetailCriteria) {
			result = null;
		} else {
			if (this.financeAccountDetailCriteria.isRequirePage()) {
				rows = Integer.parseInt((String) this.getParameterFromScope(
						"rows", HttpScopeEnum.REQUEST.getCode()));
				page = Integer.parseInt((String) this.getParameterFromScope(
						"page", HttpScopeEnum.REQUEST.getCode()));
				if (0 == rows || 0 == page) {
					result = null;
				} else {
					this.financeAccountDetailCriteria.setRequirePage(true);
					this.financeAccountDetailCriteria.setRows(rows);
					this.financeAccountDetailCriteria.setPage(page);
				}
			}
			result = this.financeInfoService
					.getFinanceAccountDetailWithPage(this.financeAccountDetailCriteria);
		}
		this.outputJsonMessage(result);
	}

}
