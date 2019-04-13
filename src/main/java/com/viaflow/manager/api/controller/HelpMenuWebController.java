package com.viaflow.manager.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viaflow.manager.api.entity.help.HelpMenu;
import com.viaflow.manager.api.response.Response;
import com.viaflow.manager.api.service.HelpMenuService;
import com.viaflow.manager.api.validation.BaseValidation;

@RestController
@RequestMapping("/api/help")
@CrossOrigin(origins = "*")
public class HelpMenuWebController extends BaseController<HelpMenu, HelpMenuService, BaseValidation<HelpMenu>>{

	@Autowired
	private HelpMenuService helpMenuService;
	
	@Autowired
	private BaseValidation<HelpMenu> baseValidation;
	
	@Override
	protected HelpMenuService getService() {
		return this.helpMenuService;
	}

	@Override
	protected BaseValidation<HelpMenu> getValidation() {
		return this.baseValidation;
	}
	
	@GetMapping(value = "/find/component/{componentid}")
	public ResponseEntity<Response<HelpMenu>> get(@PathVariable("componentid") String componentId){
		Response<HelpMenu> response = new Response<>();
		HelpMenu helpMenu = getService().findByComponentComponentId(componentId);
		if(helpMenu == null) {
			response.getErrors().add("Register not found "+ componentId);
			return ResponseEntity.badRequest().body(response);
		}
		response.setData(helpMenu);
		return ResponseEntity.ok(response);
	}

}
