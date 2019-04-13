package com.viaflow.manager.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.customer.Customer;
import com.viaflow.manager.api.repository.CustomerRepository;
import com.viaflow.manager.api.service.CustomerService;

@Service
public class CustomerServiceImpl extends BaseServiceImpl<Customer, CustomerRepository> implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	
	@Override
	protected CustomerRepository getRepo() {
		
		return this.customerRepository;
	}


	@Override
	public Customer findByCustomerCnpj(String customerCnpj) {
		return this.customerRepository.findByCustomerCnpj(customerCnpj);
	}


	@Override
	public Customer findByCustomerName(String customerName) {
		return this.customerRepository.findByCustomerName(customerName);
	}


	@Override
	public List<Customer> findAllByCustomerUserManagerUserId(String managerId) {
		return this.customerRepository.findAllByCustomerUserManagerUserId(managerId);
	}
	
	@Override
	public List<Customer> findAllBy(String text) {
		Pageable pages = PageRequest.of(0, 100, Sort.by(Order.asc("textScore")));
        TextCriteria criteria = TextCriteria.forDefaultLanguage().matchingAny(text);
		return this.getRepo().findAllBy(criteria, pages);
	}
	


}
