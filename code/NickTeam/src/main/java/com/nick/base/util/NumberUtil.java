package com.nick.base.util;

import java.text.DecimalFormat;

/**
 * [数字工具－工具类]
 * 
 * @author nick
 * @version v1.0 2015-2-13
 */
public class NumberUtil {

	/**
	 * [是否空、或者为0]
	 * 
	 * @param num
	 * @return
	 */
	public static boolean isEmptyOrZero(Integer num) {
		if (null == num || 0 == num) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * [是否空、或者为0.0]
	 * 
	 * @param num
	 * @return
	 */
	public static boolean isEmptyOrZero(Double num) {
		if (null == num || 0.0 == num) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * [是否不为空、或者为0]
	 * 
	 * @param num
	 * @return
	 */
	public static boolean isNotEmptyOrZero(Integer num) {
		if (null == num || 0 == num) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * [是否不为空、或者为0]
	 * 
	 * @param num
	 * @return
	 */
	public static boolean isNotEmptyOrZero(Double num) {
		if (null == num || 0.0 == num) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * [对double类型的数字保留2位小数]
	 * 
	 * @param a
	 * @return
	 */
	public static double get2Double(double a) {
		DecimalFormat df = new DecimalFormat("0.00");
		return new Double(df.format(a).toString());
	}

	/**
	 * [对double类型的数字保留2位小数]
	 * 
	 * @param a
	 * @return
	 */
	public static String doubleTo2String(double a) {
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(a).toString();
	}

}
