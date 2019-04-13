package com.viaflow.manager.api.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.person.Person;

@Service
public interface PersonService extends BaseService<Person>{
	Page<Person> findByLastName(String lastName, int page, int count);
	Page<Person> findByFirstName(String firstName, int page, int count);
	List<Person> findAllBy(String text);
}
