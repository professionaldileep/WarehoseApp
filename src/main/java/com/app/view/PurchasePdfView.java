package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Purchase;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class PurchasePdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Paragraph p=new Paragraph("Purchase PdfView");
		document.add(p);
		@SuppressWarnings("unchecked")
		List<Purchase> purchase=(List<Purchase>) model.get("purchase");
		PdfPTable table=new PdfPTable(8);
		table.addCell("ID");
		table.addCell("OrderCode");
		table.addCell("ShipmentMode");
		table.addCell("Vendor");
		table.addCell("ReferenceNumber");
		table.addCell("QualityCheck");
		table.addCell("DefaultStatus");
		table.addCell("Description");
		for(Purchase p1 :purchase) {
			table.addCell(p1.getId().toString());
			table.addCell(p1.getOrderCode());
			table.addCell(p1.getShipmentCode().getShipmentCode());
			table.addCell(p1.getVendor().getUserCode());
			table.addCell(p1.getReferenceNum());
			table.addCell(p1.getQualityCheck());
			table.addCell(p1.getDefaultStatus());
			table.addCell(p1.getDescription());
		}
		document.add(table);
		document.add(new Paragraph(new Date().toString()));
	}

}