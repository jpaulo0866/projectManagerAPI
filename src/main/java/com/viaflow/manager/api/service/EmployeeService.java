package com.viaflow.manager.api.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.employee.Employee;

@Service
public interface EmployeeService extends BaseService<Employee> {
	Employee findByPersonId(String personId);	
	Page<Employee> findByRoleId(String roleId, int page, int count);
	Page<Employee> findEmployeeByFireDateNull(int page, int count);
	List<Employee> findAllBy(String text);
}
