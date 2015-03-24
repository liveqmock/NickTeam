package com.wuya.backend.po.user;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.wuya.backend.po.base.BasePo;
import com.wuya.base.constant.CommonConstant;
import com.wuya.base.enumerate.user.SexEnum;
import com.wuya.base.enumerate.user.StudentGradeEnum;
import com.wuya.base.inter.IValidateable;
import com.wuya.base.util.NumberUtil;
import com.wuya.base.util.StringUtil;

/**
 * [用户通行证－实体类]
 * 
 * @author nick
 * @version v1.0 2015-1-24
 */
@Entity
@Table(name = "passport", catalog = "wuya")
public class Passport extends BasePo implements IValidateable {

	/**
	 * [对象序列化标识]
	 */
	private static final long serialVersionUID = -1554605321343880509L;

	/**
	 * [用户名]
	 */
	@Column(name = "username", length = 20)
	private String username;

	/**
	 * [邮箱地址]
	 */
	@Column(name = "email", length = 60)
	private String email;

	/**
	 * [手机号码]
	 */
	@Column(name = "mobile", length = 20)
	private String mobile;

	/**
	 * [登录密码]
	 */
	@Column(name = "password", length = 60, nullable = false)
	private String password;

	/**
	 * [真实姓名]
	 */
	@Column(name = "trueName", length = 20)
	private String trueName;

	/**
	 * [中文拼音]
	 */
	@Column(name = "pinyin", length = 40)
	private String pinyin;

	/**
	 * [性别]
	 */
	@Column(name = "sex", length = 10)
	private String sex;

	/**
	 * [qq号]
	 */
	@Column(name = "qqAcount", length = 30)
	private String qqAcount;

	/**
	 * [出生日期]
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "birthday")
	private Date birthday;

	/**
	 * [通行证类型]
	 */
	@Column(name = "type", length = 20, nullable = false)
	private String type;

	/**
	 * [来源类型：学校、机构、老师、同学、上届学长学姐、无涯教育官网]
	 */
	@Column(name = "fromType", length = 20)
	private String fromType;

	/**
	 * [通行证所属领域]
	 */
	@Column(name = "domain", length = 20, nullable = false)
	private String domain;

	/**
	 * [高中名称]
	 */
	@Column(name = "highSchoolName", length = 60, nullable = true)
	private String highSchoolName;

	/**
	 * [初中名称]
	 */
	@Column(name = "juniorSchoolName", length = 60, nullable = true)
	private String juniorSchoolName;

	/**
	 * [年级]
	 */
	@Column(name = "grade", nullable = true)
	private Integer grade;

	/**
	 * [毕业时间]
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "graduateTime", nullable = true)
	private Date graduateTime;

	/**
	 * [所在省]
	 */
	@Column(name = "province", length = 20, nullable = true)
	private String province;

	/**
	 * [所在市]
	 */
	@Column(name = "city", length = 20, nullable = true)
	private String city;

	/**
	 * [所在区县]
	 */
	@Column(name = "county", length = 20, nullable = true)
	private String county;

	/**
	 * [所在地址]
	 */
	@Column(name = "address", length = 80, nullable = true)
	private String address;

	/**
	 * [微信账号]
	 */
	@Column(name = "weixinAccount", length = 60, nullable = true)
	private String weixinAccount;

	/**
	 * [父亲姓名]
	 */
	@Column(name = "fatherName", length = 30, nullable = true)
	private String fatherName;

	/**
	 * [父亲邮箱地址]
	 */
	@Column(name = "fatherEmail", length = 30, nullable = true)
	private String fatherEmail;

	/**
	 * [父亲手机号码]
	 */
	@Column(name = "fatherMobile", length = 30, nullable = true)
	private String fatherMobile;

	/**
	 * [母亲姓名]
	 */
	@Column(name = "motherName", length = 30, nullable = true)
	private String motherName;

	/**
	 * [母亲邮箱地址]
	 */
	@Column(name = "motherEmail", length = 30, nullable = true)
	private String motherEmail;

	/**
	 * [母亲手机号码]
	 */
	@Column(name = "motherMobile", length = 30, nullable = true)
	private String motherMobile;

	/* 辅助字段 开始 */
	@Transient
	private String birthdayStr;

	@Transient
	private String sexStr;

	@Transient
	private String graduateTimeStr;

	@Transient
	private String gradeStr;

	/* 辅助字段 结束 */

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFromType() {
		return fromType;
	}

