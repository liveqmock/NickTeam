package com.wuya.backend.service;

import java.util.Date;

import com.wuya.backend.criteria.project.ProjectHolderCriteria;
import com.wuya.backend.criteria.project.ProjectInfoCriteria;
import com.wuya.backend.criteria.project.ProjectOrderCriteria;
import com.wuya.backend.criteria.project.multi.ProjectOrderJoinPassportCriteria;
import com.wuya.backend.po.project.ProjectHolder;
import com.wuya.backend.po.project.ProjectInfo;
import com.wuya.backend.po.project.ProjectOrder;
import com.wuya.base.result.EasyUiPagerResult;

/**
 * [项目相关－业务层接口]
 * 
 * @author nick
 * @version v1.0 2015-2-3
 */
public interface IProjectInfoService {

	/**
	 * [创建项目]
	 * 
	 * @param projectInfo
	 *            [项目信息]
	 * @return
	 * @throws Exception
	 */
	public boolean createProject(ProjectInfo projectInfo) throws Exception;

	/**
	 * [判断项目信息是否已存在]
	 * 
	 * @param projectInfo
	 *            [项目信息]
	 * @return
	 * @throws Exception
	 */
	public boolean isProjectExist(ProjectInfo projectInfo) throws Exception;

	/**
	 * [获取项目信息列表－支持分页]
	 * 
	 * @param projectInfoCriteria
	 *            [项目信息条件封装]
	 * @return
	 * @throws Exception
	 */
	public EasyUiPagerResult getProjectInfoListWithPage(
			ProjectInfoCriteria projectInfoCriteria) throws Exception;

	/**
	 * [根据项目标识，获取对应的项目信息]
	 * 
	 * @param id
	 *            [标识]
	 * @return
	 * @throws Exception
	 */
	public ProjectInfo getProjectInfoById(Integer id) throws Exception;

	/**
	 * [创建项目主办方信息]
	 * 
	 * @param projectHolder
	 *            [项目主办方实例]
	 * @return
	 * @throws Exception
	 */
	public boolean createProjectHolder(ProjectHolder projectHolder)
			throws Exception;

	/**
	 * [检查项目主办方信息是否重复]
	 * 
	 * @param projectHolder
	 *            [项目主办方实例]
	 * @return
	 * @throws Exception
	 */
	public boolean isProjectHolderExist(ProjectHolder projectHolder)
			throws Exception;

	/**
	 * [获取项目主办方列表－支持分页]
	 * 
	 * @param projectHolderCriteria
	 *            [项目主办方条件封装]
	 * @return
	 * @throws Exception
	 */
	public EasyUiPagerResult getProjectHolderListWithPage(
			ProjectHolderCriteria projectHolderCriteria) throws Exception;

	/**
	 * [删除标识对应的主办方信息]
	 * 
	 * @param holderId
	 *            [主办方标识]
	 * @return
	 * @throws Exception
	 */
	public boolean deleteProjectHolder(Integer holderId) throws Exception;

	/**
	 * [刪除項目信息]
	 * 
	 * @param projectId
	 *            [项目标识]
	 * @return
	 * @throws Exception
	 */
	public boolean deleteProject(Integer projectId) throws Exception;

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
			throws Exception;

	/**
	 * [获取项目订单列表－支持分页]
	 * 
	 * @param projectOrderCriteria
	 *            [项目订单条件封装]
	 * @return
	 * @throws Exception
	 */
	public EasyUiPagerResult getProjectOrderListWithPage(
			ProjectOrderCriteria projectOrderCriteria) throws Exception;

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
			throws Exception;

	/**
	 * [创建项目订单]
	 * 
	 * @param projectOrder
	 *            [项目订单实例]
	 * @return
	 * @throws Exception
	 */
	public boolean createProjectOrder(ProjectOrder projectOrder)
			throws Exception;

	/**
	 * [检查项目订单是否存在]
	 * 
	 * @param projectOrder
	 *            [项目订单实例]
	 * @return
	 * @throws Exception
	 */
	public boolean isProjectOrderExist(ProjectOrder projectOrder)
			throws Exception;

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
			throws Exception;

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
			throws Exception;

	/**
	 * [将状态迁移回等待审核状态]
	 * 
	 * @param orderId
	 *            [项目订单标识]
	 * @return
	 * @throws Exception
	 */
	public boolean returnProjectOrderStatusToWaitJudgement(Integer orderId)
			throws Exception;

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
			boolean flag) throws Exception;

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
			throws Exception;

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
			String flag) throws Exception;

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
			throws Exception;

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
			Integer passportId, Date startTime, Date endTime) throws Exception;

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
			Date endTime) throws Exception;

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
			String flagStr, String result) throws Exception;

	/**
	 * [请求重新面试]
	 * 
	 * @param orderId
	 *            [订单标识]
	 * @return
	 * @throws Exception
	 */
	public boolean requireReInterview(Integer orderId) throws Exception;

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
			boolean isNeedAirTicket, Integer ticketId) throws Exception;

	/**
	 * [作废订单]
	 * 
	 * @param orderId
	 *            [订单标识]
	 * @return
	 * @throws Exception
	 */
	public boolean dropProjectOrder(Integer orderId) throws Exception;

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
			throws Exception;

	/**
	 * [更新项目信息]
	 * 
	 * @param projectInfo
	 *            [项目信息实例]
	 * @return
	 * @throws Exception
	 */
	public boolean updateProjectInfo(ProjectInfo projectInfo) throws Exception;

	/**
	 * [获取我的正在运行的订单数量]
	 * 
	 * @param passportId
	 *            [用户通行证标识]
	 * @return
	 * @throws Exception
	 */
	public Integer getMyOperateablePorjectOrderCount(Integer passportId)
			throws Exception;

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
			throws Exception;

}
