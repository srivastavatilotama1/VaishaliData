package com.cg.car.service;

import java.util.List;

import com.cg.car.dao.CarDetailsDao;
import com.cg.car.dao.CarDetailsDaoImpl;
import com.cg.car.dto.Booking;
import com.cg.car.dto.CarDetails;
import com.cg.car.exception.CarException;

public class CarServiceImpl implements CarService {
	
	CarDetailsDao dao=new CarDetailsDaoImpl();
	
	/* (non-Javadoc)
	 * @see com.cg.car.service.CarService#getAllCarDetails()
	 */
	@Override
	public List<CarDetails> getAllCarDetails() throws CarException {
		return dao.getAllCarDetails();
	}
	
	/* (non-Javadoc)
	 * @see com.cg.car.service.CarService#insertBookingDetails(com.cg.car.dto.Booking)
	 */
	@Override
	public int insertBookingDetails(Booking booking,String num )
			throws CarException {
		return dao.insertBookingDetails(booking,num);
	}
	/* (non-Javadoc)
	 * @see com.cg.car.service.CarService#getCarId(java.lang.String)
	 */
	@Override
	public CarDetails getCarId(String carid) throws CarException {
		return dao.getCarId(carid);
	}
	

	

}
