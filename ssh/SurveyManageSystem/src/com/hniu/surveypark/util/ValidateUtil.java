package com.hniu.surveypark.util;

/**
 * �����಻�ü̳�
 */
public final class ValidateUtil {
	/**
	 * ��֤�ַ��Ƿ�Ϊ��
	 * 
	 * @param str
	 *            ����֤���ַ�
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if (str.length() > 0 && str != null) {
			return true;
		}
		return false;
	}

	/**
	 *	�ж������Ƿ���Ч�� 
	 */
	public static boolean isValidate(String[] strs) {
		if (strs.length > 0 && strs != null) {
			return true;
		}
		return false;
	}
}
