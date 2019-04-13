package com.viaflow.manager.global;

import java.io.OutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.viaflow.manager.api.model.HeaderFooterPageEvent;

public class WritePDF {
	public static Document getPDFWritter(OutputStream out) throws DocumentException {
		Document document = new Document(PageSize.A4, 36, 36, 90, 36);
		PdfWriter pdfWritter = PdfWriter.getInstance(document, out);
		HeaderFooterPageEvent event = new HeaderFooterPageEvent();
		pdfWritter.setPageEvent(event);
		
		document.open();
		
		return document;
	}
}
