package com.viaflow.manager.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.viaflow.manager.api.entity.employee.Promotion;

public interface PromotionRepository extends MongoRepository<Promotion, String> {
	Promotion findByEmployeeEmployeeId(String employeeId);
}