package com.cg.car.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cg.car.dto.Booking;
import com.cg.car.dto.CarDetails;
import com.cg.car.exception.CarException;

public class CarDetailsDaoImpl implements CarDetailsDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cg.car.dao.CarDetailsDao#getAllCarDetails()
	 */
	@Override
	public List<CarDetails> getAllCarDetails() throws CarException {
		String sql = "SELECT Car_Number,Car_Category,Hire_Price,Status from Car_Details";
		List<CarDetails> carlist = new ArrayList<CarDetails>();
		Connection conn = DButil.getConnection();
		try {

			Statement st = conn.createStatement();
			ResultSet rst = st.executeQuery(sql);
			while (rst.next()) {
				CarDetails car = new CarDetails();
				car.setCarNumber(rst.getString("Car_Number"));
				car.setCarCategory(rst.getString("Car_Category"));
				car.setHirePrice(rst.getInt("Hire_Price"));
				car.setStatus(rst.getString("STATUS"));

				carlist.add(car);
			}

		} catch (SQLException e) {
			throw new CarException("Problem in Selecting The Car Details"
					+ e.getMessage());
		}
		return carlist;
	}

	private int getBookingId() throws CarException {
		int bookingId;
		String sql = "SELECT BookingId_seq.NEXTVAL FROM dual";
		Connection conn = DButil.getConnection();
		try {
			Statement st = conn.createStatement();
			ResultSet rst = st.executeQuery(sql);
			rst.next();
			bookingId = rst.getInt(1);
		} catch (SQLException e) {

			throw new CarException(
					"Problem In Generating The Booking Id Sequence"
							+ e.getMessage());

		}

		return bookingId;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cg.car.dao.CarDetailsDao#insertBookingDetails(com.cg.car.dto.Booking)
	 */
	@Override
	public int insertBookingDetails(Booking booking ,String num) throws CarException {
		String sql = "INSERT INTO Booking VALUES(?,?,?,?,?,sysDate)";
		booking.setBookingId(getBookingId());
		
		Connection conn = DButil.getConnection();
		try {

			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setLong(1, booking.getBookingId());
			pst.setString(2, booking.getName());
			pst.setString(3, booking.getMobileNumber());
			pst.setString(4, booking.getEmail());
			pst.setString(5, booking.getAddress());

			 if(pst.executeUpdate()==1){
				 String s="UPDATE Car_Details SET Status='H' WHERE Car_Number=? ";
				 
				 PreparedStatement ps = conn.prepareStatement(s);
				 ps.setString(1,num);
				 ps.executeUpdate();
			 }
			
				

		} catch (SQLException e) {
			throw new CarException("Problem In Inserting The Booking Details"
					+ e.getMessage());
		}
		return booking.getBookingId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cg.car.dao.CarDetailsDao#getCarId(java.lang.String)
	 */
	@Override
	public CarDetails getCarId(String carid) throws CarException {
		String sql = "Select * from Car_Details where Car_Category=?";
		CarDetails car = null;
		Connection conn = DButil.getConnection();
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, carid);
			ResultSet rst = pst.executeQuery();
			if (rst.next()) {
				car = new CarDetails();
				car.setCarNumber(rst.getString("Car_Number"));
				car.setCarCategory(rst.getString("Car_Category"));
				car.setHirePrice(rst.getInt("Hire_Price"));
				car.setStatus(rst.getString("STATUS"));

			}
		} catch (SQLException e) {
			throw new CarException("Problem in selecting the car by Id:"
					+ e.getMessage());
		}
		return car;

	}
	
	
}
