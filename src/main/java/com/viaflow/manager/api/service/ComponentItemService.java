package com.viaflow.manager.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.component.ComponentItem;


@Service
public interface ComponentItemService extends BaseService<ComponentItem> {
	ComponentItem findByComponentValue(String componentValue);
	ComponentItem findByComponentItemIdHTML(String componentItemIdHTML);
	List<ComponentItem> findAllBy(String text);

}