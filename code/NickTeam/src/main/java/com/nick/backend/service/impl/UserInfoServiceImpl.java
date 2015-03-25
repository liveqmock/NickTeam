package com.nick.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.nick.backend.constant.ServiceErrorConstant;
import com.nick.backend.dao.IUserInfoDao;
import com.nick.backend.po.User;
import com.nick.backend.service.IUserInfoService;
import com.nick.base.exception.ParamErrorException;

/**
 * [用户信息相关业务层接口实现类]
 * 
 * @author nick
 * @version v1.0 2015-3-24
 */
@Service("userInfoService")
public class UserInfoServiceImpl implements IUserInfoService {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Autowired
	private IUserInfoDao userInfoDao;

	/**
	 * [注册用户]
	 * 
	 * @param user
	 *            [需要注册用户信息]
	 * @return
	 * @throws Exception
	 */
	public boolean registUser(User user) throws Exception {
		// 申明变量
		boolean mobileFlag = false;
		boolean emailFlag = false;
		boolean usernameFlag = false;
		boolean result = false;
		// 检查参数合法性
		if (null == user || !user.validate()) {
			throw new ParamErrorException(ServiceErrorConstant.E0000);
		} else {
			// 判断手机是否存在
			mobileFlag = this.checkUserMobileExist(user);
			// 判断邮箱是否存在
			emailFlag = this.checkUserEmailExist(user);
			// 判断用户名是否存在
			usernameFlag = this.checkUserUsernameExist(user);
			// 判断是否需要创建
			if (!mobileFlag && !emailFlag && !usernameFlag) {
				result = this.createUser(user);
			} else {
				if (mobileFlag) {
					throw new ParamErrorException(ServiceErrorConstant.E0001);
				}
				if (emailFlag) {
					throw new ParamErrorException(ServiceErrorConstant.E0002);
				}
				if (usernameFlag) {
					throw new ParamErrorException(ServiceErrorConstant.E0003);
				}
			}
		}
		return result;
	}

	/**
	 * [创建用户信息]
	 * 
	 * @param user
	 *            [需要创建的用户信息]
	 * @return
	 * @throws Exception
	 */
	public boolean createUser(User user) throws Exception {
		// 申明变量
		boolean result = false;
		// 判断信息是否正确
		if (null == user || !user.validate()) {
			throw new ParamErrorException(ServiceErrorConstant.E0000);
		} else {
			this.hibernateTemplate.save(user);
			result = true;
		}
		return result;
	}

	/**
	 * [检查用户手机号码是否已存在]
	 * 
	 * @param user
	 *            [需要检查的用户信息]
	 * @return
	 * @throws Exception
	 */
	public boolean checkUserMobileExist(User user) throws Exception {
		// 申明变量
		Long num = null;
		num = this.userInfoDao.countUserByMobile(user.getMobile(),
				user.getType(), user.getDomain());
		return 0 == num ? false : true;
	}

	/**
	 * [检查用户邮箱是否已存在]
	 * 
	 * @param user
	 *            [需要检查的用户信息]
	 * @return
	 * @throws Exception
	 */
	public boolean checkUserEmailExist(User user) throws Exception {
		// 申明变量
		Long num = null;
		num = this.userInfoDao.countUserByEmail(user.getEmail(),
				user.getType(), user.getDomain());
		return 0 == num ? false : true;
	}

	/**
	 * [检查用户用户名是否已存在]
	 * 
	 * @param user
	 *            [需要检查的用户信息]
	 * @return
	 * @throws Exception
	 */
	public boolean checkUserUsernameExist(User user) throws Exception {
		// 申明变量
		Long num = null;
		num = this.userInfoDao.countUserByUsername(user.getUsername(),
				user.getType(), user.getDomain());
		return 0 == num ? false : true;
	}

	/**
	 * [用户登录]
	 * 
	 * @param user
	 *            [需要登录的用户]
	 * @return
	 * @throws Exception
	 */
	public User login(User user) throws Exception {
		// 申明变量
		return null;
	}

	/**
	 * [根据登录用信息获取用户信息]
	 * 
	 * @param user
	 *            [需要登录的用户]
	 * @return
	 * @throws Exception
	 */
	public User getUserByLoginInfo(User user) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
