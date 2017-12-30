package com.cg.service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.dao.CricketScoreDAO;
import com.cg.dao.ICricketScoreDAO;

import com.cg.dto.PlayerBean;
import com.cg.exception.CricketException;


public class CricketServiceImpl implements ICricketServiceImpl {
	


	ICricketScoreDAO cricketScoreDAO = new CricketScoreDAO();//creating object for dao.


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

		return cricketScoreDAO.addPlayer(playerBean); //getting from dao.

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
	public List<PlayerBean> viewPlayers() throws CricketException {

		return cricketScoreDAO.viewPlayers(); //getting from dao.

	}

	
/****************************************************************************
-Method Name : validate
-Input parameters : playerBean
-Return Type : boolean
-Throws : CricketException
-Author : Samyaka Dalvi
-Creation date : 10/04/2016
-Description : validating data entered.
****************************************************************************/

	@Override
	public boolean validate(PlayerBean playerBean) throws CricketException {
		Pattern pattern = null;
		Matcher matcher = null;

		// Player Name Validation
		pattern = Pattern.compile("^[A-Za-z\\s]{3,25}$");
		matcher = pattern.matcher(playerBean.getPlayerName());
		if (!matcher.find()) {
			throw new CricketException("Please Enter Correct Name ");
		}

		// Country Validation
		pattern = Pattern.compile("^[A-Za-z0-9\\s,./]{3,}$");
		matcher = pattern.matcher(playerBean.getCountry());
		if (!matcher.matches()) {
			throw new CricketException("Please Enter Correct Country Name ");
		}

		// Batting Style Validation
		pattern = Pattern.compile("^[A-Za-z\\s]{3,25}$");
		matcher = pattern.matcher(playerBean.getBattingStyle());
		if (!matcher.find()) {
			throw new CricketException("Please Enter Valid alphabets ");
		}

		// Number of Centuries Validation
		if (playerBean.getCenturies() < 0) {

			throw new CricketException("Please Enter Valid Number.");

		}

		// Number of Matches Validation
		if (playerBean.getMatches() < 0) {

			throw new CricketException("Please Enter Valid Number.");

		}

		// Total Number of runs Validation
		if (playerBean.getTotalRunScore() < 0) {

			throw new CricketException("Please Enter Valid Number.");

		}
		return true;
	}

}
