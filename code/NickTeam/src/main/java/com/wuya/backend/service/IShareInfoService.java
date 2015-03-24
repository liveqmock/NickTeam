package com.wuya.backend.service;

import com.wuya.backend.criteria.share.BusinessProcessLogCriteria;
import com.wuya.backend.criteria.share.CostCriteria;
import com.wuya.backend.criteria.share.CustomerFollowCriteria;
import com.wuya.backend.criteria.share.ImageCriteria;
import com.wuya.backend.criteria.share.PayLogCriteria;
import com.wuya.backend.criteria.share.TransportTicketCriteria;
import com.wuya.backend.po.share.BusinessProcessLog;
import com.wuya.backend.po.share.Cost;
import com.wuya.backend.po.share.CustomerFollow;
import com.wuya.backend.po.share.Image;
import com.wuya.backend.po.share.PayLog;
import com.wuya.backend.po.share.TransportTicket;
import com.wuya.backend.po.user.Passport;
import com.wuya.base.result.EasyUiPagerResult;

/**
 * [共享部分－业务层接口]
 * 
 * @author nick
 * @version v1.0 2015-2-3
 */
public interface IShareInfoService {

	/**
	 * [创建费用信息]
	 * 
	 * @param cost
	 *            [费用实例]
	 * @return
	 * @throws Exception
	 */
	public boolean createCost(Cost cost) throws Exception;

	/**
	 * [检查费用信息是否重复]
	 * 
	 * @param cost
	 *            [项目主办方实例]
	 * @return
	 * @throws Exception
	 */
	public boolean isCostExist(Cost cost) throws Exception;

	/**
	 * [获取费用列表－支持分页]
	 * 
	 * @param costCriteria
	 *            [项目主办方条件封装]
	 * @return
	 * @throws Exception
	 */
	public EasyUiPagerResult getCostListWithPage(CostCriteria costCriteria)
			throws Exception;

	/**
	 * [删除标识对应的费用信息]
	 * 
	 * @param costId
	 *            [费用标识]
	 * @return
	 * @throws Exception
	 */
	public boolean deleteCost(Integer costId) throws Exception;

	/**
	 * [创建一个新的客户跟进信息]
	 * 
	 * @param customerFollow
	 *            [客户跟进实例]
	 * @return
	 * @throws Exception
	 */
	public boolean createCustomerFollow(CustomerFollow customerFollow)
			throws Exception;

	/**
	 * [检查客户跟进信息是否重复]
	 * 
	 * @param customerFollow
	 *            [客户跟进实例]
	 * @return
	 * @throws Exception
	 */
	public boolean isCustomerFollowExist(CustomerFollow customerFollow)
			throws Exception;

	/**
	 * [获取客户跟进信息列表－支持分页]
	 * 
	 * @param customerFollowCriteria
	 *            [客户跟进信息条件封装]
	 * @return
	 * @throws Exception
	 */
	public EasyUiPagerResult getCustomerFollowListWithPage(
			CustomerFollowCriteria customerFollowCriteria) throws Exception;

	/**
	 * [删除标识对应的客户跟进信息]
	 * 
	 * @param customerFollowId
	 *            [客户跟进信息标识]
	 * @return
	 * @throws Exception
	 */
	public boolean deleteCustomerFollow(Integer customerFollowId)
			throws Exception;

	/**
	 * [创建业务流程日志信息]
	 * 
	 * @param businessProcessLog
	 *            [需要创建的业务流程日志信息]
	 * @return
	 * @throws Exception
	 */
	public boolean createBusinessProcessLog(
			BusinessProcessLog businessProcessLog) throws Exception;

	/**
	 * [[创建项目订单客户信息审核日志]]
	 * 
	 * @param passport
	 *            [操作人信息]
	 * @param operateType
	 *            [操作人类型]
	 * @param targetId
	 *            [项目订单标识]
	 * @param flag
	 *            [审核是否通过]
	 * @return
	 * @throws Exception
	 */
	public boolean createProjectOrderCustomerInfoJudgementLog(
			Passport passport, String operateType, Integer targetId,
			boolean flag) throws Exception;

	/**
	 * [[创建项目订单退回到待审核日志]]
	 * 
	 * @param passport
	 *            [操作人信息]
	 * @param operateType
	 *            [操作人类型]
	 * @param targetId
	 *            [项目订单标识]
	 * @return
	 * @throws Exception
	 */
	public boolean createReturnProjectOrderToWaitJudgementLog(
			Passport passport, String operateType, Integer targetId)
			throws Exception;

	/**
	 * [[创建项目订单支付报名费日志]]
	 * 
	 * @param passport
	 *            [操作人信息]
	 * @param operateType
	 *            [操作人类型]
	 * @param targetId
	 *            [项目订单标识]
	 * @return
	 * @throws Exception
	 */
	public boolean createPayProjectOrderEntryFreeLog(Passport passport,
			String operateType, Integer targetId) throws Exception;

	/**
	 * [[创建项目订单支付全款日志]]
	 * 
	 * @param passport
	 *            [操作人信息]
	 * @param operateType
	 *            [操作人类型]
	 * @param targetId
	 *            [项目订单标识]
	 * @return
	 * @throws Exception
	 */
	public boolean createPayProjectOrderAllFeeLog(Passport passport,
			String operateType, Integer targetId) throws Exception;

	/**
	 * [[创建作废项目订单日志]]
	 * 
	 * @param passport
	 *            [操作人信息]
	 * @param operateType
	 *            [操作人类型]
	 * @param targetId
	 *            [项目订单标识]
	 * @param nowProjectStatus
	 *            [当前订单状态]
	 * @return
	 * @throws Exception
	 */
	public boolean createDropProjectOrderLog(Passport passport,
			String operateType, Integer targetId, String nowProjectStatus)
			throws Exception;

