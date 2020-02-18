package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Grn;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class GrnPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Paragraph p=new Paragraph("FromGrnPDF");
		document.add(p);
		@SuppressWarnings("unchecked")
		List<Grn> list= (List<Grn>) model.get("list");
		PdfPTable table=new PdfPTable(5);
		table.addCell("GrnID");
		table.addCell("GrnCode");
		table.addCell("GrnType");
		table.addCell("OrderCode");
		table.addCell("Description");
		
		for(Grn g:list) {
			table.addCell(g.getId().toString());
			table.addCell(g.getGrnCode());
			table.addCell(g.getGrnType());
			table.addCell(g.getPurchase().getOrderCode());
			table.addCell(g.getDescription());
		}
		
		document.add(table);
		document.add(new Paragraph(new Date().toString()));
	}

}
