package com.viaflow.manager.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.viaflow.manager.api.entity.user.Team;
import com.viaflow.manager.api.repository.TeamRepository;
import com.viaflow.manager.api.service.TeamService;

@Service
public class TeamServiceImpl extends BaseServiceImpl<Team,TeamRepository> implements TeamService {

	@Autowired
	private TeamRepository teamRepository;
	
	@Override
	protected TeamRepository getRepo() {
		return this.teamRepository;
	}

	@Override
	public Page<Team> findByUser(String userId, int page, int count) {
		Pageable pages= PageRequest.of(page, count);
		return this.getRepo().findByUsersUserId(userId, pages);
	}

	@Override
	public Page<Team> findTeamByNameIgnoreCaseContaining(String name, int page, int count) {
		Pageable pages = PageRequest.of(0, 100);
		return this.getRepo().findByTeamNameIgnoreCaseContaining(name, pages);
	}

}
