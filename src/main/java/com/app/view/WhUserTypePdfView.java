package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.WhUserType;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class WhUserTypePdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.addHeader("content-disposition", "attachment;filename=whusertype.pdf");
		
		Paragraph p=new Paragraph("Hello WhUser");
		document.add(p);
		@SuppressWarnings("unchecked")
		List<WhUserType> list=(List<WhUserType>) model.get("list");
		
		PdfPTable table=new PdfPTable(9);
		table.addCell("ID");
		table.addCell("UserType");
		table.addCell("UserCode");
		table.addCell("userFor");
		table.addCell("userEmail");
		table.addCell("userContact");
		table.addCell("uidType");
		table.addCell("other");
		table.addCell("uidNumber");
		for(WhUserType wh:list) {
			table.addCell(wh.getId().toString());
			table.addCell(wh.getUserType());
			table.addCell(wh.getUserCode());
			table.addCell(wh.getUserFor());
			table.addCell(wh.getUserEmail());
			table.addCell(wh.getUserContact());
			table.addCell(wh.getUidType());
			table.addCell(wh.getOther());
			table.addCell(wh.getUidNumber());
		}
		document.add(table);
		document.add(new Paragraph(new Date().toString()));
	}

}
