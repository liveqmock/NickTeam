package com.wuya.backend.service;

import com.wuya.backend.criteria.finance.FinanceAccountCriteria;
import com.wuya.backend.criteria.finance.FinanceAccountDetailCriteria;
import com.wuya.backend.po.finance.FinanceAccount;
import com.wuya.backend.po.finance.FinanceAccountDetail;
import com.wuya.base.result.EasyUiPagerResult;

/**
 * [财富账户－业务层接口]
 * 
 * @author nick
 * @version v1.0 2015-2-24
 */
public interface IFinanceInfoService {

	/**
	 * [创建财富账户]
	 * 
	 * @param financeAccount
	 *            [需要创建的财富账户实例]
	 * @return
	 * @throws Exception
	 */
	public boolean createFinanceAcount(FinanceAccount financeAccount)
			throws Exception;

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
			String moneyType, Double price) throws Exception;

	/**
	 * [判断财富账户是否已经存在]
	 * 
	 * @param financeAccount
	 *            [需要检查的财富账户实例]
	 * @return
	 * @throws Exception
	 */
	public boolean isFinanceAccountExist(FinanceAccount financeAccount)
			throws Exception;

	/**
	 * [获取财富账户列表－支持分页]
	 * 
	 * @param financeAccountCriteria
	 *            [财富账户查询条件封装实例]
	 * @return
	 * @throws Exception
	 */
	public EasyUiPagerResult getFinanceAccountWithPage(
			FinanceAccountCriteria financeAccountCriteria) throws Exception;

	/**
	 * [创建一个财富账户明细－基础接口]
	 * 
	 * @param financeAccountDetail
	 *            [需要创建的财富账户实例]
	 * @return
	 * @throws Exception
	 */
	public Integer createFinanceAccountDetail(
			FinanceAccountDetail financeAccountDetail) throws Exception;

	/**
	 * [创建一个充值纪录信息]
	 * 
	 * @param financeAccountDetail
	 *            [需要创建的充值纪录实例]
	 * @return
	 * @throws Exception
	 */
	public Integer createTempRechargeDetail(
			FinanceAccountDetail financeAccountDetail) throws Exception;

	/**
	 * [创建一个提现纪录信息]
	 * 
	 * @param financeAccountDetail
	 *            [需要创建的充值纪录实例]
	 * @return
	 * @throws Exception
	 */
	public Integer createWithdrawDetail(
			FinanceAccountDetail financeAccountDetail) throws Exception;

	/**
	 * [创建一个支付报名费纪录信息]
	 * 
	 * @param financeAccountDetail
	 *            [需要创建的充值纪录实例]
	 * @return
	 * @throws Exception
	 */
	public boolean createEntryFreeDetail(
			FinanceAccountDetail financeAccountDetail) throws Exception;

	/**
	 * [创建一个支付全部项目费纪录信息]
	 * 
	 * @param financeAccountDetail
	 *            [需要创建的充值纪录实例]
	 * @return
	 * @throws Exception
	 */
	public boolean createAllProjectFreeDetail(
			FinanceAccountDetail financeAccountDetail) throws Exception;

	/**
	 * [激活充值明细]
	 * 
	 * @param financeAccountDetailId
	 *            [充值纪录标识]
	 * @return
	 * @throws Exception
	 */
	public boolean activeRechargeDetail(Integer financeAccountDetailId)
			throws Exception;

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
			throws Exception;

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
			boolean flag) throws Exception;

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
			throws Exception;

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
			String typeStr) throws Exception;

	/**
	 * [记录订单作废时的金额返还明细]
	 * 
	 * @param financeAccountDetail
	 *            [具体明细]
	 * @return
	 * @throws Exception
	 */
	public boolean createReturnFeeDetailAfterProjectOrderDrop(
			FinanceAccountDetail financeAccountDetail) throws Exception;

}
