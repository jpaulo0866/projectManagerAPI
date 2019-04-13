package com.viaflow.manager.api.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.viaflow.manager.api.entity.person.TypeContact;

@Repository
public interface TypeContactRepository extends MongoRepository<TypeContact, String>{
	List<TypeContact> findByTypeContactNameIgnoreCaseContaining(String typeContactName);
}
