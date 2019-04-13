package com.viaflow.manager.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.comment.Comment;
import com.viaflow.manager.api.repository.CommentRepository;
import com.viaflow.manager.api.service.CommentService;

@Service
public class CommentServiceImpl extends BaseServiceImpl<Comment, MongoRepository<Comment, String>> implements CommentService {

	@Autowired
	private CommentRepository commentRepository;
	
	@Override
	protected CommentRepository getRepo() {
		return this.commentRepository;
	}

	@Override
	public Page<Comment> findAllByProjectId(String projectId, int page, int count) {
		Pageable pageable = PageRequest.of(page, count);
		return this.commentRepository.findByProjectProjectId(projectId, pageable);
	}

}
