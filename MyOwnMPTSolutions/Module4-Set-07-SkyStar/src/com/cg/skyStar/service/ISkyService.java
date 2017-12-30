package com.cg.skyStar.service;

import java.util.List;

import com.cg.skyStar.bean.SkyStar;

public interface ISkyService {

	public List<SkyStar> getAll();
	public SkyStar getDetail(String productId);
}
