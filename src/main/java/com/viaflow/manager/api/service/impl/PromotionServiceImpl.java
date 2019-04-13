package com.viaflow.manager.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.employee.Promotion;
import com.viaflow.manager.api.repository.PromotionRepository;
import com.viaflow.manager.api.service.PromotionService;

@Service
public class PromotionServiceImpl extends BaseServiceImpl<Promotion, PromotionRepository > implements PromotionService {

	
	@Autowired
	private PromotionRepository repo;
	
	@Override
	protected PromotionRepository getRepo() {
		return this.repo;
	}

	@Override
	public Promotion findByEmployeeId(String employeeId) {
		return this.getRepo().findByEmployeeEmployeeId(employeeId);
	}

}
