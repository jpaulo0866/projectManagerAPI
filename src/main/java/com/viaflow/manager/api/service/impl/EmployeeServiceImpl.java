package com.viaflow.manager.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.employee.Employee;
import com.viaflow.manager.api.repository.EmployeeRepository;
import com.viaflow.manager.api.service.EmployeeService;

@Service
public class EmployeeServiceImpl extends BaseServiceImpl<Employee, EmployeeRepository> implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	protected EmployeeRepository getRepo() {
		return this.employeeRepository;
	}

	@Override
	public Page<Employee> findEmployeeByFireDateNull(int page, int count) {
		Pageable pages = PageRequest.of(0, 100);
		return this.getRepo().findEmployeeByFireDateNull(pages);
	}

	@Override
	public Employee findByPersonId(String personId) {	
		return this.getRepo().findByPersonPersonId(personId);
	}

	@Override
	public Page<Employee> findByRoleId(String roleId, int page, int count) {
		Pageable pages= PageRequest.of(page, count);
		return this.getRepo().findByRoleRoleId(roleId, pages);
	}
	
	@Override
	public List<Employee> findAllBy(String text) {
		Pageable pages = PageRequest.of(0, 100, Sort.by(Order.asc("textScore")));
        TextCriteria criteria = TextCriteria.forDefaultLanguage().matchingAny(text);
		return this.getRepo().findAllBy(criteria, pages);
	}

}
