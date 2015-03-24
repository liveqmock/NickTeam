package com.wuya.base.enumerate.share;

/**
 * [图片格式枚举-枚举]
 * 
 * @author nick
 * @version v1.0 2015-2-25
 */
public enum ImageFormatEnum {
	JPG("jpg", "JPG"), PNG("png", "PNG"), GIF("gif", "GIF");

	private String code;

	private String msg;

	private ImageFormatEnum(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	/**
	 * [像下拉菜单内容一样获取]
	 * 
	 * @return
	 */
	public static String getAsDropDownOption() {
		String str = null;
		for (ImageFormatEnum e : ImageFormatEnum.values()) {
			str += "<option value='" + e.getCode() + "'>" + e.getMsg()
					+ "</option>";
		}
		return str;
	}

	/**
	 * [根据代码，判断是否在枚举中出现]
	 * 
	 * @param code
	 * @return
	 */
	public static boolean isInEnumByCode(String code) {
		Boolean flag = false;
		for (ImageFormatEnum e : ImageFormatEnum.values()) {
			if(e.getCode().equals(code)){
				flag = true;
				break;
			}
		}
		return flag;
	}

}
