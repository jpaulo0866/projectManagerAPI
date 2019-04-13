package com.viaflow.manager.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.viaflow.manager.api.entity.user.Team;

@Repository
public interface TeamRepository extends MongoRepository<Team, String> {
	Page<Team> findByUsersUserId(String userId, Pageable pages);
	Page<Team> findByTeamNameIgnoreCaseContaining(String name, Pageable page);

}
