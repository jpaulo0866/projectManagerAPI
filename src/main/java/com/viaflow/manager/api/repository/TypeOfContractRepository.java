package com.viaflow.manager.api.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.viaflow.manager.api.entity.customer.TypeOfContract;

@Repository
public interface TypeOfContractRepository extends MongoRepository<TypeOfContract, String> {
	List<TypeOfContract> findByTypeOfContractNameIgnoreCaseContaining(String typeOfContractName);
}