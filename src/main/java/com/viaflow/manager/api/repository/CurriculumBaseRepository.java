package com.viaflow.manager.api.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.viaflow.manager.api.entity.curriculum.CurriculumBase;

@Repository
public interface CurriculumBaseRepository extends MongoRepository<CurriculumBase, String> {
	List<CurriculumBase> findAllBy(TextCriteria criteria, Pageable pages);
}
