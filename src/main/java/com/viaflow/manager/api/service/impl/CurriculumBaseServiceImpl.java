package com.viaflow.manager.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.curriculum.CurriculumBase;
import com.viaflow.manager.api.repository.CurriculumBaseRepository;
import com.viaflow.manager.api.service.CurriculumBaseService;

@Service
public class CurriculumBaseServiceImpl extends BaseServiceImpl<CurriculumBase, CurriculumBaseRepository> implements CurriculumBaseService {

	@Autowired
	private CurriculumBaseRepository curriculumBaseRepository;
	
	@Override
	protected CurriculumBaseRepository getRepo() {
		return this.curriculumBaseRepository;
	}
	
	@Override
	public List<CurriculumBase> findAllBy(String text) {
		Pageable pages = PageRequest.of(0, 100, Sort.by(Order.asc("textScore")));
        TextCriteria criteria = TextCriteria.forDefaultLanguage().matchingAny(text);
		return this.getRepo().findAllBy(criteria, pages);
	}

}
