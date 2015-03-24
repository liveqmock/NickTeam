package com.wuya.backend.dao;

import java.util.List;

import com.wuya.backend.criteria.permission.PassportPermissionRefCriteria;
import com.wuya.backend.po.permission.PassportPermissionRef;

/**
 * [权限相关-数据访问层接口]
 * 
 * @author nick
 * @version v1.0 2015-3-14
 */
public interface IPermissionDao {

	/**
	 * [删除用户-权限关联关系]
	 * 
	 * @param passportId
	 *            [用户标识]
	 * @param domain
	 *            [所属领域]
	 * @return
	 * @throws Exception
	 */
	public Integer deletePassportPermissionRef(Integer passportId, String domain)
			throws Exception;

	/**
	 * [获取用户-权限关联列表]
	 * 
	 * @param passportPermissionRefCriteria
	 *            [条件封装]
	 * @return
	 * @throws Exception
	 */
	public List<PassportPermissionRef> selectPassportPermissionRefWithPage(
			PassportPermissionRefCriteria passportPermissionRefCriteria)
			throws Exception;

	/**
	 * [获取用户-权限关联列表-计算]
	 * 
	 * @param passportPermissionRefCriteria
	 *            [条件封装]
	 * @return
	 * @throws Exception
	 */
	public Integer countPassportPermissionRefWithPage(
			PassportPermissionRefCriteria passportPermissionRefCriteria)
			throws Exception;

}
