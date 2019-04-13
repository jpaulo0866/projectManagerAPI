package com.viaflow.manager.api.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.viaflow.manager.api.entity.component.ComponentItem;

@Repository
public interface ComponentItemRepository extends MongoRepository<ComponentItem, String> {
	ComponentItem findByComponentValueIgnoreCase(String componentValue);
	ComponentItem findByComponentItemIdHTML(String componentItemIdHtml);
	List<ComponentItem> findAllBy(TextCriteria criteria, Pageable pages);
}