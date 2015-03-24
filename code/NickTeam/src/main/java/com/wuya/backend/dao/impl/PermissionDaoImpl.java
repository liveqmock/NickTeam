package com.wuya.backend.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.wuya.backend.criteria.permission.PassportPermissionRefCriteria;
import com.wuya.backend.dao.IPermissionDao;
import com.wuya.backend.po.permission.PassportPermissionRef;
import com.wuya.base.util.StringUtil;

/**
 * [权限相关-数据访问层接口实现类]
 * 
 * @author nick
 * @version v1.0 2014-3-14
 */
@Repository("permissionDao")
public class PermissionDaoImpl implements IPermissionDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	/**
	 * [删除用户-权限关联关系]
	 * 
	 * @param passportId
	 *            [用户标识]
	 * @param domain
	 *            [所属领域]
	 * @return
	 * @throws Exception
	 */
	public Integer deletePassportPermissionRef(final Integer passportId,
			final String domain) throws Exception {
		// 申明变量
		Integer num = null;
		num = this.hibernateTemplate.execute(new HibernateCallback<Integer>() {

			public Integer doInHibernate(Session session)
					throws HibernateException, SQLException {
				Integer rows = 0;
				String hql = "DELETE "
						+ PassportPermissionRef.class.getSimpleName()
						+ " as p WHERE p.passportId = ? AND p.domain = ?";
				Query query = session.createQuery(hql);
				query.setInteger(0, passportId);
				query.setString(1, domain);
				rows = query.executeUpdate();
				return rows;
			}
		});
		return num;
	}

	/**
	 * [获取用户-权限关联列表]
	 * 
	 * @param passportPermissionRefCriteria
	 *            [条件封装]
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PassportPermissionRef> selectPassportPermissionRefWithPage(
			final PassportPermissionRefCriteria passportPermissionRefCriteria)
			throws Exception {
		// 申明变量
		List<PassportPermissionRef> list = null;
		list = this.hibernateTemplate
				.executeFind(new HibernateCallback<List<PassportPermissionRef>>() {
					public List<PassportPermissionRef> doInHibernate(
							Session session) throws HibernateException,
							SQLException {
						Criteria criteria = session
								.createCriteria(PassportPermissionRef.class);
						criteria.addOrder(Order.desc("id"));
						// 组装分页信息
						if (passportPermissionRefCriteria.isRequirePage()) {
							criteria.setFirstResult(passportPermissionRefCriteria
									.getFirstIndex());
							criteria.setMaxResults(passportPermissionRefCriteria
									.getRows());
						}
						if (StringUtil.isNotEmpty(passportPermissionRefCriteria
								.getDstatus())) {
							criteria.add(Restrictions.eq("dstatus",
									passportPermissionRefCriteria.getDstatus()));
						}
						if (null != passportPermissionRefCriteria
								.getPassportId()) {
							criteria.add(Restrictions.eq("passportId",
									passportPermissionRefCriteria
											.getPassportId()));
						}
						if (StringUtil.isNotEmpty(passportPermissionRefCriteria
								.getDomain())) {
							criteria.add(Restrictions.eq("domain",
									passportPermissionRefCriteria.getDomain()));
						}
						return criteria.list();
					}
				});
		return list;
	}

	/**
	 * [获取用户-权限关联列表-计算]
	 * 
	 * @param passportPermissionRefCriteria
	 *            [条件封装]
	 * @return
	 * @throws Exception
	 */
	public Integer countPassportPermissionRefWithPage(
			final PassportPermissionRefCriteria passportPermissionRefCriteria)
			throws Exception {
		// 申明变量
		Integer num = null;
		num = this.hibernateTemplate.execute(new HibernateCallback<Integer>() {

			public Integer doInHibernate(Session session)
					throws HibernateException, SQLException {
				Criteria criteria = session
						.createCriteria(PassportPermissionRef.class);
				criteria.setProjection(Projections.rowCount());
				if (passportPermissionRefCriteria.isRequirePage()) {
					criteria.setFirstResult(passportPermissionRefCriteria
							.getFirstIndex());
					criteria.setMaxResults(passportPermissionRefCriteria
							.getRows());
				}
				if (StringUtil.isNotEmpty(passportPermissionRefCriteria
						.getDstatus())) {
					criteria.add(Restrictions.eq("dstatus",
							passportPermissionRefCriteria.getDstatus()));
				}
				if (null != passportPermissionRefCriteria.getPassportId()) {
					criteria.add(Restrictions.eq("passportId",
							passportPermissionRefCriteria.getPassportId()));
				}
				if (StringUtil.isNotEmpty(passportPermissionRefCriteria
						.getDomain())) {
					criteria.add(Restrictions.eq("domain",
							passportPermissionRefCriteria.getDomain()));
				}
				return Integer.parseInt(criteria.uniqueResult().toString());
			}
		});
		return num;
	}

}
