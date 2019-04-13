package com.viaflow.manager.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.component.ComponentItem;
import com.viaflow.manager.api.repository.ComponentItemRepository;
import com.viaflow.manager.api.service.ComponentItemService;

@Service
public class ComponentItemServiceImpl extends BaseServiceImpl<ComponentItem, ComponentItemRepository> implements ComponentItemService {
	@Autowired
	private ComponentItemRepository componentItemRepository;

	@Override
	protected ComponentItemRepository getRepo() {
		return this.componentItemRepository;
	}

	@Override
	public ComponentItem findByComponentValue(String componentValue) {
		return this.componentItemRepository.findByComponentValueIgnoreCase(componentValue);
	}
	
	@Override
	public ComponentItem findByComponentItemIdHTML(String componentItemIdHTML) {
		return this.componentItemRepository.findByComponentItemIdHTML(componentItemIdHTML);
	}
	
	@Override
	public List<ComponentItem> findAllBy(String text) {
		Pageable pages = PageRequest.of(0, 100, Sort.by(Order.asc("textScore")));
        TextCriteria criteria = TextCriteria.forDefaultLanguage().matchingAny(text);
		return this.getRepo().findAllBy(criteria, pages);
	}

}
