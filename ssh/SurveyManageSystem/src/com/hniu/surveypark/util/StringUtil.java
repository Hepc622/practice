package com.hniu.surveypark.util;

import java.util.Map;

/**
 * String ������
 */
public final class StringUtil {
	/**
	 * ���ַ�����ָ�����ַ��и������
	 */
	public static String[] StringToArray(String str, String tag) {
		if (ValidateUtil.isEmpty(str)) {
			return str.split(tag);
		}
		return null;
	}

	/**
	 * �ж�ָ���ַ�������map���Ƿ����
	 */
	public static String isExistAttr(Map<String, String[]> parametersMap, String name, String value, String tag) {
		if (parametersMap != null)// �ж���map��Ϊ��
			// ��map��keyȡ����
			for (String key : parametersMap.keySet()) {
				// �ж�key�Ƿ���name��ȣ���Ⱦ�ȡ����key��Ӧ�Ĳ�������
				if (key.equals(name)) {
					String[] strs = parametersMap.get(name);
					// �ж������Ƿ���Ч
					if (ValidateUtil.isValidate(strs)) {
						// ���tag��text��ֱ��ȡ������ĵ�һ�����ݷ�����ʾ
						if (tag.equals("text")) {
							return strs[0];
						} else {// ���ǵĻ����ж����д��һ����ֵ�еû�����˵���ϴα�ѡ�е�����������tag
							for (String string : strs) {
								if (string.equals(value))
									return tag;
							}
						}
					}
				}
			}
		return "";
	}

	/**
	 * ��ȡ����id
	 */
	public static String splitQustionId(String key, int begin) {
		if (key != null)
			return key.substring(begin);
		return null;
	}

	/**
	 * ���������ַ�����tag���Ը���
	 */
	public static String ArrayToString(String[] values, String tag) {
		String str = "";
		if (ValidateUtil.isValidate(values)) {
			for (String string : values) {
				str += string + ",";
			}
			str = str.substring(0, (str.length() - 1));
		}
		return str;
	}

	/*
	 * ������id�г�����������Ǹ�λ�ÿ�ʼ���Ǹ�λ�ý���
	 */
	public static String splitQustionId(String key, int begin, int end) {
		if (ValidateUtil.isEmpty(key)) {
			return key.substring(begin, end);
		}
		return "";
	}
}
