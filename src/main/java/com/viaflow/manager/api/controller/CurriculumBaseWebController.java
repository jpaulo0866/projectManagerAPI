package com.viaflow.manager.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viaflow.manager.api.entity.curriculum.CurriculumBase;
import com.viaflow.manager.api.response.Response;
import com.viaflow.manager.api.service.CurriculumBaseService;
import com.viaflow.manager.api.validation.BaseValidation;

@RestController
@RequestMapping("/api/curriculum")
@CrossOrigin(origins = "*")
public class CurriculumBaseWebController extends BaseController<CurriculumBase, CurriculumBaseService, BaseValidation<CurriculumBase>>{

	@Autowired
	private CurriculumBaseService curriculumBaseService;
	
	@Autowired
	private BaseValidation<CurriculumBase> baseValidation;
	
	@Override
	protected CurriculumBaseService getService() {
		return this.curriculumBaseService;
	}

	@Override
	protected BaseValidation<CurriculumBase> getValidation() {
		return this.baseValidation;
	}

	@GetMapping("/find/full/{text}")
	public ResponseEntity<Response<List<CurriculumBase>>> fullTextSearch(@PathVariable("text") String text){
		Response<List<CurriculumBase>> response = new Response<>();
		List<CurriculumBase> cvList = this.getService().findAllBy(text);
		response.setData(cvList);
		return ResponseEntity.ok(response);
	}	
	

}
