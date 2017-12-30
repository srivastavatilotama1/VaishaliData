package com.cg.cricrec.dao;

public interface IQuaryMapper {

	public final static String FETCH_LIST = "SELECT player_id,player_name,ROUND((TRUNC(sysdate)-dob)/365)as age,country,batting_style,centuries,matches,total_run_score FROM cricket_score ORDER BY player_id";
	public static final String STORE_LIST = "INSERT INTO cricket_score VALUES(player_seq.NEXTVAL,?,?,?,?,?,?,?) ";

}
