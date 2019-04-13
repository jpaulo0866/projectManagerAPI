package com.viaflow.manager.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.viaflow.manager.api.entity.component.SubMenu;
import com.viaflow.manager.api.response.Response;
import com.viaflow.manager.api.service.SubMenuService;
import com.viaflow.manager.api.validation.BaseValidation;

@RestController
@RequestMapping("/api/submenu")
@CrossOrigin(origins = "*")
public class SubMenuWebController extends BaseController<SubMenu, SubMenuService, BaseValidation<SubMenu>> {

	@Autowired
	private SubMenuService subMenuService;

	@Autowired
	private BaseValidation<SubMenu> baseValidation;

	@Override
	protected SubMenuService getService() {
		return this.subMenuService;
	}

	@Override
	protected BaseValidation<SubMenu> getValidation() {
		return this.baseValidation;
	}
	
	@GetMapping(value = "/find/name/{submenuname}")
	public ResponseEntity<Response<SubMenu>> get(@PathVariable("submenuname") String subMenuName){
		Response<SubMenu> response = new Response<>();
		SubMenu subMenu = getService().findBySubMenuNameIgnoreCase(subMenuName);
		if(subMenu == null) {
			response.getErrors().add("Register not found "+ subMenuName);
			return ResponseEntity.badRequest().body(response);
		}
		response.setData(subMenu);
		return ResponseEntity.ok(response);
	}

}