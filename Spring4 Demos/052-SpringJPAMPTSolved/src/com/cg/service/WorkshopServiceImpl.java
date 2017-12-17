package com.cg.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.IParticipantDAO;
import com.cg.dao.IWorkshopDao;
import com.cg.entities.Workshop;

@Service("workshopService")
@Transactional	//This annotation will make automatic transaction management  
public class WorkshopServiceImpl implements IWorkshopService
{
	@Autowired
	private IWorkshopDao workshopDao;
	@Override
	public List<Workshop> getAllScheduledWS() {
		// TODO Auto-generated method stub
		return workshopDao.getAllScheduledWS();
	}

}
 