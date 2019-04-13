package com.viaflow.manager.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viaflow.manager.api.entity.person.TypeContact;
import com.viaflow.manager.api.response.Response;
import com.viaflow.manager.api.service.TypeContactService;
import com.viaflow.manager.api.validation.BaseValidation;

@RestController
@RequestMapping(value="/api/typecontact")
@CrossOrigin("*")
public class TypeContactWebController extends BaseController<TypeContact, TypeContactService, BaseValidation<TypeContact>>{

	@Autowired
	private TypeContactService typeContactService;
	
	@Autowired
	private BaseValidation<TypeContact> baseValidation;
	
	@Override
	protected TypeContactService getService() {
		return this.typeContactService;
	}

	@Override
	protected BaseValidation<TypeContact> getValidation() {
		return this.baseValidation;
	}

	@GetMapping("/find/name/{typeContactName}")
	public ResponseEntity<Response<List<TypeContact>>> getContactByName(@PathVariable("typeContactName") String typeContactName){
		Response<List<TypeContact>> response = new Response<>();
		List<TypeContact> typeContact = this.getService().findByTypeContactName(typeContactName);
		
		if (typeContact == null) {
			response.getErrors().add("Register not found " + typeContactName);
			return ResponseEntity.badRequest().body(response);
		}

		response.setData(typeContact);
		return ResponseEntity.ok(response);
	}
}
