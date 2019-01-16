package com.hniu.surveypark.util;

import java.awt.Font;
import java.awt.RenderingHints;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public final class JfreeChartUtil {
	/* ����ͼƬΪpng���� */
	public static final int PNG = 0;
	/* ����ͼƬΪjpeg���� */
	public static final int JPEG = 1;
	/* ƽ���ͼ */
	public static final int CHARTTYPE_PIE_2D = 0;
	/* �����ͼ */
	public static final int CHARTTYPE_PIE_3D = 1;
	/* ˮƽƽ����״ͼ */
	public static final int CHARTTYPE_BAR_2D_H = 2;
	/* ��ֱƽ����״ͼ */
	public static final int CHARTTYPE_BAR_2D_V = 3;
	/* ˮƽ������״ͼ */
	public static final int CHARTTYPE_BAR_3D_H = 4;
	/* ��ֱ������״ͼ */
	public static final int CHARTTYPE_BAR_3D_V = 5;
	/* ƽ������ͼ */
	public static final int CHARTTYPE_LINE_2D = 6;
	/* ��������ͼ */
	public static final int CHARTTYPE_LINE_3D = 7;

	public static JFreeChart chart = null;

	/**
	 * @param title
	 *            ����
	 * @param map
	 *            ����
	 * @param path
	 *            ���·��
	 * @param flag
	 *            ˮƽ���Ǵ�ֱ
	 * @param imageType
	 *            ͼƬ�������
	 * @param w
	 *            ��
	 * @param h
	 *            ��
	 */
	public static JFreeChart creatPie(String title, Map<String, Number> map, String path, int flag, int imageType,
			int w, int h) {
		DefaultPieDataset dataSet = new DefaultPieDataset();
		for (Entry<String, Number> entry : map.entrySet()) {
			dataSet.setValue(entry.getKey(), entry.getValue());
		}
		if (flag == CHARTTYPE_PIE_2D) {
			chart = ChartFactory.createPieChart(title, dataSet);
		} else if (flag == CHARTTYPE_PIE_3D) {
			chart = ChartFactory.createPieChart3D(title, dataSet);
			// ����͸��
			PiePlot3D plot = (PiePlot3D) chart.getPlot();
			plot.setForegroundAlpha(0.7f);
			// û�����ݵ�ʱ����ʾ������
			plot.setNoDataMessage("��������ʾ");
		}
		// ��������
		pieProcessChart(chart);
		if (w > 0 && h > 0)
			// ����ͼƬ
			writeChartAsImage(chart, path, w, h, imageType);
		return chart;
	}

	/**
	 * ����ס״ͼ
	 * 
	 * @param title
	 *            ͼ�α���
	 * @param htitle
	 *            �����
	 * @param vtitle
	 *            ������
	 * @param list
	 *            Ҫ��ʾ��list����
	 * @param path
	 *            Ҫ�����·��
	 * @param flag
	 *            ѡ������ģʽչʾ
	 * @param imageType
	 *            ͼƬ��������
	 * @param w
	 *            ͼƬ��
	 * @param h
	 *            ͼƬ��
	 * @return
	 */
	public static JFreeChart creatBar(String title, String htitle, String vtitle, List<Object[]> list, String path,
			int flag, int imageType, int w, int h) {
		DefaultCategoryDataset dataset = getBarOrLineData(list);
		CategoryPlot plot = null;
		switch (flag) {
		case CHARTTYPE_BAR_2D_H:
			chart = ChartFactory.createBarChart(title, htitle, vtitle, dataset, PlotOrientation.HORIZONTAL, true, false,
					false);
			break;
		case CHARTTYPE_BAR_3D_H:
			chart = ChartFactory.createBarChart3D(title, htitle, vtitle, dataset, PlotOrientation.HORIZONTAL, true,
					false, false);
			plot = chart.getCategoryPlot();
			plot.setForegroundAlpha(0.7f);
			// ����͸����
			break;
		case CHARTTYPE_BAR_2D_V:
			chart = ChartFactory.createBarChart(title, htitle, vtitle, dataset, PlotOrientation.VERTICAL, true, false,
					false);
			break;
		case CHARTTYPE_BAR_3D_V:
			chart = ChartFactory.createBarChart3D(title, htitle, vtitle, dataset, PlotOrientation.VERTICAL, true, false,
					false);
			plot = chart.getCategoryPlot();
			plot.setForegroundAlpha(0.7f);
			break;
		}
		// ��������
		processChart(chart);
		if (w > 0 && h > 0)
			// ����ͼƬ
			writeChartAsImage(chart, path, w, h, imageType);
		return chart;
	}

	/**
	 * ����ͼ
	 */
	public static JFreeChart creatLine(String title, String htitle, String vtitle, List<Object[]> list, String path,
			int flag, int imageType, int w, int h) {
		// ����ͼ������
		CategoryDataset dataset = getBarOrLineData(list);

		if (flag == CHARTTYPE_LINE_2D) {
			chart = ChartFactory.createLineChart(title, htitle, vtitle, dataset, PlotOrientation.VERTICAL, true, true,
					true);
		} else if (flag == CHARTTYPE_LINE_3D) {
			chart = ChartFactory.createLineChart3D(title, htitle, vtitle, dataset, PlotOrientation.VERTICAL, true, true,
					true);
			CategoryPlot plot = chart.getCategoryPlot();
			plot.setForegroundAlpha(0.7f);
		}
		// ��������
		processChart(chart);
		if (w > 0 && h > 0)
			// ����ͼƬ
			writeChartAsImage(chart, path, w, h, imageType);
		return chart;

	}

	/**
	 * ����ͼƬ
	 */
	private static void writeChartAsImage(JFreeChart chart, String path, int w, int h, int imageType) {
		FileOutputStream fos_jpg = null;
		try {
			fos_jpg = new FileOutputStream(path);
			switch (imageType) {
			case PNG:
				ChartUtilities.writeChartAsPNG(fos_jpg, chart, w, h, null);
				break;
			case JPEG:
				ChartUtilities.writeChartAsJPEG(fos_jpg, chart, w, h, null);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fos_jpg.close();
			} catch (Exception e) {
			}
		}
	}

	/**
	 * ����ͼ����
	 */
	private static void processChart(JFreeChart chart) {
		CategoryPlot plot = (CategoryPlot) chart.getCategoryPlot();
		CategoryAxis domainAxis = plot.getDomainAxis();
		ValueAxis rAxis = plot.getRangeAxis();
		chart.getRenderingHints().put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
		TextTitle textTitle = chart.getTitle();
		textTitle.setFont(new Font("����", Font.PLAIN, 20));
		domainAxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 11));
		domainAxis.setLabelFont(new Font("����", Font.PLAIN, 12));
		rAxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 12));
		rAxis.setLabelFont(new Font("����", Font.PLAIN, 12));
		chart.getLegend().setItemFont(new Font("����", Font.PLAIN, 12));
	}

	/**
	 * ����ͼ����
	 */
	private static void pieProcessChart(JFreeChart chart) {
		PiePlot plot = (PiePlot) chart.getPlot();
		plot.setLabelFont(new Font("����", Font.PLAIN, 20));
		plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}={1}({2})", NumberFormat.getNumberInstance(),
				new DecimalFormat("0.00%")));
		chart.getRenderingHints().put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
		TextTitle textTitle = chart.getTitle();
		textTitle.setFont(new Font("����", Font.PLAIN, 20));
		chart.getLegend().setItemFont(new Font("����", Font.PLAIN, 12));
	}

	/**
	 * ����ͼƬ����
	 * 
	 * @param list
	 * @return DefaultCategoryDataset
	 */
	private static DefaultCategoryDataset getBarOrLineData(List<Object[]> list) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (Object[] o : list) {
			dataset.addValue((Integer) o[0], o[1] + "", o[2] + "");
		}
		return dataset;
	}
}
