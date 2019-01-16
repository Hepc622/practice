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
 * �����ǣ������ռ�������Ϣ
 * 
 * @author: hpc
 * @version: 2016��12��6�� ����9:27:40
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
	 * �ռ�������Ϣ
	 */
	@SuppressWarnings({ "resource" })
	public InputStream getOutexcel() {
		ByteArrayOutputStream baos = null;
		ByteArrayInputStream bais = null;
		List<Question> question = surveyService.getAllQuestion(surveyId);
		List<Answer> anwser = surveyService.allAnwser(surveyId);
		// ����һ��������
		HSSFWorkbook work = new HSSFWorkbook();
		// ֽ��
		HSSFSheet sheet = work.createSheet();
		sheet.setAutobreaks(true);
		// ����������
		HSSFRow row = sheet.createRow(0);
		// ������Ԫ
		HSSFCell cell = row.createCell(0);
		// ����һ��map��¼ûÿ�ж�Ӧ������id
		Map<String, Integer> map = new HashMap<String, Integer>();
		// ���ñ���
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
			// �жϸô��Ƿ������ϴε���ȣ�����Ⱦͻ���
			if (!answer.getUuId().equals(olduuid)) {
				r++;
				row = sheet.createRow(r);
				olduuid = answer.getUuId();
			}
			// �ҵ�ָ�����У�Ϊ�����ɶ�Ӧ�ĵ�Ԫ��Ϣ
			cell = row.createCell(map.get(q.getQuestion_title()));
			// ���õ�Ԫֵ
			cell.setCellValue(answer.getQuestion_answer());
		}
		try {// д�뵽����
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