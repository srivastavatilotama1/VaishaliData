package com.cg.dao;

import java.util.List;

import com.cg.dto.PlayerBean;
import com.cg.exception.CricketException;

public interface ICricketScoreDAO {

	int addPlayer(PlayerBean playerBean) throws CricketException;

	List<PlayerBean> viewPlayers() throws CricketException;

}
