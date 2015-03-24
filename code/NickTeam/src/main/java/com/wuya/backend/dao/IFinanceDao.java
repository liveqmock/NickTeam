package com.wuya.backend.dao;

import java.util.List;

import com.wuya.backend.criteria.finance.FinanceAccountCriteria;
import com.wuya.backend.criteria.finance.FinanceAccountDetailCriteria;
import com.wuya.backend.po.finance.FinanceAccount;
import com.wuya.backend.po.finance.FinanceAccountDetail;

/**
 * [财富账户－数据访问层接口]
 * 
 * @author nick
 * @version v1.0 2015-2-24
 */
public interface IFinanceDao {

	/**
	 * [为财富账户的存在提供计算依据]
	 * 
	 * @param financeAccount
	 *            [财富账户实例]
	 * @return
	 * @throws Exception
	 */
	public int countFinanceAccountForExist(FinanceAccount financeAccount)
			throws Exception;

	/**
	 * [获取财富账户列表-支持分页]
	 * 
	 * @param financeAccountCriteria
	 *            [财富账户条件封装]
	 * @return
	 * @throws Exception
	 */
	public List<FinanceAccount> selectFinanceAccountWithPage(
			FinanceAccountCriteria financeAccountCriteria) throws Exception;

	/**
	 * [获取财富账户数量]
	 * 
	 * @param financeAccountCriteria
	 *            [财富账户条件封装]
	 * @return
	 * @throws Exception
	 */
	public Integer countFinanceAccountWithPage(
			FinanceAccountCriteria financeAccountCriteria) throws Exception;

	/**
	 * [获取财富账户明细列表-支持分页]
	 * 
	 * @param financeAccountDetailCriteria
	 *            [财富账户明细条件封装]
	 * @return
	 * @throws Exception
	 */
	public List<FinanceAccountDetail> selectFinanceAccountDetailWithPage(
			FinanceAccountDetailCriteria financeAccountDetailCriteria)
			throws Exception;

	/**
	 * [获取财富账户明细数量]
	 * 
	 * @param financeAccountDetailCriteria
	 *            [财富账户明细条件封装]
	 * @return
	 * @throws Exception
	 */
	public Integer countFinanceAccountDetailWithPage(
			FinanceAccountDetailCriteria financeAccountDetailCriteria)
			throws Exception;

}
