package com.hniu.surveypark.strus2.action.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.hniu.surveypark.model.Answer;
import com.hniu.surveypark.model.Question;
import com.hniu.surveypark.model.Survey;
import com.hniu.surveypark.service.SurveyService;
import com.hniu.surveypark.strus2.action.BaseAction;

/**
 * 此类是：用于收集调查信息
 * 
 * @author: hpc
 * @version: 2016年12月6日 下午9:27:40
 */
public class CollectAction extends BaseAction<Survey> {
	private static final long serialVersionUID = 82744575214948588L;
	private SurveyService surveyService;
	private Integer surveyId;

	public void setSurveyService(SurveyService surveyService) {
		this.surveyService = surveyService;
	}

	public void setSurveyId(Integer surveyId) {
		this.surveyId = surveyId;
	}

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

	/**
	 * 收集调查信息
	 */
	@SuppressWarnings({ "resource" })
	public InputStream getOutexcel() {
		ByteArrayOutputStream baos = null;
		ByteArrayInputStream bais = null;
		List<Question> question = surveyService.getAllQuestion(surveyId);
		List<Answer> anwser = surveyService.allAnwser(surveyId);
		// 声明一个工作薄
		HSSFWorkbook work = new HSSFWorkbook();
		// 纸张
		HSSFSheet sheet = work.createSheet();
		sheet.setAutobreaks(true);
		// 创建标题栏
		HSSFRow row = sheet.createRow(0);
		// 创建单元
		HSSFCell cell = row.createCell(0);
		// 创建一个map记录没每列对应的问题id
		Map<String, Integer> map = new HashMap<String, Integer>();
		// 设置标题
		for (int x = 0; x < question.size(); x++) {
			cell = row.createCell(x);
			cell.setCellValue(question.get(x).getQuestion_title());
			map.put(question.get(x).getQuestion_title(), x);
		}
		int r = 0;
		String olduuid = "";
		for (int x = 0; x < anwser.size(); x++) {
			Answer answer = anwser.get(x);
			Question q = surveyService.getQuestion(answer.getQuestion_id());
			// 判断该答案是否与你上次的相等，不想等就换行
			if (!answer.getUuId().equals(olduuid)) {
				r++;
				row = sheet.createRow(r);
				olduuid = answer.getUuId();
			}
			// 找到指定的列，为其生成对应的单元信息
			cell = row.createCell(map.get(q.getQuestion_title()));
			// 设置单元值
			cell.setCellValue(answer.getQuestion_answer());
		}
		try {// 写入到流中
			baos = new ByteArrayOutputStream(1024);
			work.write(baos);
			bais = new ByteArrayInputStream(baos.toByteArray());
			return bais;
		} catch (

		IOException e) {
			e.printStackTrace();
		} finally {

			try {
				baos.close();
				bais.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}