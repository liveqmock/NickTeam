package com.wuya.backend.dao.impl;

import java.sql.SQLException;
import java.util.Date;
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

import com.wuya.backend.criteria.project.ProjectHolderCriteria;
import com.wuya.backend.criteria.project.ProjectInfoCriteria;
import com.wuya.backend.criteria.project.ProjectOrderCriteria;
import com.wuya.backend.criteria.project.multi.ProjectOrderJoinPassportCriteria;
import com.wuya.backend.dao.IProjectDao;
import com.wuya.backend.po.project.ProjectHolder;
import com.wuya.backend.po.project.ProjectInfo;
import com.wuya.backend.po.project.ProjectOrder;
import com.wuya.backend.po.user.Passport;
import com.wuya.base.enumerate.DataStatusEnum;
import com.wuya.base.enumerate.project.ProjectOrderStatusEnum;
import com.wuya.base.util.NumberUtil;
import com.wuya.base.util.StringUtil;

/**
 * [项目相关－数据访问层接口实现类]
 * 
 * @author nick
 * @version v1.0 2015-2-3
 */
@Repository("projectDao")
public class ProjectDaoImpl implements IProjectDao {

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
	public Integer countProjectForExist(final ProjectInfo projectInfo)
			throws Exception {
		// 申明变量
		Integer num = null;
		num = this.hibernateTemplate.execute(new HibernateCallback<Integer>() {
			public Integer doInHibernate(Session session)
					throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(ProjectInfo.class);
				criteria.setProjection(Projections.rowCount());
				if (StringUtil.isNotEmpty(projectInfo.getDstatus())) {
					criteria.add(Restrictions.eq("dstatus",
							projectInfo.getDstatus()));
				}
				if (StringUtil.isNotEmpty(projectInfo.getName())) {
					criteria.add(Restrictions.eq("name", projectInfo.getName()));
				}
				return Integer.parseInt(criteria.uniqueResult().toString());
			}
		});
		return num;
	}

	/**
	 * [为项目主办方存在判断提供计算]
	 * 
	 * @param projectInfo
	 *            [需要判断的项目信息]
	 * @return
	 * @throws Exception
	 */
	public Integer countProjectHolerForExist(final ProjectHolder projectHolder)
			throws Exception {
		// 申明变量
		Integer num = null;
		num = this.hibernateTemplate.execute(new HibernateCallback<Integer>() {

			public Integer doInHibernate(Session session)
					throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(ProjectHolder.class);
				criteria.setProjection(Projections.rowCount());
				if (StringUtil.isNotEmpty(projectHolder.getDstatus())) {
					criteria.add(Restrictions.eq("dstatus",
							projectHolder.getDstatus()));
				}
				if (StringUtil.isNotEmpty(projectHolder.getName())) {
					criteria.add(Restrictions.eq("name",
							projectHolder.getName()));
				}
				if (null != projectHolder.getProjectId()) {
					criteria.add(Restrictions.eq("projectId",
							projectHolder.getProjectId()));
				}
				return Integer.parseInt(criteria.uniqueResult().toString());
			}
		});
		return num;
	}

	/**
	 * [获取项目列表-支持分页]
	 * 
	 * @param projectInfoCriteria
	 *            [项目信息－查询封装]
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<ProjectInfo> selectProjectInfoWithPage(
			final ProjectInfoCriteria projectInfoCriteria) throws Exception {
		// 申明变量
		List<ProjectInfo> list = null;
		list = this.hibernateTemplate
				.executeFind(new HibernateCallback<List<ProjectInfo>>() {
					public List<ProjectInfo> doInHibernate(Session session)
							throws HibernateException, SQLException {
						Criteria criteria = session
								.createCriteria(ProjectInfo.class);
						criteria.addOrder(Order.desc("id"));
						// 组装分页信息
						if (projectInfoCriteria.isRequirePage()) {
							criteria.setFirstResult(projectInfoCriteria
									.getFirstIndex());
							criteria.setMaxResults(projectInfoCriteria
									.getRows());
						}
						if (StringUtil.isNotEmpty(projectInfoCriteria
								.getDstatus())) {
							criteria.add(Restrictions.eq("dstatus",
									projectInfoCriteria.getDstatus()));
						}
						if (StringUtil.isNotEmpty(projectInfoCriteria
								.getLname())) {
							criteria.add(Restrictions.like("name",
									projectInfoCriteria.getLname()));
						}
						if (null != projectInfoCriteria.getPid()) {
							criteria.add(Restrictions.eq("pid",
									projectInfoCriteria.getPid()));
						}
						if (null != projectInfoCriteria.getLevel()) {
							criteria.add(Restrictions.eq("level",
									projectInfoCriteria.getLevel()));
						}
						if (StringUtil.isNotEmpty(projectInfoCriteria
								.getIsOnline())) {
							criteria.add(Restrictions.eq("isOnline",
									projectInfoCriteria.getIsOnline()));
						}
						return criteria.list();
					}
				});
		return list;
	}

	/**
	 * [获取项目数量-支持分页]
	 * 
	 * @param projectInfoCriteria
	 *            [项目信息－查询封装]
	 * @return
	 * @throws Exception
	 */
	public Integer countProjectInfoWithPage(
			final ProjectInfoCriteria projectInfoCriteria) throws Exception {
		// 申明变量
		Integer num = null;
		num = this.hibernateTemplate.execute(new HibernateCallback<Integer>() {

			public Integer doInHibernate(Session session)
					throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(ProjectInfo.class);
				criteria.setProjection(Projections.rowCount());
				if (StringUtil.isNotEmpty(projectInfoCriteria.getDstatus())) {
					criteria.add(Restrictions.eq("dstatus",
							projectInfoCriteria.getDstatus()));
				}
				if (StringUtil.isNotEmpty(projectInfoCriteria.getLname())) {
					criteria.add(Restrictions.like("name",
							projectInfoCriteria.getLname()));
				}
				if (null != projectInfoCriteria.getPid()) {
					criteria.add(Restrictions.eq("pid",
							projectInfoCriteria.getPid()));
				}
				if (null != projectInfoCriteria.getLevel()) {
					criteria.add(Restrictions.eq("level",
							projectInfoCriteria.getLevel()));
				}
				if (StringUtil.isNotEmpty(projectInfoCriteria.getIsOnline())) {
					criteria.add(Restrictions.eq("isOnline",
							projectInfoCriteria.getIsOnline()));
				}
				return Integer.parseInt(criteria.uniqueResult().toString());
			}
		});
		return num;
	}

	/**
	 * [获取项目主办方列表-支持分页]
	 * 
	 * @param projectHolderCriteria
	 *            [项目主办方信息－查询封装]
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<ProjectHolder> selectProjectHolderWithPage(
			final ProjectHolderCriteria projectHolderCriteria) throws Exception {
		// 申明变量
		List<ProjectHolder> list = null;
		list = this.hibernateTemplate
				.executeFind(new HibernateCallback<List<ProjectHolder>>() {
					public List<ProjectHolder> doInHibernate(Session session)
							throws HibernateException, SQLException {
						Criteria criteria = session
								.createCriteria(ProjectHolder.class);
						criteria.addOrder(Order.desc("id"));
						// 组装分页信息
						if (projectHolderCriteria.isRequirePage()) {
							criteria.setFirstResult(projectHolderCriteria
									.getFirstIndex());
							criteria.setMaxResults(projectHolderCriteria
									.getRows());
						}
						if (StringUtil.isNotEmpty(projectHolderCriteria
								.getDstatus())) {
							criteria.add(Restrictions.eq("dstatus",
									projectHolderCriteria.getDstatus()));
						}
						if (null != projectHolderCriteria.getProjectId()) {
							criteria.add(Restrictions.eq("projectId",
									projectHolderCriteria.getProjectId()));
						}
						return criteria.list();
					}
				});
		return list;
	}

	/**
	 * [获取项目主办方数量-支持分页]
	 * 
	 * @param projectHolderCriteria
	 *            [项目主办方信息－查询封装]
	 * @return
	 * @throws Exception
	 */
	public Integer countProjectHolderWithPage(
			final ProjectHolderCriteria projectHolderCriteria) throws Exception {
		// 申明变量
		Integer num = null;
		num = this.hibernateTemplate.execute(new HibernateCallback<Integer>() {

			public Integer doInHibernate(Session session)
					throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(ProjectHolder.class);
				criteria.setProjection(Projections.rowCount());
				if (StringUtil.isNotEmpty(projectHolderCriteria.getDstatus())) {
					criteria.add(Restrictions.eq("dstatus",
							projectHolderCriteria.getDstatus()));
				}
				if (null != projectHolderCriteria.getProjectId()) {
					criteria.add(Restrictions.eq("projectId",
							projectHolderCriteria.getProjectId()));
				}
				return Integer.parseInt(criteria.uniqueResult().toString());
			}
		});
		return num;
	}

	/**
	 * [获取项目订单列表－支持分页]
	 * 
	 * @param projectOrderCriteria
	 *            [项目订单－查询封装]
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<ProjectOrder> selectProjectOrderWithPage(
			final ProjectOrderCriteria projectOrderCriteria) throws Exception {
		// 申明变量
		List<ProjectOrder> list = null;
		list = this.hibernateTemplate
				.executeFind(new HibernateCallback<List<ProjectOrder>>() {
					public List<ProjectOrder> doInHibernate(Session session)
							throws HibernateException, SQLException {
						Criteria criteria = session
								.createCriteria(ProjectOrder.class);
						criteria.addOrder(Order.desc("id"));
						// 组装分页信息
						if (projectOrderCriteria.isRequirePage()) {
							criteria.setFirstResult(projectOrderCriteria
									.getFirstIndex());
							criteria.setMaxResults(projectOrderCriteria
									.getRows());
						}
						if (StringUtil.isNotEmpty(projectOrderCriteria
								.getDstatus())) {
							criteria.add(Restrictions.eq("dstatus",
									projectOrderCriteria.getDstatus()));
						}
						if (null != projectOrderCriteria.getId()) {
							criteria.add(Restrictions.eq("id",
									projectOrderCriteria.getId()));
						}
						if (null != projectOrderCriteria.getPassportId()) {
							criteria.add(Restrictions.eq("passportId",
									projectOrderCriteria.getPassportId()));
						}
						if (null != projectOrderCriteria.getServiceId()) {
							criteria.add(Restrictions.eq("serviceId",
									projectOrderCriteria.getServiceId()));
						}
						if (null != projectOrderCriteria.getInterviewerId()) {
							criteria.add(Restrictions.eq("interviewerId",
									projectOrderCriteria.getInterviewerId()));
						}
						if (null != projectOrderCriteria.getStatus()) {
							criteria.add(Restrictions.eq("status",
									projectOrderCriteria.getStatus()));
						}
						if (null != projectOrderCriteria.getInStatus()
								&& 0 < projectOrderCriteria.getInStatus().length) {
							criteria.add(Restrictions.in("status",
									projectOrderCriteria.getInStatus()));
						}
						if (null != projectOrderCriteria.getNotInStatus()
								&& 0 < projectOrderCriteria.getNotInStatus().length) {
							criteria.add(Restrictions.not(Restrictions.in(
									"status",
									projectOrderCriteria.getNotInStatus())));
						}
						return criteria.list();
					}
				});
		return list;
	}

	/**
	 * [获取项目订单数量－支持分页]
	 * 
	 * @param projectOrderCriteria
	 *            [项目订单－查询封装]
	 * @return
	 * @throws Exception
	 */
	public Integer countProjectOrderWithPage(
			final ProjectOrderCriteria projectOrderCriteria) throws Exception {
		// 申明变量
		Integer num = null;
		num = this.hibernateTemplate.execute(new HibernateCallback<Integer>() {

			public Integer doInHibernate(Session session)
					throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(ProjectOrder.class);
				criteria.setProjection(Projections.rowCount());
				if (StringUtil.isNotEmpty(projectOrderCriteria.getDstatus())) {
					criteria.add(Restrictions.eq("dstatus",
							projectOrderCriteria.getDstatus()));
				}
				if (null != projectOrderCriteria.getId()) {
					criteria.add(Restrictions.eq("id",
							projectOrderCriteria.getId()));
				}
				if (null != projectOrderCriteria.getPassportId()) {
					criteria.add(Restrictions.eq("passportId",
							projectOrderCriteria.getPassportId()));
				}
				if (null != projectOrderCriteria.getServiceId()) {
					criteria.add(Restrictions.eq("serviceId",
							projectOrderCriteria.getServiceId()));
				}
				if (null != projectOrderCriteria.getInterviewerId()) {
					criteria.add(Restrictions.eq("interviewerId",
							projectOrderCriteria.getInterviewerId()));
				}
				if (null != projectOrderCriteria.getStatus()) {
					criteria.add(Restrictions.eq("status",
							projectOrderCriteria.getStatus()));
				}
				if (null != projectOrderCriteria.getInStatus()
						&& 0 < projectOrderCriteria.getInStatus().length) {
					criteria.add(Restrictions.in("status",
							projectOrderCriteria.getInStatus()));
				}
				if (null != projectOrderCriteria.getNotInStatus()
						&& 0 < projectOrderCriteria.getNotInStatus().length) {
					criteria.add(Restrictions.not(Restrictions.in("status",
							projectOrderCriteria.getNotInStatus())));
				}
				return Integer.parseInt(criteria.uniqueResult().toString());
			}
		});
		return num;
	}

	/**
	 * [为项目订单存在判断提供计算]
	 * 
	 * @param projectOrder
	 *            [需要判断的项目订单信息]
	 * @return
	 * @throws Exception
	 */
	public Integer countProjectOrderForExist(final ProjectOrder projectOrder)
			throws Exception {
		// 申明变量
		Integer num = null;
		num = this.hibernateTemplate.execute(new HibernateCallback<Integer>() {

			public Integer doInHibernate(Session session)
					throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(ProjectOrder.class);
				criteria.setProjection(Projections.rowCount());
				String[] notInStatus = {
						ProjectOrderStatusEnum.FINISH.getCode(),
						ProjectOrderStatusEnum.DROPED.getCode() };
				criteria.add(Restrictions.not(Restrictions.in("status",
						notInStatus)));
				if (StringUtil.isNotEmpty(projectOrder.getDstatus())) {
					criteria.add(Restrictions.eq("dstatus",
							projectOrder.getDstatus()));
				}
				if (null != projectOrder.getProjectId()) {
					criteria.add(Restrictions.eq("projectId",
							projectOrder.getProjectId()));
				}
				if (null != projectOrder.getSubProjectId()) {
					criteria.add(Restrictions.eq("subProjectId",
							projectOrder.getSubProjectId()));
				}
				if (null != projectOrder.getProjectHolderId()) {
					criteria.add(Restrictions.eq("projectHolderId",
							projectOrder.getProjectHolderId()));
				}
				if (null != projectOrder.getPassportId()) {
					criteria.add(Restrictions.eq("passportId",
							projectOrder.getPassportId()));
				}
				return Integer.parseInt(criteria.uniqueResult().toString());
			}
		});
		return num;
	}

	/**
	 * [为项目订单时间是否冲突提供计算]
	 * 
	 * @param passportId
	 *            [面试官通行证标识]
	 * @param startTime
	 *            [面试开始时间]
	 * @param endTime
	 *            [面试结束时间]
	 * @return
	 * @throws Exception
	 */
	public Integer countProjectOrderForInterviewConflict(
			final Integer passportId, final Date startTime, final Date endTime)
			throws Exception {
		// 申明变量
		Integer num = null;
		num = this.hibernateTemplate.execute(new HibernateCallback<Integer>() {

			public Integer doInHibernate(Session session)
					throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(ProjectOrder.class);
				criteria.setProjection(Projections.rowCount());
				criteria.add(Restrictions.eq("dstatus",
						DataStatusEnum.NORMAL.getCode()));
				criteria.add(Restrictions.eq("status",
						ProjectOrderStatusEnum.WAIT_INTERVIEW.getCode()));
				if (NumberUtil.isNotEmptyOrZero(passportId)) {
					criteria.add(Restrictions.eq("interviewerId", passportId));
				}
				if (null != startTime && null != endTime) {
					criteria.add(Restrictions.le("interviewStartTime", endTime));
					criteria.add(Restrictions.ge("interviewEndTime", startTime));
				}
				return Integer.parseInt(criteria.uniqueResult().toString());
			}
		});
		return num;
	}

	/**
	 * [获取项目订单列表-和通行证表联合查询－支持分页]
	 * 
	 * @param projectOrderJoinPassportCriteria
	 *            [项目订单-通行证－查询封装]
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<ProjectOrder> selectProjectOrderJoinPassportWithPage(
			final ProjectOrderJoinPassportCriteria projectOrderJoinPassportCriteria)
			throws Exception {
		// 申明变量
		List<ProjectOrder> list = null;
		list = this.hibernateTemplate
				.executeFind(new HibernateCallback<List<ProjectOrder>>() {
					public List<ProjectOrder> doInHibernate(Session session)
							throws HibernateException, SQLException {
						String hql = "SELECT o FROM "
								+ ProjectOrder.class.getSimpleName()
								+ " as o ," + Passport.class.getSimpleName()
								+ " as p WHERE o.passportId = p.id";
						// 如果填写了数据状态
						if (StringUtil
								.isNotEmpty(projectOrderJoinPassportCriteria
										.getDstatus())) {
							hql += " AND o.dstatus = '"
									+ projectOrderJoinPassportCriteria
											.getDstatus()
									+ "' AND p.dstatus = '"
									+ projectOrderJoinPassportCriteria
											.getDstatus() + "'";
						}
						// 如果填写了跟进客服
						if (NumberUtil
								.isNotEmptyOrZero(projectOrderJoinPassportCriteria
										.getServiceId())) {
							hql += " AND o.serviceId ="
									+ projectOrderJoinPassportCriteria
											.getServiceId();
						}
						// 如果填写了订单状态
						if (StringUtil
								.isNotEmpty(projectOrderJoinPassportCriteria
										.getStatus())) {
							hql += " AND o.status ='"
									+ projectOrderJoinPassportCriteria
											.getStatus() + "'";
						}
						// 如果填写了真名
						if (StringUtil
								.isNotEmpty(projectOrderJoinPassportCriteria
										.getPtrueName())) {
							hql += " AND p.trueName like '%"
									+ projectOrderJoinPassportCriteria
											.getPtrueName() + "%'";
						}
						// 如果填写了联系手机
						if (StringUtil
								.isNotEmpty(projectOrderJoinPassportCriteria
										.getPmobile())) {
							hql += " AND p.mobile like '%"
									+ projectOrderJoinPassportCriteria
											.getPmobile() + "%'";
						}
						// 如果填写了qq
						if (StringUtil
								.isNotEmpty(projectOrderJoinPassportCriteria
										.getPqq())) {
							hql += " AND p.qq like '%"
									+ projectOrderJoinPassportCriteria.getPqq()
									+ "%'";
						}
						// 如果填写了高中名称
						if (StringUtil
								.isNotEmpty(projectOrderJoinPassportCriteria
										.getPhighSchoolName())) {
							hql += " AND p.highSchoolName like '%"
									+ projectOrderJoinPassportCriteria
											.getPhighSchoolName() + "%'";
						}
						// 如果填写了邮箱地址
						if (StringUtil
								.isNotEmpty(projectOrderJoinPassportCriteria
										.getPemail())) {
							hql += " AND p.email like '%"
									+ projectOrderJoinPassportCriteria
											.getPemail() + "%'";
						}
						// 如果填写了父母联系电话
						if (StringUtil
								.isNotEmpty(projectOrderJoinPassportCriteria
										.getPparentMobile())) {
							hql += " AND (p.fatherMobile like '%"
									+ projectOrderJoinPassportCriteria
											.getPparentMobile()
									+ "%' OR p.motherMobile like '%"
									+ projectOrderJoinPassportCriteria
											.getPparentMobile() + "%')";
						}
						// 如果填写了父母联系邮箱
						if (StringUtil
								.isNotEmpty(projectOrderJoinPassportCriteria
										.getPparentEmail())) {
							hql += " AND (p.fatherEmail like '%"
									+ projectOrderJoinPassportCriteria
											.getPparentEmail()
									+ "%' OR p.motherEmail like '%"
									+ projectOrderJoinPassportCriteria
											.getPparentEmail() + "%')";
						}
						// 创建查询对象
						Query query = session.createQuery(hql);
						if (projectOrderJoinPassportCriteria.isRequirePage()) {
							query.setFirstResult(projectOrderJoinPassportCriteria
									.getFirstIndex());
							query.setMaxResults(projectOrderJoinPassportCriteria
									.getRows());
						}
						return query.list();
					}
				});
		return list;
	}

	/**
	 * [获取项目订单数量-和通行证表联合查询－支持分页]
	 * 
	 * @param projectOrderJoinPassportCriteria
	 *            [项目订单-通行证－查询封装]
	 * @return
	 * @throws Exception
	 */
	public Integer countProjectOrderJoinPassportWithPage(
			final ProjectOrderJoinPassportCriteria projectOrderJoinPassportCriteria)
			throws Exception {
		// 申明变量
		Integer num = null;
		num = this.hibernateTemplate.execute(new HibernateCallback<Integer>() {

			public Integer doInHibernate(Session session)
					throws HibernateException, SQLException {
				String hql = "SELECT COUNT(*) FROM "
						+ ProjectOrder.class.getSimpleName() + " as o ,"
						+ Passport.class.getSimpleName()
						+ " as p WHERE  o.passportId = p.id";
				// 如果填写了数据状态
				if (StringUtil.isNotEmpty(projectOrderJoinPassportCriteria
						.getDstatus())) {
					hql += " AND o.dstatus = '"
							+ projectOrderJoinPassportCriteria.getDstatus()
							+ "' AND p.dstatus = '"
							+ projectOrderJoinPassportCriteria.getDstatus()
							+ "'";
				}
				// 如果填写了跟进客服
				if (NumberUtil
						.isNotEmptyOrZero(projectOrderJoinPassportCriteria
								.getServiceId())) {
					hql += " AND o.serviceId ="
							+ projectOrderJoinPassportCriteria.getServiceId();
				}
				// 如果填写了订单状态
				if (StringUtil.isNotEmpty(projectOrderJoinPassportCriteria
						.getStatus())) {
					hql += " AND o.status ='"
							+ projectOrderJoinPassportCriteria.getStatus()
							+ "'";
				}
				// 如果填写了真名
				if (StringUtil.isNotEmpty(projectOrderJoinPassportCriteria
						.getPtrueName())) {
					hql += " AND p.trueName like '%"
							+ projectOrderJoinPassportCriteria.getPtrueName()
							+ "%'";
				}
				// 如果填写了联系手机
				if (StringUtil.isNotEmpty(projectOrderJoinPassportCriteria
						.getPmobile())) {
					hql += " AND p.mobile like '%"
							+ projectOrderJoinPassportCriteria.getPmobile()
							+ "%'";
				}
				// 如果填写了qq
				if (StringUtil.isNotEmpty(projectOrderJoinPassportCriteria
						.getPqq())) {
					hql += " AND p.qq like '%"
							+ projectOrderJoinPassportCriteria.getPqq() + "%'";
				}
				// 如果填写了高中名称
				if (StringUtil.isNotEmpty(projectOrderJoinPassportCriteria
						.getPhighSchoolName())) {
					hql += " AND p.highSchoolName like '%"
							+ projectOrderJoinPassportCriteria
									.getPhighSchoolName() + "%'";
				}
				// 如果填写了邮箱地址
				if (StringUtil.isNotEmpty(projectOrderJoinPassportCriteria
						.getPemail())) {
					hql += " AND p.email like '%"
							+ projectOrderJoinPassportCriteria.getPemail()
							+ "%'";
				}
				// 如果填写了父母联系电话
				if (StringUtil.isNotEmpty(projectOrderJoinPassportCriteria
						.getPparentMobile())) {
					hql += " AND (p.fatherMobile like '%"
							+ projectOrderJoinPassportCriteria
									.getPparentMobile()
							+ "%' OR p.motherMobile like '%"
							+ projectOrderJoinPassportCriteria
									.getPparentMobile() + "%')";
				}
				// 如果填写了父母联系邮箱
				if (StringUtil.isNotEmpty(projectOrderJoinPassportCriteria
						.getPparentEmail())) {
					hql += " AND (p.fatherEmail like '%"
							+ projectOrderJoinPassportCriteria
									.getPparentEmail()
							+ "%' OR p.motherEmail like '%"
							+ projectOrderJoinPassportCriteria
									.getPparentEmail() + "%')";
				}
				// 创建查询对象
				Query query = session.createQuery(hql);
				Long result = (Long) query.uniqueResult();
				return result.intValue();
			}
		});
		return num;
	}
}
