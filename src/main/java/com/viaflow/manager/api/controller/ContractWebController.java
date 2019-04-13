package com.viaflow.manager.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viaflow.manager.api.entity.customer.Contract;
import com.viaflow.manager.api.response.Response;
import com.viaflow.manager.api.service.ContractService;
import com.viaflow.manager.api.validation.BaseValidation;

@RestController
@RequestMapping("/api/contract")
@CrossOrigin(origins = "*")
public class ContractWebController extends BaseController<Contract, ContractService, BaseValidation<Contract>>{

	
	@Autowired
	private ContractService contractService;
	
	@Autowired
	private BaseValidation<Contract> baseValidation;
	
	@Override
	protected ContractService getService() {
		
		return this.contractService;
	}

	@Override
	protected BaseValidation<Contract> getValidation() {
		
		return this.baseValidation;
	}
	
	@GetMapping(value = "/find/name/{name}")
	public ResponseEntity<Response<Contract>> getContractByName(@PathVariable("name") String name){
		Response<Contract> response = new Response<>();
		Contract contract = getService().findByContractName(name);
		if(contract == null) {
			response.getErrors().add("Register not found "+ name);
			return ResponseEntity.badRequest().body(response);
		}
		response.setData(contract);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/find/typeofcontract/{typeofcontractId}")
	public ResponseEntity<Response<List<Contract>>> getContractByTypeOfContract(@PathVariable("typeofcontractId") String typeOfContractId){
		Response<List<Contract>> response = new Response<>();
		List<Contract> contract = this.getService().findByTypeOfContract(typeOfContractId);
		
		if(contract == null) {
			response.getErrors().add("Register not found "+ typeOfContractId);
			return ResponseEntity.badRequest().body(response);
		}
		
		response.setData(contract);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/find/full/{text}")
	public ResponseEntity<Response<List<Contract>>> fullTextSearch(@PathVariable("text") String text){
		Response<List<Contract>> response = new Response<>();
		List<Contract> contracts = this.getService().findAllBy(text);
		response.setData(contracts);
		return ResponseEntity.ok(response);
	}	
	
}
