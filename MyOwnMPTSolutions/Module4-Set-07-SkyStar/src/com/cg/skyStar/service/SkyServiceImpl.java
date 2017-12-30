package com.cg.skyStar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.skyStar.bean.SkyStar;
import com.cg.skyStar.dao.ISkyDao;

@Service
public class SkyServiceImpl implements ISkyService {

	@Autowired
	ISkyDao dao;

	@Override
	public List<SkyStar> getAll() {
		List<SkyStar> skyStar = dao.getAll();
		for (SkyStar skyStar2 : skyStar) {
			if(skyStar2.getOptionalPack()==null){
				skyStar2.setOptionalPack("None");
			}
		}
		return skyStar;
	}

	@Override
	public SkyStar getDetail(String custNum) {
		SkyStar skyStar = dao.getDetail(custNum); 
		if(skyStar.getOptionalPack()==null){
			skyStar.setOptionalPack("None");
		}
		return skyStar;
	}

}
