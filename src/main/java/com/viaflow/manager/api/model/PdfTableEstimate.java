package com.viaflow.manager.api.model;

import java.text.DecimalFormat;
import java.util.stream.Stream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.viaflow.manager.api.entity.project.Project;

public class PdfTableEstimate {

	BaseColor borderColor = BaseColor.WHITE;

	public void addTableHeader(PdfPTable table) {
		Stream.of("Atividades ", "Horas").forEach(columnTitle -> {
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

	public void addTableFooter(PdfPTable table, GenerateEstimate estimate) {
		PdfPCell header = new PdfPCell();

		com.itextpdf.text.Font fontStyle = new com.itextpdf.text.Font();
		fontStyle.setColor(BaseColor.BLACK);

		header.setBackgroundColor(new BaseColor(205, 205, 205));
		header.setBorderWidth(1);
		header.setPhrase(new Phrase("Total", fontStyle));
		header.setPadding(5);
		header.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		header.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
		header.setBorderColor(borderColor);
		table.addCell(header);

		double vlTotal = 0;

		for (EstimateActivities est : estimate.getEstimatedActivities()) {
			vlTotal += est.getValue();
		}

		header = new PdfPCell();
		header.setBackgroundColor(new BaseColor(205, 205, 205));
		header.setBorderWidth(1);
		header.setBorderColor(borderColor);
		header.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		header.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
		DecimalFormat formatter = new DecimalFormat("#");
		String total = formatter.format(vlTotal);
		header.setPadding(5);

		header.setPhrase(new Phrase(total, fontStyle));

		header.setPhrase(new Phrase(total));
		table.addCell(header);

	}

	public void addRows(PdfPTable table, Project project, GenerateEstimate estimate) {
		int i = 0;
		for (EstimateActivities est : estimate.getEstimatedActivities()) {

			DecimalFormat formatter = new DecimalFormat("#");
			String horas = formatter.format(est.getValue());
			PdfPCell cellActivity = new PdfPCell(new Phrase(est.getActivity()));
			PdfPCell cellHour = new PdfPCell(new Phrase(horas));

			cellActivity.setPadding(5);
			cellActivity.setPaddingLeft(2);
			cellActivity.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
			cellActivity.setBorderColor(borderColor);

			cellHour.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
			cellHour.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
			cellHour.setBorderColor(borderColor);

			if (i % 2 == 0) {
				cellActivity.setBackgroundColor(new BaseColor(184, 204, 228));
				cellHour.setBackgroundColor(new BaseColor(184, 204, 228));

			} else {
				cellActivity.setBackgroundColor(new BaseColor(242, 242, 242));
				cellHour.setBackgroundColor(new BaseColor(242, 242, 242));
			}
			
			table.addCell(cellActivity);
			table.addCell(cellHour);
			i++;
		}
	}
}