	public void setFromType(String fromType) {
		this.fromType = fromType;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public String getPinyin() {
		return pinyin;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getQqAcount() {
		return qqAcount;
	}

	public void setQqAcount(String qqAcount) {
		this.qqAcount = qqAcount;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getBirthdayStr() {
		SimpleDateFormat sdf = new SimpleDateFormat(CommonConstant.SDF_FORMAT_1);
		if (null != this.birthday) {
			this.birthdayStr = sdf.format(this.birthday);
		}
		return birthdayStr;
	}

	public void setBirthdayStr(String birthdayStr) {
		this.birthdayStr = birthdayStr;
	}

	public String getGraduateTimeStr() {
		SimpleDateFormat sdf = new SimpleDateFormat(CommonConstant.SDF_FORMAT_1);
		if (null != this.graduateTime) {
			this.graduateTimeStr = sdf.format(this.graduateTime);
		}
		return graduateTimeStr;
	}

	public void setGraduateTimeStr(String graduateTimeStr) {
		this.graduateTimeStr = graduateTimeStr;
	}

	public String getSexStr() {
		if (StringUtil.isNotEmpty(this.sex)) {
			for (SexEnum e : SexEnum.values()) {
				if (e.getCode().equals(this.sex)) {
					this.sexStr = e.getMsg();
				}
			}
		}
		return sexStr;
	}

	public void setSexStr(String sexStr) {
		this.sexStr = sexStr;
	}

	public String getHighSchoolName() {
		return highSchoolName;
	}

	public void setHighSchoolName(String highSchoolName) {
		this.highSchoolName = highSchoolName;
	}

	public String getJuniorSchoolName() {
		return juniorSchoolName;
	}

	public void setJuniorSchoolName(String juniorSchoolName) {
		this.juniorSchoolName = juniorSchoolName;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public Date getGraduateTime() {
		return graduateTime;
	}

	public void setGraduateTime(Date graduateTime) {
		this.graduateTime = graduateTime;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getWeixinAccount() {
		return weixinAccount;
	}

	public void setWeixinAccount(String weixinAccount) {
		this.weixinAccount = weixinAccount;
	}

	public String getGradeStr() {
		if (NumberUtil.isNotEmptyOrZero(this.grade)) {
			this.gradeStr = StudentGradeEnum.getMsgByCode(this.grade);
		}
		return gradeStr;
	}

	public void setGradeStr(String gradeStr) {
		this.gradeStr = gradeStr;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getFatherEmail() {
		return fatherEmail;
	}

	public void setFatherEmail(String fatherEmail) {
		this.fatherEmail = fatherEmail;
	}

	public String getFatherMobile() {
		return fatherMobile;
	}

	public void setFatherMobile(String fatherMobile) {
		this.fatherMobile = fatherMobile;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getMotherEmail() {
		return motherEmail;
	}

	public void setMotherEmail(String motherEmail) {
		this.motherEmail = motherEmail;
	}

	public String getMotherMobile() {
		return motherMobile;
	}

	public void setMotherMobile(String motherMobile) {
		this.motherMobile = motherMobile;
	}

	@Override
	public String toString() {
		return "Passport [username=" + username + ", email=" + email
				+ ", mobile=" + mobile + ", password=" + password
				+ ", trueName=" + trueName + ", pinyin=" + pinyin + ", sex="
				+ sex + ", qqAcount=" + qqAcount + ", birthday=" + birthday
				+ ", type=" + type + ", fromType=" + fromType + ", domain="
				+ domain + ", highSchoolName=" + highSchoolName
				+ ", juniorSchoolName=" + juniorSchoolName + ", grade=" + grade
				+ ", graduateTime=" + graduateTime + ", province=" + province
				+ ", city=" + city + ", county=" + county + ", address="
				+ address + ", weixinAccount=" + weixinAccount
				+ ", fatherName=" + fatherName + ", fatherEmail=" + fatherEmail
				+ ", fatherMobile=" + fatherMobile + ", motherName="
				+ motherName + ", motherEmail=" + motherEmail
				+ ", motherMobile=" + motherMobile + ", birthdayStr="
				+ birthdayStr + ", sexStr=" + sexStr + ", graduateTimeStr="
				+ graduateTimeStr + ", gradeStr=" + gradeStr + "]";
	}

	public boolean validate() {
		if (StringUtil.isEmpty(this.password)
				|| StringUtil.isEmpty(this.type)
				|| StringUtil.isEmpty(this.domain)
				|| (StringUtil.isEmpty(this.username)
						&& StringUtil.isEmpty(this.mobile) && StringUtil
							.isEmpty(this.email))) {
			return false;
		} else {
			return true;
		}
	}

}
