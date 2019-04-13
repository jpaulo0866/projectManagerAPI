package com.viaflow.manager.api.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viaflow.manager.api.entity.permission.Permission;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.viaflow.manager.api.response.Response;

import com.viaflow.manager.api.service.PermissionService;
import com.viaflow.manager.api.validation.BaseValidation;

@RestController
@RequestMapping("/api/permission")
@CrossOrigin(origins = "*")
public class PermissionWebController extends BaseController<Permission, PermissionService, BaseValidation<Permission>>{

	@Autowired
	private PermissionService permissionService;
	
	@Autowired
	private BaseValidation<Permission> baseValidation;

	@Override
	protected BaseValidation<Permission> getValidation() {
		return this.baseValidation;
	}
	

	protected PermissionService getService() {
		return this.permissionService;
	}
	
	
	@GetMapping(value = "/find/name/{permissionname}")
	public ResponseEntity<Response<Permission>> getPermission(@PathVariable("permissionname") String permissionName){
		Response<Permission> response = new Response<>();
		Permission permission = getService().findByPermissionNameIgnoreCase(permissionName);
		if(permission == null) {
			response.getErrors().add("Register not found "+ permissionName);
			return ResponseEntity.badRequest().body(response);
		}
		response.setData(permission);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value = "/find/profile/{profileid}")
	public ResponseEntity<Response<Permission>> getProfile(@PathVariable("profileid") String profileId){
		Response<Permission> response = new Response<>();
		Permission permission = getService().findByProfileProfileIdIgnoreCase(profileId);
		if(permission == null) {
			response.getErrors().add("Register not found "+ profileId);
			return ResponseEntity.badRequest().body(response);
		}
		response.setData(permission);
		return ResponseEntity.ok(response);
	}


}
