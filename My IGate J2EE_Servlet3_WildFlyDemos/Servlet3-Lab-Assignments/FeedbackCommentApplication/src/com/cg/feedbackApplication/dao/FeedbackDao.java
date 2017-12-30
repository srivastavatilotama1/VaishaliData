package com.cg.feedbackApplication.dao;

import java.util.ArrayList;

import com.cg.feedbackApplication.dto.Feedback;
import com.cg.feedbackApplication.exception.FeedbackException;

public interface FeedbackDao {
	public ArrayList<String> getAllFacultyNames() throws FeedbackException;
	public int addComments(Feedback bean) throws FeedbackException;


}
