package com.nick.base.config;

/**
 * [http服务器配置]
 * 
 * @author NICK
 * @version v1.0 2015-2-25
 */
public enum HttpServerEnum {
	// 图片FTP服务器

	/* windows开发服务器配置 */
	// AVATOR_HTTP_SERVER("avator", "http", "192.168.31.11", 8080, "wuyaimage",
	// "avator"), RECHARGE_HTTP_SERVER("recharge", "http",
	// "192.168.31.11", 8080, "wuyaimage", "recharge"), CERTIFICATE_HTTP_SERVER(
	// "certificate", "http", "192.168.31.11", 8080, "wuyaimage",
	// "certificate");

	/* windows开发机配置 */
	// AVATOR_HTTP_SERVER("avator", "http", "127.0.0.1", 80, "wuyaimage",
	// "avator"), RECHARGE_HTTP_SERVER(
	// "recharge", "http", "127.0.0.1", 80, "wuyaimage", "recharge"),
	// CERTIFICATE_HTTP_SERVER(
	// "certificate", "http", "127.0.0.1", 80, "wuyaimage", "certificate"), ;

	/* MAC开发机配置 */
	// AVATOR_HTTP_SERVER("avator", "http", "192.168.31.103", 8080, "wuyaimage",
	// "avator"), RECHARGE_HTTP_SERVER("recharge", "http",
	// "192.168.31.103", 8080, "wuyaimage", "recharge"),
	// CERTIFICATE_HTTP_SERVER(
	// "certificate", "http", "192.168.31.103", 8080, "wuyaimage",
	// "certificate"), PROJECT_HTTP_SERVER("project", "http",
	// "192.168.31.103", 8080, "wuyaimage", "project"), ;

	/* 部署环境配置配置 */
	// AVATOR_HTTP_SERVER("avator", "http", "218.1.111.47", 7022, "wuyaimage",
	// "avator"), RECHARGE_HTTP_SERVER("recharge", "http", "218.1.111.47",
	// 7022, "wuyaimage", "recharge"), CERTIFICATE_HTTP_SERVER(
	// "certificate", "http", "218.1.111.47", 7022, "wuyaimage",
	// "certificate"), PROJECT_HTTP_SERVER("project", "http",
	// "218.1.111.47", 7022, "wuyaimage", "project"), ;

	/* 生产环境配置 */
	AVATOR_HTTP_SERVER("avator", "http", "115.29.173.118", 8080, "wuyaimage",
			"avator"), RECHARGE_HTTP_SERVER("recharge", "http",
			"115.29.173.118", 8080, "wuyaimage", "recharge"), CERTIFICATE_HTTP_SERVER(
			"certificate", "http", "115.29.173.118", 8080, "wuyaimage",
			"certificate"), PROJECT_HTTP_SERVER("project", "http",
			"115.29.173.118", 8080, "wuyaimage", "project"), ;

	private String code;

	private String protocol;

	private String baseAddress;

	private Integer port;

	private String path;

	private String subpath;

	private HttpServerEnum(String code, String protocol, String baseAddress,
			Integer port, String path, String subpath) {
		this.code = code;
		this.protocol = protocol;
		this.baseAddress = baseAddress;
		this.port = port;
		this.path = path;
		this.subpath = subpath;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getBaseAddress() {
		return baseAddress;
	}

	public void setBaseAddress(String baseAddress) {
		this.baseAddress = baseAddress;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getSubpath() {
		return subpath;
	}

	public void setSubpath(String subpath) {
		this.subpath = subpath;
	}

	public static HttpServerEnum getByCode(String code) {
		HttpServerEnum result = null;
		for (HttpServerEnum hse : HttpServerEnum.values()) {
			if (code.equals(hse.getCode())) {
				result = hse;
				break;
			}
		}
		return result;
	}

}
