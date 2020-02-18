package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.Grn;

public class GrnExcelView extends AbstractXlsxView{
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		@SuppressWarnings("unchecked")
		List<Grn> list=(List<Grn>) model.get("list");
		
		Sheet sheet= workbook.createSheet("grn");
		
		addHeader(sheet);
		addBody(sheet,list);
	}

	private void addHeader(Sheet sheet) {
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("GrnCode");
		row.createCell(2).setCellValue("GrnType");
		row.createCell(3).setCellValue("OrderCode");
		row.createCell(4).setCellValue("description");
	}

	private void addBody(Sheet sheet, List<Grn> list) {
		int rowNum=1;
		for(Grn g:list) {
			Row row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(g.getId());
			row.createCell(1).setCellValue(g.getGrnCode());
			row.createCell(2).setCellValue(g.getGrnType());
			row.createCell(3).setCellValue(g.getPurchase().getOrderCode());
			row.createCell(4).setCellValue(g.getDescription());
		}
	}
}
