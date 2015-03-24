package com.wuya.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.wuya.backend.constant.ServiceErrorCodeConstant;
import com.wuya.backend.criteria.user.PassportCriteria;
import com.wuya.backend.criteria.user.UserCertificateCriteria;
import com.wuya.backend.dao.IUserDao;
import com.wuya.backend.po.finance.FinanceAccount;
import com.wuya.backend.po.user.Passport;
import com.wuya.backend.po.user.UserCertificate;
import com.wuya.backend.po.user.UserContact;
import com.wuya.backend.po.user.UserEducation;
import com.wuya.backend.service.IFinanceInfoService;
import com.wuya.backend.service.IUserInfoService;
import com.wuya.base.enumerate.user.SexEnum;
import com.wuya.base.exception.ParamErrorException;
import com.wuya.base.exception.ProcessErrorException;
import com.wuya.base.result.EasyUiPagerResult;
import com.wuya.base.util.NumberUtil;
import com.wuya.base.util.StringUtil;

/**
 * [通行证－业务层实现类]
 * 
 * @author nick
 * @version v1.0 2015-1-24
 */
@Service("userInfoService")
public class UserInfoServiceImpl implements IUserInfoService {

	@Autowired
	private IFinanceInfoService financeInfoService;

	@Autowired
	private IUserDao userDao;

	@Autowired
	private HibernateTemplate hibernateTemplate;

