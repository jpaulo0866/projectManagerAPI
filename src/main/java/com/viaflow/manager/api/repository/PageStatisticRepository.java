package com.viaflow.manager.api.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.viaflow.manager.api.entity.analytics.PageStatistic;

@Repository
public interface PageStatisticRepository extends MongoRepository<PageStatistic, String>{
	List<PageStatistic> findDistinctTop10ByUserUserIdOrderByCreatedDateDesc(String userId);
}
