package com.wuya.backend.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.wuya.backend.criteria.finance.FinanceAccountCriteria;
import com.wuya.backend.criteria.finance.FinanceAccountDetailCriteria;
import com.wuya.backend.dao.IFinanceDao;
import com.wuya.backend.po.finance.FinanceAccount;
import com.wuya.backend.po.finance.FinanceAccountDetail;
import com.wuya.base.util.NumberUtil;
import com.wuya.base.util.StringUtil;

/**
 * [财富账户－数据访问层接口实现类]
 * 
 * @author nick
 * @version v1.0 2015-2-24
 */
@Repository("financeDao")
public class FinanceDaoImpl implements IFinanceDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	/**
	 * [为财富账户的存在提供计算依据]
	 * 
	 * @param financeAccount
	 *            [财富账户实例]
	 * @return
	 * @throws Exception
	 */
	public int countFinanceAccountForExist(final FinanceAccount financeAccount)
			throws Exception {
		// 申明变量
		Integer num = null;
		num = this.hibernateTemplate.execute(new HibernateCallback<Integer>() {

			public Integer doInHibernate(Session session)
					throws HibernateException, SQLException {
				Criteria criteria = session
						.createCriteria(FinanceAccount.class);
				criteria.setProjection(Projections.rowCount());
				if (StringUtil.isNotEmpty(financeAccount.getDstatus())) {
					criteria.add(Restrictions.eq("dstatus",
							financeAccount.getDstatus()));
				}
				if (NumberUtil.isNotEmptyOrZero(financeAccount.getPassportId())) {
					criteria.add(Restrictions.eq("passportId",
							financeAccount.getPassportId()));
				}
				return Integer.parseInt(criteria.uniqueResult().toString());
			}
		});
		return num;
	}

	/**
	 * [获取财富账户列表-支持分页]
	 * 
	 * @param financeAccountCriteria
	 *            [财富账户条件封装]
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<FinanceAccount> selectFinanceAccountWithPage(
			final FinanceAccountCriteria financeAccountCriteria)
			throws Exception {
		// 申明变量
		List<FinanceAccount> list = null;
		list = this.hibernateTemplate
				.executeFind(new HibernateCallback<List<FinanceAccount>>() {
					public List<FinanceAccount> doInHibernate(Session session)
							throws HibernateException, SQLException {
						Criteria criteria = session
								.createCriteria(FinanceAccount.class);
						criteria.addOrder(Order.desc("id"));
						// 组装分页信息
						if (financeAccountCriteria.isRequirePage()) {
							criteria.setFirstResult(financeAccountCriteria
									.getFirstIndex());
							criteria.setMaxResults(financeAccountCriteria
									.getRows());
						}
						if (StringUtil.isNotEmpty(financeAccountCriteria
								.getDstatus())) {
							criteria.add(Restrictions.eq("dstatus",
									financeAccountCriteria.getDstatus()));
						}
						if (NumberUtil.isNotEmptyOrZero(financeAccountCriteria
								.getPassportId())) {
							criteria.add(Restrictions.eq("passportId",
									financeAccountCriteria.getPassportId()));
						}
						return criteria.list();
					}
				});
		return list;
	}

	/**
	 * [获取财富账户数量]
	 * 
	 * @param financeAccountCriteria
	 *            [财富账户条件封装]
	 * @return
	 * @throws Exception
	 */
	public Integer countFinanceAccountWithPage(
			final FinanceAccountCriteria financeAccountCriteria)
			throws Exception {
		// 申明变量
		Integer num = null;
		num = this.hibernateTemplate.execute(new HibernateCallback<Integer>() {

			public Integer doInHibernate(Session session)
					throws HibernateException, SQLException {
				Criteria criteria = session
						.createCriteria(FinanceAccount.class);
				criteria.setProjection(Projections.rowCount());
				if (StringUtil.isNotEmpty(financeAccountCriteria.getDstatus())) {
					criteria.add(Restrictions.eq("dstatus",
							financeAccountCriteria.getDstatus()));
				}
				if (NumberUtil.isNotEmptyOrZero(financeAccountCriteria
						.getPassportId())) {
					criteria.add(Restrictions.eq("passportId",
							financeAccountCriteria.getPassportId()));
				}
				return Integer.parseInt(criteria.uniqueResult().toString());
			}
		});
		return num;
	}

	/**
	 * [获取财富账户明细列表-支持分页]
	 * 
	 * @param financeAccountDetailCriteria
	 *            [财富账户明细条件封装]
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<FinanceAccountDetail> selectFinanceAccountDetailWithPage(
			final FinanceAccountDetailCriteria financeAccountDetailCriteria)
			throws Exception {
		// 申明变量
		List<FinanceAccountDetail> list = null;
		list = this.hibernateTemplate
				.executeFind(new HibernateCallback<List<FinanceAccountDetail>>() {
					public List<FinanceAccountDetail> doInHibernate(
							Session session) throws HibernateException,
							SQLException {
						Criteria criteria = session
								.createCriteria(FinanceAccountDetail.class);
						criteria.addOrder(Order.desc("id"));
						// 组装分页信息
						if (financeAccountDetailCriteria.isRequirePage()) {
							criteria.setFirstResult(financeAccountDetailCriteria
									.getFirstIndex());
							criteria.setMaxResults(financeAccountDetailCriteria
									.getRows());
						}
						if (NumberUtil.isNotEmptyOrZero(financeAccountDetailCriteria
								.getId())) {
							criteria.add(Restrictions.eq("id",
									financeAccountDetailCriteria.getId()));
						}
						if (StringUtil.isNotEmpty(financeAccountDetailCriteria
								.getDstatus())) {
							criteria.add(Restrictions.eq("dstatus",
									financeAccountDetailCriteria.getDstatus()));
						}
						if (NumberUtil
								.isNotEmptyOrZero(financeAccountDetailCriteria
										.getAccountId())) {
							criteria.add(Restrictions
									.eq("accountId",
											financeAccountDetailCriteria
													.getAccountId()));
						}
						if (StringUtil.isNotEmpty(financeAccountDetailCriteria
								.getType())) {
							criteria.add(Restrictions.eq("type",
									financeAccountDetailCriteria.getType()));
						}
						if (StringUtil.isNotEmpty(financeAccountDetailCriteria
								.getStatus())) {
							criteria.add(Restrictions.eq("status",
									financeAccountDetailCriteria.getStatus()));
						}
						return criteria.list();
					}
				});
		return list;
	}

	/**
	 * [获取财富账户明细数量]
	 * 
	 * @param financeAccountDetailCriteria
	 *            [财富账户明细条件封装]
	 * @return
	 * @throws Exception
	 */
	public Integer countFinanceAccountDetailWithPage(
			final FinanceAccountDetailCriteria financeAccountDetailCriteria)
			throws Exception {
		// 申明变量
		Integer num = null;
		num = this.hibernateTemplate.execute(new HibernateCallback<Integer>() {

			public Integer doInHibernate(Session session)
					throws HibernateException, SQLException {
				Criteria criteria = session
						.createCriteria(FinanceAccountDetail.class);
				criteria.setProjection(Projections.rowCount());
				if (NumberUtil.isNotEmptyOrZero(financeAccountDetailCriteria
						.getId())) {
					criteria.add(Restrictions.eq("id",
							financeAccountDetailCriteria.getId()));
				}
				if (StringUtil.isNotEmpty(financeAccountDetailCriteria
						.getDstatus())) {
					criteria.add(Restrictions.eq("dstatus",
							financeAccountDetailCriteria.getDstatus()));
				}
				if (NumberUtil.isNotEmptyOrZero(financeAccountDetailCriteria
						.getAccountId())) {
					criteria.add(Restrictions.eq("accountId",
							financeAccountDetailCriteria.getAccountId()));
				}
				if (StringUtil.isNotEmpty(financeAccountDetailCriteria
						.getType())) {
					criteria.add(Restrictions.eq("type",
							financeAccountDetailCriteria.getType()));
				}
				if (StringUtil.isNotEmpty(financeAccountDetailCriteria
						.getStatus())) {
					criteria.add(Restrictions.eq("status",
							financeAccountDetailCriteria.getStatus()));
				}
				return Integer.parseInt(criteria.uniqueResult().toString());
			}
		});
		return num;
	}

}
