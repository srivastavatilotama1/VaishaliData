package com.cg.training.dao;

import java.util.List;

import com.cg.training.dto.Training;

public interface TrainingDao {
	public List<Training> getAll();
	public Training getDetail(String id);
	public int updateData(Training tra);
}
