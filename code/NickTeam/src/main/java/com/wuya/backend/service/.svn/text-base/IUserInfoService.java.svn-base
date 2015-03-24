package com.wuya.backend.service;

import java.util.List;

import com.wuya.backend.criteria.user.PassportCriteria;
import com.wuya.backend.criteria.user.UserCertificateCriteria;
import com.wuya.backend.po.user.Passport;
import com.wuya.backend.po.user.UserCertificate;
import com.wuya.backend.po.user.UserContact;
import com.wuya.backend.po.user.UserEducation;
import com.wuya.base.result.EasyUiPagerResult;

/**
 * [通行证－业务层接口]
 * 
 * @author nick
 * @version v1.0 2015-1-24
 */
public interface IUserInfoService {

	/**
	 * [创建用户通行证信息，创建前，需要检查用户名、手机号、邮箱地址是否重复，如果有一项重复，则抛出异常]
	 * 
	 * @param passportModel
	 *            [需要创建的通行证信息]
	 * @throws Exception
	 */
	public boolean createPassport(Passport passportModel) throws Exception;

	/**
	 * [注册通行证]
	 * 
	 * @param passportModel
	 *            [需要注册的通行证信息]
	 * @return
	 * @throws Exception
	 */
	public Passport registPassport(Passport passportModel) throws Exception;

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
			throws Exception;

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
			throws Exception;

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
	public boolean isExistByEmail(String email, String domain) throws Exception;

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
			throws Exception;

	/**
	 * [根据通行证标识，获取对应的教育信息列表]
	 * 
	 * @param passportId
	 *            [通行证标识]
	 * @return
	 * @throws Exception
	 */
	public List<UserEducation> getUserEducationByPassportId(Integer passportId)
			throws Exception;

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
			UserEducation userEducation) throws Exception;

	/**
	 * [删除标识对应的教育经历]
	 * 
	 * @param educationId
	 *            [教育经历标识]
	 * @return
	 * @throws Exception
	 */
	public boolean deleteUserEducation(Integer educationId) throws Exception;

	/**
	 * [创建用户联系人信息]
	 * 
	 * @param passportId
	 *            [通行证标识]
	 * @param userContact
	 *            [用户联系人信息实例]
	 * @return
	 * @throws Exception
	 */
	public boolean createUserContact(Integer passportId, UserContact userContact)
			throws Exception;

	/**
	 * [根据通行证标识，获取对应的联系人列表]
	 * 
	 * @param passportId
	 *            [通行证标识]
	 * @return
	 * @throws Exception
	 */
	public List<UserContact> getUserContactByPassportId(Integer passportId)
			throws Exception;

	/**
	 * [删除标识对应的联系人信息]
	 * 
	 * @param contactId
	 *            [用户联系人标识]
	 * @return
	 * @throws Exception
	 */
	public boolean deleteUserContact(Integer contactId) throws Exception;

	/**
	 * [更新通行证相关信息]
	 * 
	 * @param passport
	 *            [通行证实例]
	 * @return
	 * @throws Exception
	 */
	public Passport updatePassportInfo(Passport passport) throws Exception;

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
			UserCertificate userCertificate) throws Exception;

	/**
	 * [根据通行证标识，获取对应的证件列表]
	 * 
	 * @param passportId
	 *            [通行证标识]
	 * @return
	 * @throws Exception
	 */
	public List<UserCertificate> getUserCertificateByPassportId(
			Integer passportId) throws Exception;

	/**
	 * [删除标识对应的证件信息]
	 * 
	 * @param certificateId
	 *            [用户证件标识]
	 * @return
	 * @throws Exception
	 */
	public boolean deleteUserCertificate(Integer certificateId)
			throws Exception;

	/**
	 * [获取通行证列表－支持分页]
	 * 
	 * @param passportCriteria
	 *            [通行证条件封装]
	 * @return
	 * @throws Exception
	 */
	public EasyUiPagerResult getPassportListWithPage(
			PassportCriteria passportCriteria) throws Exception;

	/**
	 * [获取用户证件-支持分页]
	 * 
	 * @param userCertificateCriteria
	 *            [用户证件条件封装实例]
	 * @return
	 * @throws Exception
	 */
	public EasyUiPagerResult getCertificateListWithPage(
			UserCertificateCriteria userCertificateCriteria) throws Exception;

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
			String password2) throws Exception;

}
