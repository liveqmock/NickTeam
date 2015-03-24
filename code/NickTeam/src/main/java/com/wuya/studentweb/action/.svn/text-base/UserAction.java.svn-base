package com.wuya.studentweb.action;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.wuya.backend.po.user.Passport;
import com.wuya.backend.po.user.UserCertificate;
import com.wuya.backend.po.user.UserContact;
import com.wuya.backend.po.user.UserEducation;
import com.wuya.backend.service.IUserInfoService;
import com.wuya.base.enumerate.DataStatusEnum;
import com.wuya.base.enumerate.InvokeStateEnum;
import com.wuya.base.enumerate.SystemDomainEnum;
import com.wuya.base.enumerate.user.PassportTypeEnum;
import com.wuya.base.exception.WuYaException;
import com.wuya.base.mvc.BaseAction;
import com.wuya.base.result.InvokeResult;
import com.wuya.base.util.MD5;
import com.wuya.base.util.StringUtil;
import com.wuya.studentweb.constant.FrontErrorCode;
import com.wuya.studentweb.constant.SessionKeyConstant;

/**
 * [用户相关－前端控制器]
 * 
 * @author nick
 * @version v1.0 2015-1-26
 */
public class UserAction extends BaseAction {

	/**
	 * [通行证]
	 */
	private Passport passport;

	/**
	 * [用户教育经历]
	 */
	private UserEducation userEducation;

	/**
	 * [用户联系人信息]
	 */
	private UserContact userContact;

	/**
	 * [用户证件信息]
	 */
	private UserCertificate userCertificate;

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	public UserEducation getUserEducation() {
		return userEducation;
	}

	public void setUserEducation(UserEducation userEducation) {
		this.userEducation = userEducation;
	}

	public UserContact getUserContact() {
		return userContact;
	}

	public void setUserContact(UserContact userContact) {
		this.userContact = userContact;
	}

	public UserCertificate getUserCertificate() {
		return userCertificate;
	}

	public void setUserCertificate(UserCertificate userCertificate) {
		this.userCertificate = userCertificate;
	}

	@Autowired
	private IUserInfoService userInfoService;

	/**
	 * [登录]
	 * 
	 * @throws Exception
	 */
	public void login() throws Exception {
		System.out.println(this.getParameterMapFromRequest());
		// 申明变量
		String token = null;
		String password = null;
		Map<String, Object> requestMap = null;
		Map<String, Object> sessionMap = null;
		InvokeResult result = null;
		Passport passport = null;
		// 获取请求参数
		requestMap = this.getParameterMapFromRequest();
		token = (String) requestMap.get("token");
		password = (String) requestMap.get("password");
		// 检查参数合法性
		if (StringUtil.isEmpty(token) || StringUtil.isEmpty(password)) {
			result = new InvokeResult(InvokeStateEnum.ERROR.getCode(),
					FrontErrorCode.E0001);
		} else {
			passport = this.userInfoService.login(token,
					MD5.getMD5Str(password),
					SystemDomainEnum.PLATFORM.getCode());
			if (null != passport) {
				// 将用户信息存入session
				sessionMap = this.getSessionMap();
				sessionMap.put(SessionKeyConstant.PASSPORT_INFO, passport);
				result = new InvokeResult(InvokeStateEnum.SUCCESS.getCode(),
						null);
			} else {
				result = new InvokeResult(InvokeStateEnum.ERROR.getCode(),
						FrontErrorCode.E0002);
			}
		}
		this.outputJsonMessage(result);
	}

	/**
	 * [注册]
	 * 
	 * @throws Exception
	 */
	public void regist() throws Exception {
		System.out.println(this.getParameterMapFromRequest());
		// 申明变量
		InvokeResult result = null;
		Passport newUser = null;
		Map<String, Object> sessionMap = null;
		// 检查参数合法性
		if (null == this.passport
				|| StringUtil.isEmpty(this.passport.getPassword())
				|| (StringUtil.isEmpty(this.passport.getMobile()) && StringUtil
						.isEmpty(this.passport.getEmail()))) {
			result = new InvokeResult(InvokeStateEnum.ERROR.getCode(),
					FrontErrorCode.E0003);
		} else {
			this.passport.setDomain(SystemDomainEnum.PLATFORM.getCode());
			this.passport.setDstatus(DataStatusEnum.NORMAL.getCode());
			this.passport.setType(PassportTypeEnum.STUDENT.getCode());
			this.passport
					.setPassword(MD5.getMD5Str(this.passport.getPassword()));
			try {
				newUser = this.userInfoService.registPassport(this.passport);
			} catch (Exception e) {
				if (e instanceof WuYaException) {
					result = new InvokeResult(InvokeStateEnum.ERROR.getCode(),
							((WuYaException) e).getMsg());
				}
			}
		}
		if (null != newUser) {
			// 将用户信息存入session
			sessionMap = this.getSessionMap();
			sessionMap.put(SessionKeyConstant.PASSPORT_INFO, passport);
			result = new InvokeResult(InvokeStateEnum.SUCCESS.getCode(), null);
		} else {
			if (null == result) {
				result = new InvokeResult(InvokeStateEnum.ERROR.getCode(),
						FrontErrorCode.E0004);
			}
		}
		this.outputJsonMessage(result);
	}

