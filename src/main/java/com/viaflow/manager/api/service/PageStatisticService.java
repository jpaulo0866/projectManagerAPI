package com.viaflow.manager.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.analytics.PageStatistic;

@Service
public interface PageStatisticService extends BaseService<PageStatistic> {
	List<PageStatistic> findLastAcessedByUser(String userId);

}
