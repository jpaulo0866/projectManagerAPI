package com.viaflow.manager.api.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.viaflow.manager.api.entity.customer.Contract;

@Repository
public interface ContractRepository extends MongoRepository<Contract, String>{
	Contract findByContractName(String contractName);
	List<Contract> findByTypeOfContractTypeOfContractId(String typeOfContractId);
	List<Contract> findAllBy(TextCriteria criteria, Pageable pages);

}
