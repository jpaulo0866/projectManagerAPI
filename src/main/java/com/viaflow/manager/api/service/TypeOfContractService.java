package com.viaflow.manager.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.customer.TypeOfContract;

@Service
public interface TypeOfContractService extends BaseService<TypeOfContract> {
	List<TypeOfContract> findByTypeOfContractName(String typeOfContractName);
	
}