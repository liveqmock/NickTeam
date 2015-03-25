package com.nick.backend.dao.impl;

import java.sql.SQLException;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.nick.backend.dao.IUserInfoDao;
import com.nick.backend.po.User;
import com.nick.base.enumerate.DataStatusEnum;

/**
 * [用户信息相关数据访问层接口-实现类]
 * 
 * @author nick
 * @version v1.0 2015-3-24
 */
@Repository("userInfoDao")
public class UserInfoDaoImpl implements IUserInfoDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	/**
	 * [根据手机-计算用户数量]
	 * 
	 * @param mobile
	 *            [手机号码]
	 * @param type
	 *            [用户类型]
	 * @param domain
	 *            [用户领域]
	 * @return
	 * @throws Exception
	 */
	public Long countUserByMobile(final String mobile, final String type,
			final String domain) throws Exception {
		// 申明变量
		Long num = null;
		num = this.hibernateTemplate.execute(new HibernateCallback<Long>() {

			public Long doInHibernate(Session session)
					throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(User.class);
				criteria.setProjection(Projections.rowCount());
				// 默认正常状态
				criteria.add(Restrictions.eq("dstatus",
						DataStatusEnum.NORMAL.getCode()));
				// 设定手机号码
				criteria.add(Restrictions.eq("mobile", mobile));
				// 设定用户类型
				criteria.add(Restrictions.eq("type", type));
				// 设定用户领域
				criteria.add(Restrictions.eq("domain", domain));
				return Long.parseLong(criteria.uniqueResult().toString());
			}

		});
		return num;
	}

	/**
	 * [根据邮箱地址-计算用户数量]
	 * 
	 * @param email
	 *            [邮箱地址]
	 * @param type
	 *            [用户类型]
	 * @param domain
	 *            [用户领域]
	 * @return
	 * @throws Exception
	 */
	public Long countUserByEmail(final String email, final String type,
			final String domain) throws Exception {
		// 申明变量
		Long num = null;
		num = this.hibernateTemplate.execute(new HibernateCallback<Long>() {

			public Long doInHibernate(Session session)
					throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(User.class);
				criteria.setProjection(Projections.rowCount());
				// 默认正常状态
				criteria.add(Restrictions.eq("dstatus",
						DataStatusEnum.NORMAL.getCode()));
				// 设定邮箱地址
				criteria.add(Restrictions.eq("email", email));
				// 设定用户类型
				criteria.add(Restrictions.eq("type", type));
				// 设定用户领域
				criteria.add(Restrictions.eq("domain", domain));
				return Long.parseLong(criteria.uniqueResult().toString());
			}

		});
		return num;
	}

	/**
	 * [根据用户名-计算用户数量]
	 * 
	 * @param username
	 *            [用户名]
	 * @param type
	 *            [用户类型]
	 * @param domain
	 *            [用户领域]
	 * @return
	 * @throws Exception
	 */
	public Long countUserByUsername(final String username, final String type,
			final String domain) throws Exception {
		// 申明变量
		Long num = null;
		num = this.hibernateTemplate.execute(new HibernateCallback<Long>() {

			public Long doInHibernate(Session session)
					throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(User.class);
				criteria.setProjection(Projections.rowCount());
				// 默认正常状态
				criteria.add(Restrictions.eq("dstatus",
						DataStatusEnum.NORMAL.getCode()));
				// 设定用户名
				criteria.add(Restrictions.eq("username", username));
				// 设定用户类型
				criteria.add(Restrictions.eq("type", type));
				// 设定用户领域
				criteria.add(Restrictions.eq("domain", domain));
				return Long.parseLong(criteria.uniqueResult().toString());
			}

		});
		return num;
	}

}
