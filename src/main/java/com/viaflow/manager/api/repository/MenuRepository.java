package com.viaflow.manager.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.viaflow.manager.api.entity.component.Menu;

@Repository
public interface MenuRepository extends MongoRepository<Menu, String>{
	Menu findByMenuNameIgnoreCase(String menuName);
}
