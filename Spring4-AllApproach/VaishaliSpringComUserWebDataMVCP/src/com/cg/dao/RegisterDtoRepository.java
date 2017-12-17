package com.cg.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.cg.bean.Login;
import com.cg.bean.RegisterDto;
@Repository("regJpaDao")

public interface RegisterDtoRepository extends 
JpaRepository<RegisterDto, String> 
{

	@Query("SELECT reg FROM RegisterDto reg where reg.uname = :un") 
	RegisterDto getRegisterUserDetails
    (@Param("un") String  unm);
	
	
	@Query("UPDATE RegisterDto rd SET rd.lastName = :ln,"
	+ "  rd.email =:eml ,rd.city = :ct, "
	+ "  rd.skillSetStr=:ss  WHERE rd.uname= :un")	
	void updateUserDetailsInfo(
			@Param("ln") String  ln,
			@Param("eml") String  eml,
			@Param("ct") String  ct,
			@Param("ss") String  ss,
			@Param("un") String  unm);
	
	@Query("SELECT regList FROM RegisterDto regList") 
	ArrayList<RegisterDto> getAllUserDetails();
}