package com.wuya.backend.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.wuya.backend.constant.ServiceErrorCodeConstant;
import com.wuya.backend.criteria.project.ProjectHolderCriteria;
import com.wuya.backend.criteria.project.ProjectInfoCriteria;
import com.wuya.backend.criteria.project.ProjectOrderCriteria;
import com.wuya.backend.criteria.project.multi.ProjectOrderJoinPassportCriteria;
import com.wuya.backend.criteria.share.CostCriteria;
import com.wuya.backend.criteria.share.ImageCriteria;
import com.wuya.backend.criteria.share.PayLogCriteria;
import com.wuya.backend.dao.IProjectDao;
import com.wuya.backend.dao.IShareDao;
import com.wuya.backend.po.finance.FinanceAccount;
import com.wuya.backend.po.finance.FinanceAccountDetail;
import com.wuya.backend.po.project.ProjectHolder;
import com.wuya.backend.po.project.ProjectInfo;
import com.wuya.backend.po.project.ProjectOrder;
import com.wuya.backend.po.share.Cost;
import com.wuya.backend.po.share.Image;
import com.wuya.backend.po.share.PayLog;
import com.wuya.backend.po.share.TransportTicket;
import com.wuya.backend.po.user.Passport;
import com.wuya.backend.service.IFinanceInfoService;
import com.wuya.backend.service.IProjectInfoService;
import com.wuya.backend.service.IShareInfoService;
import com.wuya.base.config.SystemConfig;
import com.wuya.base.constant.CommonConstant;
import com.wuya.base.enumerate.CostTargetEnum;
import com.wuya.base.enumerate.CostTypeEnum;
import com.wuya.base.enumerate.CurrencyEnum;
import com.wuya.base.enumerate.DataStatusEnum;
import com.wuya.base.enumerate.YesOrNoEnum;
import com.wuya.base.enumerate.finance.FinanceAccountDetailTypeEnum;
import com.wuya.base.enumerate.project.InterviewFlagEnum;
import com.wuya.base.enumerate.project.ProjectOrderPayTypeEnum;
import com.wuya.base.enumerate.project.ProjectOrderStatusEnum;
import com.wuya.base.enumerate.share.ImageTargetEnum;
import com.wuya.base.enumerate.share.PayLogTargetTypeEnum;
import com.wuya.base.exception.ParamErrorException;
import com.wuya.base.exception.ProcessErrorException;
import com.wuya.base.result.EasyUiPagerResult;
import com.wuya.base.util.NumberUtil;
import com.wuya.base.util.StringUtil;

/**
 * [项目相关－业务层接口实现类]
 * 
 * @author nick
 * @version v1.0 2015-2-3
 */
@Service("projectInfoService")
public class ProjectInfoServiceImpl implements IProjectInfoService {

	@Autowired
	private IProjectDao projectDao;

	@Autowired
	private IShareDao shareDao;

	@Autowired
	private IFinanceInfoService financeInfoService;

	@Autowired
	private IShareInfoService shareInfoService;

	@Autowired
	private HibernateTemplate hibernateTemplate;

