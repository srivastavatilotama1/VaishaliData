package com.cg.feedbackApplication.service;

import java.util.ArrayList;

import com.cg.feedbackApplication.dao.FeedbackDao;
import com.cg.feedbackApplication.dao.FeedbackDaoImpl;
import com.cg.feedbackApplication.dto.Feedback;
import com.cg.feedbackApplication.exception.FeedbackException;

public class FeedbackServiceImpl implements FeedbackService{

	FeedbackDao dao= new FeedbackDaoImpl();
	@Override
	public ArrayList<String> getAllFacultyNames() throws FeedbackException {
		// TODO Auto-generated method stub
		System.out.println("in service class");
		return dao.getAllFacultyNames();
	}

	@Override
	public int addComments(Feedback bean) throws FeedbackException {
		// TODO Auto-generated method stub
		return dao.addComments(bean);
	}

}
