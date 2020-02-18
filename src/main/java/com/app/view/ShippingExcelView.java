package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.Shipping;

public class ShippingExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		@SuppressWarnings("unchecked")
		List<Shipping> list=(List<Shipping>) model.get("list");
		Sheet sheet=workbook.createSheet("shipping excelsheet");
		
		addHeader(sheet);
		addBody(sheet,list);
	}

	private void addHeader(Sheet sheet) {
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("ShippingID");
		row.createCell(1).setCellValue("ShippingCode");
		row.createCell(2).setCellValue("ShippingRefNumber");
		row.createCell(3).setCellValue("CourierRefNumber");
		row.createCell(4).setCellValue("ContactDetails");
		row.createCell(5).setCellValue("SaleOrderCode");
		row.createCell(6).setCellValue("Description");
		row.createCell(7).setCellValue("BillToAddress");
		row.createCell(8).setCellValue("ShipToAddress");
	}

	private void addBody(Sheet sheet, List<Shipping> list) {
		int rowNum=1;
		Row row=sheet.createRow(rowNum++);
		for(Shipping s:list) {
		row.createCell(0).setCellValue(s.getId());
		row.createCell(1).setCellValue(s.getShippingCode());
		row.createCell(2).setCellValue(s.getShippingRefNum());
		row.createCell(3).setCellValue(s.getCourierRefNum());
		row.createCell(4).setCellValue(s.getContactDetails());
		row.createCell(5).setCellValue(s.getSaleOrderCode());
		row.createCell(6).setCellValue(s.getDescription());
		row.createCell(7).setCellValue(s.getBillToAddr());
		row.createCell(8).setCellValue(s.getShipToAddr());
		}
	}

}
