package com.cg.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.training.dto.Training;

public interface TrainingService {
	public List<Training> getAllData();
	public Training getDetailA(String id);
	public int updateDataFor(Training tra);
	
}
