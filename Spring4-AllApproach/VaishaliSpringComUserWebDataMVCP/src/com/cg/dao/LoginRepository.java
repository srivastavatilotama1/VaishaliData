package com.cg.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.bean.Login;
import com.cg.bean.RegisterDto;


@Repository("loginJpaDao")
//@Transactional
public interface LoginRepository 
extends JpaRepository<Login, String>
{
	@Query("SELECT log FROM Login log where log.userName = :un") 
	Login getUserByUserName(@Param("un")  String un);
	
	@Query("UPDATE Login log SET log.password = :pw  WHERE log.userName= :un")
	void updateUserInfo(@Param("pw") String  pw,
			@Param("un") String  unm);	
	
}