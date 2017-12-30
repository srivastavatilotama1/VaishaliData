package com.cg.training.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.cg.training.dao.TrainingDao;
import com.cg.training.dto.Training;
@Service
@Transactional
public class TrainingServiceImpl implements TrainingService{
    @Autowired
	TrainingDao trainingdao;
	@Override
	public List<Training> getAllData() {
		// TODO Auto-generated method stub
		return trainingdao.getAll();
	}

	@Override
	public Training getDetailA(String id) {
		// TODO Auto-generated method stub
		return trainingdao.getDetail(id);
	}

	@Override
	public int updateDataFor(Training tra) {
		// TODO Auto-generated method stub
		return trainingdao.updateData(tra);
	}

}