	/**
	 * [创建用户教育信息]
	 * 
	 * @throws Exception
	 */
	public void createUserEducation() throws Exception {
		// 申明变量
		Map<String, Object> sessionMap = null;
		Passport passport = null;
		InvokeResult result = null;
		boolean flag = false;
		// 获取请求参数
		sessionMap = this.getSessionMap();
		passport = (Passport) sessionMap.get(SessionKeyConstant.PASSPORT_INFO);
		// 判断参数合法性
		if (null == this.userEducation || null == passport) {
			result = new InvokeResult(InvokeStateEnum.ERROR.getCode(), null);
		} else {
			try {
				flag = this.userInfoService.createUserEducation(
						passport.getId(), this.userEducation);
			} catch (Exception e) {
				if (e instanceof WuYaException) {
					result = new InvokeResult(InvokeStateEnum.ERROR.getCode(),
							((WuYaException) e).getMsg());
				}
			}
		}
		if (flag) {
			result = new InvokeResult(InvokeStateEnum.SUCCESS.getCode(), null);
		} else {
			if (null == result) {
				result = new InvokeResult(InvokeStateEnum.ERROR.getCode(),
						FrontErrorCode.E0005);
			}
		}
		this.outputJsonMessage(result);
	}

	/**
	 * [创建用户联系人信息]
	 * 
	 * @throws Exception
	 */
	public void createUserContact() throws Exception {
		// 申明变量
		Map<String, Object> sessionMap = null;
		Passport passport = null;
		InvokeResult result = null;
		boolean flag = false;
		// 获取请求参数
		sessionMap = this.getSessionMap();
		passport = (Passport) sessionMap.get(SessionKeyConstant.PASSPORT_INFO);
		// 判断参数合法性
		if (null == this.userContact || null == passport) {
			result = new InvokeResult(InvokeStateEnum.ERROR.getCode(), null);
		} else {
			try {
				flag = this.userInfoService.createUserContact(passport.getId(),
						this.userContact);
			} catch (Exception e) {
				if (e instanceof WuYaException) {
					result = new InvokeResult(InvokeStateEnum.ERROR.getCode(),
							((WuYaException) e).getMsg());
				}
			}
		}
		if (flag) {
			result = new InvokeResult(InvokeStateEnum.SUCCESS.getCode(), null);
		} else {
			if (null == result) {
				result = new InvokeResult(InvokeStateEnum.ERROR.getCode(),
						FrontErrorCode.E0005);
			}
		}
		this.outputJsonMessage(result);
	}

	/**
	 * [获取用户教育经历]
	 * 
	 * @throws Exception
	 */
	public void getUserEducationList() throws Exception {
		// 申明变量
		Map<String, Object> sessionMap = null;
		Passport passport = null;
		InvokeResult result = null;
		List<UserEducation> educations = null;
		// 获取请求参数
		sessionMap = this.getSessionMap();
		passport = (Passport) sessionMap.get(SessionKeyConstant.PASSPORT_INFO);
		// 判断参数合法性
		if (null == passport) {
			result = new InvokeResult(InvokeStateEnum.ERROR.getCode(), null);
		} else {
			try {
				educations = this.userInfoService
						.getUserEducationByPassportId(passport.getId());
			} catch (Exception e) {
				if (e instanceof WuYaException) {
					result = new InvokeResult(InvokeStateEnum.ERROR.getCode(),
							((WuYaException) e).getMsg());
				}
			}
		}
		if (null != educations) {
			result = new InvokeResult(InvokeStateEnum.SUCCESS.getCode(),
					educations);
		} else {
			if (null == result) {
				result = new InvokeResult(InvokeStateEnum.ERROR.getCode(), null);
			}
		}
		this.outputJsonMessage(result.getResult());
	}

