package com.viaflow.manager.api.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.comment.Comment;

@Service
public interface CommentService extends BaseService<Comment> {
	Page<Comment> findAllByProjectId(String projectId, int page, int count);
}	
