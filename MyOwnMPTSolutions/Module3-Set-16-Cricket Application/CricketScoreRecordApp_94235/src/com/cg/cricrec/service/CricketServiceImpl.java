package com.cg.cricrec.service;

import java.util.ArrayList;
import java.util.List;

import com.cg.cricrec.dao.CricketScoreDAO;
import com.cg.cricrec.dto.CricketScoreDTO;
import com.cg.cricrec.exception.CricketScoreException;

public class CricketServiceImpl implements ICricketService {
	
	
/**********************************************************************************************************************************
	 - Function Name	:	fetchList()
	 - Input Parameters	:	none
	 - Return Type		:	List<CricketScoreDTO>
	 - Throws			:  	CricketScoreException
	 - Author			:	Capgemini
	 - Creation Date	:	4/10/2016
	 - Description		:	Calling fetchList() of  CricketScoreDAO to get the plater details from database. 
	 						Also returning the information received to the CrickrtScoreController (Servlet)
************************************************************************************************************************************/
	

	public List<CricketScoreDTO> fetchList() throws CricketScoreException {
		
		CricketScoreDAO cricketScoredao = new CricketScoreDAO();
		List<CricketScoreDTO> recList = new ArrayList<CricketScoreDTO>();
		recList = cricketScoredao.fetchList();
		
		return recList;
	}
	
	
	
/**********************************************************************************************************************************
	 - Function Name	:	insertData()
	 - Input Parameters	:	CricketScoreDTO cricketScoredto
	 - Return Type		:	Integer
	 - Throws			:  	CricketScoreException
	 - Author			:	Capgemini
	 - Creation Date	:	4/10/2016
	 - Description		:	Calling insertData() of  CricketScoreDAO to store the details into the database. 
	 						Also returning the success/failure information to the CrickrtScoreController (Servlet).
************************************************************************************************************************************/
	
	

	public int insertData(CricketScoreDTO cricketScoredto) throws CricketScoreException {
		
		CricketScoreDAO cricketScoredao = new CricketScoreDAO();
		int result = cricketScoredao.insertData(cricketScoredto);
		return result;
		
	}

}
