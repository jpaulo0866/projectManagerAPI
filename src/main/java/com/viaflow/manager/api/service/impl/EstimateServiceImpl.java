package com.viaflow.manager.api.service.impl;

import java.io.ByteArrayOutputStream;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import com.viaflow.manager.api.entity.project.Project;
import com.viaflow.manager.api.model.AppFile;
import com.viaflow.manager.api.model.GenerateEstimate;
import com.viaflow.manager.api.model.PdfGeneralInformation;
import com.viaflow.manager.api.model.PdfTableEstimateActivities;
import com.viaflow.manager.api.model.PdfTableGuarantees;
import com.viaflow.manager.api.model.PdfTablePreRequisites;
import com.viaflow.manager.api.service.EstimateService;
import com.viaflow.manager.api.service.ProjectService;
import com.viaflow.manager.global.WritePDF;

@Service
public class EstimateServiceImpl implements EstimateService {

	@Autowired
	private ProjectService projectService;

	@Override
	public AppFile generate(GenerateEstimate estimate) throws DocumentException {	
		Project project = projectService.findById(estimate.getProject().getProjectId());
		ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
		Document pdfDoc = WritePDF.getPDFWritter(byteArray);
		pdfDoc.addCreator("ViaFlow Consultoria");
		pdfDoc.addAuthor("ViaFlow Consultoria");
		pdfDoc.addTitle(project.getProjectTitle());

		Font blue = new Font(FontFamily.HELVETICA, 25, Font.BOLD, new BaseColor (47, 162, 219));
		Chunk textTitle = new Chunk("Demanda: " + project.getProjectTitle() + " - " + project.getProjectContract().getContractName(), blue);
		Paragraph title = new Paragraph(new Phrase(textTitle));
		pdfDoc.add(title);

		Font orange = new Font(FontFamily.HELVETICA, 25, Font.BOLD, new BaseColor (245, 130, 32));
		Chunk subTitleText = new Chunk("Informações gerais", orange);
		Paragraph subTitle = new Paragraph(new Phrase(subTitleText));
		pdfDoc.add(subTitle);

		pdfDoc.add(new Phrase(20F, "Projeto: " + project.getProjectTitle(),
				FontFactory.getFont(FontFactory.TIMES_ROMAN, 15F)));

		Paragraph desc = new Paragraph(new Phrase(20F, "Descrição: " + project.getProjectDescription(),
				FontFactory.getFont(FontFactory.HELVETICA, 12F)));
		pdfDoc.add(desc);


		pdfDoc.add(new Paragraph(" "));

		PdfPTable generalInformation = new PdfPTable(2);
		generalInformation.setWidthPercentage(100);
		PdfGeneralInformation pdfGeneralInformation = new PdfGeneralInformation();
		pdfGeneralInformation.addRows(generalInformation, project, estimate);
		pdfDoc.add(generalInformation);
		
		pdfDoc.add(new Paragraph(" "));

		Chunk detalhamentoText = new Chunk("Detalhamento das Alterações de Escopo", orange);
		Paragraph detalhamento = new Paragraph(new Phrase(detalhamentoText));
		pdfDoc.add(detalhamento);
		
		pdfDoc.add(new Paragraph(" "));

		Font smallTitleBlack = new Font(FontFamily.HELVETICA, 15, Font.BOLD, new BaseColor(80, 80, 80));
		Chunk descriptionTextTitle = new Chunk("Descrição", smallTitleBlack);
		Paragraph descriptionTitle = new Paragraph(new Phrase(descriptionTextTitle));
		pdfDoc.add(descriptionTitle);

		pdfDoc.add(new Paragraph(" "));
		
		Font smallBlack = new Font(FontFamily.HELVETICA, 12, Font.BOLD, new BaseColor(100, 100, 100));
		
		Chunk descriptionText;
		if (estimate.getDescription() == null || estimate.getDescription().isEmpty()){
			descriptionText = new Chunk(project.getProjectDescription(), smallBlack);	
		}else {
			descriptionText = new Chunk(estimate.getDescription(), smallBlack);
		}
		
		Paragraph description = new Paragraph(new Phrase(descriptionText));
		pdfDoc.add(description);
		
		pdfDoc.newPage();

		pdfDoc.add(new Paragraph(" "));
		
		double chunks = 0;
		
		for (int i = 0; i < estimate.getActiviesPerfomed().size(); i++) {
					
			Chunk activityPerformedTitleText = new Chunk("Requisito "+(i+1), smallTitleBlack);
			Paragraph activityPerformedTitle = new Paragraph(new Phrase(activityPerformedTitleText));
			
			Chunk activityPerformedText = new Chunk(estimate.getActiviesPerfomed().get(i), smallBlack);
			Paragraph activityPerformed = new Paragraph(new Phrase(activityPerformedText));
			
			//Pega o total do conteudo dos paragrafos e acumula em uma variavle
			chunks += activityPerformedTitle.getContent().length() + activityPerformed.getContent().length();
			
			//Pega o valor acumulado e calcula o tamanho da pagina
			//Ap�s realiza regra de tres para gerar o percentual de uso da pagina
			double restodaPagina = pdfDoc.top() - pdfDoc.bottom();
			double percentual = restodaPagina * 75 / chunks;
			
			//Se o percentual for menor que 25% ent�o gera nova p�gina.
			if (percentual < 25) {
				pdfDoc.newPage();
				chunks = 0;
			}

			pdfDoc.add(activityPerformedTitle);
			pdfDoc.add(activityPerformed);
			pdfDoc.add(new Paragraph(" "));
		}
		
//		pdfDoc.add(listItem);
//		Fim do bloco que add lista de requisitos
		
		pdfDoc.newPage();
		
//		Inicio do bloco que add tabela de garantia
		Chunk guaranteesTitleText = new Chunk("Garantias", smallTitleBlack);
		Paragraph guaranteesTitle = new Paragraph(new Phrase(guaranteesTitleText));
		pdfDoc.add(guaranteesTitle );

		pdfDoc.add(new Paragraph(" "));
		
		PdfPTable tableWarranty = new PdfPTable(1);
		tableWarranty.setWidthPercentage(100);
		PdfTableGuarantees pdfTablewarranty = new PdfTableGuarantees();
		pdfTablewarranty.addTableHeader(tableWarranty);
		pdfTablewarranty.addRows(tableWarranty, project, estimate);
		pdfDoc.add(tableWarranty);
//		Fim do bloco que add tabela de garantia
		
//		Inicio do bloco que add tabela de pr� requisitos
		pdfDoc.add(new Paragraph(" "));
		
		Chunk preRequisitesTitleText  = new Chunk("Pré-requisitos", smallTitleBlack);
		Paragraph preRequisitesTitle = new Paragraph(new Phrase(preRequisitesTitleText));
		pdfDoc.add(preRequisitesTitle);

		pdfDoc.add(new Paragraph(" "));
		
		PdfPTable tablePreRequisites = new PdfPTable(1);
		tablePreRequisites.setWidthPercentage(100);
		PdfTablePreRequisites pdfTablePreRequisites = new PdfTablePreRequisites();
		pdfTablePreRequisites.addTableHeader(tablePreRequisites);
		pdfTablePreRequisites.addRows(tablePreRequisites, project, estimate);
		pdfDoc.add(tablePreRequisites);
//		Fim do bloco que add tabela de pr� requisitos
		
		pdfDoc.newPage();
		
//		Inicio do bloco que add tabela de estimativa
		Chunk activitiesTitleText  = new Chunk("Estimativas", smallTitleBlack);
		Paragraph activitiesTitle = new Paragraph(new Phrase(activitiesTitleText));
		pdfDoc.add(activitiesTitle);

		pdfDoc.add(new Paragraph(" "));
		
		PdfPTable tableActivities = new PdfPTable(2);
		tableActivities.setWidthPercentage(100);
		PdfTableEstimateActivities pdfTableActiviesEstimate = new PdfTableEstimateActivities();
		pdfTableActiviesEstimate.addTableHeader(tableActivities);
		pdfTableActiviesEstimate.addRows(tableActivities, project, estimate);
		pdfTableActiviesEstimate.addTableFooter(tableActivities, estimate);
		pdfDoc.add(tableActivities);
//		Fim do bloco que add tabela de estimativa
		
		pdfDoc.close();
		AppFile file = new AppFile();
		file.setExtensionName(".pdf");
		file.setFileName(estimate.getProject().getProjectTitle() + "_Generated");
		String base64data = Base64.getEncoder().encodeToString(byteArray.toByteArray());
		file.setData(base64data);
		return file;
	}
}
