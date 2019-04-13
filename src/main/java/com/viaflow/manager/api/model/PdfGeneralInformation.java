package com.viaflow.manager.api.model;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.viaflow.manager.api.entity.project.Project;

public class PdfGeneralInformation {
	public void addRows(PdfPTable table, Project project, GenerateEstimate estimate) {
		
		Font smallBlack = new Font(FontFamily.HELVETICA, 12, Font.NORMAL, new BaseColor(80, 87, 91));
		
		PdfPCell cellRole = new PdfPCell();
		PdfPCell cellValue = new PdfPCell();
		
		cellRole.setPadding(7);
		cellValue.setPadding(7);
		cellRole.setBorderColor(new BaseColor(20, 129, 196));
		cellValue.setBorderColor(new BaseColor(20, 129, 196));
		
		
		if(project.getResponsibleTI() != null) {
			cellRole.setPhrase(new Phrase("Responsável TI", smallBlack));
			cellValue.setPhrase(new Phrase(project.getResponsibleTI().getFirstName()+" "+project.getResponsibleTI().getLastName(), smallBlack));
			table.addCell(cellRole);
			table.addCell(cellValue);
		}
		
		if(project.getBusinessArea() != null) {
			cellRole.setPhrase(new Phrase("Área de negócio", smallBlack));
			cellValue.setPhrase(new Phrase(project.getBusinessArea(), smallBlack));
			table.addCell(cellRole);
			table.addCell(cellValue);
		}
		
		if(project.getResponsibleBusinessArea() != null) {
			cellRole.setPhrase(new Phrase("Responsável Área de negócio", smallBlack));
			cellValue.setPhrase(new Phrase(project.getResponsibleBusinessArea().getFirstName()+" "+project.getResponsibleBusinessArea().getLastName(), smallBlack));
			table.addCell(cellRole);
			table.addCell(cellValue);
		}
		
		if(project.getUserBusinessArea() != null) {
			cellRole.setPhrase(new Phrase("Usuário-chave da Área de negócio", smallBlack));
			cellValue.setPhrase(new Phrase(project.getUserBusinessArea().getPerson().getFirstName()+" "+project.getUserBusinessArea().getPerson().getLastName(), smallBlack));
			table.addCell(cellRole);
			table.addCell(cellValue);
		}
		
		if(project.getAnalyst() != null) {
			cellRole.setPhrase(new Phrase("Analista ViaFlow", smallBlack));
			cellValue.setPhrase(new Phrase(project.getAnalyst().getPerson().getFirstName()+" "+project.getAnalyst().getPerson().getLastName(), smallBlack));
			table.addCell(cellRole);
			table.addCell(cellValue);
		}
		
		if(project.getProjectPriority() != null) {
			cellRole.setPhrase(new Phrase("Prioridade", smallBlack));
			cellValue.setPhrase(new Phrase(project.getProjectPriority().getProjectPriorityName(), smallBlack));
			table.addCell(cellRole);
			table.addCell(cellValue);
		}
		
		if(project.getProjectDeadline() != null) {
			cellRole.setPhrase(new Phrase("Data de entrega", smallBlack));
			cellValue.setPhrase(new Phrase(project.getProjectDeadline().toString(), smallBlack));
			table.addCell(cellRole);
			table.addCell(cellValue);
		}
		
		if(project.getProjectInvestment() != 0) {
			cellRole.setPhrase(new Phrase("Investimento", smallBlack));
			cellValue.setPhrase(new Phrase(project.getProjectInvestment()+"", smallBlack));
			table.addCell(cellRole);
			table.addCell(cellValue);
		}
		
		if(project.getProjectProposalDate() != null) {
			cellRole.setPhrase(new Phrase("Data da proposta", smallBlack));
			cellValue.setPhrase(new Phrase(project.getProjectProposalDate().toString(), smallBlack));
			table.addCell(cellRole);
			table.addCell(cellValue);
		}
		
		if(project.getProjectExpirationDate() != null) {
			cellRole.setPhrase(new Phrase("Prazo de validade", smallBlack));
			cellValue.setPhrase(new Phrase(project.getProjectExpirationDate().toString(), smallBlack));
			table.addCell(cellRole);
			table.addCell(cellValue);
		}
	}
}
