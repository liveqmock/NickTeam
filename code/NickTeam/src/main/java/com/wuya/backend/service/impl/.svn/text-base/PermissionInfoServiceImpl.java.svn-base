package com.wuya.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.wuya.backend.constant.ServiceErrorCodeConstant;
import com.wuya.backend.criteria.permission.PassportPermissionRefCriteria;
import com.wuya.backend.dao.IPermissionDao;
import com.wuya.backend.po.permission.PassportPermissionRef;
import com.wuya.backend.service.IPermissionInfoService;
import com.wuya.base.enumerate.DataStatusEnum;
import com.wuya.base.exception.ParamErrorException;
import com.wuya.base.result.EasyUiPagerResult;
import com.wuya.base.util.NumberUtil;
import com.wuya.base.util.StringUtil;

/**
 * [权限相关信息-业务层接口实现类]
 * 
 * @author nick
 * @version v1.0 2015-3-14s
 */
@Service("permissionInfoService")
public class PermissionInfoServiceImpl implements IPermissionInfoService {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Autowired
	private IPermissionDao permissionDao;

	/**
	 * [创建一个新的用户-权限关联信息]
	 * 
	 * @param passportId
	 *            [用户标识]
	 * @param domain
	 *            [领域]
	 * @param pcodes
	 *            [权限列表]
	 * @return
	 * @throws Exception
	 */
	public boolean createPassportPermissionRef(Integer passportId,
			String domain, String[] pcodes) throws Exception {
		// 申明变量
		boolean result = false;
		PassportPermissionRef passportPermissionRef = null;
		// 判断参数合法性
		if (NumberUtil.isEmptyOrZero(passportId) || StringUtil.isEmpty(domain)
				|| null == pcodes) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0000);
		} else {
			// 清楚该用户下所有的权限信息
			this.clearPassportPermissionRef(passportId, domain);
			// 进行新增关联
			for (String pcode : pcodes) {
				passportPermissionRef = new PassportPermissionRef();
				passportPermissionRef.setDstatus(DataStatusEnum.NORMAL
						.getCode());
				passportPermissionRef.setDomain(domain);
				passportPermissionRef.setPassportId(passportId);
				passportPermissionRef.setPcode(pcode);
				this.hibernateTemplate.save(passportPermissionRef);
			}
			result = true;
		}
		return result;
	}

	/**
	 * [清除用户-权限关联信息]
	 * 
	 * @param passportId
	 *            [用户标识]
	 * @param domain
	 *            [所在领域]
	 * @return
	 * @throws Exception
	 */
	public boolean clearPassportPermissionRef(Integer passportId, String domain)
			throws Exception {
		// 申明变量
		Integer num = 0;
		// 判断参数
		if (NumberUtil.isEmptyOrZero(passportId) || StringUtil.isEmpty(domain)) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0000);
		} else {
			num = this.permissionDao.deletePassportPermissionRef(passportId,
					domain);
		}
		return 0 <= num ? true : false;
	}

	/**
	 * [获取用户-权限关联信息列表]
	 * 
	 * @param passportPermissionRefCriteria
	 *            [用户-权限关联条件封装]
	 * @return
	 * @throws Exception
	 */
	public EasyUiPagerResult getPassportPermissionRefListWithPage(
			PassportPermissionRefCriteria passportPermissionRefCriteria)
			throws Exception {
		// 申明变量
		EasyUiPagerResult result = null;
		List<PassportPermissionRef> list = null;
		Integer total = 0;
		// 判断参数合法性
		if (null == passportPermissionRefCriteria) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0000);
		} else {
			result = new EasyUiPagerResult();
			list = this.permissionDao
					.selectPassportPermissionRefWithPage(passportPermissionRefCriteria);
			total = this.permissionDao
					.countPassportPermissionRefWithPage(passportPermissionRefCriteria);
			result.setTotal(total);
			result.setRows(list);
		}
		return result;
	}

}
