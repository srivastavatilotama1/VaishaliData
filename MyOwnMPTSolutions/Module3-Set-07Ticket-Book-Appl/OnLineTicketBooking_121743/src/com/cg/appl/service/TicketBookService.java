package com.cg.appl.service;

import java.util.List;

import com.cg.appl.Exception.BookingException;
import com.cg.appl.dto.ShowDetails;

public interface TicketBookService {

	List<ShowDetails> showDetails() throws BookingException;
	boolean upadteShow(ShowDetails showDetails,int reqseats) throws BookingException;
}
