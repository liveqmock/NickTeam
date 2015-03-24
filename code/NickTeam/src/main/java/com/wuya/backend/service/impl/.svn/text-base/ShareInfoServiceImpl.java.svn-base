package com.wuya.backend.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.wuya.backend.constant.ServiceErrorCodeConstant;
import com.wuya.backend.criteria.share.BusinessProcessLogCriteria;
import com.wuya.backend.criteria.share.CostCriteria;
import com.wuya.backend.criteria.share.CustomerFollowCriteria;
import com.wuya.backend.criteria.share.ImageCriteria;
import com.wuya.backend.criteria.share.PayLogCriteria;
import com.wuya.backend.criteria.share.TransportTicketCriteria;
import com.wuya.backend.dao.IShareDao;
import com.wuya.backend.po.project.ProjectOrder;
import com.wuya.backend.po.share.BusinessProcessLog;
import com.wuya.backend.po.share.Cost;
import com.wuya.backend.po.share.CustomerFollow;
import com.wuya.backend.po.share.Image;
import com.wuya.backend.po.share.PayLog;
import com.wuya.backend.po.share.TransportTicket;
import com.wuya.backend.po.user.Passport;
import com.wuya.backend.service.IShareInfoService;
import com.wuya.base.config.FtpServerEnum;
import com.wuya.base.constant.CommonConstant;
import com.wuya.base.enumerate.CostTargetEnum;
import com.wuya.base.enumerate.CostTypeEnum;
import com.wuya.base.enumerate.DataStatusEnum;
import com.wuya.base.enumerate.project.InterviewFlagEnum;
import com.wuya.base.enumerate.project.ProjectOrderPayTypeEnum;
import com.wuya.base.enumerate.project.ProjectOrderStatusEnum;
import com.wuya.base.enumerate.share.BusinessProcessTargetTypeEnum;
import com.wuya.base.enumerate.share.ImageTargetEnum;
import com.wuya.base.enumerate.share.PayLogTargetTypeEnum;
import com.wuya.base.enumerate.share.TransportTicketTypeEnum;
import com.wuya.base.exception.ParamErrorException;
import com.wuya.base.exception.ProcessErrorException;
import com.wuya.base.result.EasyUiPagerResult;
import com.wuya.base.util.FtpUtil;
import com.wuya.base.util.NumberUtil;
import com.wuya.base.util.StringUtil;

/**
 * [共享相关－业务层接口实现类]
 * 
 * @author nick
 * @version v1.0 2015-2-3
 */
@Service("shareInfoService")
public class ShareInfoServiceImpl implements IShareInfoService {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Autowired
	private IShareDao shareDao;

