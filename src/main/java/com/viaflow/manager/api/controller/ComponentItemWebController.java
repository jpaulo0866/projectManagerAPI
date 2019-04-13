package com.viaflow.manager.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viaflow.manager.api.entity.component.ComponentItem;
import com.viaflow.manager.api.response.Response;
import com.viaflow.manager.api.service.ComponentItemService;
import com.viaflow.manager.api.validation.BaseValidation;

@RestController
@RequestMapping("/api/componentitem")
@CrossOrigin(origins = "*")
public class ComponentItemWebController
		extends BaseController<ComponentItem, ComponentItemService, BaseValidation<ComponentItem>> {

	@Autowired
	private ComponentItemService componentItemService;

	@Autowired
	private BaseValidation<ComponentItem> baseValidation;
	@Override
	protected ComponentItemService getService() {
		return this.componentItemService;
	}

	@Override
	protected BaseValidation<ComponentItem> getValidation() {
		return this.baseValidation;
	}
	
	@GetMapping(value = "/find/name/{componentvalue}")
	public ResponseEntity<Response<ComponentItem>> getComponentByName(@PathVariable("componentvalue") String componentValue){
		Response<ComponentItem> response = new Response<>();
		ComponentItem componentItem= getService().findByComponentValue(componentValue);
		if(componentItem == null) {
			response.getErrors().add("Register not found "+ componentValue);
			return ResponseEntity.badRequest().body(response);
		}
		response.setData(componentItem);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value = "/find/tag/{componentItemIdHTML}")
	public ResponseEntity<Response<ComponentItem>> getTagByIdHtml(@PathVariable("componentItemIdHTML") String componentItemIdHTML){
		Response<ComponentItem> response = new Response<>();
		ComponentItem componentItem= getService().findByComponentItemIdHTML(componentItemIdHTML);
		if(componentItem == null) {
			response.getErrors().add("Register not found "+ componentItemIdHTML);
			return ResponseEntity.badRequest().body(response);
		}
		response.setData(componentItem);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/find/full/{text}")
	public ResponseEntity<Response<List<ComponentItem>>> fullTextSearch(@PathVariable("text") String text){
		Response<List<ComponentItem>> response = new Response<>();
		List<ComponentItem> componentes = this.getService().findAllBy(text);
		response.setData(componentes);
		return ResponseEntity.ok(response);
	}	
}
