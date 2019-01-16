package com.hniu.springmvc.transverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * �����ǣ�converter class
 * 
 * @author hpc
 * @2017��2��23������4:46:41
 */
@Component
public class StringToDate implements Converter<String, Date> {

	@Override
	public Date convert(String str) {
		if (str != null && str.length() > 0) {
			try {
				// ���ַ���ת����date����
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				Date date = format.parse(str);
				return date;
			} catch (ParseException e) {
			}
		}
		return null;
	}

}
