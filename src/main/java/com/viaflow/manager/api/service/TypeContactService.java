package com.viaflow.manager.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.person.TypeContact;

@Service
public interface TypeContactService extends BaseService<TypeContact>{
	List<TypeContact> findByTypeContactName(String typeContactName);
}