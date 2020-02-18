package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.app.model.Sale;

public class SaleExcelView extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		@SuppressWarnings("unchecked")
		List<Sale> list=(List<Sale>) model.get("list");
		
		Sheet sheet=workbook.createSheet("Sale");
		
		addHeader(sheet);
		addBody(sheet,list);
	}

	private void addHeader(Sheet sheet) {
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("OrderCOde");
		row.createCell(2).setCellValue("ShipmentMode");
		row.createCell(3).setCellValue("Customer");
		row.createCell(4).setCellValue("RefNumber");
		row.createCell(5).setCellValue("StockMode");
		row.createCell(6).setCellValue("StockSource");
		row.createCell(7).setCellValue("DefStatus");
		row.createCell(8).setCellValue("NOTE");
	}

	private void addBody(Sheet sheet, List<Sale> list) {
		int rowNum=1;
		for(Sale s:list) {
			Row row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(s.getId().toString());
			row.createCell(1).setCellValue(s.getOrderCode());
			row.createCell(2).setCellValue(s.getShipmentCode().getShipmentCode());
			row.createCell(3).setCellValue(s.getCustomer().getUserCode());
			row.createCell(4).setCellValue(s.getRefNumber());
			row.createCell(5).setCellValue(s.getStockMode());
			row.createCell(6).setCellValue(s.getStockSource());
			row.createCell(7).setCellValue(s.getDefStatus());
			row.createCell(8).setCellValue(s.getDescription());
		}
	}

}
