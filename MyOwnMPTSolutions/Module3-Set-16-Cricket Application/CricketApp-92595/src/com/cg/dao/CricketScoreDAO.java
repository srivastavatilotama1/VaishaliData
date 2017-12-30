package com.cg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import com.cg.dto.PlayerBean;
import com.cg.exception.CricketException;
import com.cg.util.DBConnection;

public class CricketScoreDAO implements ICricketScoreDAO {

	
/****************************************************************************
-Method Name : addPlayer
-Input parameters : playerBean
-Return Type : integer
-Throws : CricketException
-Author : Samyaka Dalvi
-Creation date : 10/04/2016
-Description : adding a new player.
	****************************************************************************/
	@Override
	public int addPlayer(PlayerBean playerBean) throws CricketException {
		
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int queryResult = 0;
		int playerID = 0;

		try {
			conn = DBConnection.getConnection();
			if (conn == null) {
				System.out.println("con created");
				throw new CricketException(
			"There is some problem with database connection. Please try again after some time");
			}
			preparedStatement = conn
					.prepareStatement(IQuerryMapper.INSERTQUERY);
			
			
			//getting the inserted values and if its > 0 then generate a playerId for the player.
			
			
			preparedStatement.setString(1, playerBean.getPlayerName());
			
			preparedStatement.setDate(2, new java.sql.Date(playerBean.getDob().getTime()));
			
			preparedStatement.setString(3, playerBean.getCountry());
			preparedStatement.setString(4, playerBean.getBattingStyle());
			preparedStatement.setInt(5, playerBean.getCenturies());
			preparedStatement.setInt(6, playerBean.getMatches());
			preparedStatement.setInt(7, playerBean.getTotalRunScore());
			
		
			queryResult = preparedStatement.executeUpdate();

			if (queryResult > 0) {
				preparedStatement = conn
						.prepareStatement(IQuerryMapper.GETSEQUENCEID); //generating sequence i.e. player Id.
				resultSet = preparedStatement.executeQuery();
			} else {
				throw new CricketException("Insertion Failed");
			}

			if (resultSet.next()) {
				playerID = resultSet.getInt(1);
			}

		} catch (SQLException e) {
			throw new CricketException("Problem while inserting : " + e.getMessage());
		} finally {
			// close all the resources
		}

		return playerID; //returning value to service class.
		
		
	}
	
/****************************************************************************
-Method Name : List
-Input parameters : PlayerBean
-Return Type : integer
-Throws : CricketException
-Author : Samyaka Dalvi
-Creation date : 10/04/2016
-Description : retrieving player information.
****************************************************************************/
	
	@Override
	public List<PlayerBean> viewPlayers() throws CricketException { //creating a list.
	
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<PlayerBean> playerList = new ArrayList<PlayerBean>();
		PlayerBean playerBean = null;
		conn = DBConnection.getConnection();
		
		try {
			preparedStatement = conn.prepareStatement(IQuerryMapper.RETRIEVEALL);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				
				playerBean = new PlayerBean();
			
				//retrieving data.
				playerBean.setPlayerId(resultSet.getInt(1));
				playerBean.setPlayerName(resultSet.getString(2));
				playerBean.setDob(resultSet.getDate(3));
				playerBean.setCountry(resultSet.getString(4));
				playerBean.setBattingStyle(resultSet.getString(5));
				playerBean.setCenturies(resultSet.getInt(6));
				playerBean.setMatches(resultSet.getInt(7));
				playerBean.setTotalRunScore(resultSet.getInt(8));
				
				
				Calendar calNow = Calendar.getInstance();
				calNow.setTime(new java.util.Date());
				
				Calendar dob = Calendar.getInstance();
				dob.setTime(resultSet.getDate(3));
								
				int age = calNow.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
				
				playerBean.setAge(age);
				
				playerList.add(playerBean);
				
				playerBean = new PlayerBean();
			}
		} catch (SQLException e) {
			
			throw new CricketException("Error in retrieval" + e.getMessage());
		}finally{
			//close all the resources.
		}
		
		return playerList; //returning value to service class.
	}

}
