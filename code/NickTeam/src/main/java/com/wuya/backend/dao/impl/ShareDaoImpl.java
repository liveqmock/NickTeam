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

import com.wuya.backend.criteria.share.BusinessProcessLogCriteria;
import com.wuya.backend.criteria.share.CostCriteria;
import com.wuya.backend.criteria.share.ImageCriteria;
import com.wuya.backend.criteria.share.PayLogCriteria;
import com.wuya.backend.criteria.share.TransportTicketCriteria;
import com.wuya.backend.dao.IShareDao;
import com.wuya.backend.po.share.BusinessProcessLog;
import com.wuya.backend.po.share.Cost;
import com.wuya.backend.po.share.CustomerFollow;
import com.wuya.backend.po.share.Image;
import com.wuya.backend.po.share.PayLog;
import com.wuya.backend.po.share.TransportTicket;
import com.wuya.base.util.NumberUtil;
import com.wuya.base.util.StringUtil;

/**
 * [共享部分－数据访问层接口实现类]
 * 
 * @author nick
 * @version v1.0 2015-2-3
 */
@Repository("shareDao")
public class ShareDaoImpl implements IShareDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	/**
	 * [为存在判断提供计算]
	 * 
	 * @param projectInfo
	 *            [需要判断的项目信息]
	 * @return
	 * @throws Exception
	 */
	public Integer countCostForExist(final Cost cost) throws Exception {
		// 申明变量
		Integer num = null;
		num = this.hibernateTemplate.execute(new HibernateCallback<Integer>() {

			public Integer doInHibernate(Session session)
					throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(Cost.class);
				criteria.setProjection(Projections.rowCount());
				if (StringUtil.isNotEmpty(cost.getDstatus())) {
					criteria.add(Restrictions.eq("dstatus", cost.getDstatus()));
				}
				if (null != cost.getTargetId()) {
					criteria.add(Restrictions.eq("targetId", cost.getTargetId()));
				}
				if (StringUtil.isNotEmpty(cost.getTargetType())) {
					criteria.add(Restrictions.eq("targetType",
							cost.getTargetType()));
				}
				if (StringUtil.isNotEmpty(cost.getType())) {
					criteria.add(Restrictions.eq("type", cost.getType()));
				}
				return Integer.parseInt(criteria.uniqueResult().toString());
			}
		});
		return num;
	}

	/**
	 * [获取费用列表-支持分页]
	 * 
	 * @param costCriteria
	 *            [费用信息－查询封装]
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<Cost> selectCostWithPage(final CostCriteria costCriteria)
			throws Exception {
		// 申明变量
		List<Cost> list = null;
		list = this.hibernateTemplate
				.executeFind(new HibernateCallback<List<Cost>>() {
					public List<Cost> doInHibernate(Session session)
							throws HibernateException, SQLException {
						Criteria criteria = session.createCriteria(Cost.class);
						criteria.addOrder(Order.desc("id"));
						// 组装分页信息
						if (costCriteria.isRequirePage()) {
							criteria.setFirstResult(costCriteria
									.getFirstIndex());
							criteria.setMaxResults(costCriteria.getRows());
						}
						if (StringUtil.isNotEmpty(costCriteria.getDstatus())) {
							criteria.add(Restrictions.eq("dstatus",
									costCriteria.getDstatus()));
						}
						if (null != costCriteria.getTargetId()) {
							criteria.add(Restrictions.eq("targetId",
									costCriteria.getTargetId()));
						}
						if (StringUtil.isNotEmpty(costCriteria.getTargetType())) {
							criteria.add(Restrictions.eq("targetType",
									costCriteria.getTargetType()));
						}
						if (StringUtil.isNotEmpty(costCriteria.getType())) {
							criteria.add(Restrictions.eq("type",
									costCriteria.getType()));
						}
						if (StringUtil.isNotEmpty(costCriteria.getNotType())) {
							criteria.add(Restrictions.ne("type",
									costCriteria.getNotType()));
						}
						if (null != costCriteria.getNotInTypes()
								&& 0 < costCriteria.getNotInTypes().length) {
							criteria.add(Restrictions.not(Restrictions.in(
									"type", costCriteria.getNotInTypes())));
						}
						return criteria.list();
					}
				});
		return list;
	}

	/**
	 * [获取费用数量-支持分页]
	 * 
	 * @param costCriteria
	 *            [费用信息－查询封装]
	 * @return
	 * @throws Exception
	 */
	public Integer countCostWithPage(final CostCriteria costCriteria)
			throws Exception {
		// 申明变量
		Integer num = null;
		num = this.hibernateTemplate.execute(new HibernateCallback<Integer>() {

			public Integer doInHibernate(Session session)
					throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(Cost.class);
				criteria.setProjection(Projections.rowCount());
				if (StringUtil.isNotEmpty(costCriteria.getDstatus())) {
					criteria.add(Restrictions.eq("dstatus",
							costCriteria.getDstatus()));
				}
				if (null != costCriteria.getTargetId()) {
					criteria.add(Restrictions.eq("targetId",
							costCriteria.getTargetId()));
				}
				if (StringUtil.isNotEmpty(costCriteria.getTargetType())) {
					criteria.add(Restrictions.eq("targetType",
							costCriteria.getTargetType()));
				}
				if (StringUtil.isNotEmpty(costCriteria.getType())) {
					criteria.add(Restrictions.eq("type", costCriteria.getType()));
				}
				if (StringUtil.isNotEmpty(costCriteria.getNotType())) {
					criteria.add(Restrictions.ne("type",
							costCriteria.getNotType()));
				}
				if (null != costCriteria.getNotInTypes()
						&& 0 < costCriteria.getNotInTypes().length) {
					criteria.add(Restrictions.not(Restrictions.in("type",
							costCriteria.getNotInTypes())));
				}
				return Integer.parseInt(criteria.uniqueResult().toString());
			}
		});
		return num;
	}

	/**
	 * [为存在判断提供计算]
	 * 
	 * @param customerFollow
	 *            [需要判断的客户跟进信息]
	 * @return
	 * @throws Exception
	 */
	public Integer countCustomerFollowForExist(
			final CustomerFollow customerFollow) throws Exception {
		// 申明变量
		Integer num = null;
		num = this.hibernateTemplate.execute(new HibernateCallback<Integer>() {

			public Integer doInHibernate(Session session)
					throws HibernateException, SQLException {
				Criteria criteria = session
						.createCriteria(CustomerFollow.class);
				criteria.setProjection(Projections.rowCount());
				if (StringUtil.isNotEmpty(customerFollow.getDstatus())) {
					criteria.add(Restrictions.eq("dstatus",
							customerFollow.getDstatus()));
				}
				if (null != customerFollow.getCustomerId()) {
					criteria.add(Restrictions.eq("customerId",
							customerFollow.getCustomerId()));
				}
				if (null != customerFollow.getServiceId()) {
					criteria.add(Restrictions.eq("serviceId",
							customerFollow.getServiceId()));
				}
				if (null != customerFollow.getTargetId()) {
					criteria.add(Restrictions.eq("targetId",
							customerFollow.getTargetId()));
				}
				if (StringUtil.isNotEmpty(customerFollow.getFollowType())) {
					criteria.add(Restrictions.eq("followType",
							customerFollow.getFollowType()));
				}
				return Integer.parseInt(criteria.uniqueResult().toString());
			}
		});
		return num;
	}

	/**
	 * [获取图片列表-支持分页]
	 * 
	 * @param imageCriteria
	 *            [图片信息－查询封装]
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<Image> selectImageWithPage(final ImageCriteria imageCriteria)
			throws Exception {
		// 申明变量
		List<Image> list = null;
		list = this.hibernateTemplate
				.executeFind(new HibernateCallback<List<Image>>() {
					public List<Image> doInHibernate(Session session)
							throws HibernateException, SQLException {
						Criteria criteria = session.createCriteria(Image.class);
						criteria.addOrder(Order.desc("id"));
						// 组装分页信息
						if (imageCriteria.isRequirePage()) {
							criteria.setFirstResult(imageCriteria
									.getFirstIndex());
							criteria.setMaxResults(imageCriteria.getRows());
						}
						if (StringUtil.isNotEmpty(imageCriteria.getDstatus())) {
							criteria.add(Restrictions.eq("dstatus",
									imageCriteria.getDstatus()));
						}
						if (NumberUtil.isNotEmptyOrZero(imageCriteria
								.getTargetId())) {
							criteria.add(Restrictions.eq("targetId",
									imageCriteria.getTargetId()));
						}
						if (StringUtil.isNotEmpty(imageCriteria.getTargetType())) {
							criteria.add(Restrictions.eq("targetType",
									imageCriteria.getTargetType()));
						}
						return criteria.list();
					}
				});
		return list;
	}

	/**
	 * [获取图片数量-支持分页]
	 * 
	 * @param imageCriteria
	 *            [图片信息－查询封装]
	 * @return
	 * @throws Exception
	 */
	public Integer countImageWithPage(final ImageCriteria imageCriteria)
			throws Exception {
		// 申明变量
		Integer num = null;
		num = this.hibernateTemplate.execute(new HibernateCallback<Integer>() {

			public Integer doInHibernate(Session session)
					throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(Image.class);
				criteria.setProjection(Projections.rowCount());
				if (StringUtil.isNotEmpty(imageCriteria.getDstatus())) {
					criteria.add(Restrictions.eq("dstatus",
							imageCriteria.getDstatus()));
				}
				if (NumberUtil.isNotEmptyOrZero(imageCriteria.getTargetId())) {
					criteria.add(Restrictions.eq("targetId",
							imageCriteria.getTargetId()));
				}
				if (StringUtil.isNotEmpty(imageCriteria.getTargetType())) {
					criteria.add(Restrictions.eq("targetType",
							imageCriteria.getTargetType()));
				}
				return Integer.parseInt(criteria.uniqueResult().toString());
			}
		});
		return num;
	}

	/**
	 * [为图片信息进行存在性判断]
	 * 
	 * @param image
	 * @return
	 * @throws Exception
	 */
	public Integer countImageForExist(final Image image) throws Exception {
		// 申明变量
		Integer num = null;
		num = this.hibernateTemplate.execute(new HibernateCallback<Integer>() {
			public Integer doInHibernate(Session session)
					throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(Image.class);
				criteria.setProjection(Projections.rowCount());
				if (StringUtil.isNotEmpty(image.getDstatus())) {
					criteria.add(Restrictions.eq("dstatus", image.getDstatus()));
				}
				if (NumberUtil.isNotEmptyOrZero(image.getTargetId())) {
					criteria.add(Restrictions.eq("targetId",
							image.getTargetId()));
				}
				if (StringUtil.isNotEmpty(image.getTargetType())) {
					criteria.add(Restrictions.eq("targetType",
							image.getTargetType()));
				}
				return Integer.parseInt(criteria.uniqueResult().toString());
			}
		});
		return num;
	}

	/**
	 * [获取业务日志列表-支持分页]
	 * 
	 * @param businessProcessLogCriteria
	 *            [业务日志信息－查询封装]
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<BusinessProcessLog> selectBusinessProcessLogWithPage(
			final BusinessProcessLogCriteria businessProcessLogCriteria)
			throws Exception {
		// 申明变量
		List<BusinessProcessLog> list = null;
		list = this.hibernateTemplate
				.executeFind(new HibernateCallback<List<BusinessProcessLog>>() {
					public List<BusinessProcessLog> doInHibernate(
							Session session) throws HibernateException,
							SQLException {
						Criteria criteria = session
								.createCriteria(BusinessProcessLog.class);
						criteria.addOrder(Order.desc("id"));
						// 组装分页信息
						if (businessProcessLogCriteria.isRequirePage()) {
							criteria.setFirstResult(businessProcessLogCriteria
									.getFirstIndex());
							criteria.setMaxResults(businessProcessLogCriteria
									.getRows());
						}
						if (StringUtil.isNotEmpty(businessProcessLogCriteria
								.getDstatus())) {
							criteria.add(Restrictions.eq("dstatus",
									businessProcessLogCriteria.getDstatus()));
						}
						if (NumberUtil
								.isNotEmptyOrZero(businessProcessLogCriteria
										.getTargetId())) {
							criteria.add(Restrictions.eq("targetId",
									businessProcessLogCriteria.getTargetId()));
						}
						if (StringUtil.isNotEmpty(businessProcessLogCriteria
								.getTargetType())) {
							criteria.add(Restrictions.eq("targetType",
									businessProcessLogCriteria.getTargetType()));
						}
						if (StringUtil.isNotEmpty(businessProcessLogCriteria
								.getPrevStatus())) {
							criteria.add(Restrictions.eq("prevStatus",
									businessProcessLogCriteria.getPrevStatus()));
						}
						if (StringUtil.isNotEmpty(businessProcessLogCriteria
								.getNextStatus())) {
							criteria.add(Restrictions.eq("nextStatus",
									businessProcessLogCriteria.getNextStatus()));
						}
						return criteria.list();
					}
				});
		return list;
	}

	/**
	 * [获取业务日志数量-支持分页]
	 * 
	 * @param businessProcessLogCriteria
	 *            [业务日志信息－查询封装]
	 * @return
	 * @throws Exception
	 */
	public Integer countBusinessProcessLogWithPage(
			final BusinessProcessLogCriteria businessProcessLogCriteria)
			throws Exception {
		// 申明变量
		Integer num = null;
		num = this.hibernateTemplate.execute(new HibernateCallback<Integer>() {
			public Integer doInHibernate(Session session)
					throws HibernateException, SQLException {
				Criteria criteria = session
						.createCriteria(BusinessProcessLog.class);
				criteria.setProjection(Projections.rowCount());
				if (StringUtil.isNotEmpty(businessProcessLogCriteria
						.getDstatus())) {
					criteria.add(Restrictions.eq("dstatus",
							businessProcessLogCriteria.getDstatus()));
				}
				if (NumberUtil.isNotEmptyOrZero(businessProcessLogCriteria
						.getTargetId())) {
					criteria.add(Restrictions.eq("targetId",
							businessProcessLogCriteria.getTargetId()));
				}
				if (StringUtil.isNotEmpty(businessProcessLogCriteria
						.getTargetType())) {
					criteria.add(Restrictions.eq("targetType",
							businessProcessLogCriteria.getTargetType()));
				}
				if (StringUtil.isNotEmpty(businessProcessLogCriteria
						.getPrevStatus())) {
					criteria.add(Restrictions.eq("prevStatus",
							businessProcessLogCriteria.getPrevStatus()));
				}
				if (StringUtil.isNotEmpty(businessProcessLogCriteria
						.getNextStatus())) {
					criteria.add(Restrictions.eq("nextStatus",
							businessProcessLogCriteria.getNextStatus()));
				}
				return Integer.parseInt(criteria.uniqueResult().toString());
			}
		});
		return num;
	}

	/**
	 * [为存在判断提供计算]
	 * 
	 * @param transportTicket
	 *            [交通票信息实例]
	 * @return
	 * @throws Exception
	 */
	public Integer countTransportTicketForExist(
			final TransportTicket transportTicket) throws Exception {
		// 申明变量
		Integer num = null;
		num = this.hibernateTemplate.execute(new HibernateCallback<Integer>() {

			public Integer doInHibernate(Session session)
					throws HibernateException, SQLException {
				Criteria criteria = session
						.createCriteria(TransportTicket.class);
				criteria.setProjection(Projections.rowCount());
				if (StringUtil.isNotEmpty(transportTicket.getDstatus())) {
					criteria.add(Restrictions.eq("dstatus",
							transportTicket.getDstatus()));
				}
				if (StringUtil.isNotEmpty(transportTicket.getEndCity())) {
					criteria.add(Restrictions.eq("endCity",
							transportTicket.getEndCity()));
				}
				if (StringUtil.isNotEmpty(transportTicket.getStartCity())) {
					criteria.add(Restrictions.eq("startCity",
							transportTicket.getStartCity()));
				}
				if (StringUtil.isNotEmpty(transportTicket.getEndCity())) {
					criteria.add(Restrictions.eq("endCity",
							transportTicket.getEndCity()));
				}
				if (StringUtil.isNotEmpty(transportTicket.getType())) {
					criteria.add(Restrictions.eq("type",
							transportTicket.getType()));
				}
				return Integer.parseInt(criteria.uniqueResult().toString());
			}
		});
		return num;
	}

	/**
	 * [获取交通票列表-支持分页]
	 * 
	 * @param imageCriteria
	 *            [交通票信息－查询封装]
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<TransportTicket> selectTransportTicketWithPage(
			final TransportTicketCriteria transportTicketCriteria)
			throws Exception {
		// 申明变量
		List<TransportTicket> list = null;
		list = this.hibernateTemplate
				.executeFind(new HibernateCallback<List<TransportTicket>>() {
					public List<TransportTicket> doInHibernate(Session session)
							throws HibernateException, SQLException {
						Criteria criteria = session
								.createCriteria(TransportTicket.class);
						criteria.addOrder(Order.desc("id"));
						// 组装分页信息
						if (transportTicketCriteria.isRequirePage()) {
							criteria.setFirstResult(transportTicketCriteria
									.getFirstIndex());
							criteria.setMaxResults(transportTicketCriteria
									.getRows());
						}
						if (StringUtil.isNotEmpty(transportTicketCriteria
								.getDstatus())) {
							criteria.add(Restrictions.eq("dstatus",
									transportTicketCriteria.getDstatus()));
						}
						if (StringUtil.isNotEmpty(transportTicketCriteria
								.getEndCity())) {
							criteria.add(Restrictions.eq("endCity",
									transportTicketCriteria.getEndCity()));
						}
						if (StringUtil.isNotEmpty(transportTicketCriteria
								.getStartCity())) {
							criteria.add(Restrictions.eq("startCity",
									transportTicketCriteria.getStartCity()));
						}
						if (StringUtil.isNotEmpty(transportTicketCriteria
								.getEndCity())) {
							criteria.add(Restrictions.eq("endCity",
									transportTicketCriteria.getEndCity()));
						}
						if (StringUtil.isNotEmpty(transportTicketCriteria
								.getType())) {
							criteria.add(Restrictions.eq("type",
									transportTicketCriteria.getType()));
						}
						return criteria.list();
					}
				});
		return list;
	}

	/**
	 * [获取交通票数量-支持分页]
	 * 
	 * @param imageCriteria
	 *            [交通票信息－查询封装]
	 * @return
	 * @throws Exception
	 */
	public Integer countTransportTicketWithPage(
			final TransportTicketCriteria transportTicketCriteria)
			throws Exception {
		// 申明变量
		Integer num = null;
		num = this.hibernateTemplate.execute(new HibernateCallback<Integer>() {
			public Integer doInHibernate(Session session)
					throws HibernateException, SQLException {
				Criteria criteria = session
						.createCriteria(TransportTicket.class);
				criteria.setProjection(Projections.rowCount());
				if (StringUtil.isNotEmpty(transportTicketCriteria.getDstatus())) {
					criteria.add(Restrictions.eq("dstatus",
							transportTicketCriteria.getDstatus()));
				}
				if (StringUtil.isNotEmpty(transportTicketCriteria.getEndCity())) {
					criteria.add(Restrictions.eq("endCity",
							transportTicketCriteria.getEndCity()));
				}
				if (StringUtil.isNotEmpty(transportTicketCriteria
						.getStartCity())) {
					criteria.add(Restrictions.eq("startCity",
							transportTicketCriteria.getStartCity()));
				}
				if (StringUtil.isNotEmpty(transportTicketCriteria.getEndCity())) {
					criteria.add(Restrictions.eq("endCity",
							transportTicketCriteria.getEndCity()));
				}
				if (StringUtil.isNotEmpty(transportTicketCriteria.getType())) {
					criteria.add(Restrictions.eq("type",
							transportTicketCriteria.getType()));
				}
				return Integer.parseInt(criteria.uniqueResult().toString());
			}
		});
		return num;
	}

	/**
	 * [获取支付日志列表-支持分页]
	 * 
	 * @param payLogCriteria
	 *            [支付日志信息－查询封装]
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PayLog> selectPayLogWithPage(final PayLogCriteria payLogCriteria)
			throws Exception {
		// 申明变量
		List<PayLog> list = null;
		list = this.hibernateTemplate
				.executeFind(new HibernateCallback<List<PayLog>>() {
					public List<PayLog> doInHibernate(Session session)
							throws HibernateException, SQLException {
						Criteria criteria = session
								.createCriteria(PayLog.class);
						criteria.addOrder(Order.desc("id"));
						// 组装分页信息
						if (payLogCriteria.isRequirePage()) {
							criteria.setFirstResult(payLogCriteria
									.getFirstIndex());
							criteria.setMaxResults(payLogCriteria.getRows());
						}
						if (StringUtil.isNotEmpty(payLogCriteria.getDstatus())) {
							criteria.add(Restrictions.eq("dstatus",
									payLogCriteria.getDstatus()));
						}
						if (null != payLogCriteria.getTargetId()) {
							criteria.add(Restrictions.eq("targetId",
									payLogCriteria.getTargetId()));
						}
						if (StringUtil.isNotEmpty(payLogCriteria
								.getTargetType())) {
							criteria.add(Restrictions.eq("targetType",
									payLogCriteria.getTargetType()));
						}
						if (StringUtil.isNotEmpty(payLogCriteria.getType())) {
							criteria.add(Restrictions.eq("type",
									payLogCriteria.getType()));
						}
						if (StringUtil.isNotEmpty(payLogCriteria.getNotType())) {
							criteria.add(Restrictions.ne("type",
									payLogCriteria.getNotType()));
						}
						if (null != payLogCriteria.getNotInTypes()
								&& 0 < payLogCriteria.getNotInTypes().length) {
							criteria.add(Restrictions.not(Restrictions.in(
									"type", payLogCriteria.getNotInTypes())));
						}
						return criteria.list();
					}
				});
		return list;
	}

	/**
	 * [获取支付日志数量-支持分页]
	 * 
	 * @param payLogCriteria
	 *            [支付日志信息－查询封装]
	 * @return
	 * @throws Exception
	 */
	public Integer countPayLogWithPage(final PayLogCriteria payLogCriteria)
			throws Exception {
		// 申明变量
		Integer num = null;
		num = this.hibernateTemplate.execute(new HibernateCallback<Integer>() {

			public Integer doInHibernate(Session session)
					throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(PayLog.class);
				criteria.setProjection(Projections.rowCount());
				if (StringUtil.isNotEmpty(payLogCriteria.getDstatus())) {
					criteria.add(Restrictions.eq("dstatus",
							payLogCriteria.getDstatus()));
				}
				if (null != payLogCriteria.getTargetId()) {
					criteria.add(Restrictions.eq("targetId",
							payLogCriteria.getTargetId()));
				}
				if (StringUtil.isNotEmpty(payLogCriteria.getTargetType())) {
					criteria.add(Restrictions.eq("targetType",
							payLogCriteria.getTargetType()));
				}
				if (StringUtil.isNotEmpty(payLogCriteria.getType())) {
					criteria.add(Restrictions.eq("type",
							payLogCriteria.getType()));
				}
				if (StringUtil.isNotEmpty(payLogCriteria.getNotType())) {
					criteria.add(Restrictions.ne("type",
							payLogCriteria.getNotType()));
				}
				if (null != payLogCriteria.getNotInTypes()
						&& 0 < payLogCriteria.getNotInTypes().length) {
					criteria.add(Restrictions.not(Restrictions.in("type",
							payLogCriteria.getNotInTypes())));
				}
				return Integer.parseInt(criteria.uniqueResult().toString());
			}
		});
		return num;
	}

}
