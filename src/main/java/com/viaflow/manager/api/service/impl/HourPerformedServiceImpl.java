package com.viaflow.manager.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.viaflow.manager.api.entity.appropriation.HourPerformed;
import com.viaflow.manager.api.repository.HourPerformedRepository;
import com.viaflow.manager.api.service.HourPerformedService;

@Service
public class HourPerformedServiceImpl  extends BaseServiceImpl<HourPerformed, HourPerformedRepository> implements HourPerformedService{

	@Autowired
	private HourPerformedRepository hoursPerfomedRepository;
	
	@Override
	protected HourPerformedRepository getRepo() {
		return this.hoursPerfomedRepository;
	}


}
