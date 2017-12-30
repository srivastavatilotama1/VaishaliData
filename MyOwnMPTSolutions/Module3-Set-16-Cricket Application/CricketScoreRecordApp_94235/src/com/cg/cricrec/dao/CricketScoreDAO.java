package com.cg.cricrec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cg.cricrec.dto.CricketScoreDTO;
import com.cg.cricrec.exception.CricketScoreException;
import com.cg.cricrec.util.DBUtil;

public class CricketScoreDAO implements ICricketScoreDAO{
	
	
/**********************************************************************************************************************************
	 - Function Name	:	fetchList()
	 - Input Parameters	:	none
	 - Return Type		:	List<CricketScoreDTO>
	 - Throws			:  	CricketScoreException
	 - Author			:	Capgemini
	 - Creation Date	:	4/10/2016
	 - Description		:	Fetching player details from Database and sending it to fetchList() of CricketServiceImpl.
************************************************************************************************************************************/

	public List<CricketScoreDTO> fetchList() throws CricketScoreException {
	
		List<CricketScoreDTO> recList = new ArrayList<CricketScoreDTO>();
		CricketScoreDTO cricketscoredto =null;
		
		
		try 
		{
			Connection c = DBUtil.getConnection();
			PreparedStatement pstat;
			pstat = c.prepareStatement(IQuaryMapper.FETCH_LIST);
			ResultSet rs = pstat.executeQuery();
			while (rs.next()) 
			{
				cricketscoredto = new CricketScoreDTO();
				
				cricketscoredto.setPlayerId(rs.getInt(1));
				cricketscoredto.setPlayerName(rs.getString(2));
				cricketscoredto.setAge(rs.getInt(3));
				cricketscoredto.setTeam(rs.getString(4));
				cricketscoredto.setBattingstyle(rs.getString(5));
				cricketscoredto.setCenturies(rs.getInt(6));
				cricketscoredto.setMatchesplayed(rs.getInt(7));
				cricketscoredto.setTotalScore(rs.getInt(8));
				
				recList.add(cricketscoredto);
				
				
			} 
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new CricketScoreException("Cannot connect to database");
		}
		
		if(recList.isEmpty())
			throw new CricketScoreException("Player List is not present");
		return recList;
		
		
		
	}
	
/**********************************************************************************************************************************
	 - Function Name	:	insertData()
	 - Input Parameters	:	CricketScoreDTO cricketScoredto
	 - Return Type		:	Integer
	 - Throws			:  	CricketScoreException
	 - Author			:	Capgemini
	 - Creation Date	:	4/10/2016
	 - Description		:	Stroring the player details in the database.
************************************************************************************************************************************/


	public int insertData(CricketScoreDTO cricketScoredto) throws CricketScoreException {
		
		int result = 0;
		
		try 
		{
			PreparedStatement pstat;
			Connection c = DBUtil.getConnection();
			pstat = c.prepareStatement(IQuaryMapper.STORE_LIST);
			
			java.util.Date date = cricketScoredto.getDob();
			java.sql.Date sqldate = new java.sql.Date (date.getTime());
			
			pstat.setString(1, cricketScoredto.getPlayerName());
			pstat.setDate(2, sqldate);
			pstat.setString(3, cricketScoredto.getTeam());
			pstat.setString(4, cricketScoredto.getBattingstyle());
			pstat.setInt(5, cricketScoredto.getCenturies());
			pstat.setInt(6, cricketScoredto.getMatchesplayed());
			pstat.setInt(7, cricketScoredto.getTotalScore());
			
			result = pstat.executeUpdate();
			System.out.println(result);
			
		} 
		catch (SQLException e)
		{
			if(result == 0)
				throw new CricketScoreException("Could not Insert the values");
		}
		
		
		return result;
		
	}

}
