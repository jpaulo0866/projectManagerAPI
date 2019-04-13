package com.viaflow.manager.api.model;

import java.util.stream.Stream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.viaflow.manager.api.entity.project.Project;

public class PdfTableGuarantees {

	BaseColor borderColor = BaseColor.WHITE;

	public void addTableHeader(PdfPTable table) {
		Stream.of("Garantias ").forEach(columnTitle -> {
			PdfPCell header = new PdfPCell();
			com.itextpdf.text.Font fontStyle = new com.itextpdf.text.Font();
			fontStyle.setColor(new BaseColor(242, 242, 242));

			header.setBackgroundColor(new BaseColor(20, 129, 196));
			header.setBorderWidth(1);
			header.setBorderColor(borderColor);
			header.setPadding(5);
			header.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
			header.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
			header.setPhrase(new Phrase(columnTitle, fontStyle));
			table.addCell(header);
		});
	}

	public void addRows(PdfPTable table, Project project, GenerateEstimate estimate) {
		int i = 0;
		for (String guarantees : estimate.getGuarantees()) {
			PdfPCell cellGuarantees = new PdfPCell(new Phrase(guarantees));
			cellGuarantees.setPadding(5);
			cellGuarantees.setPaddingLeft(2);
			cellGuarantees.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
			cellGuarantees.setBorderColor(borderColor);

			if (i % 2 == 0) {
				cellGuarantees.setBackgroundColor(new BaseColor(184, 204, 228));

			} else {
				cellGuarantees.setBackgroundColor(new BaseColor(242, 242, 242));
			}

			table.addCell(cellGuarantees);
			i++;
		}
	}
}
