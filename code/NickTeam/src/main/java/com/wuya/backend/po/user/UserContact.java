package com.wuya.backend.po.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.wuya.backend.po.base.BasePo;
import com.wuya.base.inter.IValidateable;
import com.wuya.base.util.StringUtil;

/**
 * [用户联系人－实体类]
 * 
 * @author nick
 * @version v1.0 2015-1-31
 */
@Entity
@Table(name = "user_contact", catalog = "wuya")
public class UserContact extends BasePo implements IValidateable {

	/**
	 * [对象序列化标识]
	 */
	private static final long serialVersionUID = 3163488539655016193L;

	/**
	 * [联系人名称]
	 */
	@Column(name = "name", length = 20, nullable = false)
	private String name;

	/**
	 * [联系人类型]
	 */
	@Column(name = "type", length = 20, nullable = false)
	private String type;

	/**
	 * [联系人手机]
	 */
	@Column(name = "mobile", length = 20, nullable = false)
	private String mobile;

	/**
	 * [联系人邮箱]
	 */
	@Column(name = "email", length = 60, nullable = false)
	private String email;

	/**
	 * [对应通行证标识]
	 */
	@Column(name = "passportId", nullable = false)
	private Integer passportId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getPassportId() {
		return passportId;
	}

	public void setPassportId(Integer passportId) {
		this.passportId = passportId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((passportId == null) ? 0 : passportId.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserContact other = (UserContact) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (mobile == null) {
			if (other.mobile != null)
				return false;
		} else if (!mobile.equals(other.mobile))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (passportId == null) {
			if (other.passportId != null)
				return false;
		} else if (!passportId.equals(other.passportId))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserContact [name=" + name + ", type=" + type + ", mobile="
				+ mobile + ", email=" + email + ", passportId=" + passportId
				+ "]";
	}

	/**
	 * [自我验证接口]
	 */
	public boolean validate() {
		if (StringUtil.isEmpty(this.name)
				|| StringUtil.isEmpty(this.type)
				|| (StringUtil.isEmpty(this.mobile) && StringUtil
						.isEmpty(this.email))) {
			return false;
		} else {
			return true;
		}
	}

}
