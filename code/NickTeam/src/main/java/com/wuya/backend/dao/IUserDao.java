package com.wuya.backend.dao;

import java.util.List;

import com.wuya.backend.criteria.user.PassportCriteria;
import com.wuya.backend.criteria.user.UserCertificateCriteria;
import com.wuya.backend.po.user.Passport;
import com.wuya.backend.po.user.UserCertificate;
import com.wuya.backend.po.user.UserContact;
import com.wuya.backend.po.user.UserEducation;

/**
 * [用户相关－数据访问层接口]
 * 
 * @author nick
 * @version v1.0 2015-1-24
 */
public interface IUserDao {

	/**
	 * [根据用户名计算]
	 * 
	 * @param username
	 *            [需要判断的用户名]
	 * @param domain
	 *            [所在领域]
	 * @return
	 * @throws Exception
	 */
	public Integer countByUsername(String username, String domain)
			throws Exception;

	/**
	 * [根据手机号码计算]
	 * 
	 * @param mobile
	 *            [需要判断的手机号码]
	 * @param domain
	 *            [所在领域]
	 * @return
	 * @throws Exception
	 */
	public Integer countByMobile(String mobile, String domain) throws Exception;

	/**
	 * [根据邮箱地址计算]
	 * 
	 * @param mobile
	 *            [需要判断的邮箱地址]
	 * @param domain
	 *            [所在领域]
	 * @return
	 * @throws Exception
	 */
	public Integer countByEmail(String email, String domain) throws Exception;

	/**
	 * [根据用户名和密码获取通行证信息]
	 * 
	 * @param username
	 *            [用户名]
	 * @param password
	 *            [密码]
	 * @param domain
	 *            [所属系统领域]
	 * @return
	 * @throws Exception
	 */
	public Passport getByUsernameWithPassword(String username, String password,
			String domain) throws Exception;

	/**
	 * [根据邮箱地址和密码获取通行证信息]
	 * 
	 * @param email
	 *            [邮箱地址]
	 * @param password
	 *            [密码]
	 * @param domain
	 *            [所属系统领域]
	 * @return
	 * @throws Exception
	 */
	public Passport getByEmailWithPassword(String email, String password,
			String domain) throws Exception;

	/**
	 * [根据手机号码和密码获取通行证信息]
	 * 
	 * @param mobile
	 *            [手机号码]
	 * @param password
	 *            [密码]
	 * @param domain
	 *            [所属系统领域]
	 * @return
	 * @throws Exception
	 */
	public Passport getByMobileWithPassword(String mobile, String password,
			String domain) throws Exception;

	/**
	 * [根据通行证标识，获取对应的用户教育经历信息]
	 * 
	 * @param passportId
	 *            [通行证标识]
	 * @return
	 * @throws Exception
	 */
	public List<UserEducation> selectUserEducationByPassportId(
			Integer passportId) throws Exception;

	/**
	 * [根据通行证标识，获取对应的用户联系人信息]
	 * 
	 * @param passportId
	 *            [通行证标识]
	 * @return
	 * @throws Exception
	 */
	public List<UserContact> selectUserContactByPassportId(Integer passportId)
			throws Exception;

	/**
	 * [根据通行证标识，获取对应的用户证件信息]
	 * 
	 * @param passportId
	 *            [通行证标识]
	 * @return
	 * @throws Exception
	 */
	public List<UserCertificate> selectUserCertificateByPassportId(
			Integer passportId) throws Exception;

	/**
	 * [获取通行证-支持分页]
	 * 
	 * @param passportCriteria
	 *            [通行证－查询封装]
	 * @return
	 * @throws Exception
	 */
	public List<Passport> selectPassportWithPage(
			final PassportCriteria passportCriteria) throws Exception;

	/**
	 * [获取通行证计数-支持分页]
	 * 
	 * @param passportCriteria
	 *            [通行证－查询封装]
	 * @return
	 * @throws Exception
	 */
	public Integer countPassportWithPage(final PassportCriteria passportCriteria)
			throws Exception;

	/**
	 * [获取用户证件-支持分页]
	 * 
	 * @param userCertificateCriteria
	 *            [用户证件－查询封装]
	 * @return
	 * @throws Exception
	 */
	public List<UserCertificate> selectUserCertificateWithPage(
			final UserCertificateCriteria userCertificateCriteria)
			throws Exception;

	/**
	 * [获取用户证件计数-支持分页]
	 * 
	 * @param userCertificateCriteria
	 *            [用户证件－查询封装]
	 * @return
	 * @throws Exception
	 */
	public Integer countUserCertificateWithPage(
			final UserCertificateCriteria userCertificateCriteria)
			throws Exception;
}
