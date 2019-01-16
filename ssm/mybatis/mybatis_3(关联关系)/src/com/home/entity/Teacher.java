package com.home.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * �����ǣ���ʦ
 * @author hpc
 * @2017��1��14������7:06:47
 */
public class Teacher {
	private Integer teacher_id;// ��ʦid
	private String teacher_name;// ��ʦ����
	private Integer teacher_number;// ��ʦ���
	private Set<Student> teacher_student = new HashSet<Student>();// ��ʦ�̹���Щѧ��
	
	public Integer getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(Integer teacher_id) {
		this.teacher_id = teacher_id;
	}

	public String getTeacher_name() {
		return teacher_name;
	}

	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}

	public Integer getTeacher_number() {
		return teacher_number;
	}

	public void setTeacher_number(Integer teacher_number) {
		this.teacher_number = teacher_number;
	}

	public Set<Student> getTeacher_student() {
		return teacher_student;
	}

	public void setTeacher_student(Set<Student> teacher_student) {
		this.teacher_student = teacher_student;
	}

	@Override
	public String toString() {
		return "Teacher [teacher_id=" + teacher_id + ", teacher_name=" + teacher_name + ", teacher_number="
				+ teacher_number + ", teacher_student=" + teacher_student + "]";
	}
	
}
