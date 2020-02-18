package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.ShipmentType;

public class ShipmentTypeExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook book, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		
		@SuppressWarnings("unchecked")
		List<ShipmentType> list =(List<ShipmentType>)model.get("list");
		
		Sheet sheet=book.createSheet("ShipmentTypes");
		addHeader(sheet);
		addBody(sheet,list);
		
	}

	private void addHeader(Sheet sheet) {
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("ShipmentMode");
		row.createCell(2).setCellValue("ShipmentCode");
		row.createCell(3).setCellValue("EnableShipment");
		row.createCell(4).setCellValue("ShipmentGrade");
		row.createCell(5).setCellValue("Description");
	}

	private void addBody(Sheet sheet, List<ShipmentType> list) {
		int rowNum=1;
		for(ShipmentType st:list) {
			Row row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(st.getId());
			row.createCell(1).setCellValue(st.getShipmentMode());
			row.createCell(2).setCellValue(st.getShipmentCode());
			row.createCell(3).setCellValue(st.getEnable());
			row.createCell(4).setCellValue(st.getGrade());
			row.createCell(5).setCellValue(st.getDescr());
		}
	}

}
