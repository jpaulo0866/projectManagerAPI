package com.viaflow.manager.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viaflow.manager.api.entity.customer.Customer;
import com.viaflow.manager.api.response.Response;
import com.viaflow.manager.api.service.CustomerService;
import com.viaflow.manager.api.validation.BaseValidation;

@RestController
@RequestMapping("/api/customer")
@CrossOrigin(origins = "*")
public class CustomerWebController extends BaseController<Customer, CustomerService, BaseValidation<Customer>>{

	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private BaseValidation<Customer> baseValidation;
	
	@Override
	protected CustomerService getService() {
	
		return this.customerService;
	}

	@Override
	protected BaseValidation<Customer> getValidation() {
		
		return this.baseValidation;
	}
	
	@GetMapping(value = "/find/cnpj/{cnpj}")
	public ResponseEntity<Response<Customer>> getCustomerByCnpj(@PathVariable("cnpj") String cnpj){
		Response<Customer> response = new Response<>();
		Customer customer = getService().findByCustomerCnpj(cnpj);
		if(customer == null) {
			response.getErrors().add("Register not found"+cnpj);
			return ResponseEntity.badRequest().body(response);
		}
		response.setData(customer);
		return ResponseEntity.ok(response);
	
	}
	
	@GetMapping(value = "/find/name/{customerName}")
	public ResponseEntity<Response<Customer>> getCustomerName(@PathVariable("customerName") String customerName){
		Response<Customer> response = new Response<>();
		Customer customer = getService().findByCustomerName(customerName);
		if(customer == null) {
			response.getErrors().add("Register not found"+customerName);
			return ResponseEntity.badRequest().body(response);
		}
		response.setData(customer);
		return ResponseEntity.ok(response);
	
	}
	
	@GetMapping("/find/manager/{managerId}")
	public ResponseEntity<Response<List<Customer>>> findAllManager(@PathVariable("managerId") String managerId) { 
		Response<List<Customer>> response = new Response<>();
		List<Customer> list = customerService.findAllByCustomerUserManagerUserId(managerId);
		if(list == null || list.isEmpty()) {
			response.getErrors().add("Register not found "+ managerId);
			return ResponseEntity.badRequest().body(response);
		}
		response.setData(list);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/find/full/{text}")
	public ResponseEntity<Response<List<Customer>>> fullTextSearch(@PathVariable("text") String text){
		Response<List<Customer>> response = new Response<>();
		List<Customer> customers = this.getService().findAllBy(text);
		response.setData(customers);
		return ResponseEntity.ok(response);
	}	
	
	

}
