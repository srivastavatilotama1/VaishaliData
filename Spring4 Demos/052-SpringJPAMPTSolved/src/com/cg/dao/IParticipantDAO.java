package com.cg.dao;

import com.cg.entities.Participants;

public interface IParticipantDAO 
{
	public  abstract  Participants addParticipants(Participants part);
	public long getNoOfParticipantCount(long workshopId);
}
