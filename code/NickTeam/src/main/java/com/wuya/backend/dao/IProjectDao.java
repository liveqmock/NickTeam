package com.wuya.backend.dao;

import java.util.Date;
import java.util.List;

import com.wuya.backend.criteria.project.ProjectHolderCriteria;
import com.wuya.backend.criteria.project.ProjectInfoCriteria;
import com.wuya.backend.criteria.project.ProjectOrderCriteria;
import com.wuya.backend.criteria.project.multi.ProjectOrderJoinPassportCriteria;
import com.wuya.backend.po.project.ProjectHolder;
import com.wuya.backend.po.project.ProjectInfo;
import com.wuya.backend.po.project.ProjectOrder;

/**
 * [项目相关－数据访问层接口]
 * 
 * @author nick
 * @version v1.0 2015-2-3
 */
public interface IProjectDao {

	/**
	 * [为存在判断提供计算]
	 * 
	 * @param projectInfo
	 *            [需要判断的项目信息]
	 * @return
	 * @throws Exception
	 */
	public Integer countProjectForExist(ProjectInfo projectInfo)
			throws Exception;

	/**
	 * [为项目主办方存在判断提供计算]
	 * 
	 * @param projectInfo
	 *            [需要判断的项目信息]
	 * @return
	 * @throws Exception
	 */
	public Integer countProjectHolerForExist(ProjectHolder projectHolder)
			throws Exception;

	/**
	 * [获取项目列表-支持分页]
	 * 
	 * @param projectInfoCriteria
	 *            [项目信息－查询封装]
	 * @return
	 * @throws Exception
	 */
	public List<ProjectInfo> selectProjectInfoWithPage(
			final ProjectInfoCriteria projectInfoCriteria) throws Exception;

	/**
	 * [获取项目数量-支持分页]
	 * 
	 * @param projectInfoCriteria
	 *            [项目信息－查询封装]
	 * @return
	 * @throws Exception
	 */
	public Integer countProjectInfoWithPage(
			final ProjectInfoCriteria projectInfoCriteria) throws Exception;

	/**
	 * [获取项目主办方列表-支持分页]
	 * 
	 * @param projectHolderCriteria
	 *            [项目主办方信息－查询封装]
	 * @return
	 * @throws Exception
	 */
	public List<ProjectHolder> selectProjectHolderWithPage(
			final ProjectHolderCriteria projectHolderCriteria) throws Exception;

	/**
	 * [获取项目主办方数量-支持分页]
	 * 
	 * @param projectHolderCriteria
	 *            [项目主办方信息－查询封装]
	 * @return
	 * @throws Exception
	 */
	public Integer countProjectHolderWithPage(
			final ProjectHolderCriteria projectHolderCriteria) throws Exception;

	/**
	 * [获取项目订单列表－支持分页]
	 * 
	 * @param projectOrderCriteria
	 *            [项目订单－查询封装]
	 * @return
	 * @throws Exception
	 */
	public List<ProjectOrder> selectProjectOrderWithPage(
			final ProjectOrderCriteria projectOrderCriteria) throws Exception;

	/**
	 * [获取项目订单数量－支持分页]
	 * 
	 * @param projectOrderCriteria
	 *            [项目订单－查询封装]
	 * @return
	 * @throws Exception
	 */
	public Integer countProjectOrderWithPage(
			final ProjectOrderCriteria projectOrderCriteria) throws Exception;

	/**
	 * [获取项目订单列表-和通行证表联合查询－支持分页]
	 * 
	 * @param projectOrderJoinPassportCriteria
	 *            [项目订单-通行证－查询封装]
	 * @return
	 * @throws Exception
	 */
	public List<ProjectOrder> selectProjectOrderJoinPassportWithPage(
			final ProjectOrderJoinPassportCriteria projectOrderJoinPassportCriteria)
			throws Exception;

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
			throws Exception;

	/**
	 * [为项目订单存在判断提供计算]
	 * 
	 * @param projectOrder
	 *            [需要判断的项目订单信息]
	 * @return
	 * @throws Exception
	 */
	public Integer countProjectOrderForExist(ProjectOrder projectOrder)
			throws Exception;

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
	public Integer countProjectOrderForInterviewConflict(Integer passportId,
			Date startTime, Date endTime) throws Exception;

}
