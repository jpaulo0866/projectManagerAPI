package com.viaflow.manager.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.viaflow.manager.api.entity.user.Profile;
import com.viaflow.manager.api.response.Response;
import com.viaflow.manager.api.service.ProfileService;
import com.viaflow.manager.api.validation.BaseValidation;

@RestController
@RequestMapping("/api/profile")
@CrossOrigin(origins = "*")
public class ProfileWebController extends BaseController<Profile, ProfileService, BaseValidation<Profile>> {

	@Autowired
	private ProfileService profileService;

	@Autowired
	private BaseValidation<Profile> baseValidation;

	@Override
	protected ProfileService getService() {
		return this.profileService;
	}

	@Override
	protected BaseValidation<Profile> getValidation() {
		return this.baseValidation;
	}
	
	@GetMapping(value = "/find/name/{name}")
	public ResponseEntity<Response<List<Profile>>> getProfileByName(@PathVariable("name") String name){
		Response<List<Profile>> response = new Response<>();
		List<Profile> profiles = getService().findByName(name);
		response.setData(profiles);
		return ResponseEntity.ok(response);
	}

}
