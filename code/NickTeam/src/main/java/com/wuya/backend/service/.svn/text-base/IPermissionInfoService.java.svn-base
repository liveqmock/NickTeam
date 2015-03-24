package com.wuya.backend.service;

import com.wuya.backend.criteria.permission.PassportPermissionRefCriteria;
import com.wuya.base.result.EasyUiPagerResult;

/**
 * [权限相关信息-业务层接口]
 * 
 * @author nick
 * @version v1.0 2015-3-14
 */
public interface IPermissionInfoService {

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
			String domain, String[] pcodes) throws Exception;

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
			throws Exception;

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
			throws Exception;

}
