package com.viaflow.manager.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.customer.Contract;
import com.viaflow.manager.api.repository.ContractRepository;
import com.viaflow.manager.api.service.ContractService;

@Service
public class ContractServiceImpl extends BaseServiceImpl<Contract, ContractRepository> implements ContractService{

	@Autowired
	private ContractRepository contractRepository;
	
	@Override
	protected ContractRepository getRepo() {
		
		return contractRepository;
	}

	public Contract findByContractName(String contractName) {
		return this.contractRepository.findByContractName(contractName);
	}
	
	public List<Contract> findByTypeOfContract(String typeOfContractId) {
		return this.getRepo().findByTypeOfContractTypeOfContractId(typeOfContractId);
	}
	
	@Override
	public List<Contract> findAllBy(String text) {
		Pageable pages = PageRequest.of(0, 100, Sort.by(Order.asc("textScore")));
        TextCriteria criteria = TextCriteria.forDefaultLanguage().matchingAny(text);
		return this.getRepo().findAllBy(criteria, pages);
	}

}
