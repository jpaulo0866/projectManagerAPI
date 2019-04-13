package com.viaflow.manager.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viaflow.manager.api.entity.permission.TypePermission;
import com.viaflow.manager.api.response.Response;
import com.viaflow.manager.api.service.BaseService;
import com.viaflow.manager.api.service.TypePermissionService;
import com.viaflow.manager.api.validation.BaseValidation;

@RestController
@RequestMapping("/api/typepermission")
@CrossOrigin(origins = "*")
public class TypePermissionWebController
		extends BaseController<TypePermission, BaseService<TypePermission>, BaseValidation<TypePermission>> {

	@Autowired
	private TypePermissionService typePermissionService;

	@Autowired
	private BaseValidation<TypePermission> baseValidation;

	@Override
	protected TypePermissionService getService() {
		return this.typePermissionService;
	}

	@Override
	protected BaseValidation<TypePermission> getValidation() {
		return this.baseValidation;
	}

	
	@GetMapping(value = "/find/name/{typePermissionName}")
	public ResponseEntity<Response<TypePermission>> get(@PathVariable("typePermissionName") String typePermissionName){
		Response<TypePermission> response = new Response<>();
		TypePermission typePermission = getService().findByTypePermissionName(typePermissionName);
		if(typePermission == null) {
			response.getErrors().add("Register not found "+ typePermissionName);
			return ResponseEntity.badRequest().body(response);
		}
		response.setData(typePermission);
		return ResponseEntity.ok(response);
	}
	
	
}
