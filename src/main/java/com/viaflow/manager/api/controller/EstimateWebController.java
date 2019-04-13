package com.viaflow.manager.api.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viaflow.manager.api.model.AppFile;
import com.viaflow.manager.api.model.GenerateEstimate;
import com.viaflow.manager.api.response.Response;
import com.viaflow.manager.api.service.EstimateService;

@RestController
@RequestMapping("/api/estimate")
@CrossOrigin("*")
public class EstimateWebController {

	@Autowired
	private EstimateService estimateService;

	@PostMapping
	public ResponseEntity<Response<AppFile>> generateEstimate(HttpServletRequest req,
			@RequestBody GenerateEstimate estimate, BindingResult result) {
		Response<AppFile> response = new Response<>();
		try {
			response.setData(estimateService.generate(estimate));

		} catch (Exception e) {
			response.getErrors().add("Critical Error on Request! " + e.toString());
			return ResponseEntity.badRequest().body(response);
		}

		return ResponseEntity.ok(response);
	}
}