	/**
	 * [创建费用信息]
	 * 
	 * @param cost
	 *            [费用实例]
	 * @return
	 * @throws Exception
	 */
	public boolean createCost(Cost cost) throws Exception {
		// 申明变量
		boolean flag = false;
		boolean isExist = false;
		ProjectOrder projectOrder = null;
		// 判断参数合法性
		if (cost.validate()) {
			if (CostTargetEnum.PROJECT_ORDER.getCode().equals(
					cost.getTargetType())) {
				projectOrder = this.hibernateTemplate.load(ProjectOrder.class,
						cost.getTargetId());
				// 如果是删除报名费
				if (CostTypeEnum.ENTRY_FEE.getCode().equals(cost.getType())) {
					// 仅在待审核和待支付报名费时创建
					if (!ProjectOrderStatusEnum.WAIT_JUDGEMENT.getCode()
							.equals(projectOrder.getStatus())
							&& !ProjectOrderStatusEnum.WAIT_SIGN_PAY.getCode()
									.equals(projectOrder.getStatus())) {
						throw new ProcessErrorException(
								ServiceErrorCodeConstant.E0083);
					}
				} else {// 如果不是报名费,只能在待交项目费是更改
					if (!ProjectOrderStatusEnum.WAIT_PROJECT_PAY.getCode()
							.equals(projectOrder.getStatus())) {
						throw new ProcessErrorException(
								ServiceErrorCodeConstant.E0084);
					}
				}
			}
			isExist = this.isCostExist(cost);
			if (!isExist) {
				this.hibernateTemplate.save(cost);
				flag = true;
			} else {
				throw new ProcessErrorException(ServiceErrorCodeConstant.E0018);
			}
		} else {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0019);
		}
		return flag;
	}

	/**
	 * [检查费用信息是否重复]
	 * 
	 * @param cost
	 *            [项目主办方实例]
	 * @return
	 * @throws Exception
	 */
	public boolean isCostExist(Cost cost) throws Exception {
		// 申明变量
		Integer num = 0;
		// 计算数量
		num = this.shareDao.countCostForExist(cost);
		return 0 == num ? false : true;
	}

	/**
	 * [获取费用列表－支持分页]
	 * 
	 * @param costCriteria
	 *            [项目主办方条件封装]
	 * @return
	 * @throws Exception
	 */
	public EasyUiPagerResult getCostListWithPage(CostCriteria costCriteria)
			throws Exception {
		// 申明变量
		EasyUiPagerResult result = null;
		List<Cost> list = null;
		Integer num = 0;
		// 判断参数合法性
		if (null == costCriteria) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0020);
		} else {
			result = new EasyUiPagerResult();
			list = this.shareDao.selectCostWithPage(costCriteria);
			num = this.shareDao.countCostWithPage(costCriteria);
			result.setTotal(num);
			result.setRows(list);
		}
		return result;
	}

	/**
	 * [删除标识对应的费用信息]
	 * 
	 * @param costId
	 *            [费用标识]
	 * @return
	 * @throws Exception
	 */
	public boolean deleteCost(Integer costId) throws Exception {
		// 申明变量
		Cost cost = null;
		boolean flag = false;
		ProjectOrder projectOrder = null;
		// 检查参数合法性
		if (null == costId || 0 == costId) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0021);
		} else {
			cost = this.hibernateTemplate.load(Cost.class, costId);
			if (CostTargetEnum.PROJECT_ORDER.getCode().equals(
					cost.getTargetType())) {
				projectOrder = this.hibernateTemplate.load(ProjectOrder.class,
						cost.getTargetId());
				// 如果是删除报名费
				if (CostTypeEnum.ENTRY_FEE.getCode().equals(cost.getType())) {
					// 仅在待审核和待支付报名费时删除
					if (ProjectOrderStatusEnum.WAIT_JUDGEMENT.getCode().equals(
							projectOrder.getStatus())
							|| ProjectOrderStatusEnum.WAIT_SIGN_PAY.getCode()
									.equals(projectOrder.getStatus())) {
						// this.hibernateTemplate.delete(cost);
						cost.setDstatus(DataStatusEnum.DROP.getCode());
						flag = true;
					} else {
						throw new ProcessErrorException(
								ServiceErrorCodeConstant.E0081);
					}
				} else {// 如果不是报名费,只能在待交项目费是更改
					if (ProjectOrderStatusEnum.WAIT_PROJECT_PAY.getCode()
							.equals(projectOrder.getStatus())) {
						// this.hibernateTemplate.delete(cost);
						cost.setDstatus(DataStatusEnum.DROP.getCode());
						flag = true;
					} else {
						throw new ProcessErrorException(
								ServiceErrorCodeConstant.E0082);
					}
				}
			}
		}
		return flag;
	}

	/**
	 * [创建一个新的客户跟进信息]
	 * 
	 * @param customerFollow
	 *            [客户跟进实例]
	 * @return
	 * @throws Exception
	 */
	public boolean createCustomerFollow(CustomerFollow customerFollow)
			throws Exception {
		// 申明变量
		boolean flag = false;
		boolean isExist = false;
		// 判断参数合法性
		if (customerFollow.validate()) {
			isExist = this.isCustomerFollowExist(customerFollow);
			if (!isExist) {
				this.hibernateTemplate.save(customerFollow);
				flag = true;
			} else {
				throw new ProcessErrorException(ServiceErrorCodeConstant.E0028);
			}
		} else {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0027);
		}
		return flag;
	}

	/**
	 * [检查客户跟进信息是否重复]
	 * 
	 * @param customerFollow
	 *            [客户跟进实例]
	 * @return
	 * @throws Exception
	 */
	public boolean isCustomerFollowExist(CustomerFollow customerFollow)
			throws Exception {
		// 申明变量
		Integer num = 0;
		// 计算数量
		num = this.shareDao.countCustomerFollowForExist(customerFollow);
		return 0 == num ? false : true;
	}

	/**
	 * [获取客户跟进信息列表－支持分页]
	 * 
	 * @param customerFollowCriteria
	 *            [客户跟进信息条件封装]
	 * @return
	 * @throws Exception
	 */
	public EasyUiPagerResult getCustomerFollowListWithPage(
			CustomerFollowCriteria customerFollowCriteria) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * [删除标识对应的客户跟进信息]
	 * 
	 * @param customerFollowId
	 *            [客户跟进信息标识]
	 * @return
	 * @throws Exception
	 */
	public boolean deleteCustomerFollow(Integer customerFollowId)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * [创建业务流程日志信息]
	 * 
	 * @param businessProcessLog
	 *            [需要创建的业务流程日志信息]
	 * @return
	 * @throws Exception
	 */
	public boolean createBusinessProcessLog(
			BusinessProcessLog businessProcessLog) throws Exception {
		// 申明变量
		boolean flag = false;
		// 判断参数合法性
		if (!businessProcessLog.validate()) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0032);
		} else {
			// 设定创建时间
			businessProcessLog.setCreateTime(new Date());
			businessProcessLog.setDstatus(DataStatusEnum.NORMAL.getCode());
			this.hibernateTemplate.save(businessProcessLog);
			flag = true;
		}
		return flag;
	}

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
			boolean flag) throws Exception {
		// 申明变量
		boolean result = false;
		BusinessProcessLog businessProcessLog = null;
		ProjectOrder projectOrder = null;
		// 判断参数合法性
		if (null != passport && StringUtil.isNotEmpty(operateType)) {
			businessProcessLog = new BusinessProcessLog();
			businessProcessLog.setOperaterId(passport.getId());
			businessProcessLog.setOperaterType(operateType);
			businessProcessLog.setTargetId(targetId);
			businessProcessLog
					.setTargetType(BusinessProcessTargetTypeEnum.PROJECT_ORDER
							.getCode());
			// 获取订单信息
			projectOrder = this.hibernateTemplate.get(ProjectOrder.class,
					targetId);
			if (flag) {// 审核通过
				if (ProjectOrderPayTypeEnum.STEPABLE.getCode().equals(
						projectOrder.getPayType())) {
					businessProcessLog
							.setPrevStatus(ProjectOrderStatusEnum.WAIT_JUDGEMENT
									.getCode());
					businessProcessLog
							.setNextStatus(ProjectOrderStatusEnum.WAIT_SIGN_PAY
									.getCode());
				} else if (ProjectOrderPayTypeEnum.INCLUDE_ENTRY_FREE.getCode()
						.equals(projectOrder.getPayType())) {
					businessProcessLog
							.setPrevStatus(ProjectOrderStatusEnum.WAIT_JUDGEMENT
									.getCode());
					businessProcessLog
							.setNextStatus(ProjectOrderStatusEnum.WAIT_INTERVIEW
									.getCode());
				}
			} else {// 审核失败
				businessProcessLog
						.setPrevStatus(ProjectOrderStatusEnum.WAIT_JUDGEMENT
								.getCode());
				businessProcessLog
						.setNextStatus(ProjectOrderStatusEnum.JUDGEMENT_ERROR
								.getCode());
			}
			result = this.createBusinessProcessLog(businessProcessLog);
		}
		return result;
	}

	/**
	 * [创建图片信息]
	 * 
	 * @param image
	 *            [图片信息实例]
	 * @return
	 * @throws Exception
	 */
	public boolean createImage(Image image) throws Exception {
		// 申明变量
		boolean flag = false;
		// 检查参数合法性
		if (null == image || !image.validate()) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0040);
		} else {
			image.setCreateTime(new Date());
			image.setDstatus(DataStatusEnum.NORMAL.getCode());
			this.hibernateTemplate.save(image);
			flag = true;
		}
		return flag;
	}

	/**
	 * [获取图片列表-支持分页]
	 * 
	 * @param imageCriteria
	 *            [图片条件封装实例]
	 * @return
	 * @throws Exception
	 */
	public EasyUiPagerResult getImageListWithPage(ImageCriteria imageCriteria)
			throws Exception {
		// 申明变量
		EasyUiPagerResult result = null;
		List<Image> list = null;
		Integer num = 0;
		// 判断参数合法性
		if (null == imageCriteria) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0041);
		} else {
			result = new EasyUiPagerResult();
			list = this.shareDao.selectImageWithPage(imageCriteria);
			num = this.shareDao.countImageWithPage(imageCriteria);
			result.setTotal(num);
			result.setRows(list);
		}
		return result;
	}

	/**
	 * [删除图片信息]
	 * 
	 * @param imageId
	 *            [图片标识]
	 * @return
	 * @throws Exception
	 */
	public boolean deleteImage(Integer imageId) throws Exception {
		// 申明变量
		boolean result = false;
		Image image = null;
		// 检查参数合法性
		if (NumberUtil.isEmptyOrZero(imageId)) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0043);
		} else {
			image = this.hibernateTemplate.load(Image.class, imageId);
			image.setDstatus(DataStatusEnum.DROP.getCode());
			result = true;
			// 删除图片
			FtpUtil.deleteImage(image.getFileName(), image.getFileFormat(),
					image.getDataFloder(),
					FtpServerEnum.getByCode(image.getServerCode()));
		}
		return result;
	}

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
			throws Exception {
		// 申明变量
		EasyUiPagerResult result = null;
		List<BusinessProcessLog> list = null;
		Integer num = 0;
		// 判断参数合法性
		if (null == businessProcessLogCriteria) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0045);
		} else {
			result = new EasyUiPagerResult();
			list = this.shareDao
					.selectBusinessProcessLogWithPage(businessProcessLogCriteria);
			num = this.shareDao
					.countBusinessProcessLogWithPage(businessProcessLogCriteria);
			result.setTotal(num);
			result.setRows(list);
		}
		return result;
	}

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
			throws Exception {
		// 申明变量
		boolean result = false;
		BusinessProcessLog businessProcessLog = null;
		// 判断参数合法性
		if (null != passport && StringUtil.isNotEmpty(operateType)) {
			businessProcessLog = new BusinessProcessLog();
			businessProcessLog.setOperaterId(passport.getId());
			businessProcessLog.setOperaterType(operateType);
			businessProcessLog.setTargetId(targetId);
			businessProcessLog
					.setTargetType(BusinessProcessTargetTypeEnum.PROJECT_ORDER
							.getCode());
			businessProcessLog
					.setPrevStatus(ProjectOrderStatusEnum.JUDGEMENT_ERROR
							.getCode());
			businessProcessLog
					.setNextStatus(ProjectOrderStatusEnum.WAIT_JUDGEMENT
							.getCode());
			result = this.createBusinessProcessLog(businessProcessLog);
		}
		return result;
	}

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
			String operateType, Integer targetId) throws Exception {
		// 申明变量
		boolean result = false;
		BusinessProcessLog businessProcessLog = null;
		// 判断参数合法性
		if (null != passport && StringUtil.isNotEmpty(operateType)) {
			businessProcessLog = new BusinessProcessLog();
			businessProcessLog.setOperaterId(passport.getId());
			businessProcessLog.setOperaterType(operateType);
			businessProcessLog.setTargetId(targetId);
			businessProcessLog
					.setTargetType(BusinessProcessTargetTypeEnum.PROJECT_ORDER
							.getCode());
			businessProcessLog
					.setPrevStatus(ProjectOrderStatusEnum.WAIT_SIGN_PAY
							.getCode());
			businessProcessLog
					.setNextStatus(ProjectOrderStatusEnum.WAIT_INTERVIEW
							.getCode());
			result = this.createBusinessProcessLog(businessProcessLog);
		}
		return result;
	}

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
			String operateType, Integer targetId) throws Exception {
		// 申明变量
		boolean result = false;
		BusinessProcessLog businessProcessLog = null;
		// 判断参数合法性
		if (null != passport && StringUtil.isNotEmpty(operateType)) {
			businessProcessLog = new BusinessProcessLog();
			businessProcessLog.setOperaterId(passport.getId());
			businessProcessLog.setOperaterType(operateType);
			businessProcessLog.setTargetId(targetId);
			businessProcessLog
					.setTargetType(BusinessProcessTargetTypeEnum.PROJECT_ORDER
							.getCode());
			businessProcessLog
					.setPrevStatus(ProjectOrderStatusEnum.WAIT_INTERVIEW
							.getCode());
			businessProcessLog
					.setNextStatus(ProjectOrderStatusEnum.INTERVIEW_SIGNED
							.getCode());
			result = this.createBusinessProcessLog(businessProcessLog);
		}
		return result;
	}

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
			throws Exception {
		// 申明变量
		boolean result = false;
		BusinessProcessLog businessProcessLog = null;
		// 判断参数合法性
		if (null != passport && StringUtil.isNotEmpty(operateType)) {
			businessProcessLog = new BusinessProcessLog();
			businessProcessLog.setOperaterId(passport.getId());
			businessProcessLog.setOperaterType(operateType);
			businessProcessLog.setTargetId(targetId);
			businessProcessLog
					.setTargetType(BusinessProcessTargetTypeEnum.PROJECT_ORDER
							.getCode());
			if (InterviewFlagEnum.PASS.getCode().equals(flagStr)) {
				// 订单流转到待缴纳项目费
				businessProcessLog
						.setPrevStatus(ProjectOrderStatusEnum.WAIT_INTERVIEW
								.getCode());
				businessProcessLog
						.setNextStatus(ProjectOrderStatusEnum.WAIT_PROJECT_PAY
								.getCode());
			}
			if (InterviewFlagEnum.FAILED.getCode().equals(flagStr)) {
				// 订单流转到面试失败状态
				businessProcessLog
						.setPrevStatus(ProjectOrderStatusEnum.WAIT_INTERVIEW
								.getCode());
				businessProcessLog
						.setNextStatus(ProjectOrderStatusEnum.INTERVIEW_FAILED
								.getCode());
			}
			result = this.createBusinessProcessLog(businessProcessLog);
		}
		return result;
	}

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
			String operateType, Integer targetId) throws Exception {
		// 申明变量
		boolean result = false;
		BusinessProcessLog businessProcessLog = null;
		// 判断参数合法性
		if (null != passport && StringUtil.isNotEmpty(operateType)) {
			businessProcessLog = new BusinessProcessLog();
			businessProcessLog.setOperaterId(passport.getId());
			businessProcessLog.setOperaterType(operateType);
			businessProcessLog.setTargetId(targetId);
			businessProcessLog
					.setTargetType(BusinessProcessTargetTypeEnum.PROJECT_ORDER
							.getCode());
			businessProcessLog
					.setPrevStatus(ProjectOrderStatusEnum.INTERVIEW_FAILED
							.getCode());
			businessProcessLog
					.setNextStatus(ProjectOrderStatusEnum.WAIT_INTERVIEW
							.getCode());
			result = this.createBusinessProcessLog(businessProcessLog);
		}
		return result;
	}

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
			String operateType, Integer targetId) throws Exception {
		// 申明变量
		boolean result = false;
		BusinessProcessLog businessProcessLog = null;
		// 判断参数合法性
		if (null != passport && StringUtil.isNotEmpty(operateType)) {
			businessProcessLog = new BusinessProcessLog();
			businessProcessLog.setOperaterId(passport.getId());
			businessProcessLog.setOperaterType(operateType);
			businessProcessLog.setTargetId(targetId);
			businessProcessLog
					.setTargetType(BusinessProcessTargetTypeEnum.PROJECT_ORDER
							.getCode());
			businessProcessLog
					.setPrevStatus(ProjectOrderStatusEnum.WAIT_PROJECT_PAY
							.getCode());
			businessProcessLog.setNextStatus(ProjectOrderStatusEnum.FINISH
					.getCode());
			result = this.createBusinessProcessLog(businessProcessLog);
		}
		return result;
	}

	/**
	 * [创建交通票信息]
	 * 
	 * @param transportTicket
	 *            [需要创建的交通票实例]
	 * @return
	 * @throws Exception
	 */
	public boolean createTransportTicket(TransportTicket transportTicket)
			throws Exception {
		// 申明变量
		boolean result = false;
		boolean isExist = false;
		// 检查参数合法性
		if (null == transportTicket || !transportTicket.validate()) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0064);
		} else {
			// 设定预设信息
			transportTicket.setDstatus(DataStatusEnum.NORMAL.getCode());
			transportTicket.setUpdateTime(new Date());
			// 判断是否存在
			isExist = this.isTransportTicketExist(transportTicket);
			if (isExist) {
				throw new ProcessErrorException(ServiceErrorCodeConstant.E0065);
			} else {
				this.hibernateTemplate.save(transportTicket);
				result = true;
			}
		}
		return result;
	}

	/**
	 * [检查交通票信息是否存在]
	 * 
	 * @param transportTicket
	 *            [需要检查的交通票实例]
	 * @return
	 * @throws Exception
	 */
	public boolean isTransportTicketExist(TransportTicket transportTicket)
			throws Exception {
		// 创建变量
		Integer num = 0;
		// 获取结果
		num = this.shareDao.countTransportTicketForExist(transportTicket);
		return 0 == num ? false : true;
	}

	/**
	 * [创建飞机票信息]
	 * 
	 * @param transportTicket
	 *            [需要创建的交通票实例]
	 * @return
	 * @throws Exception
	 */
	public boolean createAirTicket(TransportTicket transportTicket)
			throws Exception {
		// 申明变量
		boolean result = false;
		// 检查参数合法性
		if (null == transportTicket || !transportTicket.validate()) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0064);
		} else {
			// 设定预设信息
			transportTicket.setType(TransportTicketTypeEnum.AIR.getCode());
			this.createTransportTicket(transportTicket);
			result = true;
		}
		return result;
	}

	/**
	 * [获取交通票信息列表-支持分页]
	 * 
	 * @param transportTicketCriteria
	 *            [交通票查询类]
	 * @return
	 * @throws Exception
	 */
	public EasyUiPagerResult getTransportTicketListWithPage(
			TransportTicketCriteria transportTicketCriteria) throws Exception {
		// 申明变量
		EasyUiPagerResult result = null;
		List<TransportTicket> list = null;
		Integer num = 0;
		// 判断参数合法性
		if (null == transportTicketCriteria) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0066);
		} else {
			result = new EasyUiPagerResult();
			list = this.shareDao
					.selectTransportTicketWithPage(transportTicketCriteria);
			num = this.shareDao
					.countTransportTicketWithPage(transportTicketCriteria);
			result.setTotal(num);
			result.setRows(list);
		}
		return result;
	}

	/**
	 * [删除标识对应的交通票务信息]
	 * 
	 * @param ticketId
	 *            [交通票务标识]
	 * @return
	 * @throws Exception
	 */
	public boolean deleteTransportTicket(Integer ticketId) throws Exception {// 申明变量
		boolean result = false;
		TransportTicket transportTicket = null;
		// 检查参数合法性
		if (NumberUtil.isEmptyOrZero(ticketId)) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0064);
		} else {
			transportTicket = this.hibernateTemplate.load(
					TransportTicket.class, ticketId);
			transportTicket.setDstatus(DataStatusEnum.DROP.getCode());
			result = true;
		}
		return result;
	}

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
			throws Exception {
		// 申明变量
		boolean result = false;
		TransportTicket transportTicket = null;
		Cost cost = null;
		// 检查参数合法性
		if (NumberUtil.isEmptyOrZero(ticketId)
				|| NumberUtil.isEmptyOrZero(projectId)) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0064);
		} else {
			// 获取对应的票务信息
			transportTicket = this.hibernateTemplate.get(TransportTicket.class,
					ticketId);
			// 判票务信息状态是否正确
			if (TransportTicketTypeEnum.AIR.getCode().equals(
					transportTicket.getType())) {
				// 生成费用信息
				cost = new Cost();
				cost.setDstatus(DataStatusEnum.NORMAL.getCode());
				cost.setType(CostTypeEnum.AIR_TICKET.getCode());
				cost.setTargetType(CostTargetEnum.PROJECT.getCode());
				cost.setTargetId(projectId);
				cost.setCurrency(transportTicket.getCurrency());
				cost.setCost(transportTicket.getPrice());
				cost.setRemark(transportTicket.getStartCity()
						+ CommonConstant.HIFHONE + transportTicket.getEndCity());
				this.createCost(cost);
				result = true;
			} else {
				throw new ProcessErrorException(ServiceErrorCodeConstant.E0067);
			}
		}
		return result;
	}

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
			throws Exception {
		// 申明变量
		Cost cost = null;
		ProjectOrder projectOrder = null;
		boolean flag = false;
		// 判断参数合法性
		// 获取价格信息
		cost = this.hibernateTemplate.load(Cost.class, costId);
		if (CostTargetEnum.PROJECT_ORDER.getCode().equals(cost.getTargetType())) {
			projectOrder = this.hibernateTemplate.load(ProjectOrder.class,
					cost.getTargetId());
			// 如果是报名费
			if (CostTypeEnum.ENTRY_FEE.getCode().equals(cost.getType())) {
				// 报名费只能在待审核和待交报名费时更改
				if (ProjectOrderStatusEnum.WAIT_JUDGEMENT.getCode().equals(
						projectOrder.getStatus())
						|| ProjectOrderStatusEnum.WAIT_SIGN_PAY.getCode()
								.equals(projectOrder.getStatus())) {
					cost.setCost(price);
					flag = true;
				} else {
					throw new ProcessErrorException(
							ServiceErrorCodeConstant.E0085);
				}
			} else {// 如果不是报名费
				// 其他费用只能在待交报名费时更改
				if (ProjectOrderStatusEnum.WAIT_PROJECT_PAY.getCode().equals(
						projectOrder.getStatus())) {
					cost.setCost(price);
					flag = true;
				} else {
					throw new ProcessErrorException(
							ServiceErrorCodeConstant.E0086);
				}
			}
		}
		return flag;
	}

	/**
	 * [创建付款日志]
	 * 
	 * @param payLog
	 * @return
	 * @throws Exception
	 */
	public boolean createPayLog(PayLog payLog) throws Exception {
		// 申明参数
		boolean flag = false;
		// 判断参数合法性
		if (!payLog.validate()) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0077);
		} else {
			// 设定预设值
			payLog.setDstatus(DataStatusEnum.NORMAL.getCode());
			payLog.setCreateTime(new Date());
			this.hibernateTemplate.save(payLog);
			flag = true;
		}
		return flag;
	}

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
			String currency, String feeType) throws Exception {
		// 申明变量
		PayLog payLog = null;
		boolean flag = false;
		// 判断参数合法性
		if (NumberUtil.isEmptyOrZero(orderId)) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0077);
		} else {
			payLog = new PayLog();
			payLog.setTargetId(orderId);
			payLog.setTargetType(PayLogTargetTypeEnum.PROJECT_ORDER.getCode());
			payLog.setPrice(price);
			payLog.setCurrency(currency);
			payLog.setType(feeType);
			flag = this.createPayLog(payLog);
		}
		return flag;
	}

	/**
	 * [获取支付日志信息列表-支持分页]
	 * 
	 * @param payLogCriteria
	 *            [支付日志查询类]
	 * @return
	 * @throws Exception
	 */
	public EasyUiPagerResult getPayLogListWithPage(PayLogCriteria payLogCriteria)
			throws Exception {// 申明变量
		EasyUiPagerResult result = null;
		List<PayLog> list = null;
		Integer num = 0;
		// 判断参数合法性
		if (null == payLogCriteria) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0078);
		} else {
			result = new EasyUiPagerResult();
			list = this.shareDao.selectPayLogWithPage(payLogCriteria);
			num = this.shareDao.countPayLogWithPage(payLogCriteria);
			result.setTotal(num);
			result.setRows(list);
		}
		return result;
	}

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
			throws Exception {// 申明变量
		boolean result = false;
		BusinessProcessLog businessProcessLog = null;
		// 判断参数合法性
		if (null != passport && StringUtil.isNotEmpty(operateType)) {
			businessProcessLog = new BusinessProcessLog();
			businessProcessLog.setOperaterId(passport.getId());
			businessProcessLog.setOperaterType(operateType);
			businessProcessLog.setTargetId(targetId);
			businessProcessLog
					.setTargetType(BusinessProcessTargetTypeEnum.PROJECT_ORDER
							.getCode());
			businessProcessLog.setPrevStatus(nowProjectStatus);
			businessProcessLog.setNextStatus(ProjectOrderStatusEnum.DROPED
					.getCode());
			result = this.createBusinessProcessLog(businessProcessLog);
		}
		return result;
	}

	/**
	 * [创建项目图片]
	 * 
	 * @param image
	 *            [项目图片实例]
	 * @return
	 * @throws Exception
	 */
	public boolean createProjectImage(Image image) throws Exception {
		// 申明参数
		boolean result = false;
		boolean isExist = false;
		// 判断参数合法性
		if (null == image || !image.validate()
				|| NumberUtil.isEmptyOrZero(image.getTargetId())) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0000);
		} else {
			// 设定默认信息
			image.setDstatus(DataStatusEnum.NORMAL.getCode());
			image.setCreateTime(new Date());
			image.setTargetType(ImageTargetEnum.PROJECT.getCode());
			isExist = this.isImageExist(image);
			if (!isExist) {
				result = this.createImage(image);
			} else {
				throw new ProcessErrorException(ServiceErrorCodeConstant.E0088);
			}
		}
		return result;
	}

	/**
	 * [检查图片是否已经存在]
	 * 
	 * @param image
	 *            [项目图片实例]
	 * @return
	 * @throws Exception
	 */
	public boolean isImageExist(Image image) throws Exception {
		// 申明变量
		Integer num = 0;
		// 获取数量
		num = this.shareDao.countImageForExist(image);
		return 0 == num ? false : true;
	}
}
