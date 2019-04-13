package com.viaflow.manager.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.viaflow.manager.api.entity.component.SubMenu;

@Repository
public interface SubMenuRepository extends MongoRepository<SubMenu, String> {
	SubMenu findBySubMenuNameIgnoreCase(String subMenuName);
}
