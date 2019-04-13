package com.viaflow.manager.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viaflow.manager.api.entity.analytics.PageStatistic;
import com.viaflow.manager.api.response.Response;
import com.viaflow.manager.api.service.PageStatisticService;
import com.viaflow.manager.api.validation.BaseValidation;

@RestController
@RequestMapping("/api/analytics/pagestatistics")
@CrossOrigin("*")
public class PageStatisticWebController extends BaseController<PageStatistic, PageStatisticService, BaseValidation<PageStatistic>> {

	@Autowired
	private PageStatisticService pageStatisticService;
	
	@Override
	protected PageStatisticService getService() {
		return pageStatisticService;
	}

	@Override
	protected BaseValidation<PageStatistic> getValidation() {
		return null;
	}
	
	@GetMapping("lastaccess/{userId}")
	public ResponseEntity<Response<List<PageStatistic>>> findLastAccessPages(@PathVariable("userId") String userId) {
		Response<List<PageStatistic>> response = new Response<>();
		try {
			response.setData(this.pageStatisticService.findLastAcessedByUser(userId));
		} catch (Exception e) {
			response.getErrors().add(e.toString());
			response.getErrors().add(e.getMessage());
			response.getErrors().add(e.getStackTrace().toString());
			return ResponseEntity.badRequest().body(response);
		}
		
		return ResponseEntity.ok(response);
		
	}

}
