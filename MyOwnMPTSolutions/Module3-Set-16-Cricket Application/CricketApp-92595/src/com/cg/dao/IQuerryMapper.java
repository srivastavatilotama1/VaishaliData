package com.cg.dao;

/****************************************************************************
-Class Name : IQuerryMapper
-Author : Samyaka Dalvi
-Creation date : 10/04/2016
-Description : Include the sql queries.
****************************************************************************/

public interface IQuerryMapper {
	String INSERTQUERY ="INSERT INTO cricket_score VALUES(player_seq.NEXTVAL,?,?,?,?,?,?,?)";
	String GETSEQUENCEID ="SELECT player_seq.CURRVAL FROM DUAL";
	String RETRIEVEALL ="SELECT player_id, player_name, dob, country, batting_style, centuries, matches, total_run_score FROM cricket_score";

}
