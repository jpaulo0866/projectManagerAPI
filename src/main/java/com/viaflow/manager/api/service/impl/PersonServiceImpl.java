package com.viaflow.manager.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.person.Person;
import com.viaflow.manager.api.repository.PersonRepository;
import com.viaflow.manager.api.service.PersonService;

@Service
public class PersonServiceImpl extends BaseServiceImpl<Person, PersonRepository> implements PersonService{

	@Autowired
	private PersonRepository personRepository;
	
	@Override
	protected PersonRepository getRepo() {
		return this.personRepository;
	}

	public Page<Person> findByLastName(String lastName, int page, int count) {
		Pageable pages = PageRequest.of(page, count);
		return this.getRepo().findByLastNameIgnoreCaseContaining(lastName, pages);
	}
	
	public Page<Person> findByFirstName(String firstName, int page, int count){
		Pageable pages = PageRequest.of(page, count);
		return this.getRepo().findByFirstNameIgnoreCaseContaining(firstName, pages);
	}

	@Override
	public List<Person> findAllBy(String text) {
		Pageable pages = PageRequest.of(0, 100, Sort.by(Order.asc("textScore")));
        TextCriteria criteria = TextCriteria.forDefaultLanguage().matchingAny(text);
		return this.getRepo().findAllBy(criteria, pages);
	}
}
