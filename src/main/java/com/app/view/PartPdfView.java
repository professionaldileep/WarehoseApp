package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Part;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class PartPdfView extends AbstractPdfView implements View {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.addHeader("content-disposition", "attachment;filename=part.pdf");
		// TODO Auto-generated method stub

		
		Paragraph p = new Paragraph("WelCome TO PartPDF");
		document.add(p);
		
		@SuppressWarnings("unchecked")
		List<Part> list=(List<Part>) model.get("list");
		
		PdfPTable table=new PdfPTable(9);
		table.addCell("ID");
		table.addCell("PartCode");
		table.addCell("Dimensions");
		table.addCell("BaseCost");
		table.addCell("BaseCurrency");
		table.addCell("UOM");
		table.addCell("Sale");
		table.addCell("Purchase");
		table.addCell("NOTE");
		
		
		for(Part part:list) {
			table.addCell(part.getId().toString());
			table.addCell(part.getCode());
			table.addCell(" W: "+part.getWidth().toString()+" L: "+part.getLength().toString()+" H: "+part.getHeight().toString());
			table.addCell(part.getBaseCost().toString());
			table.addCell(part.getBaseCurr());
			table.addCell(part.getUom().getUomModel());
			table.addCell(part.getSale().getOrderCode());
			table.addCell(part.getPurchase().getOrderCode());
			table.addCell(part.getNote());
		}
		document.add(table);
		document.add(new Paragraph(new Date().toString()));
	}

}
