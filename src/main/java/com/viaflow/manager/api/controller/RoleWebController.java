package com.viaflow.manager.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viaflow.manager.api.entity.employee.Role;
import com.viaflow.manager.api.response.Response;
import com.viaflow.manager.api.service.RoleService;
import com.viaflow.manager.api.validation.BaseValidation;

@RestController
@RequestMapping(value="/api/role")
@CrossOrigin("*")
public class RoleWebController extends BaseController<Role, RoleService, BaseValidation<Role>> {

	@Autowired
	private RoleService roleService;
	
	@Autowired
	private BaseValidation<Role> baseValidation;
	
	@Override
	protected RoleService getService() {
		return this.roleService;
	}

	@Override
	protected BaseValidation<Role> getValidation() {
		return this.baseValidation;
	}
		
	@GetMapping(value = "/find/name/{roleName}")
	public ResponseEntity<Response<Role>> getRoleByName(@PathVariable("roleName") String roleName){
		Response<Role> response = new Response<>();
		Role role = getService().findRoleByRoleNameIgnoreCaseContaining(roleName);
		if (role == null) {
			response.getErrors().add("Cargo inexistente, " + roleName);
			return ResponseEntity.badRequest().body(response);
		}
		
		response.setData(role);
		return ResponseEntity.ok(response);
	}

}
