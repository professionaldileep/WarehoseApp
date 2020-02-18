package com.app.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;

@Component
public class UomUtil {
	
	public void genPie(String path,List<Object[]> list) {
//		1. Create DataSet
		DefaultPieDataset dataset= new DefaultPieDataset();
		
		for(Object[] ob:list) {
			dataset.setValue(ob[0].toString(), new Double(ob[1].toString()));
		}
//		2. Create JfreeChart Object
		JFreeChart chart= ChartFactory.createPieChart3D("Uom PieChart", dataset);
//		3. Save as Image
		try {
			ChartUtils.saveChartAsJPEG(new File(path+"/resources/images/Uompie.jpg"), chart, 400, 400);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void genBar(String path,List<Object[]> list) {
		DefaultCategoryDataset dataset=new DefaultCategoryDataset();
		for(Object[] ob:list) {
			dataset.setValue(new Double(ob[1].toString()), ob[0].toString(), "");
		}
		JFreeChart chart=ChartFactory.createBarChart("UomBarChart", "UomTypes", "Count", dataset);
		
		try {
			ChartUtils.saveChartAsJPEG(new File(path+"/resources/images/UomBar.jpg"), chart, 400, 400);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
