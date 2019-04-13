package com.viaflow.manager.api.service;

import org.springframework.stereotype.Service;

import com.itextpdf.text.DocumentException;
import com.viaflow.manager.api.model.AppFile;
import com.viaflow.manager.api.model.GenerateEstimate;

@Service
public interface EstimateService {
	AppFile generate(GenerateEstimate estimate) throws DocumentException;
	
}