	/**
	 * [删除对应的用户教育经历]
	 * 
	 * @throws Exception
	 */
	public void deleteUserEducation() throws Exception {
		// 申明变量
		InvokeResult result = null;
		Integer educationId = null;
		Map<String, Object> requestMap = null;
		boolean flag = false;
		// 获取请求参数
		requestMap = this.getParameterMapFromRequest();
		educationId = Integer.parseInt((String) requestMap.get("educationId"));
		// 检查参数合法性
		if (0 == educationId) {
			result = new InvokeResult(InvokeStateEnum.ERROR.getCode(),
					FrontErrorCode.E0009);
		} else {
			try {
				flag = this.userInfoService.deleteUserEducation(educationId);
			} catch (Exception e) {
				if (e instanceof WuYaException) {
					result = new InvokeResult(InvokeStateEnum.ERROR.getCode(),
							((WuYaException) e).getMsg());
				}
			}
		}
		if (flag) {
			result = new InvokeResult(InvokeStateEnum.SUCCESS.getCode(), null);
		} else {
			if (null == result) {
				result = new InvokeResult(InvokeStateEnum.ERROR.getCode(), null);
			}
		}
		this.outputJsonMessage(result);
	}

	/**
	 * [获取用户联系人]
	 * 
	 * @throws Exception
	 */
	public void getUserContactList() throws Exception {
		// 申明变量
		Map<String, Object> sessionMap = null;
		Passport passport = null;
		InvokeResult result = null;
		List<UserContact> contacts = null;
		// 获取请求参数
		sessionMap = this.getSessionMap();
		passport = (Passport) sessionMap.get(SessionKeyConstant.PASSPORT_INFO);
		// 判断参数合法性
		if (null == passport) {
			result = new InvokeResult(InvokeStateEnum.ERROR.getCode(), null);
		} else {
			try {
				contacts = this.userInfoService
						.getUserContactByPassportId(passport.getId());
			} catch (Exception e) {
				if (e instanceof WuYaException) {
					result = new InvokeResult(InvokeStateEnum.ERROR.getCode(),
							((WuYaException) e).getMsg());
				}
			}
		}
		if (null != contacts) {
			result = new InvokeResult(InvokeStateEnum.SUCCESS.getCode(),
					contacts);
		} else {
			if (null == result) {
				result = new InvokeResult(InvokeStateEnum.ERROR.getCode(), null);
			}
		}
		this.outputJsonMessage(result.getResult());
	}

	/**
	 * [删除对应的用户联系人信息]
	 * 
	 * @throws Exception
	 */
	public void deleteUserContact() throws Exception {
		// 申明变量
		InvokeResult result = null;
		Integer contactId = null;
		Map<String, Object> requestMap = null;
		boolean flag = false;
		// 获取请求参数
		requestMap = this.getParameterMapFromRequest();
		contactId = Integer.parseInt((String) requestMap.get("contactId"));
		// 检查参数合法性
		if (0 == contactId) {
			result = new InvokeResult(InvokeStateEnum.ERROR.getCode(),
					FrontErrorCode.E0010);
		} else {
			try {
				flag = this.userInfoService.deleteUserContact(contactId);
			} catch (Exception e) {
				if (e instanceof WuYaException) {
					result = new InvokeResult(InvokeStateEnum.ERROR.getCode(),
							((WuYaException) e).getMsg());
				}
			}
		}
		if (flag) {
			result = new InvokeResult(InvokeStateEnum.SUCCESS.getCode(), null);
		} else {
			if (null == result) {
				result = new InvokeResult(InvokeStateEnum.ERROR.getCode(), null);
			}
		}
		this.outputJsonMessage(result);
	}

	/**
	 * [删除对应的用户证件信息]
	 * 
	 * @throws Exception
	 */
	public void deleteUserCertificate() throws Exception {
		// 申明变量
		InvokeResult result = null;
		Integer certificateId = null;
		Map<String, Object> requestMap = null;
		boolean flag = false;
		// 获取请求参数
		requestMap = this.getParameterMapFromRequest();
		certificateId = Integer.parseInt((String) requestMap
				.get("certificateId"));
		// 检查参数合法性
		if (0 == certificateId) {
			result = new InvokeResult(InvokeStateEnum.ERROR.getCode(),
					FrontErrorCode.E0013);
		} else {
			try {
				flag = this.userInfoService
						.deleteUserCertificate(certificateId);
			} catch (Exception e) {
				if (e instanceof WuYaException) {
					result = new InvokeResult(InvokeStateEnum.ERROR.getCode(),
							((WuYaException) e).getMsg());
				}
			}
		}
		if (flag) {
			result = new InvokeResult(InvokeStateEnum.SUCCESS.getCode(), null);
		} else {
			if (null == result) {
				result = new InvokeResult(InvokeStateEnum.ERROR.getCode(), null);
			}
		}
		this.outputJsonMessage(result);
	}

