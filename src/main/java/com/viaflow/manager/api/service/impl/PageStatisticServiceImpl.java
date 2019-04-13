package com.viaflow.manager.api.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.analytics.PageStatistic;
import com.viaflow.manager.api.repository.PageStatisticRepository;
import com.viaflow.manager.api.service.PageStatisticService;

@Service
public class PageStatisticServiceImpl extends BaseServiceImpl<PageStatistic, MongoRepository<PageStatistic,String>> implements PageStatisticService {
	
	@Autowired
	private PageStatisticRepository pageStatisticRepository; 

	@Override
	protected MongoRepository<PageStatistic, String> getRepo() {
		return pageStatisticRepository;
	}
	
	private String pageLink;

	@Override
	public List<PageStatistic> findLastAcessedByUser(String userId) {
		List<PageStatistic> tempList = this.pageStatisticRepository.findDistinctTop10ByUserUserIdOrderByCreatedDateDesc(userId);
		List<PageStatistic> newList = new ArrayList<>();
		tempList.forEach((t) -> {
			pageLink = t.getPageLink();
			Predicate<PageStatistic> findByLink = e -> {
				return e.getPageLink().equals(pageLink);
			};
			if (!newList.stream().anyMatch(findByLink)) {
				t.setUser(null);
				newList.add(t);
			}
		});
		
		return newList;		
	}

}
