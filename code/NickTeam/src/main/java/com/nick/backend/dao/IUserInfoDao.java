package com.nick.backend.dao;

/**
 * [用户信息相关数据访问层接口]
 * 
 * @author nick
 * @version v1.0 2015-3-24
 */
public interface IUserInfoDao {

	/**
	 * [根据手机-计算用户数量]
	 * 
	 * @param mobile
	 *            [手机号码]
	 * @param type
	 *            [用户类型]
	 * @param domain
	 *            [用户领域]
	 * @return
	 * @throws Exception
	 */
	public Long countUserByMobile(String mobile, String type, String domain)
			throws Exception;

	/**
	 * [根据邮箱地址-计算用户数量]
	 * 
	 * @param email
	 *            [邮箱地址]
	 * @param type
	 *            [用户类型]
	 * @param domain
	 *            [用户领域]
	 * @return
	 * @throws Exception
	 */
	public Long countUserByEmail(String email, String type, String domain)
			throws Exception;

	/**
	 * [根据用户名-计算用户数量]
	 * 
	 * @param username
	 *            [用户名]
	 * @param type
	 *            [用户类型]
	 * @param domain
	 *            [用户领域]
	 * @return
	 * @throws Exception
	 */
	public Long countUserByUsername(String username, String type, String domain)
			throws Exception;

}
