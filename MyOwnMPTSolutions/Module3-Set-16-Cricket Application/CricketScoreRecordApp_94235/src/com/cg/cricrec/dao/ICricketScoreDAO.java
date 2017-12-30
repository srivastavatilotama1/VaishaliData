package com.cg.cricrec.dao;

import java.util.List;

import com.cg.cricrec.dto.CricketScoreDTO;
import com.cg.cricrec.exception.CricketScoreException;

public interface ICricketScoreDAO {
	
	public List<CricketScoreDTO> fetchList() throws CricketScoreException;
	public int insertData(CricketScoreDTO cricketScoredto) throws CricketScoreException;

}
