package com.viaflow.manager.api.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import com.viaflow.manager.api.entity.user.Team;

@Service
public interface TeamService extends BaseService<Team> {
	Page<Team> findByUser(String userId, int page, int count);
	Page<Team> findTeamByNameIgnoreCaseContaining(String name, int page, int count);

}
