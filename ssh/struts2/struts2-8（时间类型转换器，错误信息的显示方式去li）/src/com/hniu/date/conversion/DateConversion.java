package com.hniu.date.conversion;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

public class DateConversion extends StrutsTypeConverter {
	private DateFormat date;

	public DateConversion() {
		System.out.println("DateConversion");
		this.date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	}

	// 将string类型转换成指定类型
	public Object convertFromString(@SuppressWarnings("rawtypes") Map arg0, String[] arg1, @SuppressWarnings("rawtypes") Class arg2) {
		if (arg2 == Date.class) {
			if (arg1.length > 0 && arg1 != null) {
				try {
					System.out.println(date.parse(arg1[0]));
					return date.parse(arg1[0]);
				} catch (ParseException e) {
				}
			}
		}
		return arg1;
	}

	// 将指定了类型转换成string类型
	public String convertToString(@SuppressWarnings("rawtypes") Map arg0, Object arg1) {
		if (arg1 instanceof Date) {
			System.out.println("将类型转换成字符串" + date.format(arg1));
			return date.format(arg1);
		}
		return null;
	}

}
