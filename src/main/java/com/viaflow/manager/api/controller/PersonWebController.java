package com.viaflow.manager.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viaflow.manager.api.entity.person.Person;
import com.viaflow.manager.api.response.Response;
import com.viaflow.manager.api.service.PersonService;
import com.viaflow.manager.api.validation.BaseValidation;

@RestController
@RequestMapping(value="/api/person")
@CrossOrigin("*")
public class PersonWebController extends BaseController<Person, PersonService, BaseValidation<Person>>{

	@Autowired
	private PersonService personService;
	
	@Autowired
	private BaseValidation<Person> baseValidation;
	
	@Override
	protected PersonService getService() {
		return this.personService;
	}

	@Override
	protected BaseValidation<Person> getValidation() {
		return this.baseValidation;
	}
	
	@GetMapping("/find/lastName/{lastName}/{page}/{count}")
	public ResponseEntity<Response<Page<Person>>> getPersonByLastName(@PathVariable("lastName") String lastName, @PathVariable("page") int page, @PathVariable("count") int count){
		Response<Page<Person>> response = new Response<>();
		Page<Person> person = this.getService().findByLastName(lastName, page, count);
		
		if (person == null) {
			response.getErrors().add("Register not found " + lastName);
			return ResponseEntity.badRequest().body(response);
		}

		response.setData(person);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/find/firstName/{firstName}/{page}/{count}")
	public ResponseEntity<Response<Page<Person>>> getPersonByFirstName(@PathVariable("firstName") String firstName, @PathVariable("page") int page, @PathVariable("count") int count){
		Response<Page<Person>> response = new Response<>();
		Page<Person> person = this.getService().findByFirstName(firstName, page, count);
		
		if (person == null) {
			response.getErrors().add("Register not found " + firstName);
			return ResponseEntity.badRequest().body(response);
		}

		response.setData(person);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/find/full/{text}")
	public ResponseEntity<Response<List<Person>>> fullTextSearch(@PathVariable("text") String text){
		Response<List<Person>> response = new Response<>();
		List<Person> person = this.getService().findAllBy(text);
		response.setData(person);
		return ResponseEntity.ok(response);
	}
}
