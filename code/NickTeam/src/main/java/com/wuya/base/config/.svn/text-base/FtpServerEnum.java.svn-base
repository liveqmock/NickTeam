package com.wuya.base.config;

/**
 * [服务器枚举]
 * 
 * @author nick
 * @version v1.0 2015-25
 */
public enum FtpServerEnum {

	// 图片FTP服务器

	/* windows开发服务器配置 */
	// AVATOR_FTP_SERVER("avator", "ftp", "192.168.31.11", 21, "avator",
	// "avator",
	// "avator"), RECHARGE_FTP_SERVER("recharge", "ftp", "192.168.31.11",
	// 21, "recharge", "recharge", "recharge"), CERTIFICATE_FTP_SERVER(
	// "certificate", "ftp", "192.168.31.11", 21, "certificate",
	// "certificate", "certificate");

	/* windows开发机配置 */
	// AVATOR_FTP_SERVER("avator", "ftp", "127.0.0.1", 21, "avator", "avator",
	// "avator"), RECHARGE_FTP_SERVER("recharge", "ftp", "127.0.0.1", 21,
	// "recharge", "recharge", "recharge"), CERTIFICATE_FTP_SERVER(
	// "certificate", "ftp", "127.0.0.1", 21, "certificate",
	// "certificate", "certificate");

	/* MAC开发机配置 */
//	AVATOR_FTP_SERVER("avator", "ftp", "192.168.31.103", 21, "avator",
//			"avator", "avator"), RECHARGE_FTP_SERVER("recharge", "ftp",
//			"192.168.31.103", 21, "recharge", "recharge", "recharge"), CERTIFICATE_FTP_SERVER(
//			"certificate", "ftp", "192.168.31.103", 21, "certificate",
//			"certificate", "certificate"), PROJECT_FTP_SERVER("project", "ftp",
//			"192.168.31.103", 21, "project", "project", "project");

	/* 部署环境配置配置 */
//	AVATOR_FTP_SERVER("avator", "ftp", "127.0.0.1", 21, "avator", "avator",
//			"avator"), RECHARGE_FTP_SERVER("recharge", "ftp", "127.0.0.1", 21,
//			"recharge", "recharge", "recharge"), CERTIFICATE_FTP_SERVER(
//			"certificate", "ftp", "127.0.0.1", 21, "certificate",
//			"certificate", "certificate"), PROJECT_FTP_SERVER("project", "ftp",
//			"127.0.0.1", 21, "project", "project", "project");

	/* 生产环境配置 */
	AVATOR_FTP_SERVER("avator", "ftp", "127.0.0.1", 21, "avator", "avator",
			"avator"), RECHARGE_FTP_SERVER("recharge", "ftp", "127.0.0.1", 21,
			"recharge", "recharge", "recharge"), CERTIFICATE_FTP_SERVER(
			"certificate", "ftp", "127.0.0.1", 21, "certificate",
			"certificate", "certificate"), PROJECT_FTP_SERVER("project", "ftp",
			"127.0.0.1", 21, "project", "project", "project");

	private String code;

	private String protocol;

	private String baseAddress;

	private Integer port;

	private String username;

	private String password;

	private String httpServerCode;

	private FtpServerEnum(String code, String protocol, String baseAddress,
			Integer port, String username, String password,
			String httpServerCode) {
		this.code = code;
		this.protocol = protocol;
		this.baseAddress = baseAddress;
		this.port = port;
		this.username = username;
		this.password = password;
		this.httpServerCode = httpServerCode;
	}

	public String getCode() {
		return code;
	}

	public String getProtocol() {
		return protocol;
	}

	public String getBaseAddress() {
		return baseAddress;
	}

	public Integer getPort() {
		return port;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getHttpServerCode() {
		return httpServerCode;
	}

	public static FtpServerEnum getByCode(String code) {
		FtpServerEnum result = null;
		for (FtpServerEnum fse : FtpServerEnum.values()) {
			if (code.equals(fse.getCode())) {
				result = fse;
				break;
			}
		}
		return result;
	}

}
