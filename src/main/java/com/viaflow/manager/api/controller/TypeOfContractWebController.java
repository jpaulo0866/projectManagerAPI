package com.viaflow.manager.api.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viaflow.manager.api.entity.customer.TypeOfContract;
import com.viaflow.manager.api.response.Response;
import com.viaflow.manager.api.service.TypeOfContractService;
import com.viaflow.manager.api.validation.BaseValidation;

@RestController
@RequestMapping(value="/api/typeofcontract")
@CrossOrigin("*")
public class TypeOfContractWebController extends BaseController<TypeOfContract, TypeOfContractService, BaseValidation<TypeOfContract>> {

	@Autowired
	private TypeOfContractService typeOfContractService;
	
	@Autowired
	private BaseValidation<TypeOfContract> baseValidation;
	
	@Override
	protected TypeOfContractService getService() {
		return this.typeOfContractService;
	}

	@Override
	protected BaseValidation<TypeOfContract> getValidation() {
		return this.baseValidation;
	}
	
	@GetMapping(value = "/find/name/{typeOfContractName}")
	public ResponseEntity<Response<List<TypeOfContract>>> getTagByIdHtml(@PathVariable("typeOfContractName") String typeOfContractName){
		Response<List<TypeOfContract>> response = new Response<>();
		List<TypeOfContract> typeOfContract= getService().findByTypeOfContractName(typeOfContractName);
		if(typeOfContract == null) {
			response.getErrors().add("Register not found "+ typeOfContractName);
			return ResponseEntity.badRequest().body(response);
		}
		response.setData(typeOfContract);
		return ResponseEntity.ok(response);
	}

}
