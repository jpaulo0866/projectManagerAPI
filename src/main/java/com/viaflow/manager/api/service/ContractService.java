package com.viaflow.manager.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.customer.Contract;


@Service
public interface ContractService extends BaseService<Contract>{
	Contract findByContractName(String contractName);
	List<Contract> findByTypeOfContract(String typeOfContractId);
	List<Contract> findAllBy(String text);
}
