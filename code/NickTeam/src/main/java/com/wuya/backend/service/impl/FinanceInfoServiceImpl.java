package com.wuya.backend.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.wuya.backend.constant.ServiceErrorCodeConstant;
import com.wuya.backend.criteria.finance.FinanceAccountCriteria;
import com.wuya.backend.criteria.finance.FinanceAccountDetailCriteria;
import com.wuya.backend.dao.IFinanceDao;
import com.wuya.backend.po.finance.FinanceAccount;
import com.wuya.backend.po.finance.FinanceAccountDetail;
import com.wuya.backend.po.user.Passport;
import com.wuya.backend.service.IFinanceInfoService;
import com.wuya.base.enumerate.CurrencyEnum;
import com.wuya.base.enumerate.DataStatusEnum;
import com.wuya.base.enumerate.YesOrNoEnum;
import com.wuya.base.enumerate.finance.FinanceAccountDetailStatusEnum;
import com.wuya.base.enumerate.finance.FinanceAccountDetailTypeEnum;
import com.wuya.base.enumerate.finance.FinanceAccountMoneyTypeEnum;
import com.wuya.base.exception.ParamErrorException;
import com.wuya.base.exception.ProcessErrorException;
import com.wuya.base.result.EasyUiPagerResult;
import com.wuya.base.util.NumberUtil;
import com.wuya.base.util.StringUtil;

/**
 * [财富账户－业务层实现类]
 * 
 * @author nick
 * @version v1.0 2015-2-24
 */
@Service("financeInfoService")
public class FinanceInfoServiceImpl implements IFinanceInfoService {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Autowired
	private IFinanceDao financeDao;

