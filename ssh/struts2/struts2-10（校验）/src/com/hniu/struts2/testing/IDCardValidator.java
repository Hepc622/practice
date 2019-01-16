package com.hniu.struts2.testing;

import com.opensymphony.xwork2.validator.ValidationException;
import com.opensymphony.xwork2.validator.validators.FieldValidatorSupport;

public class IDCardValidator extends FieldValidatorSupport {

	public void validate(Object object) throws ValidationException {
		// 1.获取字段和值
		String fieldName = getFieldName();
		Object value = getFieldValue(fieldName, object);
		// 2.进行验证
		IDCard idCard = new IDCard();
		boolean verify = idCard.Verify((String) value);
		// 3.验证失败，添加信息
		if (!verify) {
			addFieldError(fieldName, object);
		}
	}

}
