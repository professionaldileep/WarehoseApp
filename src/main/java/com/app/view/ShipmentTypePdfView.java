package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.ShipmentType;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class ShipmentTypePdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Paragraph p=new Paragraph("SHIPMENTTYPE");
		document.add(p);
		@SuppressWarnings("unchecked")
		List<ShipmentType> st=(List<ShipmentType>)model.get("list");
		PdfPTable table=new PdfPTable(6);
		table.addCell("SHIPMENTTYPEID");
		table.addCell("SHIPMENTTYPEMODE");
		table.addCell("SHIPMENTTYPECODE");
		table.addCell("ENABLESHIPMENTTYPE");
		table.addCell("SHIPMENTTYPEGRADE");
		table.addCell("NOTE");
		for(ShipmentType s:st) {
			table.addCell(s.getId().toString());
			table.addCell(s.getShipmentMode());
			table.addCell(s.getShipmentCode());
			table.addCell(s.getEnable());
			table.addCell(s.getGrade());
			table.addCell(s.getDescr());
		}
		document.add(table);
		document.add(new Paragraph(new Date().toString()));
	}

}
