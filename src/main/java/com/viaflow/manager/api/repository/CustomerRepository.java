package com.viaflow.manager.api.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.viaflow.manager.api.entity.customer.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String>{
	Customer findByCustomerCnpj(String customerCnpj);
	Customer findByCustomerName(String customerName);
	List<Customer> findAllByCustomerUserManagerUserId(String managerId);
	List<Customer> findAllBy(TextCriteria criteria, Pageable pages);
}
