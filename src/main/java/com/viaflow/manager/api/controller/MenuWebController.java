package com.viaflow.manager.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.viaflow.manager.api.entity.component.Menu;
import com.viaflow.manager.api.response.Response;
import com.viaflow.manager.api.service.MenuService;
import com.viaflow.manager.api.validation.BaseValidation;

@RestController
@RequestMapping("/api/menu")
@CrossOrigin(origins="*")
public class MenuWebController extends BaseController<Menu, MenuService, BaseValidation<Menu>>{

	@Autowired
	private MenuService menuService;
	
	@Autowired
	private BaseValidation<Menu> baseValidation;
	
	@Override
	protected MenuService getService() {
		return this.menuService;
	}

	@Override
	protected BaseValidation<Menu> getValidation() {
		return this.baseValidation;
	}
	
	@GetMapping(value = "/find/name/{menuname}")
	public ResponseEntity<Response<Menu>> get(@PathVariable("menuname") String menuName){
		Response<Menu> response = new Response<>();
		Menu menu = getService().findByMenuNameIgnoreCase(menuName);
		if(menu == null) {
			response.getErrors().add("Register not found "+ menuName);
			return ResponseEntity.badRequest().body(response);
		}
		response.setData(menu);
		return ResponseEntity.ok(response);
	}
}
