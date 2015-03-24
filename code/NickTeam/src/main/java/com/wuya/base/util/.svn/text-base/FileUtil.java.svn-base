package com.wuya.base.util;

import com.wuya.base.constant.CommonConstant;

/**
 * [文件相关－工具类]
 * 
 * @author nick
 * @version v1.0 2015-2-25
 */
public class FileUtil {

	/**
	 * [获取文件名称]
	 * 
	 * @return
	 */
	public static String getFileName(String fileName) {
		String result = null;
		String[] temp = fileName.split(CommonConstant.DOT);
		if (null != temp && 2 == temp.length) {
			result = temp[0];
		}
		return result;
	}

	/**
	 * [获取文件类型]
	 * 
	 * @return
	 */
	public static String getFileFormat(String fileName) {
		String result = null;
		String[] temp = fileName.split(CommonConstant.DOT);
		if (null != temp && 2 == temp.length) {
			result = temp[1];
		}
		return result;
	}
}
