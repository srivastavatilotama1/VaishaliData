package com.cg.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.cg.bean.Login;
import com.cg.bean.RegisterDto;
import com.cg.util.MyStringDateUtil;

@Repository("loginDao")
@Transactional
public class LoginDaoImpl  implements ILoginDao
{
	@PersistenceContext
	private EntityManager entityManager;
	public EntityManager getEntityManager() {
		return entityManager;
		
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Login getUserByUserName(String un)
	{
		Login log=entityManager.find(Login.class, un);
		System.out.println(" In Login Dao Rec retrieve is  "+ log);
		return log;
	}

	@Override
	public boolean isValid(String un)
	{
		return false;
	}

	@Override
	public boolean isUserExist(String un)
	{
	
		return false;
	}

	@Override
	public RegisterDto addAllUserDeatils(RegisterDto regDto) {
		
		System.out.println(" in dao regi ster obj is "+
				regDto);

		//Convert skillset array to string using , separator
		
		String skillSetString=
				MyStringDateUtil.fromArrayToCommaSeparatedString
				(regDto.getSkillSet());
		regDto.setSkillSetStr(skillSetString);
		
		 String gender=new Character(regDto.getGender()).toString();
		
		
		System.out.println("In dao skill is ..............................."+
				skillSetString+ "before persist : "+regDto);
		 entityManager.persist(regDto);
		
		 entityManager.flush();
		 System.out.println(" In Dao class after persist................"+regDto);
		 return  regDto;
	}

	@Override
	public Login addUser(Login log) {
		System.out.println(" in dao log obj is "+
				log);
		 entityManager.persist(log);
		 entityManager.flush();
		 System.out.println(" In Dao class after log ersist................"+log);
		 return  log;
	}

	@Override
	public ArrayList<RegisterDto> getAllUserDetails() {
		String fetchUserQry="SELECT u FROM RegisterDto u ";
		TypedQuery<RegisterDto> tq=
				entityManager.createQuery(fetchUserQry, 
						RegisterDto.class);
				
		ArrayList <RegisterDto> uList=(ArrayList)tq.
				getResultList();
		return uList;
	}

	@Override
	public RegisterDto getRegisterUserDetails(String un) {
		
		RegisterDto  regDto=entityManager.find(RegisterDto.class, un);
		System.out.println(" In getRegisterUserDetails Dao Rec retrieve is  "+ regDto);
		return regDto;		
	}

	@Override
	public void updateUserDetailsInfo(RegisterDto u) {
		
		String skillSetString=
				MyStringDateUtil.fromArrayToCommaSeparatedString
				(u.getSkillSet());
		u.setSkillSetStr(skillSetString);		
		Query query1 = entityManager.createQuery
				("UPDATE RegisterDto rd SET rd.lastName = :ln,"
						+ " rd.email =:eml ,rd.city = :ct, "
						+ " rd.skillSetStr=:ss  WHERE rd.uname= :un");
		
		Query query2 = entityManager.createQuery
				("UPDATE Login log SET log.password = :pw  WHERE log.userName= :un");
		
		query1.setParameter("ln", u.getLastName());
		query1.setParameter("eml", u.getEmail());
		query1.setParameter("ct", u.getCity());
		query1.setParameter("ss", u.getSkillSetStr());
		query1.setParameter("un", u.getUname());
		
		query2.setParameter("pw", u.getPwd());
		query2.setParameter("un", u.getUname());
		
		int dataUp1=query1.executeUpdate();
		int dataUp2=query2.executeUpdate();
	}

	@Override
	public  void updateUserInfo(Login lg) {
		Login lgg=entityManager.find(Login.class, lg.getUserName());
		entityManager.merge(lgg);
		 entityManager.flush();
		 Login lggg=entityManager.find(Login.class, lg.getUserName());
		System.out.println("in updateUserInfo updated..........."+lggg);System.out.println("In dao after merge and flush..........."+
		 lggg);
	}
	

}
