package com.viaflow.manager.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viaflow.manager.api.entity.user.Team;
import com.viaflow.manager.api.response.Response;
import com.viaflow.manager.api.service.TeamService;
import com.viaflow.manager.api.validation.BaseValidation;

@RestController
@RequestMapping(value="/api/team")
@CrossOrigin("*")
public class TeamWebController extends BaseController<Team, TeamService, BaseValidation<Team>>{

	@Autowired
	private TeamService teamService;
	
	@Autowired
	private BaseValidation<Team> baseValidation;

	@Override
	protected TeamService getService() {
		return this.teamService;
	}

	@Override
	protected BaseValidation<Team> getValidation() {
		return this.baseValidation;
	}
	
	@GetMapping(value = "/find/name/{name}/{page}/{count}")
	public ResponseEntity<Response<Page<Team>>> getTeamByName(
			@PathVariable("name") String name,
			@PathVariable("page") int page,
			@PathVariable("count") int count) { 
		Response<Page<Team>> response = new Response<>();
		Page<Team> list = getService().findTeamByNameIgnoreCaseContaining(name, page, count);
		response.setData(list);
		return ResponseEntity.ok(response);
	}
}