package com.viaflow.manager.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.customer.Customer;

@Service
public interface CustomerService extends BaseService<Customer>{
	Customer findByCustomerCnpj(String customerCnpj);
	Customer findByCustomerName(String customerName);
	List<Customer> findAllByCustomerUserManagerUserId(String managerId);
	List<Customer> findAllBy(String text);
}
