package com.viaflow.manager.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.person.Contact;
import com.viaflow.manager.api.repository.ContactRepository;
import com.viaflow.manager.api.service.ContactService;

@Service
public class ContactServiceImpl extends BaseServiceImpl<Contact, ContactRepository> implements ContactService{
	
	@Autowired
	private ContactRepository contactRepository;
	
	@Override
	protected ContactRepository getRepo() {
		return this.contactRepository;
	}

}
