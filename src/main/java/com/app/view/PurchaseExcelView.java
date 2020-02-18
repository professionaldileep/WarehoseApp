package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.Purchase;

public class PurchaseExcelView extends AbstractXlsxView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		@SuppressWarnings("unchecked")
		List<Purchase> list=(List<Purchase>) model.get("purchase");
		Sheet sheet=workbook.createSheet("Purchase");
		addHeader(sheet);
		addBody(sheet,list);
	}


	private void addHeader(Sheet sheet) {
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("OrderCode");
		row.createCell(2).setCellValue("ShipmentMode");
		row.createCell(3).setCellValue("Vendor");
		row.createCell(4).setCellValue("ReferenceNumber");
		row.createCell(5).setCellValue("QualityCheck");
		row.createCell(6).setCellValue("DefaultStatus");
		row.createCell(7).setCellValue("Description");
	}
	
	private void addBody(Sheet sheet,List<Purchase> list) {
		int rowNum=1;
		for(Purchase p:list) {
			Row row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(p.getId());
			row.createCell(1).setCellValue(p.getOrderCode());
			row.createCell(2).setCellValue(p.getShipmentCode().getShipmentCode());
			row.createCell(3).setCellValue(p.getVendor().getUserCode());
			row.createCell(4).setCellValue(p.getReferenceNum());
			row.createCell(5).setCellValue(p.getQualityCheck());
			row.createCell(6).setCellValue(p.getDefaultStatus());
			row.createCell(7).setCellValue(p.getDescription());
		}
	}


	
}
