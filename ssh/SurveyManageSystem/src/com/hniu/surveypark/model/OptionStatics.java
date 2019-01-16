package com.hniu.surveypark.model;

/**
 * 选项统计
 */
public class OptionStatics {
	private Integer option_index;
	private String option_label;
	private Integer option_count;

	private String matrix_row_label;
	private String matrix_col_label;
	private Integer matrix_row_index;
	private Integer matrix_col_index;

	public Integer getOption_index() {
		return option_index;
	}

	public void setOption_index(Integer option_index) {
		this.option_index = option_index;
	}

	public String getOption_label() {
		return option_label;
	}

	public void setOption_label(String option_label) {
		this.option_label = option_label;
	}

	public Integer getOption_count() {
		return option_count;
	}

	public void setOption_count(Integer option_count) {
		this.option_count = option_count;
	}

	public String getMatrix_row_label() {
		return matrix_row_label;
	}

	public void setMatrix_row_label(String matrix_row_label) {
		this.matrix_row_label = matrix_row_label;
	}

	public String getMatrix_col_label() {
		return matrix_col_label;
	}

	public void setMatrix_col_label(String matrix_col_label) {
		this.matrix_col_label = matrix_col_label;
	}

	public Integer getMatrix_row_index() {
		return matrix_row_index;
	}

	public void setMatrix_row_index(Integer matrix_row_index) {
		this.matrix_row_index = matrix_row_index;
	}

	public Integer getMatrix_col_index() {
		return matrix_col_index;
	}

	public void setMatrix_col_index(Integer matrix_col_index) {
		this.matrix_col_index = matrix_col_index;
	}

	@Override
	public String toString() {
		return "OptionStatics [option_index=" + option_index + ", option_label=" + option_label + ", option_count="
				+ option_count + ", matrix_row_label=" + matrix_row_label + ", matrix_col_label=" + matrix_col_label
				+ ", matrix_row_index=" + matrix_row_index + ", matrix_col_index=" + matrix_col_index + "]";
	}

}
