package com.cg.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.ParticipantRepository;
import com.cg.entities.Participants;
@Service("participantsService")
@Transactional	//This annotation will make automatic transaction management  
public class ParticipantsServiceImpl  implements IParticipantService
{
	@Autowired
	private ParticipantRepository participantDao;

	@Override
	public Participants addParticipants(Participants part) {
		// TODO Auto-generated method stub
		return participantDao.save(part);
	}

	@Override
	public long getNoOfParticipantCount(long workshopId) 
	{
		// TODO Auto-generated method stub
		return participantDao.getNoOfParticipantCount(workshopId);
	}

}
