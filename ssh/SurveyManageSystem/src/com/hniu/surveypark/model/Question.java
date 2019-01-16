package com.hniu.surveypark.model;

import java.io.Serializable;

import com.hniu.surveypark.util.StringUtil;

/**
 * ������
 */
@SuppressWarnings("unused")
public class Question implements Serializable {
	private static final long serialVersionUID = -6962935220249436708L;
	public static final String RN = "\r\n";
	private transient Integer question_id;
	// ��������
	private Integer question_type;
	// �������
	private String question_title;
	// ����ѡ��
	private String question_options;
	private String[] question_optionArr;
	// ������
	private boolean question_other = false;
	// ����ѡ����ʽ��0-�ޣ�1-�ı���2-�����б�
	private Integer question_other_style;
	// ����������ѡ��
	private String question_other_select_options;
	private String[] question_other_select_optionArr;
	// ����ʽ�б��⼯
	private String question_other_matrix_row_titles;
	private String[] question_other_matrix_row_titleArr;
	// ����ʽ�б��⼯
	private String question_other_matrix_col_titles;
	private String[] question_other_matrix_col_titleArr;
	// ����ʽ����ѡ�
	private String question_other_matrix_select_options;
	private String[] question_other_matrix_select_optionArr;

	public String[] getQuestion_optionArr() {
		return StringUtil.StringToArray(question_options, RN);
	}

	public String[] getQuestion_other_select_optionArr() {
		return StringUtil.StringToArray(question_other_select_options, RN);
	}

	public String[] getQuestion_other_matrix_row_titleArr() {
		return StringUtil.StringToArray(question_other_matrix_row_titles, RN);
	}

	public String[] getQuestion_other_matrix_col_titleArr() {
		return StringUtil.StringToArray(question_other_matrix_col_titles, RN);
	}

	public String[] getQuestion_other_matrix_select_optionArr() {
		return StringUtil.StringToArray(question_other_matrix_select_options, RN);
	}

	private Page page = new Page();

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public Integer getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(Integer question_id) {
		this.question_id = question_id;
	}

	public Integer getQuestion_type() {
		return question_type;
	}

	public void setQuestion_type(Integer question_type) {
		this.question_type = question_type;
	}

	public String getQuestion_title() {
		return question_title;
	}

	public void setQuestion_title(String question_title) {
		this.question_title = question_title;
	}

	public String getQuestion_options() {
		return question_options;
	}

	public void setQuestion_options(String question_options) {
		this.question_options = question_options;
	}

	public boolean isQuestion_other() {
		return question_other;
	}

	public void setQuestion_other(boolean question_other) {
		this.question_other = question_other;
	}

	public Integer getQuestion_other_style() {
		return question_other_style;
	}

	public void setQuestion_other_style(Integer question_other_style) {
		this.question_other_style = question_other_style;
	}

	public String getQuestion_other_select_options() {
		return question_other_select_options;
	}

	public void setQuestion_other_select_options(String question_other_select_options) {
		this.question_other_select_options = question_other_select_options;
		if (question_options == null) {
			this.question_options = question_other_select_options;
		}
	}

	public String getQuestion_other_matrix_row_titles() {
		return question_other_matrix_row_titles;
	}

	public void setQuestion_other_matrix_row_titles(String question_other_matrix_row_titles) {
		this.question_other_matrix_row_titles = question_other_matrix_row_titles;
	}

	public String getQuestion_other_matrix_col_titles() {
		return question_other_matrix_col_titles;
	}

	public void setQuestion_other_matrix_col_titles(String question_other_matrix_col_titles) {
		this.question_other_matrix_col_titles = question_other_matrix_col_titles;
	}

	public String getQuestion_other_matrix_select_options() {
		return question_other_matrix_select_options;
	}

	public void setQuestion_other_matrix_select_options(String question_other_matrix_select_options) {
		if (question_other_matrix_select_options == null || question_other_matrix_select_options.equals("")) {
			this.question_other_matrix_select_options = getQuestion_other_matrix_col_titles();
		} else {
			this.question_other_matrix_select_options = question_other_matrix_select_options;
		}
	}
}