	/**
	 * [创建财富账户]
	 * 
	 * @param financeAccount
	 *            [需要创建的财富账户实例]
	 * @return
	 * @throws Exception
	 */
	public boolean createFinanceAcount(FinanceAccount financeAccount)
			throws Exception {
		// 申明变量
		boolean flag = false;
		boolean isExist = false;
		// 验证参数是否合法
		if (null == financeAccount || !financeAccount.validate()) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0035);
		} else {
			// 首先判断财富账户是否已经存在
			isExist = this.isFinanceAccountExist(financeAccount);
			if (isExist) {// 如果已经存在
				throw new ProcessErrorException(ServiceErrorCodeConstant.E0036);
			} else {// 如果不存在
				// 设定默认参数
				financeAccount.setDstatus(DataStatusEnum.NORMAL.getCode());
				// 默认账户没钱
				financeAccount.setCanUseMoney(0.0);
				financeAccount.setFrozenMoney(0.0);
				// 执行创建
				this.hibernateTemplate.save(financeAccount);
				flag = true;
			}
		}
		return flag;
	}

	/**
	 * [修改财富账户金额]
	 * 
	 * @param accountId
	 *            [财富账户标识]
	 * @param flag
	 *            [加值、减值标志]
	 * @param moneyType
	 *            [需要影响的金额类型]
	 * @param price
	 *            [具体金额]
	 * @return
	 * @throws Exception
	 */
	public boolean changeFinanceAccountMoney(Integer accountId, boolean flag,
			String moneyType, Double price) throws Exception {
		// 申明变量
		boolean result = false;
		FinanceAccount financeAccount = null;
		// 判断参数合法性
		if (NumberUtil.isEmptyOrZero(accountId)
				|| StringUtil.isEmpty(moneyType)) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0039);
		} else {
			// 获取财富账户、持久化状态
			financeAccount = this.hibernateTemplate.load(FinanceAccount.class,
					accountId);
			// 判断金额类型-并根据加减标志进行更改
			if (FinanceAccountMoneyTypeEnum.CANUSE.getCode().equals(moneyType)) {
				if (flag) {
					financeAccount.setCanUseMoney(financeAccount
							.getCanUseMoney() + price);
				} else {
					financeAccount.setCanUseMoney(financeAccount
							.getCanUseMoney() - price);
				}
			}
			if (FinanceAccountMoneyTypeEnum.FROZEN.getCode().equals(moneyType)) {
				if (flag) {
					financeAccount.setFrozenMoney(financeAccount
							.getFrozenMoney() + price);
				} else {
					financeAccount.setFrozenMoney(financeAccount
							.getFrozenMoney() - price);
				}
			}
			result = true;
		}
		return result;
	}

	/**
	 * [判断财富账户是否已经存在]
	 * 
	 * @param financeAccount
	 *            [需要检查的财富账户实例]
	 * @return
	 * @throws Exception
	 */
	public boolean isFinanceAccountExist(FinanceAccount financeAccount)
			throws Exception {
		int num = 0;
		num = this.financeDao.countFinanceAccountForExist(financeAccount);
		return 0 == num ? false : true;
	}

	/**
	 * [获取财富账户列表－支持分页]
	 * 
	 * @param financeAccountCriteria
	 *            [财富账户查询条件封装实例]
	 * @return
	 * @throws Exception
	 */
	public EasyUiPagerResult getFinanceAccountWithPage(
			FinanceAccountCriteria financeAccountCriteria) throws Exception {
		// 申明变量
		EasyUiPagerResult result = null;
		List<FinanceAccount> list = null;
		Integer num = 0;
		// 判断参数合法性
		if (null == financeAccountCriteria) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0037);
		} else {
			result = new EasyUiPagerResult();
			list = this.financeDao
					.selectFinanceAccountWithPage(financeAccountCriteria);
			num = this.financeDao
					.countFinanceAccountWithPage(financeAccountCriteria);
			result.setTotal(num);
			result.setRows(list);
		}
		return result;
	}

	/**
	 * [创建一个财富账户明细－基础接口]
	 * 
	 * @param financeAccountDetail
	 *            [需要创建的财富账户实例]
	 * @return
	 * @throws Exception
	 */
	public Integer createFinanceAccountDetail(
			FinanceAccountDetail financeAccountDetail) throws Exception {
		// 申明变量
		Integer id = null;
		// 检查参数合法性
		if (null == financeAccountDetail || !financeAccountDetail.validate()) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0038);
		} else {
			// 预设信息
			// financeAccountDetail.setDstatus(DataStatusEnum.NORMAL.getCode());
			financeAccountDetail.setCreateTime(new Date());
			// 执行保存操作
			id = (Integer) this.hibernateTemplate.save(financeAccountDetail);
		}
		return id;
	}

	/**
	 * [创建一个充值纪录信息]
	 * 
	 * @param financeAccountDetail
	 *            [需要创建的充值纪录实例]
	 * @return
	 * @throws Exception
	 */
	public Integer createTempRechargeDetail(
			FinanceAccountDetail financeAccountDetail) throws Exception {
		// 申明变量
		Integer id = null;
		// 检查参数合法性
		if (null == financeAccountDetail) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0038);
		} else {
			// 预设信息
			financeAccountDetail.setType(FinanceAccountDetailTypeEnum.RECHARGE
					.getCode());
			financeAccountDetail
					.setStatus(FinanceAccountDetailStatusEnum.WAIT_JUDGEMENT
							.getCode());
			// 默认删除状态
			financeAccountDetail.setDstatus(DataStatusEnum.TEMP.getCode());
			financeAccountDetail.setRequireJudgement(YesOrNoEnum.YES.getCode());
			// 执行保存操作
			id = (Integer) this
					.createFinanceAccountDetail(financeAccountDetail);
		}
		return id;
	}

	/**
	 * [创建一个提现纪录信息]
	 * 
	 * @param financeAccountDetail
	 *            [需要创建的充值纪录实例]
	 * @return
	 * @throws Exception
	 */
	public Integer createWithdrawDetail(
			FinanceAccountDetail financeAccountDetail) throws Exception {
		// 申明变量
		Integer id = 0;
		FinanceAccount financeAccount = null;
		// 检查参数合法性
		if (null == financeAccountDetail) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0038);
		} else {
			// 获取对应的账户信息
			financeAccount = this.hibernateTemplate.load(FinanceAccount.class,
					financeAccountDetail.getAccountId());
			// 判断提现金额
			if (financeAccount.getCanUseMoney() >= financeAccountDetail
					.getPrice()) {
				// 预设信息
				financeAccountDetail
						.setType(FinanceAccountDetailTypeEnum.WITHDRAW
								.getCode());
				financeAccountDetail
						.setStatus(FinanceAccountDetailStatusEnum.WAIT_JUDGEMENT
								.getCode());
				financeAccountDetail
						.setDstatus(DataStatusEnum.NORMAL.getCode());
				financeAccountDetail.setRequireJudgement(YesOrNoEnum.YES
						.getCode());
				// 执行保存操作
				id = (Integer) this
						.createFinanceAccountDetail(financeAccountDetail);
				// 冻结金额
				financeAccount.setCanUseMoney(financeAccount.getCanUseMoney()
						- financeAccountDetail.getPrice());
				financeAccount.setFrozenMoney(financeAccount.getFrozenMoney()
						+ financeAccountDetail.getPrice());
			} else {
				throw new ProcessErrorException(ServiceErrorCodeConstant.E0089);
			}
		}
		return id;
	}

	/**
	 * [激活充值明细]
	 * 
	 * @param financeAccountDetailId
	 *            [充值纪录标识]
	 * @return
	 * @throws Exception
	 */
	public boolean activeRechargeDetail(Integer financeAccountDetailId)
			throws Exception {
		// 申明变量
		boolean flag = false;
		FinanceAccountDetail financeAccountDetail = null;
		// 判断参数合法性
		if (NumberUtil.isEmptyOrZero(financeAccountDetailId)) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0038);
		} else {
			financeAccountDetail = this.hibernateTemplate.load(
					FinanceAccountDetail.class, financeAccountDetailId);
			if (DataStatusEnum.NORMAL.getCode().equals(
					financeAccountDetail.getDstatus())) {
				// 如果已经是正常状态的话，什么都不做
			} else {
				// 将状态置为正常
				financeAccountDetail
						.setDstatus(DataStatusEnum.NORMAL.getCode());
				// 如果成功-对冻结账户进行加值
				this.changeFinanceAccountMoney(
						financeAccountDetail.getAccountId(), true,
						FinanceAccountMoneyTypeEnum.FROZEN.getCode(),
						financeAccountDetail.getPrice());
			}
			flag = true;
		}
		return flag;
	}

	/**
	 * [获取财富账户明细列表－支持分页]
	 * 
	 * @param financeAccountDetailCriteria
	 *            [财富账户明细查询条件封装实例]
	 * @return
	 * @throws Exception
	 */
	public EasyUiPagerResult getFinanceAccountDetailWithPage(
			FinanceAccountDetailCriteria financeAccountDetailCriteria)
			throws Exception {
		// 申明变量
		EasyUiPagerResult result = null;
		List<FinanceAccountDetail> list = null;
		Integer num = 0;
		// 判断参数合法性
		if (null == financeAccountDetailCriteria) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0042);
		} else {
			result = new EasyUiPagerResult();
			list = this.financeDao
					.selectFinanceAccountDetailWithPage(financeAccountDetailCriteria);
			num = this.financeDao
					.countFinanceAccountDetailWithPage(financeAccountDetailCriteria);
			result.setTotal(num);
			result.setRows(list);
			// 如果需要加载用户信息
			if (YesOrNoEnum.YES.getCode().equals(
					financeAccountDetailCriteria.getRequirePassport())) {
				for (int i = 0; i < list.size(); i++) {
					Passport passport = null;
					passport = this.hibernateTemplate.get(Passport.class, list
							.get(i).getPassportId());
					list.get(i).setPassport(passport);
				}
			}
		}
		return result;
	}

	/**
	 * [审核充值记录]
	 * 
	 * @param financeAccountDetailId
	 *            [充值记录实例]
	 * @param flag
	 *            [是否通过标志]
	 * @return
	 * @throws Exception
	 */
	public boolean judgeFinanceAccountDetail(Integer financeAccountDetailId,
			boolean flag) throws Exception {
		// 申明变量
		FinanceAccountDetail detail = null;
		boolean result = false;
		// 判断参数合法性
		if (NumberUtil.isEmptyOrZero(financeAccountDetailId)) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0044);
		} else {
			// 获取指定的账户和明细信息
			detail = this.hibernateTemplate.load(FinanceAccountDetail.class,
					financeAccountDetailId);
			if (YesOrNoEnum.YES.getCode().equals(detail.getRequireJudgement())) {
				if (FinanceAccountDetailTypeEnum.RECHARGE.getCode().equals(
						detail.getType())) {// 如果是审核记录
					if (flag) { // 如果审核通过
						detail.setStatus(FinanceAccountDetailStatusEnum.PASS_JUDGEMENT
								.getCode());
						this.changeFinanceAccountMoney(detail.getAccountId(),
								true,
								FinanceAccountMoneyTypeEnum.CANUSE.getCode(),
								detail.getPrice());
						this.changeFinanceAccountMoney(detail.getAccountId(),
								false,
								FinanceAccountMoneyTypeEnum.FROZEN.getCode(),
								detail.getPrice());
					} else { // 如果审核未通过
						detail.setStatus(FinanceAccountDetailStatusEnum.REFUSE_JUDGEMENT
								.getCode());
						this.changeFinanceAccountMoney(detail.getAccountId(),
								false,
								FinanceAccountMoneyTypeEnum.FROZEN.getCode(),
								detail.getPrice());
					}
					result = true;
				} else if (FinanceAccountDetailTypeEnum.WITHDRAW.getCode()
						.equals(detail.getType())) {
					if (flag) { // 如果审核通过
						detail.setStatus(FinanceAccountDetailStatusEnum.PASS_JUDGEMENT
								.getCode());
						this.changeFinanceAccountMoney(detail.getAccountId(),
								false,
								FinanceAccountMoneyTypeEnum.FROZEN.getCode(),
								detail.getPrice());
					} else { // 如果审核未通过
						detail.setStatus(FinanceAccountDetailStatusEnum.REFUSE_JUDGEMENT
								.getCode());
						this.changeFinanceAccountMoney(detail.getAccountId(),
								true,
								FinanceAccountMoneyTypeEnum.CANUSE.getCode(),
								detail.getPrice());
						this.changeFinanceAccountMoney(detail.getAccountId(),
								false,
								FinanceAccountMoneyTypeEnum.FROZEN.getCode(),
								detail.getPrice());
					}
					result = true;
				}
			}
		}
		return result;
	}

	/**
	 * [可用金额是否足够支付]
	 * 
	 * @param passportId
	 *            [用户标识]
	 * @param money
	 *            [金额]
	 * @return
	 * @throws Exception
	 */
	public boolean isCanUseMoneyEnough(Integer passportId, Double money)
			throws Exception {
		// 申明变量
		boolean flag = false;
		FinanceAccount financeAccount = null;
		FinanceAccountCriteria financeAccountCriteria = null;
		List<FinanceAccount> financeAccounts = null;
		// 判断参数合法性
		if (NumberUtil.isEmptyOrZero(passportId)
				|| NumberUtil.isEmptyOrZero(money)) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0051);
		} else {
			// 获取目标用户的财富账户
			financeAccountCriteria = new FinanceAccountCriteria();
			financeAccountCriteria.setRequirePage(false);
			financeAccountCriteria.setDstatus(DataStatusEnum.NORMAL.getCode());
			financeAccountCriteria.setPassportId(passportId);
			financeAccounts = this.financeDao
					.selectFinanceAccountWithPage(financeAccountCriteria);
			if (null != financeAccounts && 1 == financeAccounts.size()) {
				// 获取到该用户的财富账户
				financeAccount = financeAccounts.get(0);
				// 进行判断
				if (money <= financeAccount.getCanUseMoney()) { // 可用
					flag = true;
				} else { // 不可用
					flag = false;
				}
			} else {
				throw new ProcessErrorException(ServiceErrorCodeConstant.E0052);
			}

		}
		return flag;
	}

	/**
	 * [支付项目费用]
	 * 
	 * @param passportId
	 *            [支付用户标识]
	 * @param money
	 *            [支付金额]
	 * @param type
	 *            [支付类型]
	 * @return
	 * @throws Exception
	 */
	public boolean payProjectCost(Integer passportId, Double money,
			String typeStr) throws Exception {
		// 申明变量
		boolean flag = false;
		FinanceAccount financeAccount = null;
		FinanceAccountCriteria financeAccountCriteria = null;
		List<FinanceAccount> financeAccounts = null;
		FinanceAccountDetail financeAccountDetail = null;
		// 判断参数合法性
		if (NumberUtil.isEmptyOrZero(passportId)
				|| NumberUtil.isEmptyOrZero(money)
				|| StringUtil.isEmpty(typeStr)) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0051);
		} else {
			// 获取目标用户的财富账户
			financeAccountCriteria = new FinanceAccountCriteria();
			financeAccountCriteria.setRequirePage(false);
			financeAccountCriteria.setDstatus(DataStatusEnum.NORMAL.getCode());
			financeAccountCriteria.setPassportId(passportId);
			financeAccounts = this.financeDao
					.selectFinanceAccountWithPage(financeAccountCriteria);
			if (null != financeAccounts && 1 == financeAccounts.size()) {
				// 获取到该用户的财富账户
				financeAccount = financeAccounts.get(0);
				// 重新获取持久化态的账户信息
				financeAccount = this.hibernateTemplate.load(
						FinanceAccount.class, financeAccount.getId());
				// 进行金额改动
				financeAccount.setCanUseMoney(financeAccount.getCanUseMoney()
						- money);
				// 生成支付明细
				if (FinanceAccountDetailTypeEnum.ENTRY_FREE.getCode().equals(
						typeStr)) {
					financeAccountDetail = new FinanceAccountDetail();
					financeAccountDetail.setPassportId(financeAccount
							.getPassportId());
					financeAccountDetail.setAccountId(financeAccount.getId());
					financeAccountDetail.setPrice(money);
					financeAccountDetail
							.setCurrency(CurrencyEnum.RMB.getCode());
					this.createEntryFreeDetail(financeAccountDetail);
				} else if (FinanceAccountDetailTypeEnum.ALLPAYMENT.getCode()
						.equals(typeStr)) {
					financeAccountDetail = new FinanceAccountDetail();
					financeAccountDetail.setPassportId(financeAccount
							.getPassportId());
					financeAccountDetail.setAccountId(financeAccount.getId());
					financeAccountDetail.setPrice(money);
					financeAccountDetail
							.setCurrency(CurrencyEnum.RMB.getCode());
					this.createAllProjectFreeDetail(financeAccountDetail);
				}
				flag = true;
			} else {
				throw new ProcessErrorException(ServiceErrorCodeConstant.E0052);
			}

		}
		return flag;
	}

	/**
	 * [创建一个支付报名费纪录信息]
	 * 
	 * @param financeAccountDetail
	 *            [需要创建的充值纪录实例]
	 * @return
	 * @throws Exception
	 */
	public boolean createEntryFreeDetail(
			FinanceAccountDetail financeAccountDetail) throws Exception {
		// 申明变量
		boolean flag = false;
		// 检查参数合法性
		if (null == financeAccountDetail) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0038);
		} else {
			// 预设信息
			financeAccountDetail
					.setType(FinanceAccountDetailTypeEnum.ENTRY_FREE.getCode());
			financeAccountDetail
					.setStatus(FinanceAccountDetailStatusEnum.PASS_JUDGEMENT
							.getCode());
			// 默认正常
			financeAccountDetail.setDstatus(DataStatusEnum.NORMAL.getCode());
			financeAccountDetail.setRequireJudgement(YesOrNoEnum.NO.getCode());
			// 执行保存操作
			this.createFinanceAccountDetail(financeAccountDetail);
			flag = true;
		}
		return flag;
	}

	/**
	 * [创建一个支付全部项目费纪录信息]
	 * 
	 * @param financeAccountDetail
	 *            [需要创建的充值纪录实例]
	 * @return
	 * @throws Exception
	 */
	public boolean createAllProjectFreeDetail(
			FinanceAccountDetail financeAccountDetail) throws Exception {
		// 申明变量
		boolean flag = false;
		// 检查参数合法性
		if (null == financeAccountDetail) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0038);
		} else {
			// 预设信息
			financeAccountDetail
					.setType(FinanceAccountDetailTypeEnum.ALLPAYMENT.getCode());
			financeAccountDetail
					.setStatus(FinanceAccountDetailStatusEnum.PASS_JUDGEMENT
							.getCode());
			// 默认正常
			financeAccountDetail.setDstatus(DataStatusEnum.NORMAL.getCode());
			financeAccountDetail.setRequireJudgement(YesOrNoEnum.NO.getCode());
			// 执行保存操作
			this.createFinanceAccountDetail(financeAccountDetail);
			flag = true;
		}
		return flag;
	}

	/**
	 * [记录订单作废时的金额返还明细]
	 * 
	 * @param financeAccountDetail
	 *            [具体明细]
	 * @return
	 * @throws Exception
	 */
	public boolean createReturnFeeDetailAfterProjectOrderDrop(
			FinanceAccountDetail financeAccountDetail) throws Exception {
		// 申明变量
		boolean flag = false;
		// 检查参数合法性
		if (null == financeAccountDetail) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0038);
		} else {
			// 预设信息
			financeAccountDetail
					.setType(FinanceAccountDetailTypeEnum.ORDER_DROP.getCode());
			financeAccountDetail
					.setStatus(FinanceAccountDetailStatusEnum.PASS_JUDGEMENT
							.getCode());
			// 默认正常
			financeAccountDetail.setDstatus(DataStatusEnum.NORMAL.getCode());
			financeAccountDetail.setRequireJudgement(YesOrNoEnum.NO.getCode());
			// 执行保存操作
			this.createFinanceAccountDetail(financeAccountDetail);
			flag = true;
		}
		return flag;
	}
}
