package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.OrderMethod;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class OrderMethodPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Paragraph p=new Paragraph("OrderMethod PDF");
		document.add(p);
		
		@SuppressWarnings("unchecked")
		List<OrderMethod> list=(List<OrderMethod>)model.get("list");
		PdfPTable table=new PdfPTable(6);
		table.addCell("ID");
		table.addCell("OrderMode");
		table.addCell("OrderCode");
		table.addCell("OrderType");
		table.addCell("OrderAccept");
		table.addCell("NOTE");
		
		for(OrderMethod m: list) {
			table.addCell(m.getId().toString());
			table.addCell(m.getOrderMode());
			table.addCell(m.getOrderCode());
			table.addCell(m.getOrderType());
			table.addCell(m.getOrderAccept().toString());
			table.addCell(m.getDescription());
		}
		document.add(table);
		document.add(new Paragraph( new Date().toString()));
	}

}