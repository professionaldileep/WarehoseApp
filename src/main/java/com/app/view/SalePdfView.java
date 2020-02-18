package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Sale;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class SalePdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Paragraph p=new Paragraph("Sale PDF View");
		document.add(p);
		
		@SuppressWarnings("unchecked")
		List<Sale> list=(List<Sale>)model.get("list");
		
		PdfPTable table= new PdfPTable(9);
		table.addCell("ID");
		table.addCell("OrderCOde");
		table.addCell("ShipmentMode");
		table.addCell("Customer");
		table.addCell("RefNumber");
		table.addCell("StockMode");
		table.addCell("StockSource");
		table.addCell("DefStatus");
		table.addCell("NOTE");
		
		for(Sale s:list) {
			table.addCell(s.getId().toString());
			table.addCell(s.getOrderCode());
			table.addCell(s.getShipmentCode().getShipmentCode());
			table.addCell(s.getCustomer().getUserCode());
			table.addCell(s.getRefNumber());
			table.addCell(s.getStockMode());
			table.addCell(s.getStockSource());
			table.addCell(s.getDefStatus());
			table.addCell(s.getDescription());
		}
		document.add(table);
		document.add(new Paragraph( new Date().toString()));
		
	}

}
