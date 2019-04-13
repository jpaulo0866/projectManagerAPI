package com.viaflow.manager.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viaflow.manager.api.entity.employee.Promotion;
import com.viaflow.manager.api.response.Response;
import com.viaflow.manager.api.service.PromotionService;
import com.viaflow.manager.api.validation.BaseValidation;

@RestController
@RequestMapping("/api/promotion")
@CrossOrigin(origins = "*")
public class PromotionWebController extends BaseController<Promotion, PromotionService , BaseValidation<Promotion>> {

	@Autowired
	private PromotionService promotionService;
	
	@Autowired
	private BaseValidation<Promotion> baseValidation;
	
	
	@Override
	protected PromotionService getService() {
		return this.promotionService;
	}

	@Override
	protected BaseValidation<Promotion> getValidation() {
		return this.baseValidation ;
	}

	@GetMapping(value = "/find/employee/{employeeId}")
	public ResponseEntity<Response<Promotion>> getPromotionByEmployeeId(
			@PathVariable("employeeId") String employeeId){
		Response<Promotion> response = new Response<>();
		Promotion promotion = getService().findByEmployeeId(employeeId);
		if (promotion == null) {
			response.getErrors().add("Register not found " + employeeId);
			return ResponseEntity.badRequest().body(response);
		}
		
		response.setData(promotion);
		return ResponseEntity.ok(response);
	}

	
}
