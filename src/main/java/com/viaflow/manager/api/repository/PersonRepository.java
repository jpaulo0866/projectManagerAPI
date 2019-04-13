package com.viaflow.manager.api.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.viaflow.manager.api.entity.person.Person;

@Repository
public interface PersonRepository extends MongoRepository<Person, String>{
	Page<Person> findByLastNameIgnoreCaseContaining(String lastName, Pageable pages);
	Page<Person> findByFirstNameIgnoreCaseContaining(String firstName, Pageable pages);
	List<Person> findAllBy(TextCriteria criteria, Pageable pages);
}
