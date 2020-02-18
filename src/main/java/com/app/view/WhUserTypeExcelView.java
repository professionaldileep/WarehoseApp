package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.WhUserType;

public class WhUserTypeExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.addHeader("content-disposition", "attachment;filename=whuser.xlsx");
		
		@SuppressWarnings("unchecked")
		List<WhUserType> list=(List<WhUserType>)model.get("list");
		
		//create New Sheet
		Sheet sheet=workbook.createSheet("WhUserTypesheet");
		
		addHeader(sheet);
		addBody(sheet,list);
	}


	private void addHeader(Sheet sheet) {
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("userType");
		row.createCell(2).setCellValue("userCode");
		row.createCell(3).setCellValue("userFor");
		row.createCell(4).setCellValue("userEmail");
		row.createCell(5).setCellValue("userContact");
		row.createCell(6).setCellValue("uidType");
		row.createCell(7).setCellValue("other");
		row.createCell(8).setCellValue("uidNumber");
	}

	private void addBody(Sheet sheet, List<WhUserType> list) {
		int rowNum=1;
		for(WhUserType w:list) {
			Row row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(w.getId());
			row.createCell(1).setCellValue(w.getUserType());
			row.createCell(2).setCellValue(w.getUserCode());
			row.createCell(3).setCellValue(w.getUserFor());
			row.createCell(4).setCellValue(w.getUserEmail());
			row.createCell(5).setCellValue(w.getUserContact());
			row.createCell(6).setCellValue(w.getUidType());
			row.createCell(7).setCellValue(w.getOther());
			row.createCell(8).setCellValue(w.getUidNumber());
		}
	}

}
