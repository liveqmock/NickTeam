package com.nick.backend.service;

import com.nick.backend.po.User;

/**
 * [用户信息相关业务层接口]
 * 
 * @author nick
 * @version v1.0 2015-3-24
 */
public interface IUserInfoService {

	/**
	 * [注册用户]
	 * 
	 * @param user
	 *            [需要注册用户信息]
	 * @return
	 * @throws Exception
	 */
	public boolean registUser(User user) throws Exception;

	/**
	 * [创建用户信息]
	 * 
	 * @param user
	 *            [需要创建的用户信息]
	 * @return
	 * @throws Exception
	 */
	public boolean createUser(User user) throws Exception;

	/**
	 * [检查用户手机号码是否已存在]
	 * 
	 * @param user
	 *            [需要检查的用户信息]
	 * @return
	 * @throws Exception
	 */
	public boolean checkUserMobileExist(User user) throws Exception;

	/**
	 * [检查用户邮箱是否已存在]
	 * 
	 * @param user
	 *            [需要检查的用户信息]
	 * @return
	 * @throws Exception
	 */
	public boolean checkUserEmailExist(User user) throws Exception;

	/**
	 * [检查用户用户名是否已存在]
	 * 
	 * @param user
	 *            [需要检查的用户信息]
	 * @return
	 * @throws Exception
	 */
	public boolean checkUserUsernameExist(User user) throws Exception;

	/**
	 * [用户登录]
	 * 
	 * @param user
	 *            [需要登录的用户]
	 * @return
	 * @throws Exception
	 */
	public User login(User user) throws Exception;

	/**
	 * [根据登录用信息获取用户信息]
	 * 
	 * @param user
	 *            [需要登录的用户]
	 * @return
	 * @throws Exception
	 */
	public User getUserByLoginInfo(User user) throws Exception;

}
