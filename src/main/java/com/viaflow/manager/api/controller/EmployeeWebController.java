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

import com.viaflow.manager.api.entity.employee.Employee;
import com.viaflow.manager.api.response.Response;
import com.viaflow.manager.api.service.EmployeeService;
import com.viaflow.manager.api.validation.BaseValidation;

@RestController
@RequestMapping(value="/api/employee")
@CrossOrigin("*")
public class EmployeeWebController extends BaseController<Employee, EmployeeService, BaseValidation<Employee>>  {

	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private  BaseValidation<Employee> baseValidation;
	
	
	@Override
	protected EmployeeService getService() {
		return this.employeeService;
	}

	@Override
	protected BaseValidation<Employee> getValidation() {
		return this.baseValidation;
	}
	
	@GetMapping(value = "find/person/{personId}")
	public ResponseEntity<Response<Employee>> getEmployeeByPerson(
			@PathVariable("personId") String personId){
		Response<Employee> response = new Response<>();
		Employee employee = employeeService.findByPersonId(personId);
		response.setData(employee);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value = "/find/role/{roleId}/{page}/{count}")
	public ResponseEntity<Response<Page<Employee>>> getEmployeeByRole(
			@PathVariable("roleId") String roleId,
			@PathVariable("page") int page,
			@PathVariable("count") int count){
		Response<Page<Employee>> response = new Response<>();
		Page<Employee> list = employeeService.findByRoleId(roleId, page, count);
		response.setData(list);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value = "/find/active/{page}/{count}")
	public ResponseEntity<Response<Page<Employee>>> getActiveEmployees(
			@PathVariable("page") int page,
			@PathVariable("count") int count) { 
		Response<Page<Employee>> response = new Response<>();
		Page<Employee> list = getService().findEmployeeByFireDateNull(page, count);
		for (int i =0; i<=list.getContent().size(); i++) {
			if (list.getContent().get(i).getFireDate() == null) {
				response.setData(list);
				return ResponseEntity.ok(response);	
			}
		}
		
		response.getErrors().add("Register not found " + list);
		return ResponseEntity.badRequest().body(response);
		
	}
	
	@GetMapping("/find/full/{text}")
	public ResponseEntity<Response<List<Employee>>> fullTextSearch(@PathVariable("text") String text){
		Response<List<Employee>> response = new Response<>();
		List<Employee> employee = this.getService().findAllBy(text);
		response.setData(employee);
		return ResponseEntity.ok(response);
	}	
	
}
