package com.hniu.surveypark.util;

import java.util.Map;

/**
 * String 工具类
 */
public final class StringUtil {
	/**
	 * 将字符串以指定的字符切割成数组
	 */
	public static String[] StringToArray(String str, String tag) {
		if (ValidateUtil.isEmpty(str)) {
			return str.split(tag);
		}
		return null;
	}

	/**
	 * 判断指定字符串是在map中是否存在
	 */
	public static String isExistAttr(Map<String, String[]> parametersMap, String name, String value, String tag) {
		if (parametersMap != null)// 判断是map否为空
			// 将map的key取出来
			for (String key : parametersMap.keySet()) {
				// 判断key是否与name相等，相等就取出该key对应的参数数组
				if (key.equals(name)) {
					String[] strs = parametersMap.get(name);
					// 判断数组是否有效
					if (ValidateUtil.isValidate(strs)) {
						// 如果tag是text就直接取出数组的第一个数据返回显示
						if (tag.equals("text")) {
							return strs[0];
						} else {// 不是的话就判断是有存放一样的值有得话，就说明上次被选中的是它，返回tag
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
	 * 获取问题id
	 */
	public static String splitQustionId(String key, int begin) {
		if (key != null)
			return key.substring(begin);
		return null;
	}

	/**
	 * 将数组变成字符串，tag加以隔开
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
	 * 将问题id切出来，具体从那个位置开始，那个位置结束
	 */
	public static String splitQustionId(String key, int begin, int end) {
		if (ValidateUtil.isEmpty(key)) {
			return key.substring(begin, end);
		}
		return "";
	}
}
