package com.cg.appl.dao;

import java.util.List;

import javax.swing.text.StyledEditorKit.BoldAction;

import com.cg.appl.Exception.BookingException;
import com.cg.appl.dto.ShowDetails;

public interface TicketBooking {
	List<ShowDetails> showDetails() throws BookingException;
	boolean upadteShow(ShowDetails showDetails,int reqseats) throws BookingException;
}
