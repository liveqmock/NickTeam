package com.wuya.base.permission.managerweb;

/**
 * [权限信息-数据传输对象]
 * 
 * @author nick
 * @version v1.0 2015-3-14
 */
public class PermissionDto {

	/**
	 * [权限代号]
	 */
	private String code;

	/**
	 * [权限名称]
	 */
	private String name;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "PermissionDto [code=" + code + ", name=" + name + "]";
	}

}
