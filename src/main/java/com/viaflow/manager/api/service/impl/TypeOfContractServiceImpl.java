package com.viaflow.manager.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.customer.TypeOfContract;
import com.viaflow.manager.api.repository.TypeOfContractRepository;
import com.viaflow.manager.api.service.TypeOfContractService;

@Service
public class TypeOfContractServiceImpl extends BaseServiceImpl<TypeOfContract, TypeOfContractRepository> implements TypeOfContractService {

	@Autowired
	private TypeOfContractRepository typeOfContractRepository;
	
	@Override
	protected TypeOfContractRepository getRepo() {
		return this.typeOfContractRepository;
	}

	@Override
	public List<TypeOfContract> findByTypeOfContractName(String typeOfContractName) {
		return this.typeOfContractRepository.findByTypeOfContractNameIgnoreCaseContaining(typeOfContractName);
	}

}