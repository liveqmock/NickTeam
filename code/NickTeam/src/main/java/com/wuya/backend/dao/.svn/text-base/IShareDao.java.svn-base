package com.wuya.backend.dao;

import java.util.List;

import com.wuya.backend.criteria.share.BusinessProcessLogCriteria;
import com.wuya.backend.criteria.share.CostCriteria;
import com.wuya.backend.criteria.share.ImageCriteria;
import com.wuya.backend.criteria.share.PayLogCriteria;
import com.wuya.backend.criteria.share.TransportTicketCriteria;
import com.wuya.backend.po.share.BusinessProcessLog;
import com.wuya.backend.po.share.Cost;
import com.wuya.backend.po.share.CustomerFollow;
import com.wuya.backend.po.share.Image;
import com.wuya.backend.po.share.PayLog;
import com.wuya.backend.po.share.TransportTicket;

/**
 * [共享部分－数据访问层接口]
 * 
 * @author nick
 * @version v1.0 2015-2-3
 */
public interface IShareDao {

	/**
	 * [为存在判断提供计算]
	 * 
	 * @param projectInfo
	 *            [需要判断的项目信息]
	 * @return
	 * @throws Exception
	 */
	public Integer countCostForExist(Cost cost) throws Exception;

	/**
	 * [获取费用列表-支持分页]
	 * 
	 * @param costCriteria
	 *            [费用信息－查询封装]
	 * @return
	 * @throws Exception
	 */
	public List<Cost> selectCostWithPage(final CostCriteria costCriteria)
			throws Exception;

	/**
	 * [获取费用数量-支持分页]
	 * 
	 * @param costCriteria
	 *            [费用信息－查询封装]
	 * @return
	 * @throws Exception
	 */
	public Integer countCostWithPage(final CostCriteria costCriteria)
			throws Exception;

	/**
	 * [为存在判断提供计算]
	 * 
	 * @param customerFollow
	 *            [需要判断的客户跟进信息]
	 * @return
	 * @throws Exception
	 */
	public Integer countCustomerFollowForExist(CustomerFollow customerFollow)
			throws Exception;

	/**
	 * [获取图片列表-支持分页]
	 * 
	 * @param imageCriteria
	 *            [图片信息－查询封装]
	 * @return
	 * @throws Exception
	 */
	public List<Image> selectImageWithPage(final ImageCriteria imageCriteria)
			throws Exception;

	/**
	 * [获取图片数量-支持分页]
	 * 
	 * @param imageCriteria
	 *            [图片信息－查询封装]
	 * @return
	 * @throws Exception
	 */
	public Integer countImageWithPage(final ImageCriteria imageCriteria)
			throws Exception;

	/**
	 * [为图片信息进行存在性判断]
	 * 
	 * @param image
	 * @return
	 * @throws Exception
	 */
	public Integer countImageForExist(final Image image) throws Exception;

	/**
	 * [获取业务日志列表-支持分页]
	 * 
	 * @param businessProcessLogCriteria
	 *            [业务日志信息－查询封装]
	 * @return
	 * @throws Exception
	 */
	public List<BusinessProcessLog> selectBusinessProcessLogWithPage(
			final BusinessProcessLogCriteria businessProcessLogCriteria)
			throws Exception;

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
			throws Exception;

	/**
	 * [为存在判断提供计算]
	 * 
	 * @param transportTicket
	 *            [交通票信息实例]
	 * @return
	 * @throws Exception
	 */
	public Integer countTransportTicketForExist(TransportTicket transportTicket)
			throws Exception;

	/**
	 * [获取交通票列表-支持分页]
	 * 
	 * @param imageCriteria
	 *            [交通票信息－查询封装]
	 * @return
	 * @throws Exception
	 */
	public List<TransportTicket> selectTransportTicketWithPage(
			final TransportTicketCriteria transportTicketCriteria)
			throws Exception;

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
			throws Exception;

	/**
	 * [获取支付日志列表-支持分页]
	 * 
	 * @param payLogCriteria
	 *            [支付日志信息－查询封装]
	 * @return
	 * @throws Exception
	 */
	public List<PayLog> selectPayLogWithPage(final PayLogCriteria payLogCriteria)
			throws Exception;

	/**
	 * [获取支付日志数量-支持分页]
	 * 
	 * @param payLogCriteria
	 *            [支付日志信息－查询封装]
	 * @return
	 * @throws Exception
	 */
	public Integer countPayLogWithPage(final PayLogCriteria payLogCriteria)
			throws Exception;

}
