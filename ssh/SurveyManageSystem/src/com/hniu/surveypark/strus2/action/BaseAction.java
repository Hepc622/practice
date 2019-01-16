package com.hniu.surveypark.strus2.action;

import java.lang.reflect.ParameterizedType;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.Validateable;

/**
 * ���ڼ̳е�BaseAction
 */
public abstract class BaseAction<T> extends ActionSupport implements ModelDriven<T>, Preparable, Validateable {

	private static final long serialVersionUID = 1L;
	public T model;

	@SuppressWarnings("unchecked")
	public BaseAction() {
		try {
			ParameterizedType superclass = (ParameterizedType) this.getClass().getGenericSuperclass();
			@SuppressWarnings("rawtypes")
			Class clazz = (Class) superclass.getActualTypeArguments()[0];
			model = (T) clazz.newInstance();
		} catch (Exception e) {
		}
	}

	public void prepare() throws Exception {
	}

	// ����model��֮��Ķ���ظ��������ڸ�����д����ꡣ����������
	// public abstract T getModel();
	public T getModel() {
		return model;
	}
}
