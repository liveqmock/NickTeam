package com.wuya.backend.po.permission;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.wuya.backend.po.base.BasePo;
import com.wuya.base.inter.IValidateable;
import com.wuya.base.util.NumberUtil;
import com.wuya.base.util.StringUtil;

/**
 * [通行证-权限关联]
 * 
 * @author nick
 * @version v1.0 2015-3-14
 */
@Entity
@Table(catalog = "wuya", name = "passport_permission_ref")
public class PassportPermissionRef extends BasePo implements IValidateable {

	/**
	 * [对象序列化标识]
	 */
	private static final long serialVersionUID = 7687521813537904209L;

	/**
	 * [权限代号]
	 */
	@Column(name = "pcode", length = 40, nullable = false)
	private String pcode;

	/**
	 * [通行证标识]
	 */
	@Column(name = "passportId", nullable = false)
	private Integer passportId;

	/**
	 * [所属领域]
	 */
	@Column(name = "domain", length = 20, nullable = false)
	private String domain;

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public Integer getPassportId() {
		return passportId;
	}

	public void setPassportId(Integer passportId) {
		this.passportId = passportId;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	@Override
	public String toString() {
		return "PassportPermissionRef [pcode=" + pcode + ", passportId="
				+ passportId + ", domain=" + domain + "]";
	}

	/**
	 * [自我检测方法]
	 */
	public boolean validate() {
		if (NumberUtil.isEmptyOrZero(this.passportId)
				|| StringUtil.isEmpty(this.pcode)
				|| StringUtil.isEmpty(this.pcode)) {
			return false;
		} else {
			return true;
		}
	}

}
