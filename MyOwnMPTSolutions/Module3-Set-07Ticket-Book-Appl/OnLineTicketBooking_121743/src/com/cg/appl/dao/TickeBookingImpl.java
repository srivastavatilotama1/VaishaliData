/*********************************************************************
 * File                 : TicketBookingImpl.java
 * Author Name          : NIKHIL PANDEY
 * Desc                 : TicketBooking Implementation  of Application
 * Version              : 1.0
 * Creation Date        : 14-Mar-2017
 * Last Modified Date   : 14-Mar-2017
 *********************************************************************/
package com.cg.appl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cg.appl.Exception.BookingException;
import com.cg.appl.dto.ShowDetails;
import com.cg.appl.util.JndiUtil;

public class TickeBookingImpl implements TicketBooking {
	private JndiUtil jdbcUtill = null;

	public TickeBookingImpl() {
		try {
			jdbcUtill = new JndiUtil();
		} catch (BookingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<ShowDetails> showDetails() throws BookingException {
		// SHOWING DEATILS
		PreparedStatement stat = null;
		Connection connection = null;
		ResultSet rs = null;
		List<ShowDetails> list = new ArrayList<ShowDetails>();

		String Query = "select * from ShowDetails ";
		try {

			connection = jdbcUtill.getConnection();
			stat = connection.prepareStatement(Query);
			rs = stat.executeQuery();
			while (rs.next()) {
				String showid = rs.getString("showid");
				String showname = rs.getString("showname");
				String location = rs.getString("location");
				java.sql.Date showdate = rs.getDate("showdate");
				int avseats = rs.getInt("avseats");
				double priceticket = rs.getInt("priceticket");
				ShowDetails showDetails = new ShowDetails(showid, showname,
						location, showdate, avseats, priceticket);
				list.add(showDetails);
			}
			return list;

		} catch (SQLException e) {
			throw new BookingException("UNABLE TO FETCH DATA");
		} finally {
			if (rs != null) {
				try {
					rs.close();
					if (stat != null) {
						stat.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					throw new BookingException("Connection Closing failed");
				}
			}

		}

	}

	@Override
	public boolean upadteShow(ShowDetails showDetails, int reqseats)
			throws BookingException {
		// Updating Seats
		PreparedStatement stat = null;
		Connection connection = null;
		ResultSet rs = null;
		String Query = "UPDATE ShowDetails SET avseats = ? WHERE ShowId=? ";

		try {
			if (showDetails.getAvseats() - reqseats >= 0) {
				connection = jdbcUtill.getConnection();
				stat = connection.prepareStatement(Query);
				stat.setInt(1, showDetails.getAvseats() - reqseats);
				stat.setString(2, showDetails.getShowid());
				rs = stat.executeQuery();
				if (rs.next()) {
					return true;
				} else {
					return false;
				}

			} else {
				throw new BookingException(
						"Not enough required Booking seats are availabe ");
			}

		} catch (SQLException e1) {
			throw new BookingException("CAN NOT UPADTE INTO TABLE");

		}

	}

}
