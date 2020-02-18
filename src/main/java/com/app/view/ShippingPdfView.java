package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Shipping;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class ShippingPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Paragraph p=new Paragraph("ShippingPDF");
		document.add(p);
		PdfPTable table=new PdfPTable(9);
		table.addCell("ShippingID");
		table.addCell("ShippingCode");
		table.addCell("ShippingRefNumber");
		table.addCell("CourierRefNumber");
		table.addCell("Contact Details");
		table.addCell("Sale OrderCode");
		table.addCell("Description");
		table.addCell("BillToAddress");
		table.addCell("ShipToAddress");
		
		@SuppressWarnings("unchecked")
		List<Shipping> shipping= (List<Shipping>) model.get("list");
		for(Shipping s:shipping) {
			table.addCell(s.getId().toString());
			table.addCell(s.getShippingCode());
			table.addCell(s.getShippingRefNum());
			table.addCell(s.getCourierRefNum());
			table.addCell(s.getContactDetails());
			table.addCell(s.getSaleOrderCode());
			table.addCell(s.getDescription());
			table.addCell(s.getBillToAddr());
			table.addCell(s.getShipToAddr());
		}
		document.add(table);
		document.add(new Paragraph(new Date().toString()));
	}

}
