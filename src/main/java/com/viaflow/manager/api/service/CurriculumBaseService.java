package com.viaflow.manager.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.curriculum.CurriculumBase;

@Service
public interface CurriculumBaseService extends BaseService<CurriculumBase>{
	List<CurriculumBase> findAllBy(String text);
}
