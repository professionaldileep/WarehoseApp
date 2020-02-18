package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.Part;

public class PartExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.addHeader("content-disposition", "attachment;filename=part.xlsx");
		// TODO Auto-generated method stub

		@SuppressWarnings("unchecked")
		List<Part> list=(List<Part>) model.get("list");

		Sheet sheet=workbook.createSheet("Parts");

		addHeader(sheet);
		addFooter(sheet, list);
	}

	private void addHeader(Sheet sheet) {
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("Dimensions");
		row.createCell(2).setCellValue("BaseCost");
		row.createCell(3).setCellValue("BaseCurrency");
		row.createCell(4).setCellValue("UOM");
		row.createCell(5).setCellValue("SALE");
		row.createCell(6).setCellValue("PURCHASE");
		row.createCell(7).setCellValue("NOTE");
	}

	private void addFooter(Sheet sheet, List<Part> list) {
		// TODO Auto-generated method stub
		int rowNum=1;
		for(Part p:list) {
			Row row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(p.getId());
			row.createCell(1).setCellValue("W:"+p.getWidth()+"L:"+p.getLength()+"H:"+p.getHeight());
			row.createCell(2).setCellValue(p.getBaseCost());
			row.createCell(3).setCellValue(p.getBaseCurr());
			row.createCell(4).setCellValue(p.getUom().getUomModel());
			row.createCell(5).setCellValue(p.getSale().getOrderCode());
			row.createCell(6).setCellValue(p.getPurchase().getOrderCode());
			row.createCell(7).setCellValue(p.getNote());
			
		}
	}

}