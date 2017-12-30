package com.cg.appl.service;

import java.util.List;

import com.cg.appl.Exception.BookingException;
import com.cg.appl.dao.TickeBookingImpl;
import com.cg.appl.dto.ShowDetails;

public class TicketBookingServiceImpl implements TicketBookService {
TickeBookingImpl tImpl=null;//Object of dao
	public TicketBookingServiceImpl() {
	tImpl=new TickeBookingImpl();
	}

	@Override
	public List<ShowDetails> showDetails() throws BookingException {
		// TODO Auto-generated method stub
		return tImpl.showDetails();
	}

	@Override
	public boolean upadteShow(ShowDetails showDetails, int reqseats)
			throws BookingException {
		// TODO Auto-generated method stub
		return tImpl.upadteShow(showDetails, reqseats);
	}

}
