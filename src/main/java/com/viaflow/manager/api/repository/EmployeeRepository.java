package com.viaflow.manager.api.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.viaflow.manager.api.entity.employee.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {
	Employee findByPersonPersonId(String personId);	
	Page<Employee> findByRoleRoleId(String roleId, Pageable pages);
	Page<Employee> findEmployeeByFireDateNull(Pageable pages);
	List<Employee> findAllBy(TextCriteria criteria, Pageable pages);
}
