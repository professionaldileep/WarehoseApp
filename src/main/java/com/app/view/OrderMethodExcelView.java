package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.OrderMethod;

public class OrderMethodExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.addHeader("content-disposition", "attachment;filename=ordermethod.xlsx");
		
		/* ReadData */
		@SuppressWarnings("unchecked")
		List<OrderMethod> list=(List<OrderMethod>)model.get("list");
		
		Sheet sheet= workbook.createSheet("OrderMethods");
		
		addHeader(sheet);
		addBody(sheet,list);
	}

	private void addHeader(Sheet sheet) {
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("OrderMode");
		row.createCell(2).setCellValue("OrderCode");
		row.createCell(3).setCellValue("OrderType");
		row.createCell(4).setCellValue("OrderAccept");
		row.createCell(5).setCellValue("NOTE");
	}

	private void addBody(Sheet sheet, List<OrderMethod> list) {
		int rowNum=1;
		for(OrderMethod m:list) {
			Row row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(m.getId());
			row.createCell(1).setCellValue(m.getOrderMode());
			row.createCell(2).setCellValue(m.getOrderCode());
			row.createCell(3).setCellValue(m.getOrderType());
			row.createCell(4).setCellValue(m.getOrderAccept().toString());
			row.createCell(5).setCellValue(m.getDescription());
		}
	}

}
