package com.cg.service;

import java.util.List;

import com.cg.dto.PlayerBean;
import com.cg.exception.CricketException;

public interface ICricketServiceImpl {

	int addPlayer(PlayerBean playerBean) throws CricketException;

	List<PlayerBean> viewPlayers() throws CricketException;

	boolean validate(PlayerBean playerBean) throws CricketException;

}
