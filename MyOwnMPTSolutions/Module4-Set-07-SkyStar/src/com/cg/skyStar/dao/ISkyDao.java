package com.cg.skyStar.dao;

import java.util.List;
import com.cg.skyStar.bean.SkyStar;

public interface ISkyDao {
	
	public List<SkyStar> getAll();
	public SkyStar getDetail(String custNum);
}
