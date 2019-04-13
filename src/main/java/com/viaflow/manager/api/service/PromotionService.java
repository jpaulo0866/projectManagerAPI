package com.viaflow.manager.api.service;

import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.employee.Promotion;


@Service
public interface PromotionService extends BaseService<Promotion> {
	Promotion findByEmployeeId(String employeeId);
}
