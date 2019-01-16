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
	/* 生成图片为png类型 */
	public static final int PNG = 0;
	/* 生成图片为jpeg类型 */
	public static final int JPEG = 1;
	/* 平面饼图 */
	public static final int CHARTTYPE_PIE_2D = 0;
	/* 立体饼图 */
	public static final int CHARTTYPE_PIE_3D = 1;
	/* 水平平面柱状图 */
	public static final int CHARTTYPE_BAR_2D_H = 2;
	/* 竖直平面柱状图 */
	public static final int CHARTTYPE_BAR_2D_V = 3;
	/* 水平立体柱状图 */
	public static final int CHARTTYPE_BAR_3D_H = 4;
	/* 竖直立体柱状图 */
	public static final int CHARTTYPE_BAR_3D_V = 5;
	/* 平面折线图 */
	public static final int CHARTTYPE_LINE_2D = 6;
	/* 立体折线图 */
	public static final int CHARTTYPE_LINE_3D = 7;

	public static JFreeChart chart = null;

	/**
	 * @param title
	 *            标题
	 * @param map
	 *            数据
	 * @param path
	 *            存放路径
	 * @param flag
	 *            水平还是垂直
	 * @param imageType
	 *            图片存放类型
	 * @param w
	 *            宽
	 * @param h
	 *            高
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
			// 设置透明
			PiePlot3D plot = (PiePlot3D) chart.getPlot();
			plot.setForegroundAlpha(0.7f);
			// 没有数据的时候显示的内容
			plot.setNoDataMessage("无数据显示");
		}
		// 设置字体
		pieProcessChart(chart);
		if (w > 0 && h > 0)
			// 保存图片
			writeChartAsImage(chart, path, w, h, imageType);
		return chart;
	}

	/**
	 * 创建住状图
	 * 
	 * @param title
	 *            图形标题
	 * @param htitle
	 *            横标题
	 * @param vtitle
	 *            竖标题
	 * @param list
	 *            要显示的list数据
	 * @param path
	 *            要保存的路径
	 * @param flag
	 *            选择哪种模式展示
	 * @param imageType
	 *            图片保存类型
	 * @param w
	 *            图片宽
	 * @param h
	 *            图片高
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
			// 设置透明度
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
		// 设置字体
		processChart(chart);
		if (w > 0 && h > 0)
			// 保存图片
			writeChartAsImage(chart, path, w, h, imageType);
		return chart;
	}

	/**
	 * 线性图
	 */
	public static JFreeChart creatLine(String title, String htitle, String vtitle, List<Object[]> list, String path,
			int flag, int imageType, int w, int h) {
		// 设置图形数据
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
		// 设置字体
		processChart(chart);
		if (w > 0 && h > 0)
			// 保存图片
			writeChartAsImage(chart, path, w, h, imageType);
		return chart;

	}

	/**
	 * 保存图片
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
	 * 设置图字体
	 */
	private static void processChart(JFreeChart chart) {
		CategoryPlot plot = (CategoryPlot) chart.getCategoryPlot();
		CategoryAxis domainAxis = plot.getDomainAxis();
		ValueAxis rAxis = plot.getRangeAxis();
		chart.getRenderingHints().put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
		TextTitle textTitle = chart.getTitle();
		textTitle.setFont(new Font("宋体", Font.PLAIN, 20));
		domainAxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 11));
		domainAxis.setLabelFont(new Font("宋体", Font.PLAIN, 12));
		rAxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 12));
		rAxis.setLabelFont(new Font("宋体", Font.PLAIN, 12));
		chart.getLegend().setItemFont(new Font("宋体", Font.PLAIN, 12));
	}

	/**
	 * 设置图字体
	 */
	private static void pieProcessChart(JFreeChart chart) {
		PiePlot plot = (PiePlot) chart.getPlot();
		plot.setLabelFont(new Font("宋体", Font.PLAIN, 20));
		plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}={1}({2})", NumberFormat.getNumberInstance(),
				new DecimalFormat("0.00%")));
		chart.getRenderingHints().put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
		TextTitle textTitle = chart.getTitle();
		textTitle.setFont(new Font("宋体", Font.PLAIN, 20));
		chart.getLegend().setItemFont(new Font("宋体", Font.PLAIN, 12));
	}

	/**
	 * 设置图片数据
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
