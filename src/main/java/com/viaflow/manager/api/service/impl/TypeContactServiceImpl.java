package com.viaflow.manager.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.person.TypeContact;
import com.viaflow.manager.api.repository.TypeContactRepository;
import com.viaflow.manager.api.service.TypeContactService;

@Service
public class TypeContactServiceImpl extends BaseServiceImpl<TypeContact, TypeContactRepository> implements TypeContactService{

	@Autowired
	private TypeContactRepository typeContactRepository;
	
	@Override
	protected TypeContactRepository getRepo() {
		return 	this.typeContactRepository;
	}
	
	public List<TypeContact> findByTypeContactName(String typeContactName){
		return this.getRepo().findByTypeContactNameIgnoreCaseContaining(typeContactName);
	}
}
