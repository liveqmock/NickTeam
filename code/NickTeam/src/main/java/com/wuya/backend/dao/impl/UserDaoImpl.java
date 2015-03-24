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

import com.wuya.backend.criteria.user.PassportCriteria;
import com.wuya.backend.criteria.user.UserCertificateCriteria;
import com.wuya.backend.dao.IUserDao;
import com.wuya.backend.po.user.Passport;
import com.wuya.backend.po.user.UserCertificate;
import com.wuya.backend.po.user.UserContact;
import com.wuya.backend.po.user.UserEducation;
import com.wuya.base.util.NumberUtil;
import com.wuya.base.util.StringUtil;

/**
 * [用户相关－数据访问层实现类]
 * 
 * @author nick
 * @version v1.0 2015-1-24
 */
@Repository("userDao")
public class UserDaoImpl implements IUserDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	/**
	 * [根据用户名计算]
	 * 
	 * @param username
	 *            [需要判断的用户名]
	 * @param domain
	 *            [所在领域]
	 * @return
	 * @throws Exception
	 */
	public Integer countByUsername(String username, String domain)
			throws Exception {
		int num = 0;
		String hql = "SELECT COUNT(*) AS number from "
				+ Passport.class.getSimpleName()
				+ " p WHERE p.username = ? AND p.domain = ? AND p.dstatus='normal'";
		Query query = this.hibernateTemplate.getSessionFactory()
				.getCurrentSession().createQuery(hql);
		query.setString(0, username);
		query.setString(1, domain);
		num = ((Number) query.iterate().next()).intValue();
		return num;
	}

	/**
	 * [根据手机号码计算]
	 * 
	 * @param mobile
	 *            [需要判断的手机号码]
	 * @param domain
	 *            [所在领域]
	 * @return
	 * @throws Exception
	 */
	public Integer countByMobile(String mobile, String domain) throws Exception {
		int num = 0;
		String hql = "SELECT COUNT(*) AS number from "
				+ Passport.class.getSimpleName()
				+ " p WHERE p.mobile = ? AND p.domain = ? AND p.dstatus='normal'";
		Query query = this.hibernateTemplate.getSessionFactory()
				.getCurrentSession().createQuery(hql);
		query.setString(0, mobile);
		query.setString(1, domain);
		num = ((Number) query.iterate().next()).intValue();
		return num;
	}

	/**
	 * [根据邮箱地址计算]
	 * 
	 * @param mobile
	 *            [需要判断的邮箱地址]
	 * @param domain
	 *            [所在领域]
	 * @return
	 * @throws Exception
	 */
	public Integer countByEmail(String email, String domain) throws Exception {
		int num = 0;
		String hql = "SELECT COUNT(*) AS number from "
				+ Passport.class.getSimpleName()
				+ " p WHERE p.email = ? AND p.domain = ? AND p.dstatus='normal'";
		Query query = this.hibernateTemplate.getSessionFactory()
				.getCurrentSession().createQuery(hql);
		query.setString(0, email);
		query.setString(1, domain);
		num = ((Number) query.iterate().next()).intValue();
		return num;
	}

	/**
	 * [根据用户名和密码获取通行证信息]
	 * 
	 * @param username
	 *            [用户名]
	 * @param password
	 *            [密码]
	 * @param domain
	 *            [所属系统领域]
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public Passport getByUsernameWithPassword(String username, String password,
			String domain) throws Exception {
		// 申明变量
		List<Passport> list = null;
		Passport passport = null;
		// 执行验证
		Criteria criteria = this.hibernateTemplate.getSessionFactory()
				.getCurrentSession().createCriteria(Passport.class);
		criteria.add(Restrictions.eq("dstatus", "normal"));
		criteria.add(Restrictions.eq("username", username));
		criteria.add(Restrictions.eq("password", password));
		criteria.add(Restrictions.eq("domain", domain));
		list = criteria.list();
		if (null != list && 1 == list.size()) {
			passport = list.get(0);
		} else {
			passport = null;
		}
		return passport;
	}

	/**
	 * [根据邮箱地址和密码获取通行证信息]
	 * 
	 * @param email
	 *            [邮箱地址]
	 * @param password
	 *            [密码]
	 * @param domain
	 *            [所属系统领域]
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public Passport getByEmailWithPassword(String email, String password,
			String domain) throws Exception {
		// 申明变量
		List<Passport> list = null;
		Passport passport = null;
		// 执行验证
		Criteria criteria = this.hibernateTemplate.getSessionFactory()
				.getCurrentSession().createCriteria(Passport.class);
		criteria.add(Restrictions.eq("dstatus", "normal"));
		criteria.add(Restrictions.eq("email", email));
		criteria.add(Restrictions.eq("password", password));
		criteria.add(Restrictions.eq("domain", domain));
		list = criteria.list();
		if (null != list && 1 == list.size()) {
			passport = list.get(0);
		} else {
			passport = null;
		}
		return passport;
	}

	/**
	 * [根据手机号码和密码获取通行证信息]
	 * 
	 * @param mobile
	 *            [手机号码]
	 * @param password
	 *            [密码]
	 * @param domain
	 *            [所属系统领域]
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public Passport getByMobileWithPassword(String mobile, String password,
			String domain) throws Exception {
		// 申明变量
		List<Passport> list = null;
		Passport passport = null;
		// 执行验证
		Criteria criteria = this.hibernateTemplate.getSessionFactory()
				.getCurrentSession().createCriteria(Passport.class);
		criteria.add(Restrictions.eq("dstatus", "normal"));
		criteria.add(Restrictions.eq("mobile", mobile));
		criteria.add(Restrictions.eq("password", password));
		criteria.add(Restrictions.eq("domain", domain));
		list = criteria.list();
		if (null != list && 1 == list.size()) {
			passport = list.get(0);
		} else {
			passport = null;
		}
		return passport;
	}

	/**
	 * [根据通行证标识，获取对应的用户教育经历信息]
	 * 
	 * @param passportId
	 *            [通行证标识]
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<UserEducation> selectUserEducationByPassportId(
			Integer passportId) throws Exception {
		// 申明变量
		List<UserEducation> list = null;
		// 执行查询
		Criteria criteria = this.hibernateTemplate.getSessionFactory()
				.getCurrentSession().createCriteria(UserEducation.class);
		criteria.addOrder(Order.desc("id"));
		criteria.add(Restrictions.eq("dstatus", "normal"));
		criteria.add(Restrictions.eq("passportId", passportId));
		list = criteria.list();
		return list;
	}

	/**
	 * [根据通行证标识，获取对应的用户联系人信息]
	 * 
	 * @param passportId
	 *            [通行证标识]
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<UserContact> selectUserContactByPassportId(Integer passportId)
			throws Exception {
		// 申明变量
		List<UserContact> list = null;
		// 执行查询
		Criteria criteria = this.hibernateTemplate.getSessionFactory()
				.getCurrentSession().createCriteria(UserContact.class);
		criteria.addOrder(Order.desc("id"));
		criteria.add(Restrictions.eq("dstatus", "normal"));
		criteria.add(Restrictions.eq("passportId", passportId));
		list = criteria.list();
		return list;
	}

	/**
	 * [根据通行证标识，获取对应的用户证件信息]
	 * 
	 * @param passportId
	 *            [通行证标识]
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<UserCertificate> selectUserCertificateByPassportId(
			Integer passportId) throws Exception {
		// 申明变量
		List<UserCertificate> list = null;
		// 执行查询
		Criteria criteria = this.hibernateTemplate.getSessionFactory()
				.getCurrentSession().createCriteria(UserCertificate.class);
		criteria.addOrder(Order.desc("id"));
		criteria.add(Restrictions.eq("dstatus", "normal"));
		criteria.add(Restrictions.eq("passportId", passportId));
		list = criteria.list();
		return list;
	}

	/**
	 * [获取通行证-支持分页]
	 * 
	 * @param passportCriteria
	 *            [通行证－查询封装]
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<Passport> selectPassportWithPage(
			final PassportCriteria passportCriteria) throws Exception {
		// 申明变量
		List<Passport> list = null;
		list = this.hibernateTemplate
				.executeFind(new HibernateCallback<List<Passport>>() {

					public List<Passport> doInHibernate(Session session)
							throws HibernateException, SQLException {
						Criteria criteria = session
								.createCriteria(Passport.class);
						criteria.addOrder(Order.desc("id"));
						// 组装分页信息
						if (passportCriteria.isRequirePage()) {
							criteria.setFirstResult(passportCriteria
									.getFirstIndex());
							criteria.setMaxResults(passportCriteria.getRows());
						}
						if (StringUtil.isNotEmpty(passportCriteria.getDstatus())) {
							criteria.add(Restrictions.eq("dstatus",
									passportCriteria.getDstatus()));
						}
						if (StringUtil.isNotEmpty(passportCriteria
								.getLusername())) {
							criteria.add(Restrictions.like("username", "%"
									+ passportCriteria.getLusername() + "%"));
						}
						if (StringUtil.isNotEmpty(passportCriteria.getLemail())) {
							criteria.add(Restrictions.like("email", "%"
									+ passportCriteria.getLemail() + "%"));
						}
						if (StringUtil.isNotEmpty(passportCriteria.getLmobile())) {
							criteria.add(Restrictions.like("mobile", "%"
									+ passportCriteria.getLmobile() + "%"));
						}
						if (StringUtil.isNotEmpty(passportCriteria.getType())) {
							criteria.add(Restrictions.eq("type",
									passportCriteria.getType()));
						}
						if (StringUtil.isNotEmpty(passportCriteria.getDomain())) {
							criteria.add(Restrictions.eq("domain",
									passportCriteria.getDomain()));
						}
						return criteria.list();
					}
				});
		return list;
	}

	/**
	 * [获取通行证计数-支持分页]
	 * 
	 * @param passportCriteria
	 *            [通行证－查询封装]
	 * @return
	 * @throws Exception
	 */
	public Integer countPassportWithPage(final PassportCriteria passportCriteria)
			throws Exception {
		// 申明变量
		Integer num = null;
		num = this.hibernateTemplate.execute(new HibernateCallback<Integer>() {

			public Integer doInHibernate(Session session)
					throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(Passport.class);
				criteria.setProjection(Projections.rowCount());
				if (StringUtil.isNotEmpty(passportCriteria.getDstatus())) {
					criteria.add(Restrictions.eq("dstatus",
							passportCriteria.getDstatus()));
				}
				if (StringUtil.isNotEmpty(passportCriteria.getLusername())) {
					criteria.add(Restrictions.like("username",
							passportCriteria.getLusername()));
				}
				if (StringUtil.isNotEmpty(passportCriteria.getLemail())) {
					criteria.add(Restrictions.like("email",
							passportCriteria.getLemail()));
				}
				if (StringUtil.isNotEmpty(passportCriteria.getLmobile())) {
					criteria.add(Restrictions.like("mobile",
							passportCriteria.getLmobile()));
				}
				if (StringUtil.isNotEmpty(passportCriteria.getType())) {
					criteria.add(Restrictions.eq("type",
							passportCriteria.getType()));
				}
				if (StringUtil.isNotEmpty(passportCriteria.getDomain())) {
					criteria.add(Restrictions.eq("domain",
							passportCriteria.getDomain()));
				}
				return Integer.parseInt(criteria.uniqueResult().toString());
			}
		});
		return num;
	}

	/**
	 * [获取用户证件-支持分页]
	 * 
	 * @param userCertificateCriteria
	 *            [用户证件－查询封装]
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<UserCertificate> selectUserCertificateWithPage(
			final UserCertificateCriteria userCertificateCriteria)
			throws Exception {
		// 申明变量
		List<UserCertificate> list = null;
		list = this.hibernateTemplate
				.executeFind(new HibernateCallback<List<UserCertificate>>() {

					public List<UserCertificate> doInHibernate(Session session)
							throws HibernateException, SQLException {
						Criteria criteria = session
								.createCriteria(UserCertificate.class);
						criteria.addOrder(Order.desc("id"));
						// 组装分页信息
						if (userCertificateCriteria.isRequirePage()) {
							criteria.setFirstResult(userCertificateCriteria
									.getFirstIndex());
							criteria.setMaxResults(userCertificateCriteria
									.getRows());
						}
						if (StringUtil.isNotEmpty(userCertificateCriteria
								.getDstatus())) {
							criteria.add(Restrictions.eq("dstatus",
									userCertificateCriteria.getDstatus()));
						}
						if (StringUtil.isNotEmpty(userCertificateCriteria
								.getType())) {
							criteria.add(Restrictions.eq("type",
									userCertificateCriteria.getType()));
						}
						if (NumberUtil.isNotEmptyOrZero(userCertificateCriteria
								.getPassportId())) {
							criteria.add(Restrictions.eq("passportId",
									userCertificateCriteria.getPassportId()));
						}
						if (NumberUtil.isNotEmptyOrZero(userCertificateCriteria
								.getId())) {
							criteria.add(Restrictions.eq("id",
									userCertificateCriteria.getId()));
						}
						return criteria.list();
					}
				});
		return list;
	}

	/**
	 * [获取用户证件计数-支持分页]
	 * 
	 * @param userCertificateCriteria
	 *            [用户证件－查询封装]
	 * @return
	 * @throws Exception
	 */
	public Integer countUserCertificateWithPage(
			final UserCertificateCriteria userCertificateCriteria)
			throws Exception {
		// 申明变量
		Integer num = null;
		num = this.hibernateTemplate.execute(new HibernateCallback<Integer>() {

			public Integer doInHibernate(Session session)
					throws HibernateException, SQLException {
				Criteria criteria = session
						.createCriteria(UserCertificate.class);
				criteria.setProjection(Projections.rowCount());
				if (StringUtil.isNotEmpty(userCertificateCriteria.getDstatus())) {
					criteria.add(Restrictions.eq("dstatus",
							userCertificateCriteria.getDstatus()));
				}
				if (StringUtil.isNotEmpty(userCertificateCriteria.getType())) {
					criteria.add(Restrictions.eq("type",
							userCertificateCriteria.getType()));
				}
				if (NumberUtil.isNotEmptyOrZero(userCertificateCriteria
						.getPassportId())) {
					criteria.add(Restrictions.eq("passportId",
							userCertificateCriteria.getPassportId()));
				}
				if (NumberUtil.isNotEmptyOrZero(userCertificateCriteria.getId())) {
					criteria.add(Restrictions.eq("id",
							userCertificateCriteria.getId()));
				}
				return Integer.parseInt(criteria.uniqueResult().toString());
			}
		});
		return num;
	}
}