	/**
	 * [创建面试信息日志]
	 * 
	 * @param passport
	 *            [操作人信息]
	 * @param operateType
	 *            [操作人类型]
	 * @param targetId
	 *            [项目订单标识]
	 * @return
	 * @throws Exception
	 */
	public boolean createSignInterviewerInfoLog(Passport passport,
			String operateType, Integer targetId) throws Exception;

	/**
	 * [创建面试结果信息日志]
	 * 
	 * @param passport
	 *            [操作人信息]
	 * @param operateType
	 *            [操作人类型]
	 * @param targetId
	 *            [项目订单标识]
	 * @return
	 * @throws Exception
	 */
	public boolean createSubmitInterviewerResultLog(Passport passport,
			String operateType, Integer targetId, String flagStr)
			throws Exception;

	/**
	 * [创建请求重新面试信息日志]
	 * 
	 * @param passport
	 *            [操作人信息]
	 * @param operateType
	 *            [操作人类型]
	 * @param targetId
	 *            [项目订单标识]
	 * @return
	 * @throws Exception
	 */
	public boolean createRequestReInterviewLog(Passport passport,
			String operateType, Integer targetId) throws Exception;

	/**
	 * [创建图片信息]
	 * 
	 * @param image
	 *            [图片信息实例]
	 * @return
	 * @throws Exception
	 */
	public boolean createImage(Image image) throws Exception;

	/**
	 * [获取图片列表-支持分页]
	 * 
	 * @param imageCriteria
	 *            [图片条件封装实例]
	 * @return
	 * @throws Exception
	 */
	public EasyUiPagerResult getImageListWithPage(ImageCriteria imageCriteria)
			throws Exception;

	/**
	 * [删除图片信息]
	 * 
	 * @param imageId
	 *            [图片标识]
	 * @return
	 * @throws Exception
	 */
	public boolean deleteImage(Integer imageId) throws Exception;

	/**
	 * [获取业务处理日志-支持分页]
	 * 
	 * @param businessProcessLogCriteria
	 *            [业务处理日志-条件封装]
	 * @return
	 * @throws Exception
	 */
	public EasyUiPagerResult getBusinessProcessLogListWithPage(
			BusinessProcessLogCriteria businessProcessLogCriteria)
			throws Exception;

	/**
	 * [创建交通票信息]
	 * 
	 * @param transportTicket
	 *            [需要创建的交通票实例]
	 * @return
	 * @throws Exception
	 */
	public boolean createTransportTicket(TransportTicket transportTicket)
			throws Exception;

	/**
	 * [检查交通票信息是否存在]
	 * 
	 * @param transportTicket
	 *            [需要检查的交通票实例]
	 * @return
	 * @throws Exception
	 */
	public boolean isTransportTicketExist(TransportTicket transportTicket)
			throws Exception;

	/**
	 * [创建飞机票信息]
	 * 
	 * @param transportTicket
	 *            [需要创建的交通票实例]
	 * @return
	 * @throws Exception
	 */
	public boolean createAirTicket(TransportTicket transportTicket)
			throws Exception;

	/**
	 * [获取交通票信息列表-支持分页]
	 * 
	 * @param transportTicketCriteria
	 *            [交通票查询类]
	 * @return
	 * @throws Exception
	 */
	public EasyUiPagerResult getTransportTicketListWithPage(
			TransportTicketCriteria transportTicketCriteria) throws Exception;

	/**
	 * [删除标识对应的交通票务信息]
	 * 
	 * @param ticketId
	 *            [交通票务标识]
	 * @return
	 * @throws Exception
	 */
	public boolean deleteTransportTicket(Integer ticketId) throws Exception;

	/**
	 * [根据机票生成某项目下的机票费用]
	 * 
	 * @param projectId
	 *            [项目标识]
	 * @param ticketId
	 *            [机票标识]
	 * @return
	 * @throws Exception
	 */
	public boolean pickAirTicketToCost(Integer projectId, Integer ticketId)
			throws Exception;

	/**
	 * [更新项目订单价格信息]
	 * 
	 * @param costId
	 *            [价格信息标识]
	 * @param price
	 *            [价格]
	 * @return
	 * @throws Exception
	 */
	public boolean updateProjectOrderCost(Integer costId, Double price)
			throws Exception;

	/**
	 * [创建付款日志]
	 * 
	 * @param payLog
	 *            [需要记录的日志]
	 * @return
	 * @throws Exception
	 */
	public boolean createPayLog(PayLog payLog) throws Exception;

	/**
	 * [记录支付订单日志]
	 * 
	 * @param orderId
	 *            [订单标识]
	 * @param price
	 *            [价格]
	 * @param currency
	 *            [币种]
	 * @param feeType
	 *            [费用类型]
	 * @return
	 * @throws Exception
	 */
	public boolean createPayProjectOrderLog(Integer orderId, Double price,
			String currency, String feeType) throws Exception;

	/**
	 * [获取支付日志信息列表-支持分页]
	 * 
	 * @param payLogCriteria
	 *            [支付日志查询类]
	 * @return
	 * @throws Exception
	 */
	public EasyUiPagerResult getPayLogListWithPage(PayLogCriteria payLogCriteria)
			throws Exception;

	/**
	 * [创建项目图片]
	 * 
	 * @param image
	 *            [项目图片实例]
	 * @return
	 * @throws Exception
	 */
	public boolean createProjectImage(Image image) throws Exception;

	/**
	 * [检查图片是否已经存在]
	 * 
	 * @param image
	 *            [项目图片实例]
	 * @return
	 * @throws Exception
	 */
	public boolean isImageExist(Image image) throws Exception;

}