	/**
	 * [更新通行证信息]
	 * 
	 * @throws Exception
	 */
	public void updatePassportInfo() throws Exception {
		System.out.println(this.getParameterMapFromRequest());
		// 申明变量
		InvokeResult result = null;
		Passport passportNew = null;
		// 检查参数合法性
		if (null == this.passport || 0 == this.passport.getId()
				|| StringUtil.isEmpty(this.passport.getDomain())) {
			result = new InvokeResult(InvokeStateEnum.ERROR.getCode(),
					FrontErrorCode.E0011);
		} else {
			if (StringUtil.isNotEmpty(this.passport.getPassword())) {
				this.passport.setPassword(MD5.getMD5Str(this.passport
						.getPassword()));
			} else {
				this.passport.setPassword(null);
			}
			try {
				passportNew = this.userInfoService
						.updatePassportInfo(this.passport);
			} catch (Exception e) {
				if (e instanceof WuYaException) {
					result = new InvokeResult(InvokeStateEnum.ERROR.getCode(),
							((WuYaException) e).getMsg());
				}
			}
		}
		if (null != passportNew) {
			this.getSessionMap().put(SessionKeyConstant.PASSPORT_INFO,
					passportNew);
			result = new InvokeResult(InvokeStateEnum.SUCCESS.getCode(), null);
		} else {
			if (null == result) {
				result = new InvokeResult(InvokeStateEnum.ERROR.getCode(),
						FrontErrorCode.E0004);
			}
		}
		this.outputJsonMessage(result);
	}

	/**
	 * [创建用户证件信息]
	 * 
	 * @throws Exception
	 */
	public void createUserCertificate() throws Exception {
		// 申明变量
		Map<String, Object> sessionMap = null;
		Passport passport = null;
		InvokeResult result = null;
		boolean flag = false;
		// 获取请求参数
		sessionMap = this.getSessionMap();
		passport = (Passport) sessionMap.get(SessionKeyConstant.PASSPORT_INFO);
		// 判断参数合法性
		if (null == this.userCertificate || null == passport) {
			result = new InvokeResult(InvokeStateEnum.ERROR.getCode(), null);
		} else {
			try {
				flag = this.userInfoService.createUserCertificate(
						passport.getId(), this.userCertificate);
			} catch (Exception e) {
				if (e instanceof WuYaException) {
					result = new InvokeResult(InvokeStateEnum.ERROR.getCode(),
							((WuYaException) e).getMsg());
				}
			}
		}
		if (flag) {
			result = new InvokeResult(InvokeStateEnum.SUCCESS.getCode(), null);
		} else {
			if (null == result) {
				result = new InvokeResult(InvokeStateEnum.ERROR.getCode(),
						FrontErrorCode.E0012);
			}
		}
		this.outputJsonMessage(result);
	}

	/**
	 * [获取用户证件]
	 * 
	 * @throws Exception
	 */
	public void getUserCertificateList() throws Exception {
		// 申明变量
		Map<String, Object> sessionMap = null;
		Passport passport = null;
		InvokeResult result = null;
		List<UserCertificate> certificates = null;
		// 获取请求参数
		sessionMap = this.getSessionMap();
		passport = (Passport) sessionMap.get(SessionKeyConstant.PASSPORT_INFO);
		// 判断参数合法性
		if (null == passport) {
			result = new InvokeResult(InvokeStateEnum.ERROR.getCode(), null);
		} else {
			try {
				certificates = this.userInfoService
						.getUserCertificateByPassportId(passport.getId());
			} catch (Exception e) {
				if (e instanceof WuYaException) {
					result = new InvokeResult(InvokeStateEnum.ERROR.getCode(),
							((WuYaException) e).getMsg());
				}
			}
		}
		if (null != certificates) {
			result = new InvokeResult(InvokeStateEnum.SUCCESS.getCode(),
					certificates);
		} else {
			if (null == result) {
				result = new InvokeResult(InvokeStateEnum.ERROR.getCode(), null);
			}
		}
		this.outputJsonMessage(result.getResult());
	}

}