	/**
	 * [创建项目]
	 * 
	 * @param projectInfo
	 *            [项目信息]
	 * @return
	 * @throws Exception
	 */
	public boolean createProject(ProjectInfo projectInfo) throws Exception {
		// 申明参数
		boolean flag = false;
		boolean isExist = false;
		// 验证参数合法性
		if (!projectInfo.validate()) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0012);
		} else {
			projectInfo.setDstatus(DataStatusEnum.NORMAL.getCode());
			projectInfo.setApplyCount(0);
			if (0 == projectInfo.getPid()) {
				isExist = this.isProjectExist(projectInfo);
			} else {
				isExist = false;
			}
			if (isExist) {
				throw new ParamErrorException(ServiceErrorCodeConstant.E0013);
			} else {
				this.hibernateTemplate.save(projectInfo);
				flag = true;
			}
		}
		return flag;
	}

	/**
	 * [判断项目信息是否已存在]
	 * 
	 * @param projectInfo
	 *            [项目信息]
	 * @return
	 * @throws Exception
	 */
	public boolean isProjectExist(ProjectInfo projectInfo) throws Exception {
		int num = 0;
		num = this.projectDao.countProjectForExist(projectInfo);
		return 0 == num ? false : true;
	}

	/**
	 * [获取项目信息列表－支持分页]
	 * 
	 * @param projectInfoCriteria
	 *            [项目信息条件封装]
	 * @return
	 * @throws Exception
	 */
	public EasyUiPagerResult getProjectInfoListWithPage(
			ProjectInfoCriteria projectInfoCriteria) throws Exception {
		// 申明变量
		EasyUiPagerResult result = null;
		List<ProjectInfo> list = null;
		Integer num = 0;
		// 判断参数合法性
		if (null == projectInfoCriteria) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0011);
		} else {
			result = new EasyUiPagerResult();
			list = this.projectDao
					.selectProjectInfoWithPage(projectInfoCriteria);
			num = this.projectDao.countProjectInfoWithPage(projectInfoCriteria);
			// 如果需要加载子项目
			if (YesOrNoEnum.YES.getCode().equals(
					projectInfoCriteria.getNeedSubProject())) {
				for (int i = 0; i < list.size(); i++) {
					ProjectInfoCriteria criteria = new ProjectInfoCriteria();
					List<ProjectInfo> subProjectlist = null;
					criteria.setRequirePage(false);
					criteria.setDstatus(projectInfoCriteria.getDstatus());
					criteria.setPid(list.get(i).getId());
					criteria.setIsOnline(projectInfoCriteria.getIsOnline());
					subProjectlist = this.projectDao
							.selectProjectInfoWithPage(criteria);
					list.get(i).setSubProjects(subProjectlist);
				}
			}
			// 如果需要加载费用
			if (YesOrNoEnum.YES.getCode().equals(
					projectInfoCriteria.getNeedCost())) {
				for (int i = 0; i < list.size(); i++) {
					List<Cost> costs = null;
					CostCriteria criteria = new CostCriteria();
					criteria.setRequirePage(false);
					criteria.setDstatus(projectInfoCriteria.getDstatus());
					criteria.setTargetId(list.get(i).getId());
					criteria.setTargetType(CostTargetEnum.PROJECT.getCode());
					costs = this.shareDao.selectCostWithPage(criteria);
					list.get(i).setCosts(costs);
				}
			}
			// 如果需要图片信息
			if (YesOrNoEnum.YES.getCode().equals(
					projectInfoCriteria.getNeedImage())) {
				for (int i = 0; i < list.size(); i++) {
					ImageCriteria criteria = new ImageCriteria();
					criteria.setDstatus(DataStatusEnum.NORMAL.getCode());
					criteria.setTargetType(ImageTargetEnum.PROJECT.getCode());
					criteria.setRequirePage(false);
					criteria.setTargetId(list.get(i).getId());
					List<Image> images = this.shareDao
							.selectImageWithPage(criteria);
					if (null != images && 0 < images.size()) {
						list.get(i).setImage(images.get(0));
					}
				}
			}
			result.setTotal(num);
			result.setRows(list);
		}
		return result;
	}

	/**
	 * [根据项目标识，获取对应的项目信息]
	 * 
	 * @param id
	 *            [标识]
	 * @return
	 * @throws Exception
	 */
	public ProjectInfo getProjectInfoById(Integer id) throws Exception {
		// 申明变量
		ProjectInfo projectInfo = null;
		// 检查参数合法性
		if (null == id || 0 == id) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0014);
		} else {
			projectInfo = this.hibernateTemplate.get(ProjectInfo.class, id);
		}
		return projectInfo;
	}

	/**
	 * [创建项目主办方信息]
	 * 
	 * @param projectHolder
	 *            [项目主办方实例]
	 * @return
	 * @throws Exception
	 */
	public boolean createProjectHolder(ProjectHolder projectHolder)
			throws Exception {
		// 申明变量
		boolean flag = false;
		boolean isExist = false;
		// 判断参数合法性
		if (projectHolder.validate()) {
			isExist = this.isProjectHolderExist(projectHolder);
			if (!isExist) {
				this.hibernateTemplate.save(projectHolder);
				flag = true;
			} else {
				throw new ProcessErrorException(ServiceErrorCodeConstant.E0016);
			}
		} else {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0015);
		}
		return flag;
	}

	/**
	 * [检查项目主办方信息是否重复]
	 * 
	 * @param projectHolder
	 *            [项目主办方实例]
	 * @return
	 * @throws Exception
	 */
	public boolean isProjectHolderExist(ProjectHolder projectHolder)
			throws Exception {
		// 申明变量
		Integer num = 0;
		// 计算数量
		num = this.projectDao.countProjectHolerForExist(projectHolder);
		return 0 == num ? false : true;
	}

	/**
	 * [获取项目主办方列表－支持分页]
	 * 
	 * @param projectHolderCriteria
	 *            [项目主办方条件封装]
	 * @return
	 * @throws Exception
	 */
	public EasyUiPagerResult getProjectHolderListWithPage(
			ProjectHolderCriteria projectHolderCriteria) throws Exception {
		// 申明变量
		EasyUiPagerResult result = null;
		List<ProjectHolder> list = null;
		Integer num = 0;
		// 判断参数合法性
		if (null == projectHolderCriteria) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0011);
		} else {
			result = new EasyUiPagerResult();
			list = this.projectDao
					.selectProjectHolderWithPage(projectHolderCriteria);
			num = this.projectDao
					.countProjectHolderWithPage(projectHolderCriteria);
			result.setTotal(num);
			result.setRows(list);
		}
		return result;
	}

	/**
	 * [删除标识对应的主办方信息]
	 * 
	 * @param holderId
	 *            [主办方标识]
	 * @return
	 * @throws Exception
	 */
	public boolean deleteProjectHolder(Integer holderId) throws Exception {
		// 申明变量
		ProjectHolder projectHolder = null;
		boolean flag = false;
		// 检查参数合法性
		if (null == holderId || 0 == holderId) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0017);
		} else {
			projectHolder = this.hibernateTemplate.load(ProjectHolder.class,
					holderId);
			if (null == projectHolder) {
				flag = false;
			} else {
				// this.hibernateTemplate.delete(projectHolder);
				projectHolder.setDstatus(DataStatusEnum.DROP.getCode());
				flag = true;
			}
		}
		return flag;
	}

	/**
	 * [刪除項目信息]
	 * 
	 * @param projectId
	 *            [项目标识]
	 * @return
	 * @throws Exception
	 */
	public boolean deleteProject(Integer projectId) throws Exception {
		// 申明变量
		ProjectInfo projectInfo = null;
		List<ProjectInfo> subProjectInfos = null;
		List<ProjectHolder> projectHolders = null;
		List<Cost> costs = null;
		ProjectInfoCriteria projectInfoCriteria = null;
		ProjectHolderCriteria projectHolderCriteria = null;
		CostCriteria costCriteria = null;
		boolean flag = false;
		// 检查参数合法性
		if (null == projectId || 0 == projectId) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0014);
		} else {
			projectInfo = this.hibernateTemplate.load(ProjectInfo.class,
					projectId);
			if (null != projectInfo) {
				if (YesOrNoEnum.NO.getCode().equals(projectInfo.getIsOnline())) {// 如果没有上线
					if (1 == projectInfo.getLevel()
							&& 0 == projectInfo.getPid()) { // 如果是父级项目
						// 查询项目费用
						costCriteria = new CostCriteria();
						costCriteria.setRequirePage(false);
						costCriteria.setTargetId(projectId);
						costCriteria.setTargetType(CostTargetEnum.PROJECT
								.getCode());
						costs = this.shareDao.selectCostWithPage(costCriteria);
						// 删除费用
						for (Cost c : costs) {
							// this.hibernateTemplate.delete(c);
							c.setDstatus(DataStatusEnum.DROP.getCode());
							this.hibernateTemplate.update(c);
						}
						// 获取子项目
						projectInfoCriteria = new ProjectInfoCriteria();
						projectInfoCriteria.setRequirePage(false);
						projectInfoCriteria.setPid(projectInfo.getId());
						subProjectInfos = this.projectDao
								.selectProjectInfoWithPage(projectInfoCriteria);
						// 删子项目
						for (ProjectInfo p : subProjectInfos) {
							// 获取子项目主办方
							projectHolderCriteria = new ProjectHolderCriteria();
							projectHolderCriteria.setRequirePage(false);
							projectHolderCriteria.setProjectId(p.getId());
							projectHolders = this.projectDao
									.selectProjectHolderWithPage(projectHolderCriteria);
							// 删子子项目主办方
							for (ProjectHolder h : projectHolders) {
								// this.hibernateTemplate.delete(h);
								h.setDstatus(DataStatusEnum.DROP.getCode());
								this.hibernateTemplate.update(h);
							}
							// this.hibernateTemplate.delete(p);
							p.setDstatus(DataStatusEnum.DROP.getCode());
							this.hibernateTemplate.update(p);
						}
					} else { // 如果是子级项目
						// 获取子项目主办方
						projectHolderCriteria = new ProjectHolderCriteria();
						projectHolderCriteria.setRequirePage(false);
						projectHolderCriteria.setProjectId(projectInfo.getId());
						projectHolders = this.projectDao
								.selectProjectHolderWithPage(projectHolderCriteria);
						// 删子子项目主办方
						for (ProjectHolder h : projectHolders) {
							// this.hibernateTemplate.delete(h);
							h.setDstatus(DataStatusEnum.DROP.getCode());
							this.hibernateTemplate.update(h);
						}
					}
					// 删除项目
					// this.hibernateTemplate.delete(projectInfo);
					projectInfo.setDstatus(DataStatusEnum.DROP.getCode());
					this.hibernateTemplate.update(projectInfo);
					flag = true;
				} else {// 如果已经上线
					throw new ParamErrorException(
							ServiceErrorCodeConstant.E0022);
				}
			} else {
				throw new ProcessErrorException(ServiceErrorCodeConstant.E0023);
			}
		}
		return flag;
	}

	/**
	 * [改变项目上下线状态]
	 * 
	 * @param projectId
	 *            [项目标识]
	 * @param isOnline
	 *            [是否上线标志]
	 * @return
	 * @throws Exception
	 */
	public boolean changeProjectOnLineStatus(Integer projectId, boolean isOnline)
			throws Exception {
		// 申明变量
		ProjectInfo projectInfo = null;
		boolean flag = false;
		// 检查参数合法性
		if (null == projectId || 0 == projectId) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0014);
		} else {
			// 持久化态
			projectInfo = this.hibernateTemplate.load(ProjectInfo.class,
					projectId);
			if (null != projectInfo) {
				// 设定上下线状态
				if (isOnline) {
					projectInfo.setIsOnline(YesOrNoEnum.YES.getCode());
				} else {
					projectInfo.setIsOnline(YesOrNoEnum.NO.getCode());
				}
				flag = true;
			} else {
				throw new ProcessErrorException(ServiceErrorCodeConstant.E0023);
			}
		}
		return flag;
	}

	/**
	 * [获取项目订单列表－支持分页]
	 * 
	 * @param projectOrderCriteria
	 *            [项目订单条件封装]
	 * @return
	 * @throws Exception
	 */
	public EasyUiPagerResult getProjectOrderListWithPage(
			ProjectOrderCriteria projectOrderCriteria) throws Exception {
		// 申明变量
		EasyUiPagerResult result = null;
		List<ProjectOrder> list = null;
		Integer num = 0;
		// 判断参数合法性
		if (null == projectOrderCriteria) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0024);
		} else {
			result = new EasyUiPagerResult();
			list = this.projectDao
					.selectProjectOrderWithPage(projectOrderCriteria);
			num = this.projectDao
					.countProjectOrderWithPage(projectOrderCriteria);
			// 根据需要加载其他信息
			for (int i = 0; i < list.size(); i++) {
				if (YesOrNoEnum.YES.getCode().equals(
						projectOrderCriteria.getNeedProjectInfo())) { // 需要加载主项目
					ProjectInfo projectInfo = null;
					projectInfo = this.hibernateTemplate.get(ProjectInfo.class,
							list.get(i).getProjectId());
					list.get(i).setProjectInfo(projectInfo);
				}
				if (YesOrNoEnum.YES.getCode().equals(
						projectOrderCriteria.getNeedSubProjectInfo())) { // 需要加载子项目
					ProjectInfo projectInfo = null;
					projectInfo = this.hibernateTemplate.get(ProjectInfo.class,
							list.get(i).getSubProjectId());
					list.get(i).setSubProjectInfo(projectInfo);
				}
				if (YesOrNoEnum.YES.getCode().equals(
						projectOrderCriteria.getNeedProjectHolder())) { // 需要项目主办方
					ProjectHolder projectHolder = null;
					projectHolder = this.hibernateTemplate.get(
							ProjectHolder.class, list.get(i)
									.getProjectHolderId());
					list.get(i).setProjectHolder(projectHolder);
				}
				if (YesOrNoEnum.YES.getCode().equals(
						projectOrderCriteria.getNeedPassport())) { // 需要申请人
					Passport passport = null;
					passport = this.hibernateTemplate.get(Passport.class, list
							.get(i).getPassportId());
					list.get(i).setPassport(passport);
				}
				if (YesOrNoEnum.YES.getCode().equals(
						projectOrderCriteria.getNeedInterviewer())) { // 需要面试人信息
					Passport passport = null;
					passport = this.hibernateTemplate.get(Passport.class, list
							.get(i).getInterviewerId());
					list.get(i).setInterviewer(passport);
				}
				if (YesOrNoEnum.YES.getCode().equals(
						projectOrderCriteria.getNeedCosts())) { // 需要费用信息
					List<Cost> costs = null;
					CostCriteria criteria = new CostCriteria();
					criteria.setRequirePage(false);
					criteria.setDstatus(DataStatusEnum.NORMAL.getCode());
					criteria.setTargetId(list.get(i).getId());
					criteria.setTargetType(CostTargetEnum.PROJECT_ORDER
							.getCode());
					costs = shareDao.selectCostWithPage(criteria);
					list.get(i).setCosts(costs);
				}
				// 如果需要图片信息
				if (YesOrNoEnum.YES.getCode().equals(
						projectOrderCriteria.getNeedProjectImage())) {
					ImageCriteria criteria = new ImageCriteria();
					criteria.setDstatus(DataStatusEnum.NORMAL.getCode());
					criteria.setTargetType(ImageTargetEnum.PROJECT.getCode());
					criteria.setRequirePage(false);
					criteria.setTargetId(list.get(i).getProjectId());
					List<Image> images = this.shareDao
							.selectImageWithPage(criteria);
					if (null != images && 0 < images.size()) {
						list.get(i).setProjectImage(images.get(0));
					}
				}
			}
			result.setTotal(num);
			result.setRows(list);
		}
		return result;
	}

	/**
	 * [获取项目订单列表-连接通行证－支持分页]
	 * 
	 * @param projectOrderJoinPassportCriteria
	 *            [项目-通行证订单条件封装]
	 * @return
	 * @throws Exception
	 */
	public EasyUiPagerResult getProjectOrderListJoinPassportWithPage(
			ProjectOrderJoinPassportCriteria projectOrderJoinPassportCriteria)
			throws Exception {
		// 申明变量
		EasyUiPagerResult result = null;
		List<ProjectOrder> list = null;
		Integer num = 0;
		// 判断参数合法性
		if (null == projectOrderJoinPassportCriteria) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0024);
		} else {
			result = new EasyUiPagerResult();
			list = this.projectDao
					.selectProjectOrderJoinPassportWithPage(projectOrderJoinPassportCriteria);
			num = this.projectDao
					.countProjectOrderJoinPassportWithPage(projectOrderJoinPassportCriteria);
			// 根据需要加载其他信息
			for (int i = 0; i < list.size(); i++) {
				if (YesOrNoEnum.YES.getCode().equals(
						projectOrderJoinPassportCriteria.getNeedProjectInfo())) { // 需要加载主项目
					ProjectInfo projectInfo = null;
					projectInfo = this.hibernateTemplate.get(ProjectInfo.class,
							list.get(i).getProjectId());
					list.get(i).setProjectInfo(projectInfo);
				}
				if (YesOrNoEnum.YES.getCode().equals(
						projectOrderJoinPassportCriteria
								.getNeedSubProjectInfo())) { // 需要加载子项目
					ProjectInfo projectInfo = null;
					projectInfo = this.hibernateTemplate.get(ProjectInfo.class,
							list.get(i).getSubProjectId());
					list.get(i).setSubProjectInfo(projectInfo);
				}
				if (YesOrNoEnum.YES.getCode()
						.equals(projectOrderJoinPassportCriteria
								.getNeedProjectHolder())) { // 需要项目主办方
					ProjectHolder projectHolder = null;
					projectHolder = this.hibernateTemplate.get(
							ProjectHolder.class, list.get(i)
									.getProjectHolderId());
					list.get(i).setProjectHolder(projectHolder);
				}
				if (YesOrNoEnum.YES.getCode().equals(
						projectOrderJoinPassportCriteria.getNeedPassport())) { // 需要申请人
					Passport passport = null;
					passport = this.hibernateTemplate.get(Passport.class, list
							.get(i).getPassportId());
					list.get(i).setPassport(passport);
				}
				if (YesOrNoEnum.YES.getCode().equals(
						projectOrderJoinPassportCriteria.getNeedInterviewer())) { // 需要面试人信息
					Passport passport = null;
					passport = this.hibernateTemplate.get(Passport.class, list
							.get(i).getInterviewerId());
					list.get(i).setInterviewer(passport);
				}
				if (YesOrNoEnum.YES.getCode().equals(
						projectOrderJoinPassportCriteria.getNeedCosts())) { // 需要费用信息
					List<Cost> costs = null;
					CostCriteria criteria = new CostCriteria();
					criteria.setRequirePage(false);
					criteria.setDstatus(DataStatusEnum.NORMAL.getCode());
					criteria.setTargetId(list.get(i).getId());
					criteria.setTargetType(CostTargetEnum.PROJECT_ORDER
							.getCode());
					costs = shareDao.selectCostWithPage(criteria);
					list.get(i).setCosts(costs);
				}
				// 如果需要图片信息
				if (YesOrNoEnum.YES.getCode().equals(
						projectOrderJoinPassportCriteria.getNeedProjectImage())) {
					ImageCriteria criteria = new ImageCriteria();
					criteria.setDstatus(DataStatusEnum.NORMAL.getCode());
					criteria.setTargetType(ImageTargetEnum.PROJECT.getCode());
					criteria.setRequirePage(false);
					criteria.setTargetId(list.get(i).getProjectId());
					List<Image> images = this.shareDao
							.selectImageWithPage(criteria);
					if (null != images && 0 < images.size()) {
						list.get(i).setProjectImage(images.get(0));
					}
				}
			}
			result.setTotal(num);
			result.setRows(list);
		}
		return result;
	}

	/**
	 * [创建项目订单]
	 * 
	 * @param projectOrder
	 *            [项目订单实例]
	 * @return
	 * @throws Exception
	 */
	public boolean createProjectOrder(ProjectOrder projectOrder)
			throws Exception {
		// 申明参数
		boolean flag = false;
		boolean isExist = false;
		CostCriteria costCriteria = null;
		List<Cost> costList = null;
		Integer orderId = null;
		ProjectInfo projectInfo = null;
		// 验证参数合法性
		if (!projectOrder.validate()) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0025);
		} else {
			projectInfo = this.hibernateTemplate.load(ProjectInfo.class,
					projectOrder.getProjectId());
			projectInfo.setApplyCount(projectInfo.getApplyCount() + 1);
			projectOrder.setDstatus(DataStatusEnum.NORMAL.getCode());
			projectOrder.setCreateTime(new Date());
			projectOrder.setServiceId(0);
			projectOrder.setNeedAirTicket(YesOrNoEnum.NO.getCode());
			projectOrder.setPayType(ProjectOrderPayTypeEnum.STEPABLE.getCode());
			projectOrder.setIsEntryFeePaid(YesOrNoEnum.NO.getCode());
			projectOrder.setIsProjectFeePaid(YesOrNoEnum.NO.getCode());
			projectOrder.setInterviewerId(0);
			projectOrder.setInterviewTimes(0);
			projectOrder.setInterviewFlag(InterviewFlagEnum.WAIT.getCode());
			projectOrder.setAirTicketId(0);
			isExist = this.isProjectOrderExist(projectOrder);
			if (isExist) {
				throw new ParamErrorException(ServiceErrorCodeConstant.E0026);
			} else {
				projectOrder.setStatus(ProjectOrderStatusEnum.WAIT_JUDGEMENT
						.getCode());
				orderId = (Integer) this.hibernateTemplate.save(projectOrder);
				// 将项目价格转换到订单价格中去
				costCriteria = new CostCriteria();
				costCriteria.setDstatus(DataStatusEnum.NORMAL.getCode());
				costCriteria.setRequirePage(false);
				costCriteria.setTargetType(CostTargetEnum.PROJECT.getCode());
				costCriteria.setTargetId(projectOrder.getProjectId());
				costList = this.shareDao.selectCostWithPage(costCriteria);
				if (null != costList) {
					costList = this.changeProjectCostListToOrderCostList(
							costList, orderId);
					for (Cost c : costList) {
						this.hibernateTemplate.save(c);
					}
				}
				flag = true;
			}
		}
		return flag;
	}

	/**
	 * [将项目价格转换成订单价格]
	 * 
	 * @return
	 */
	public List<Cost> changeProjectCostListToOrderCostList(List<Cost> costList,
			Integer orderId) {
		List<Cost> orderCostList = new ArrayList<Cost>();
		Cost cost = null;
		if (null != costList) {
			for (Cost c : costList) {
				cost = new Cost();
				cost.setCost(c.getCost());
				cost.setCurrency(c.getCurrency());
				cost.setDstatus(c.getDstatus());
				cost.setType(c.getType());
				cost.setTargetType(CostTargetEnum.PROJECT_ORDER.getCode());
				cost.setTargetId(orderId);
				orderCostList.add(cost);
			}
		} else {

		}
		return orderCostList;
	}

	/**
	 * [检查项目订单是否存在]
	 * 
	 * @param projectOrder
	 *            [项目订单实例]
	 * @return
	 * @throws Exception
	 */
	public boolean isProjectOrderExist(ProjectOrder projectOrder)
			throws Exception {
		int num = 0;
		num = this.projectDao.countProjectOrderForExist(projectOrder);
		return 0 == num ? false : true;
	}

	/**
	 * [跟进项目订单]
	 * 
	 * @param orderId
	 *            [项目订单标识]
	 * @param serviceId
	 *            [跟进客服人员标识]
	 * @return
	 * @throws Exception
	 */
	public boolean followProjectOrder(Integer orderId, Integer serviceId)
			throws Exception {
		// 申明变量
		ProjectOrder projectOrder = null;
		boolean flag = false;
		// 判断参数合法性
		if (NumberUtil.isEmptyOrZero(orderId)
				|| NumberUtil.isEmptyOrZero(serviceId)) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0029);
		} else {
			projectOrder = this.hibernateTemplate.get(ProjectOrder.class,
					orderId);
			if (NumberUtil.isNotEmptyOrZero(projectOrder.getServiceId())
					&& serviceId.equals(projectOrder.getServiceId())) {
				throw new ParamErrorException(ServiceErrorCodeConstant.E0030);
			} else {
				projectOrder.setServiceId(serviceId);
				this.hibernateTemplate.update(projectOrder);
				flag = true;
			}
		}
		return flag;
	}

	/**
	 * [更改项目订单状态]
	 * 
	 * @param orderId
	 *            [项目订单标识]
	 * @param status
	 *            [项目订单状态]
	 * @return
	 * @throws Exception
	 */
	public boolean changeProjectOrderStatus(Integer orderId, String status)
			throws Exception {
		// 申明变量
		ProjectOrder projectOrder = null;
		boolean flag = false;
		// 判断参数合法性
		if (NumberUtil.isEmptyOrZero(orderId) || StringUtil.isEmpty(status)) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0029);
		} else {
			projectOrder = this.hibernateTemplate.get(ProjectOrder.class,
					orderId);
			if (status.equals(projectOrder.getStatus())) {
				throw new ParamErrorException(ServiceErrorCodeConstant.E0031);
			} else {
				projectOrder.setStatus(status);
				this.hibernateTemplate.update(projectOrder);
				flag = true;
			}
		}
		return flag;
	}

	/**
	 * [项目订单客户信息审核]
	 * 
	 * @param orderId
	 *            [订单标识]
	 * @param flag
	 *            [成功失败标志位]
	 * @return
	 * @throws Exception
	 */
	public boolean projectOrderCustomerInfoJudgement(Integer orderId,
			boolean flag) throws Exception {
		// 申明变量
		boolean result = false;
		ProjectOrder projectOrder = null;
		// 判断参数合法性
		if (NumberUtil.isEmptyOrZero(orderId)) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0025);
		} else {
			// 获取订单信息－持久化状态
			projectOrder = this.hibernateTemplate.load(ProjectOrder.class,
					orderId);
			if (null != projectOrder) {
				if (ProjectOrderStatusEnum.WAIT_JUDGEMENT.getCode().equals(
						projectOrder.getStatus())
						|| ProjectOrderStatusEnum.JUDGEMENT_ERROR.getCode()
								.equals(projectOrder.getStatus())) {
					if (flag) {
						// 判断支付类型
						if (ProjectOrderPayTypeEnum.STEPABLE.getCode().equals(
								projectOrder.getPayType())) {
							// 将状态迁移到待支付报名费
							projectOrder
									.setStatus(ProjectOrderStatusEnum.WAIT_SIGN_PAY
											.getCode());
						} else {
							// 将状态迁移到待安排面试
							projectOrder
									.setStatus(ProjectOrderStatusEnum.WAIT_INTERVIEW
											.getCode());
						}
					} else {
						// 将状态迁移到信息审核失败状态
						projectOrder
								.setStatus(ProjectOrderStatusEnum.JUDGEMENT_ERROR
										.getCode());
					}
					result = true;
				} else {
					throw new ProcessErrorException(
							ServiceErrorCodeConstant.E0033);
				}
			} else {
				throw new ProcessErrorException(ServiceErrorCodeConstant.E0034);
			}
		}
		return result;
	}

	/**
	 * [将状态迁移回等待审核状态]
	 * 
	 * @param orderId
	 *            [项目订单标识]
	 * @return
	 * @throws Exception
	 */
	public boolean returnProjectOrderStatusToWaitJudgement(Integer orderId)
			throws Exception {
		// 申明变量
		ProjectOrder projectOrder = null;
		boolean flag = false;
		// 检查参数合法性
		if (NumberUtil.isEmptyOrZero(orderId)) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0025);
		} else {
			projectOrder = this.hibernateTemplate.load(ProjectOrder.class,
					orderId);
			if (ProjectOrderStatusEnum.JUDGEMENT_ERROR.getCode().equals(
					projectOrder.getStatus())) {
				projectOrder.setStatus(ProjectOrderStatusEnum.WAIT_JUDGEMENT
						.getCode());
				flag = true;
			} else {
				throw new ParamErrorException(ServiceErrorCodeConstant.E0046);
			}
		}
		return flag;
	}

	/**
	 * [修改订单报名费支付类型]
	 * 
	 * @param orderId
	 *            [订单标识]
	 * @param type
	 *            [目标支付类型]
	 * @return
	 * @throws Exception
	 */
	public boolean changeProjectOrderEntryFreeType(Integer orderId, String type)
			throws Exception {
		// 申明变量
		ProjectOrder projectOrder = null;
		boolean flag = false;
		// 判断参数合法性
		if (NumberUtil.isEmptyOrZero(orderId) || StringUtil.isEmpty(type)) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0047);
		} else {
			// 获取当前订单信息
			projectOrder = this.hibernateTemplate.load(ProjectOrder.class,
					orderId);
			// 判断订单状态是否允许修改支付类型
			if (ProjectOrderStatusEnum.WAIT_JUDGEMENT.getCode().equals(
					projectOrder.getStatus())
					|| ProjectOrderStatusEnum.JUDGEMENT_ERROR.getCode().equals(
							projectOrder.getStatus())) {
				// 判断当前报名费支付类型是否和需要修改的一致
				if (projectOrder.getPayType().equals(type)) {
					throw new ProcessErrorException(
							ServiceErrorCodeConstant.E0049);
				} else {
					projectOrder.setPayType(type);
				}
				flag = true;
			} else {
				throw new ProcessErrorException(ServiceErrorCodeConstant.E0048);
			}
		}
		return flag;
	}

	/**
	 * [支付订单报名费]
	 * 
	 * @param orderId
	 *            [订单标识]
	 * @param passportId
	 *            [用户标识]
	 * @return
	 * @throws Exception
	 */
	public boolean payProjectOrderEntryFree(Integer orderId, Integer passportId)
			throws Exception {
		// 申明变量
		ProjectOrder projectOrder = null;
		boolean flag = false;
		List<Cost> costs = null;
		CostCriteria costCriteria = null;
		Double totalCost = 0.0;
		boolean isAfford = false;
		boolean payFlag = false;
		// 判断参数合法性
		if (NumberUtil.isEmptyOrZero(orderId)
				|| NumberUtil.isEmptyOrZero(passportId)) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0025);
		} else {
			// 获取项目订单
			projectOrder = this.hibernateTemplate.load(ProjectOrder.class,
					orderId);
			// 判断是否已经支付了报名费
			if (YesOrNoEnum.NO.getCode().equals(
					projectOrder.getIsEntryFeePaid())
					&& ProjectOrderStatusEnum.WAIT_SIGN_PAY.getCode().equals(
							projectOrder.getStatus())) {
				// 获取该项目的报名费用
				costCriteria = new CostCriteria();
				costCriteria.setRequirePage(false);
				costCriteria.setDstatus(DataStatusEnum.NORMAL.getCode());
				costCriteria.setTargetId(projectOrder.getId());
				costCriteria.setTargetType(CostTargetEnum.PROJECT_ORDER
						.getCode());
				costCriteria.setType(CostTypeEnum.ENTRY_FEE.getCode());
				costs = this.shareDao.selectCostWithPage(costCriteria);
				if (null != costs && 0 < costs.size()) {
					// 获取总价格
					for (Cost c : costs) {
						totalCost += c.getCost();
					}
					// 判断是否有足够的可用金额来支付
					isAfford = this.financeInfoService.isCanUseMoneyEnough(
							passportId, totalCost);
					// 进行支付
					if (isAfford) {// 有钱支付
						// 开始支付
						payFlag = this.financeInfoService.payProjectCost(
								passportId, totalCost,
								FinanceAccountDetailTypeEnum.ENTRY_FREE
										.getCode());
						// 支付成功，则讲状态迁移到待面试
						if (payFlag) {
							projectOrder.setIsEntryFeePaid(YesOrNoEnum.YES
									.getCode());
							projectOrder
									.setStatus(ProjectOrderStatusEnum.WAIT_INTERVIEW
											.getCode());
							// 记录日志
							this.shareInfoService.createPayProjectOrderLog(
									projectOrder.getId(), totalCost,
									costs.get(0).getCurrency(),
									CostTypeEnum.ENTRY_FEE.getCode());
							flag = true;
						} else {
							flag = false;
						}
					} else {// 没钱支付
						throw new ProcessErrorException(
								ServiceErrorCodeConstant.E0053);
					}
				} else {
					throw new ProcessErrorException(
							ServiceErrorCodeConstant.E0053);
				}
			} else {
				throw new ProcessErrorException(ServiceErrorCodeConstant.E0050);
			}
		}
		return flag;
	}

	/**
	 * [设定项目订单面试信息]
	 * 
	 * @param orderId
	 *            [订单标识]
	 * @param passportId
	 *            [面试官通行证标识]
	 * @param startTime
	 *            [面试开始时间]
	 * @param endTime
	 *            [面试结束时间]
	 * @return
	 * @throws Exception
	 */
	public boolean signProjectOrderInterviewInfo(Integer orderId,
			Integer passportId, Date startTime, Date endTime) throws Exception {
		// 申明变量
		ProjectOrder projectOrder = null;
		boolean flag = false;
		boolean conflictFlag = false;
		// 判断参数合法性
		if (NumberUtil.isEmptyOrZero(orderId)
				|| NumberUtil.isEmptyOrZero(passportId) || null == startTime
				|| null == endTime || (0 <= startTime.compareTo(endTime))) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0055);
		} else {
			// 获取订单信息
			projectOrder = this.hibernateTemplate.load(ProjectOrder.class,
					orderId);
			// 首先判断该用户的面试时间是否冲突
			conflictFlag = this.isInterviewTimeConflict(passportId, startTime,
					endTime);
			if (!conflictFlag) {
				// 设定面试信息
				projectOrder.setInterviewerId(passportId);
				projectOrder.setInterviewStartTime(startTime);
				projectOrder.setInterviewEndTime(endTime);
				projectOrder.setStatus(ProjectOrderStatusEnum.INTERVIEW_SIGNED
						.getCode());
				flag = true;
			} else {
				throw new ProcessErrorException(ServiceErrorCodeConstant.E0056);
			}
		}
		return flag;
	}

	/**
	 * [判断面试时间是否冲突]
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
	public boolean isInterviewTimeConflict(Integer passportId, Date startTime,
			Date endTime) throws Exception {
		// 申明变量
		Integer num = 0;
		// 进行计算
		num = this.projectDao.countProjectOrderForInterviewConflict(passportId,
				startTime, endTime);
		return 0 == num ? false : true;
	}

	/**
	 * [提交项目订单面试结果信息]
	 * 
	 * @param orderId
	 *            [订单标识]
	 * @param flagStr
	 *            [是否通过标志]
	 * @param result
	 *            [面试结果信息]
	 * @return
	 * @throws Exception
	 */
	public boolean submitProjectOrderInterviewResult(Integer orderId,
			String flagStr, String result) throws Exception {
		// 申明变量
		ProjectOrder projectOrder = null;
		boolean flag = false;
		// 判断参数合法性
		if (NumberUtil.isEmptyOrZero(orderId) || StringUtil.isEmpty(flagStr)) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0057);
		} else {
			// 获取订单信息-持久化状态
			projectOrder = this.hibernateTemplate.load(ProjectOrder.class,
					orderId);
			// 判断当前订单状态是否符合迁移要求
			if (ProjectOrderStatusEnum.INTERVIEW_SIGNED.getCode().equals(
					projectOrder.getStatus())) {
				// 判断当前时间是否已经过了订单面试结束时间
				if (0 > projectOrder.getInterviewEndTime()
						.compareTo(new Date())) {
					if (InterviewFlagEnum.PASS.getCode().equals(flagStr)) {
						// 订单流转到待缴纳项目费
						projectOrder
								.setStatus(ProjectOrderStatusEnum.WAIT_PROJECT_PAY
										.getCode());
						projectOrder.setInterviewFlag(flagStr);
					}
					if (InterviewFlagEnum.FAILED.getCode().equals(flagStr)) {
						// 订单流转到面试失败状态
						projectOrder
								.setStatus(ProjectOrderStatusEnum.INTERVIEW_FAILED
										.getCode());
						projectOrder.setInterviewFlag(flagStr);
					}
					projectOrder.setInterviewTimes(projectOrder
							.getInterviewTimes() + 1);
					projectOrder.setInterviewResult(result);
					flag = true;
				} else {
					throw new ProcessErrorException(
							ServiceErrorCodeConstant.E0058);
				}
			} else {
				throw new ProcessErrorException(ServiceErrorCodeConstant.E0059);
			}
		}
		return flag;
	}

	/**
	 * [请求重新面试]
	 * 
	 * @param orderId
	 *            [订单标识]
	 * @return
	 * @throws Exception
	 */
	public boolean requireReInterview(Integer orderId) throws Exception {
		// 申明变量
		boolean flag = false;
		ProjectOrder projectOrder = null;
		// 检查参数合法性
		if (NumberUtil.isEmptyOrZero(orderId)) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0025);
		} else {
			// 获取订单信息-持久化态
			projectOrder = this.hibernateTemplate.load(ProjectOrder.class,
					orderId);
			// 判断迁移状态是否符合要求
			if (ProjectOrderStatusEnum.INTERVIEW_FAILED.getCode().equals(
					projectOrder.getStatus())) {
				// 判断面试次数是否合法
				if (0 < SystemConfig.PROJECT_ORDER_INTERVIEW_MAX_TIMES
						.compareTo(projectOrder.getInterviewTimes())) {
					// 变回待面试状态-清空面试人信息
					projectOrder
							.setStatus(ProjectOrderStatusEnum.WAIT_INTERVIEW
									.getCode());
					projectOrder.setInterviewerId(0);
					projectOrder.setInterviewStartTime(null);
					projectOrder.setInterviewEndTime(null);
					projectOrder.setInterviewFlag(InterviewFlagEnum.WAIT
							.getCode());
					projectOrder.setInterviewResult(null);
					flag = true;
				} else {
					throw new ProcessErrorException(
							ServiceErrorCodeConstant.E0061);
				}
			} else {
				throw new ProcessErrorException(ServiceErrorCodeConstant.E0060);
			}
		}
		return flag;
	}

	/**
	 * [支付项目费用]
	 * 
	 * @param passportId
	 *            [支付人标识]
	 * @param orderId
	 *            [订单标识]
	 * @param isNeedAirTicket
	 *            [是否需要飞机票]
	 * @param ticketId
	 *            [飞机票标识]
	 * @return
	 * @throws Exception
	 */
	public boolean payProjectOrderFee(Integer passportId, Integer orderId,
			boolean isNeedAirTicket, Integer ticketId) throws Exception {
		// 申明变量
		ProjectOrder projectOrder = null;
		boolean flag = false;
		List<Cost> costs = null;
		CostCriteria costCriteria = null;
		Double totalCost = 0.0;
		TransportTicket transportTicket = null;
		boolean isAfford = false;
		boolean payFlag = false;
		Cost airCost = null;
		// 判断参数合法性
		if (NumberUtil.isEmptyOrZero(orderId)
				|| NumberUtil.isEmptyOrZero(passportId)) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0025);
		} else {
			// 获取项目订单
			projectOrder = this.hibernateTemplate.load(ProjectOrder.class,
					orderId);
			if (isNeedAirTicket && NumberUtil.isNotEmptyOrZero(ticketId)) {
				transportTicket = this.hibernateTemplate.load(
						TransportTicket.class, ticketId);
				projectOrder.setNeedAirTicket(YesOrNoEnum.YES.getCode());
				projectOrder.setAirTicketId(ticketId);
				// 将机票信息加入订单价格信息中
				airCost = new Cost();
				airCost.setDstatus(DataStatusEnum.NORMAL.getCode());
				airCost.setCurrency(transportTicket.getCurrency());
				airCost.setCost(transportTicket.getPrice());
				airCost.setType(CostTypeEnum.AIR_TICKET.getCode());
				airCost.setTargetType(CostTargetEnum.PROJECT_ORDER.getCode());
				airCost.setTargetId(projectOrder.getId());
				airCost.setRemark(transportTicket.getStartCity()
						+ CommonConstant.HIFHONE + transportTicket.getEndCity());
				this.hibernateTemplate.save(airCost);
			}
			// 判断是否已经支付了报名费
			if (YesOrNoEnum.NO.getCode().equals(
					projectOrder.getIsProjectFeePaid())
					&& ProjectOrderStatusEnum.WAIT_PROJECT_PAY.getCode()
							.equals(projectOrder.getStatus())) {
				// 判断是否要纳入报名费-分别获取支付总额
				// 获取该项目的报名费用
				costCriteria = new CostCriteria();
				costCriteria.setRequirePage(false);
				costCriteria.setDstatus(DataStatusEnum.NORMAL.getCode());
				costCriteria.setTargetId(projectOrder.getId());
				costCriteria.setTargetType(CostTargetEnum.PROJECT_ORDER
						.getCode());
				if (ProjectOrderPayTypeEnum.STEPABLE.getCode().equals(
						projectOrder.getPayType())
						&& YesOrNoEnum.YES.getCode().equals(
								projectOrder.getIsEntryFeePaid())) { // 已经支付-需要排除报名费
					String[] notInTypes = { CostTypeEnum.ENTRY_FEE.getCode() };
					costCriteria.setNotInTypes(notInTypes);
				} else if (ProjectOrderPayTypeEnum.INCLUDE_ENTRY_FREE.getCode()
						.equals(projectOrder.getPayType())
						&& YesOrNoEnum.NO.getCode().equals(
								projectOrder.getIsEntryFeePaid())) {// 本次支付
				} else {
					throw new ProcessErrorException(
							ServiceErrorCodeConstant.E0063);
				}
				// 获取总费用
				costs = this.shareDao.selectCostWithPage(costCriteria);
				if (null != costs && 0 < costs.size()) {
					// 获取总价格
					for (Cost c : costs) {
						totalCost += c.getCost();
					}
					// 判断是否有足够的可用金额来支付
					isAfford = this.financeInfoService.isCanUseMoneyEnough(
							passportId, totalCost);
					// 进行支付
					if (isAfford) {// 有钱支付
						// 开始支付
						payFlag = this.financeInfoService.payProjectCost(
								passportId, totalCost,
								FinanceAccountDetailTypeEnum.ALLPAYMENT
										.getCode());
						if (payFlag) {
							// 支付成功，则讲状态迁移到完成
							if (ProjectOrderPayTypeEnum.STEPABLE.getCode()
									.equals(projectOrder.getPayType())
									&& YesOrNoEnum.NO.getCode().equals(
											projectOrder.getIsEntryFeePaid())) {
								// 一起支付
								projectOrder.setIsEntryFeePaid(YesOrNoEnum.YES
										.getCode());
								projectOrder
										.setIsProjectFeePaid(YesOrNoEnum.YES
												.getCode());
							} else if (ProjectOrderPayTypeEnum.INCLUDE_ENTRY_FREE
									.getCode()
									.equals(projectOrder.getPayType())
									&& YesOrNoEnum.YES.getCode().equals(
											projectOrder.getIsEntryFeePaid())) {
								// 已经支付
								projectOrder
										.setIsProjectFeePaid(YesOrNoEnum.YES
												.getCode());
							}
							projectOrder
									.setStatus(ProjectOrderStatusEnum.FINISH
											.getCode());
							// 记录日志
							for (Cost c : costs) {
								this.shareInfoService.createPayProjectOrderLog(
										projectOrder.getId(), c.getCost(),
										c.getCurrency(), c.getType());
							}
							flag = true;
						} else {
							flag = false;
						}
					} else {// 没钱支付
						throw new ProcessErrorException(
								ServiceErrorCodeConstant.E0053);
					}
				} else {// 没支付费用
					throw new ProcessErrorException(
							ServiceErrorCodeConstant.E0062);
				}
			} else {
				throw new ProcessErrorException(ServiceErrorCodeConstant.E0050);
			}
		}
		return flag;
	}

	/**
	 * [修改订单是否需要代购机票]
	 * 
	 * @param orderId
	 *            [订单标识]
	 * @param flag
	 *            [是否标志]
	 * @return
	 * @throws Exception
	 */
	public boolean changeProjectOrderIsNeedAirTicket(Integer orderId,
			String flag) throws Exception {
		// 申明变量
		boolean result = false;
		ProjectOrder projectOrder = null;
		// 判断参数合法性
		if (NumberUtil.isEmptyOrZero(orderId) || StringUtil.isEmpty(flag)) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0025);
		} else {
			// 获取项目订单
			projectOrder = this.hibernateTemplate.load(ProjectOrder.class,
					orderId);
			// 判断订单状态-面试失败情况下不能修改、订单完成支付情况下不能修改、订单作废情况下不能修改
			if (ProjectOrderStatusEnum.INTERVIEW_FAILED.getCode().equals(
					projectOrder.getStatus())
					|| ProjectOrderStatusEnum.FINISH.getCode().equals(
							projectOrder.getStatus())
					|| ProjectOrderStatusEnum.DROPED.getCode().equals(
							projectOrder.getStatus())) {
				throw new ProcessErrorException(ServiceErrorCodeConstant.E0068);
			} else {
				if (YesOrNoEnum.YES.getCode().equals(flag)) {
					projectOrder.setNeedAirTicket(YesOrNoEnum.YES.getCode());
				} else {
					projectOrder.setNeedAirTicket(YesOrNoEnum.NO.getCode());
				}
				result = true;
			}
		}
		return result;
	}

	/**
	 * [作废订单]
	 * 
	 * @param orderId
	 *            [订单标识]
	 * @return
	 * @throws Exception
	 */
	public boolean dropProjectOrder(Integer orderId) throws Exception {
		// 申明变量
		ProjectOrder projectOrder = null;
		boolean flag = true;
		List<PayLog> payLogs = null;
		PayLogCriteria payLogCriteria = null;
		FinanceAccount financeAccount = null;
		FinanceAccountDetail financeAccountDetail = null;
		Double totalPrice = 0.0;
		// 判断参数是否合法
		if (NumberUtil.isEmptyOrZero(orderId)) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0025);
		} else {
			// 获取订单信息
			projectOrder = this.hibernateTemplate.load(ProjectOrder.class,
					orderId);
			financeAccount = this.hibernateTemplate.load(FinanceAccount.class,
					projectOrder.getPassportId());
			// 获取支付信息
			payLogCriteria = new PayLogCriteria();
			payLogCriteria.setDstatus(DataStatusEnum.NORMAL.getCode());
			payLogCriteria.setRequirePage(false);
			payLogCriteria.setTargetType(PayLogTargetTypeEnum.PROJECT_ORDER
					.getCode());
			payLogCriteria.setTargetId(orderId);
			payLogs = this.shareDao.selectPayLogWithPage(payLogCriteria);
			// 判断支付状态-将已经支付过的费用返还给用户
			if (null != payLogs && 0 < payLogs.size()) {
				for (PayLog p : payLogs) {
					totalPrice += p.getPrice();
				}
				financeAccount.setCanUseMoney(financeAccount.getCanUseMoney()
						+ totalPrice);
				financeAccountDetail = new FinanceAccountDetail();
				financeAccountDetail.setPassportId(financeAccount
						.getPassportId());
				financeAccountDetail.setAccountId(financeAccount.getId());
				financeAccountDetail.setPrice(totalPrice);
				financeAccountDetail.setCurrency(CurrencyEnum.RMB.getCode());
				this.financeInfoService
						.createReturnFeeDetailAfterProjectOrderDrop(financeAccountDetail);
			}
			// 修改订单状态到已作废
			projectOrder.setIsEntryFeePaid(YesOrNoEnum.NO.getCode());
			projectOrder.setIsProjectFeePaid(YesOrNoEnum.NO.getCode());
			projectOrder.setStatus(ProjectOrderStatusEnum.DROPED.getCode());
			flag = true;
		}
		return flag;
	}

	/**
	 * [更新订单备注]
	 * 
	 * @param orderId
	 *            [订单标识]
	 * @param remark
	 *            [订单备注]
	 * @return
	 * @throws Exception
	 */
	public boolean updateProjectRemark(Integer orderId, String remark)
			throws Exception {
		// 申明变量
		boolean flag = false;
		ProjectOrder projectOrder = null;
		// 检查参数合法性
		if (NumberUtil.isEmptyOrZero(orderId) || StringUtil.isEmpty(remark)) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0080);
		} else {
			projectOrder = this.hibernateTemplate.load(ProjectOrder.class,
					orderId);
			projectOrder.setRemark(remark);
			flag = true;
		}
		return flag;
	}

	/**
	 * [更新项目信息]
	 * 
	 * @param projectInfo
	 *            [项目信息实例]
	 * @return
	 * @throws Exception
	 */
	public boolean updateProjectInfo(ProjectInfo projectInfo) throws Exception {
		// 申明变量
		ProjectInfo projectInfoDb = null;
		boolean result = false;
		// 验证参数合法性
		if (null == projectInfo
				|| NumberUtil.isEmptyOrZero(projectInfo.getId())) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0001);
		} else {
			projectInfoDb = this.hibernateTemplate.load(ProjectInfo.class,
					projectInfo.getId());
			if (StringUtil.isNotEmpty(projectInfo.getName())) {
				if (!projectInfo.getName().equals(projectInfoDb.getName())) {
					projectInfoDb.setName(projectInfo.getName());
				}
			}
			if (StringUtil.isNotEmpty(projectInfo.getShortName())) {
				if (!projectInfo.getShortName().equals(
						projectInfoDb.getShortName())) {
					projectInfoDb.setShortName(projectInfo.getShortName());
				}
			}
			if (StringUtil.isNotEmpty(projectInfo.getMsgAddress())) {
				if (!projectInfo.getMsgAddress().equals(
						projectInfoDb.getMsgAddress())) {
					projectInfoDb.setMsgAddress(projectInfo.getMsgAddress());
				}
			}
			if (StringUtil.isNotEmpty(projectInfo.getDescription())) {
				if (!projectInfo.getDescription().equals(
						projectInfoDb.getDescription())) {
					projectInfoDb.setDescription(projectInfo.getDescription());
				}
			}
			result = true;
		}
		return result;
	}

	/**
	 * [获取我的正在运行的订单数量]
	 * 
	 * @param passportId
	 *            [用户通行证标识]
	 * @return
	 * @throws Exception
	 */
	public Integer getMyOperateablePorjectOrderCount(Integer passportId)
			throws Exception {
		// 申明变量
		Integer num = 0;
		ProjectOrderCriteria projectOrderCriteria = null;
		// 验证参数合法性
		if (NumberUtil.isEmptyOrZero(passportId)) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0000);
		} else {
			String[] notInStatus = { ProjectOrderStatusEnum.FINISH.getCode(),
					ProjectOrderStatusEnum.DROPED.getCode() };
			projectOrderCriteria = new ProjectOrderCriteria();
			projectOrderCriteria.setDstatus(DataStatusEnum.NORMAL.getCode());
			projectOrderCriteria.setPassportId(passportId);
			projectOrderCriteria.setNotInStatus(notInStatus);
			num = this.projectDao
					.countProjectOrderWithPage(projectOrderCriteria);
		}
		return num;
	}

	/**
	 * [客服放弃对项目订单的跟进]
	 * 
	 * @param passportId
	 *            [操作客服]
	 * @param orderId
	 *            [订单标识]
	 * @return
	 * @throws Exception
	 */
	public boolean giveUpProjectOrderFollow(Integer passportId, Integer orderId)
			throws Exception {
		// 申明变量
		boolean result = false;
		ProjectOrder projectOrder = null;
		// 判断参数合法性
		if (NumberUtil.isEmptyOrZero(orderId)
				|| NumberUtil.isEmptyOrZero(passportId)) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0000);
		} else {
			// 获取目标订单
			projectOrder = this.hibernateTemplate.load(ProjectOrder.class,
					orderId);
			if (0 == passportId.compareTo(projectOrder.getServiceId())) { // 放弃人和跟进人相同
				// 放弃跟进
				projectOrder.setServiceId(0);
				result = true;
			} else {
				throw new ProcessErrorException(ServiceErrorCodeConstant.E0090);
			}
		}
		return result;
	}
}
