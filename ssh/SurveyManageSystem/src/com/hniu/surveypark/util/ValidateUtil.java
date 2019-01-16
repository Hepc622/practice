package com.hniu.surveypark.util;

/**
 * 工具类不用继承
 */
public final class ValidateUtil {
	/**
	 * 验证字符是否为空
	 * 
	 * @param str
	 *            被验证的字符
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if (str.length() > 0 && str != null) {
			return true;
		}
		return false;
	}

	/**
	 *	判断数据是否有效性 
	 */
	public static boolean isValidate(String[] strs) {
		if (strs.length > 0 && strs != null) {
			return true;
		}
		return false;
	}
}
