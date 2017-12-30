package com.cg.car.service;

import java.util.List;

import com.cg.car.dto.Booking;
import com.cg.car.dto.CarDetails;
import com.cg.car.exception.CarException;

public interface CarService {

	public abstract List<CarDetails> getAllCarDetails() throws CarException;

	public abstract int insertBookingDetails(Booking booking,String num)
			throws CarException;

	public abstract CarDetails getCarId(String carid ) throws CarException;


}