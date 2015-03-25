package com.nick.backend.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.nick.base.inter.IValidateable;
import com.nick.base.po.BasePo;
import com.nick.base.util.StringUtil;

/**
 * [用户-实体类]
 * 
 * @author nick
 * @version v1.0 2015-3-24
 */
@Entity
@Table(catalog = "nick_team", name = "user")
public class User extends BasePo implements IValidateable {

	/**
	 * [对象序列化标识]
	 */
	private static final long serialVersionUID = 6727544143286302136L;

	/**
	 * [用户名]
	 */
	@Column(name = "username", length = 20, nullable = true)
	private String username;

	/**
	 * [邮件地址]
	 */
	@Column(name = "email", length = 80, nullable = true)
	private String email;

	/**
	 * [手机号码]
	 */
	@Column(name = "mobile", length = 20, nullable = true)
	private String mobile;

	/**
	 * [密码]
	 */
	@Column(name = "password", length = 80, nullable = false)
	private String password;

	/**
	 * [真实姓名]
	 */
	@Column(name = "trueName", length = 20, nullable = true)
	private String trueName;

	/**
	 * [生日]
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "birthday", nullable = true)
	private Date birthday;

	/**
	 * [类型]
	 */
	@Column(name = "type", nullable = false)
	private String type;

	/**
	 * [注册时间]
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "sign_time", nullable = true)
	private Date signTime;

	/**
	 * [最近登录时间]
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_login_time", nullable = true)
	private Date lastLoginTime;

	/**
	 * [所属领域]
	 */
	@Column(name = "domain", length = 20, nullable = false)
	private String domain;

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

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getSignTime() {
		return signTime;
	}

	public void setSignTime(Date signTime) {
		this.signTime = signTime;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", email=" + email + ", mobile="
				+ mobile + ", password=" + password + ", trueName=" + trueName
				+ ", birthday=" + birthday + ", type=" + type + ", signTime="
				+ signTime + ", lastLoginTime=" + lastLoginTime + ", domain="
				+ domain + "]";
	}

	/**
	 * [自我检测方法实现]
	 */
	public boolean validate() {
		if (StringUtil.isEmpty(this.password) || StringUtil.isEmpty(this.type)
				|| StringUtil.isEmpty(this.domain)) {
			return false;
		} else {
			return true;
		}
	}

}
