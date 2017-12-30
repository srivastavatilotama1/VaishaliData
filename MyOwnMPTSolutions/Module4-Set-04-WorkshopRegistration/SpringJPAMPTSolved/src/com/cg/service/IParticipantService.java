package com.cg.service;

import com.cg.entities.Participants;

public interface IParticipantService 
{
	public Participants addParticipants(Participants part) ;
	public long getNoOfParticipantCount(long workshopId);
}