	/**
	 * [创建用户通行证信息，创建前，需要检查用户名、手机号、邮箱地址是否重复，如果有一项重复，则抛出异常]
	 * 
	 * @param passportModel
	 *            [需要创建的通行证信息]
	 * @throws Exception
	 */
	public boolean createPassport(Passport passportModel) throws Exception {
		// 申明变量
		boolean nameFlag = false;
		boolean mobileFlag = false;
		boolean emailFlg = false;
		boolean flag = false;
		FinanceAccount financeAccount = null;
		Integer passportId = null;
		// 验证对象是否符合要求
		if (passportModel.validate()) {
			if (StringUtil.isNotEmpty(passportModel.getUsername())) {
				nameFlag = this.isExistByUsername(passportModel.getUsername(),
						passportModel.getDomain());
			}
			if (StringUtil.isNotEmpty(passportModel.getMobile())) {
				mobileFlag = this.isExistByMobile(passportModel.getMobile(),
						passportModel.getDomain());
			}
			if (StringUtil.isNotEmpty(passportModel.getEmail())) {
				emailFlg = this.isExistByEmail(passportModel.getEmail(),
						passportModel.getDomain());
			}
			// 如果都不存在，才可添加
			if (!nameFlag && !mobileFlag && !emailFlg) {
				if (StringUtil.isEmpty(passportModel.getSex())) {
					passportModel.setSex(SexEnum.MALE.getCode());
				}
				// 获取创建的主键
				passportId = (Integer) this.hibernateTemplate
						.save(passportModel);
				// 同步生成财富账户信息
				financeAccount = new FinanceAccount();
				financeAccount.setPassportId(passportId);
				this.financeInfoService.createFinanceAcount(financeAccount);
				flag = true;
			} else {// 返回错误信息
				if (nameFlag) {
					throw new ProcessErrorException(
							ServiceErrorCodeConstant.E0002);
				}
				if (mobileFlag) {
					throw new ProcessErrorException(
							ServiceErrorCodeConstant.E0003);
				}
				if (emailFlg) {
					throw new ProcessErrorException(
							ServiceErrorCodeConstant.E0004);
				}
			}
		} else {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0001);
		}
		return flag;
	}

	/**
	 * [注册通行证]
	 * 
	 * @param passportModel
	 *            [需要注册的通行证信息]
	 * @return
	 * @throws Exception
	 */
	public Passport registPassport(Passport passportModel) throws Exception {
		// 申明变量
		boolean nameFlag = false;
		boolean mobileFlag = false;
		boolean emailFlg = false;
		Passport passport = null;
		FinanceAccount financeAccount = null;
		Integer passportId = null;
		// 验证对象是否符合要求
		if (passportModel.validate()) {
			if (StringUtil.isNotEmpty(passportModel.getUsername())) {
				nameFlag = this.isExistByUsername(passportModel.getUsername(),
						passportModel.getDomain());
			}
			if (StringUtil.isNotEmpty(passportModel.getMobile())) {
				mobileFlag = this.isExistByMobile(passportModel.getMobile(),
						passportModel.getDomain());
			}
			if (StringUtil.isNotEmpty(passportModel.getEmail())) {
				emailFlg = this.isExistByEmail(passportModel.getEmail(),
						passportModel.getDomain());
			}
			// 如果都不存在，才可添加
			if (!nameFlag && !mobileFlag && !emailFlg) {
				if (StringUtil.isEmpty(passportModel.getSex())) {
					passportModel.setSex(SexEnum.MALE.getCode());
				}
				// 获取创建的主键
				passportId = (Integer) this.hibernateTemplate
						.save(passportModel);
				passport = this.hibernateTemplate.get(Passport.class,
						passportId);
				// 同步生成财富账户信息
				financeAccount = new FinanceAccount();
				financeAccount.setPassportId(passportId);
				this.financeInfoService.createFinanceAcount(financeAccount);
			} else {// 返回错误信息
				if (nameFlag) {
					throw new ProcessErrorException(
							ServiceErrorCodeConstant.E0002);
				}
				if (mobileFlag) {
					throw new ProcessErrorException(
							ServiceErrorCodeConstant.E0003);
				}
				if (emailFlg) {
					throw new ProcessErrorException(
							ServiceErrorCodeConstant.E0004);
				}
			}
		} else {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0001);
		}
		return passport;
	}

	/**
	 * [根据用户名，检查该用户名在某系统领域下是否已经存在]
	 * 
	 * @param username
	 *            [用户名]
	 * @param domain
	 *            [系统领域]
	 * @return
	 * @throws Exception
	 */
	public boolean isExistByUsername(String username, String domain)
			throws Exception {
		int num = 0;
		num = this.userDao.countByUsername(username, domain);
		return 0 == num ? false : true;
	}

	/**
	 * [根据手机号码，检查该手机号码在某系统领域下是否已经存在]
	 * 
	 * @param mobile
	 *            [手机号码]
	 * @param domain
	 *            [系统领域]
	 * @return
	 * @throws Exception
	 */
	public boolean isExistByMobile(String mobile, String domain)
			throws Exception {
		int num = 0;
		num = this.userDao.countByMobile(mobile, domain);
		return 0 == num ? false : true;
	}

	/**
	 * [根据邮箱地址，检查该邮箱地址在某系统领域下是否已经存在]
	 * 
	 * @param email
	 *            [邮箱地址]
	 * @param domain
	 *            [系统领域]
	 * @return
	 * @throws Exception
	 */
	public boolean isExistByEmail(String email, String domain) throws Exception {
		int num = 0;
		num = this.userDao.countByEmail(email, domain);
		return 0 == num ? false : true;
	}

	/**
	 * [用户登录接口]
	 * 
	 * @param token
	 *            [登录口令]
	 * @param password
	 *            [密码]
	 * @param domain
	 *            [系统领域]
	 * @return
	 * @throws Exception
	 */
	public Passport login(String token, String password, String domain)
			throws Exception {
		// 申明变量
		Passport passport = null;
		// 判断参数合法性
		if (StringUtil.isEmpty(token) || StringUtil.isEmpty(password)) {
			throw new ProcessErrorException(ServiceErrorCodeConstant.E0005);
		} else {
			// 判断口令类型
			if (StringUtil.isMobile(token)) {
				passport = this.userDao.getByMobileWithPassword(token,
						password, domain);
			} else if (StringUtil.isEmail(token)) {
				passport = this.userDao.getByEmailWithPassword(token, password,
						domain);
			} else {
				passport = this.userDao.getByUsernameWithPassword(token,
						password, domain);
			}
		}
		return passport;
	}

	/**
	 * [根据通行证标识，获取对应的教育信息列表]
	 * 
	 * @param passportId
	 *            [通行证标识]
	 * @return
	 * @throws Exception
	 */
	public List<UserEducation> getUserEducationByPassportId(Integer passportId)
			throws Exception {
		// 申明变量
		List<UserEducation> list = null;
		// 检查参数合法性
		if (null == passportId || 0 == passportId) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0007);
		} else {
			list = this.userDao.selectUserEducationByPassportId(passportId);
		}
		return list;
	}

	/**
	 * [创建用户教育经历]
	 * 
	 * @param passportId
	 *            [通行证标识]
	 * @param userEducation
	 *            [用户教育信息实例]
	 * @return
	 * @throws Exception
	 */
	public boolean createUserEducation(Integer passportId,
			UserEducation userEducation) throws Exception {
		// 申明变量
		Passport passport = null;
		boolean flag = false;
		// 检查参数合法性
		if (!userEducation.validate() || null == passportId || 0 == passportId) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0006);
		} else {
			// 获取通行证对象
			passport = this.hibernateTemplate.get(Passport.class, passportId);
			userEducation.setPassportId(passport.getId());
			this.hibernateTemplate.save(userEducation);
			flag = true;
		}
		return flag;
	}

	/**
	 * [删除标识对应的教育经历]
	 * 
	 * @param educationId
	 *            [教育经历标识]
	 * @return
	 * @throws Exception
	 */
	public boolean deleteUserEducation(Integer educationId) throws Exception {
		// 申明变量
		UserEducation userEducation = null;
		boolean flag = false;
		// 检查参数合法性
		if (null == educationId || 0 == educationId) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0008);
		} else {
			userEducation = this.hibernateTemplate.load(UserEducation.class,
					educationId);
			if (null == userEducation) {
				flag = false;
			} else {
				this.hibernateTemplate.delete(userEducation);
				flag = true;
			}
		}
		return flag;
	}

	/**
	 * [创建用户联系人信息]
	 * 
	 * @param passportId
	 *            [通行证标识]
	 * @param userEducation
	 *            [用户联系人信息实例]
	 * @return
	 * @throws Exception
	 */
	public boolean createUserContact(Integer passportId, UserContact userContact)
			throws Exception {
		// 申明变量
		Passport passport = null;
		boolean flag = false;
		// 检查参数合法性
		if (!userContact.validate() || null == passportId || 0 == passportId) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0006);
		} else {
			// 获取通行证对象
			passport = this.hibernateTemplate.get(Passport.class, passportId);
			userContact.setPassportId(passport.getId());
			this.hibernateTemplate.save(userContact);
			flag = true;
		}
		return flag;
	}

	/**
	 * [根据通行证标识，获取对应的联系人列表]
	 * 
	 * @param passportId
	 *            [通行证标识]
	 * @return
	 * @throws Exception
	 */
	public List<UserContact> getUserContactByPassportId(Integer passportId)
			throws Exception {
		// 申明变量
		List<UserContact> list = null;
		// 检查参数合法性
		if (null == passportId || 0 == passportId) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0007);
		} else {
			list = this.userDao.selectUserContactByPassportId(passportId);
		}
		return list;
	}

	/**
	 * [删除标识对应的联系人信息]
	 * 
	 * @param contactId
	 *            [用户联系人标识]
	 * @return
	 * @throws Exception
	 */
	public boolean deleteUserContact(Integer contactId) throws Exception {
		// 申明变量
		UserContact userContact = null;
		boolean flag = false;
		// 检查参数合法性
		if (null == contactId || 0 == contactId) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0009);
		} else {
			userContact = this.hibernateTemplate.load(UserContact.class,
					contactId);
			if (null == userContact) {
				flag = false;
			} else {
				this.hibernateTemplate.delete(userContact);
				flag = true;
			}
		}
		return flag;
	}

	/**
	 * [更新通行证相关信息]
	 * 
	 * @param passport
	 *            [通行证实例]
	 * @return
	 * @throws Exception
	 */
	public Passport updatePassportInfo(Passport passport) throws Exception {
		// 申明变量
		Passport passportDb = null;
		// 验证参数合法性
		if (null == passport || null == passport.getId()
				|| 0 == passport.getId()
				|| StringUtil.isEmpty(passport.getDomain())) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0001);
		} else {
			passportDb = this.hibernateTemplate.load(Passport.class,
					passport.getId());
			// 开始判断-并执行相关更新
			if (StringUtil.isNotEmpty(passport.getUsername())) {
				if (!passport.getUsername().equals(passportDb.getUsername())) {
					if (!this.isExistByUsername(passport.getUsername(),
							passport.getDomain())) {
						passportDb.setUsername(passport.getUsername());
					} else {
						throw new ParamErrorException(
								ServiceErrorCodeConstant.E0002);
					}
				}
			}
			if (StringUtil.isNotEmpty(passport.getMobile())) {
				if (!passport.getMobile().equals(passportDb.getMobile())) {
					if (!this.isExistByMobile(passport.getMobile(),
							passport.getDomain())) {
						passportDb.setMobile(passport.getMobile());
					} else {
						throw new ProcessErrorException(
								ServiceErrorCodeConstant.E0003);
					}
				}
			}
			if (StringUtil.isNotEmpty(passport.getEmail())) {
				if (!passport.getEmail().equals(passportDb.getEmail())) {
					if (!this.isExistByEmail(passport.getEmail(),
							passport.getDomain())) {
						passportDb.setEmail(passport.getEmail());
					} else {
						throw new ProcessErrorException(
								ServiceErrorCodeConstant.E0004);
					}
				}
			}
			if (StringUtil.isNotEmpty(passport.getPassword())) {
				if (!passport.getPassword().equals(passportDb.getPassword())) {
					passportDb.setPassword(passport.getPassword());
				}
			}
			if (StringUtil.isNotEmpty(passport.getTrueName())) {
				if (!passport.getTrueName().equals(passportDb.getTrueName())) {
					passportDb.setTrueName(passport.getTrueName());
				}
			}
			if (StringUtil.isNotEmpty(passport.getSex())) {
				if (!passport.getSex().equals(passportDb.getSex())) {
					passportDb.setSex(passport.getSex());
				}
			}
			if (StringUtil.isNotEmpty(passport.getQqAcount())) {
				if (!passport.getQqAcount().equals(passportDb.getQqAcount())) {
					passportDb.setQqAcount(passport.getQqAcount());
				}
			}
			if (StringUtil.isNotEmpty(passport.getPinyin())) {
				if (!passport.getPinyin().equals(passportDb.getPinyin())) {
					passportDb.setPinyin(passport.getPinyin());
				}
			}
			if (null != passport.getBirthday()) {
				if (!passport.getBirthday().equals(passportDb.getBirthday())) {
					passportDb.setBirthday(passport.getBirthday());
				}
			}
			if (StringUtil.isNotEmpty(passport.getWeixinAccount())) {
				if (!passport.getWeixinAccount().equals(
						passportDb.getWeixinAccount())) {
					passportDb.setWeixinAccount(passport.getWeixinAccount());
				}
			}
			if (StringUtil.isNotEmpty(passport.getHighSchoolName())) {
				if (!passport.getHighSchoolName().equals(
						passportDb.getHighSchoolName())) {
					passportDb.setHighSchoolName(passport.getHighSchoolName());
				}
			}
			if (StringUtil.isNotEmpty(passport.getJuniorSchoolName())) {
				if (!passport.getJuniorSchoolName().equals(
						passportDb.getJuniorSchoolName())) {
					passportDb.setJuniorSchoolName(passport
							.getJuniorSchoolName());
				}
			}
			if (NumberUtil.isNotEmptyOrZero(passport.getGrade())) {
				if (!passport.getGrade().equals(passportDb.getGrade())) {
					passportDb.setGrade(passport.getGrade());
				}
			}
			if (null != passport.getGraduateTime()) {
				if (!passport.getGraduateTime().equals(
						passportDb.getGraduateTime())) {
					passportDb.setGraduateTime(passport.getGraduateTime());
				}
			}
			if (StringUtil.isNotEmpty(passport.getProvince())) {
				if (!passport.getProvince().equals(passportDb.getProvince())) {
					passportDb.setProvince(passport.getProvince());
				}
			}
			if (StringUtil.isNotEmpty(passport.getCity())) {
				if (!passport.getCity().equals(passportDb.getCity())) {
					passportDb.setCity(passport.getCity());
				}
			}
			if (StringUtil.isNotEmpty(passport.getCounty())) {
				if (!passport.getCounty().equals(passportDb.getCounty())) {
					passportDb.setCounty(passport.getCounty());
				}
			}
			if (StringUtil.isNotEmpty(passport.getAddress())) {
				if (!passport.getAddress().equals(passportDb.getAddress())) {
					passportDb.setAddress(passport.getAddress());
				}
			}
			if (StringUtil.isNotEmpty(passport.getFatherName())) {
				if (!passport.getFatherName()
						.equals(passportDb.getFatherName())) {
					passportDb.setFatherName(passport.getFatherName());
				}
			}
			if (StringUtil.isNotEmpty(passport.getFatherEmail())) {
				if (!passport.getFatherEmail().equals(
						passportDb.getFatherEmail())) {
					passportDb.setFatherEmail(passport.getFatherEmail());
				}
			}
			if (StringUtil.isNotEmpty(passport.getFatherMobile())) {
				if (!passport.getFatherMobile().equals(
						passportDb.getFatherMobile())) {
					passportDb.setFatherMobile(passport.getFatherMobile());
				}
			}
			if (StringUtil.isNotEmpty(passport.getMotherName())) {
				if (!passport.getMotherName()
						.equals(passportDb.getMotherName())) {
					passportDb.setMotherName(passport.getMotherName());
				}
			}
			if (StringUtil.isNotEmpty(passport.getMotherEmail())) {
				if (!passport.getMotherEmail().equals(
						passportDb.getMotherEmail())) {
					passportDb.setMotherEmail(passport.getMotherEmail());
				}
			}
			if (StringUtil.isNotEmpty(passport.getMotherMobile())) {
				if (!passport.getMotherMobile().equals(
						passportDb.getMotherMobile())) {
					passportDb.setMotherMobile(passport.getMotherMobile());
				}
			}
		}
		return passportDb;
	}

	/**
	 * [创建用户证件信息]
	 * 
	 * @param passportId
	 *            [通行证标识]
	 * @param userCertificate
	 *            [用户证件信息]
	 * @return
	 * @throws Exception
	 */
	public boolean createUserCertificate(Integer passportId,
			UserCertificate userCertificate) throws Exception {
		// 申明变量
		boolean flag = false;
		Passport passport = null;
		// 验证参数
		if (!userCertificate.validate() || null == passportId
				|| 0 == passportId) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0010);
		} else {
			passport = this.hibernateTemplate.load(Passport.class, passportId);
			userCertificate.setPassportId(passport.getId());
			this.hibernateTemplate.save(userCertificate);
			flag = true;
		}
		return flag;
	}

	/**
	 * [根据通行证标识，获取对应的证件列表]
	 * 
	 * @param passportId
	 *            [通行证标识]
	 * @return
	 * @throws Exception
	 */
	public List<UserCertificate> getUserCertificateByPassportId(
			Integer passportId) throws Exception {
		// 申明变量
		List<UserCertificate> list = null;
		// 检查参数合法性
		if (null == passportId || 0 == passportId) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0007);
		} else {
			list = this.userDao.selectUserCertificateByPassportId(passportId);
		}
		return list;
	}

	/**
	 * [删除标识对应的证件信息]
	 * 
	 * @param certificateId
	 *            [用户证件标识]
	 * @return
	 * @throws Exception
	 */
	public boolean deleteUserCertificate(Integer certificateId)
			throws Exception {
		// 申明变量
		UserCertificate userCertificate = null;
		boolean flag = false;
		// 检查参数合法性
		if (null == certificateId || 0 == certificateId) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0009);
		} else {
			userCertificate = this.hibernateTemplate.load(
					UserCertificate.class, certificateId);
			if (null == userCertificate) {
				flag = false;
			} else {
				this.hibernateTemplate.delete(userCertificate);
				flag = true;
			}
		}
		return flag;
	}

	/**
	 * [获取通行证列表－支持分页]
	 * 
	 * @param passportCriteria
	 *            [通行证条件封装]
	 * @return
	 * @throws Exception
	 */
	public EasyUiPagerResult getPassportListWithPage(
			PassportCriteria passportCriteria) throws Exception {
		// 申明变量
		List<Passport> list = null;
		EasyUiPagerResult result = null;
		Integer num = 0;
		// 判断参数合法性
		if (null == passportCriteria) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0011);
		} else {
			result = new EasyUiPagerResult();
			list = this.userDao.selectPassportWithPage(passportCriteria);
			num = this.userDao.countPassportWithPage(passportCriteria);
			result.setRows(list);
			result.setTotal(num);
		}
		return result;
	}

	/**
	 * [获取用户证件-支持分页]
	 * 
	 * @param userCertificateCriteria
	 *            [用户证件条件封装实例]
	 * @return
	 * @throws Exception
	 */
	public EasyUiPagerResult getCertificateListWithPage(
			UserCertificateCriteria userCertificateCriteria) throws Exception {
		// 申明变量
		List<UserCertificate> list = null;
		EasyUiPagerResult result = null;
		Integer num = 0;
		// 判断参数合法性
		if (null == userCertificateCriteria) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0069);
		} else {
			result = new EasyUiPagerResult();
			list = this.userDao
					.selectUserCertificateWithPage(userCertificateCriteria);
			num = this.userDao
					.countUserCertificateWithPage(userCertificateCriteria);
			result.setRows(list);
			result.setTotal(num);
		}
		return result;
	}

	/**
	 * [重置通行证密码]
	 * 
	 * @param passportId
	 *            [通行证标识]
	 * @param password1
	 *            [第一次输入密码]
	 * @param password2
	 *            [第二次输入密码]
	 * @return
	 * @throws Exception
	 */
	public boolean resetPasswordPassword(Integer passportId, String password1,
			String password2) throws Exception {
		// 申明变量
		boolean result = false;
		Passport passport = null;
		// 判断参数合法性
		if (NumberUtil.isEmptyOrZero(passportId)
				|| StringUtil.isEmpty(password1)
				|| StringUtil.isEmpty(password2)) {
			throw new ParamErrorException(ServiceErrorCodeConstant.E0000);
		} else {
			// 判断两个密码是否相同
			if (password1.equals(password2)) {
				passport = this.hibernateTemplate.load(Passport.class,
						passportId);
				// 设置密码
				passport.setPassword(password1);
				result = true;
			} else {
				throw new ProcessErrorException(ServiceErrorCodeConstant.E0091);
			}
		}
		return result;
	}
}
