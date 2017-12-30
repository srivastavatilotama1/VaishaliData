package com.cg.cricrec.service;

import java.util.List;

import com.cg.cricrec.dto.CricketScoreDTO;
import com.cg.cricrec.exception.CricketScoreException;

public interface ICricketService {

	public List<CricketScoreDTO> fetchList() throws CricketScoreException;
	public int insertData(CricketScoreDTO cricketScoredto) throws CricketScoreException;
}
