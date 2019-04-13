package com.viaflow.manager.api.model;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;

public class HeaderFooterPageEvent extends PdfPageEventHelper {

	private PdfTemplate t;
	private Image total;

	public void onOpenDocument(PdfWriter writer, Document document) {
		t = writer.getDirectContent().createTemplate(30, 16);
		try {
			total = Image.getInstance(t);
			total.setRole(PdfName.ARTIFACT);
		} catch (DocumentException de) {
			throw new ExceptionConverter(de);
		}
	}

	private void addFooter(PdfWriter writer) {
		PdfPTable footer = new PdfPTable(2);
		try {

			footer.setWidths(new int[] { 24, 3 });
			footer.setTotalWidth(527);
			footer.setLockedWidth(true);
			
			footer.getDefaultCell().setFixedHeight(40);
			footer.getDefaultCell().setBorder(Rectangle.TOP);
			footer.getDefaultCell().setBorderColor(BaseColor.BLACK);
			footer.getDefaultCell().setPaddingTop(6);
			footer.addCell(new Phrase("\u00A9 viaflow.com.br", new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD)));

			footer.getDefaultCell().setPaddingTop(12);
			footer.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
			footer.addCell(new Phrase(String.format("Page %d", writer.getPageNumber()),new Font(Font.FontFamily.HELVETICA, 8)));
						
			PdfContentByte canvas = writer.getDirectContent();
			canvas.beginMarkedContentSequence(PdfName.ARTIFACT);
			footer.writeSelectedRows(0, -1, 34, 34, canvas);
			canvas.endMarkedContentSequence();
			
			
		} catch (DocumentException de) {
			throw new ExceptionConverter(de);
		}
	}

	public void onStartPage(PdfWriter pdfWriter, Document document) {
		try {
			Image logo = Image.getInstance(HeaderFooterPageEvent.class.getResource("/logoviaflow.png"));
			logo.scaleToFit(120, 120);
			logo.setAbsolutePosition(document.right() - 250, document.top() + 60);
			logo.setAlignment(Element.ALIGN_TOP);
			pdfWriter.getDirectContent().addImage(logo);

			logo = Image.getInstance(HeaderFooterPageEvent.class.getResource("/ibmLogo.png"));
			logo.scaleToFit(100, 100);
			logo.setAbsolutePosition(document.right() - 100, document.top() + 40);
			logo.setAlignment(Element.ALIGN_TOP);
			pdfWriter.getDirectContent().addImage(logo);

		} catch (Exception e) {
			throw new ExceptionConverter(e);
		}
	}

	public void onEndPage(PdfWriter pdfWriter, Document document) {
		addFooter(pdfWriter);
	}
}
