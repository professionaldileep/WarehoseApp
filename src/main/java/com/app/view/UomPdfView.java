package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Uom;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class UomPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Paragraph p=new Paragraph("Hello UOM");
		document.add(p);
		@SuppressWarnings("unchecked")
		List<Uom> uoms=(List<Uom>)model.get("list");
		PdfPTable table=new PdfPTable(4);
		table.addCell("ID");
		table.addCell("TYPE");
		table.addCell("MODEL");
		table.addCell("NOTE");
		
		for(Uom u:uoms) {
			table.addCell(u.getId().toString());
			table.addCell(u.getUomType());
			table.addCell(u.getUomModel());
			table.addCell(u.getDescr());
		}
		document.add(table);
		document.add(new Paragraph(new Date().toString()));
	}

}
