package com.cg.feedbackApplication.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.cg.feedbackApplication.dto.Feedback;
import com.cg.feedbackApplication.exception.FeedbackException;

public class FeedbackDaoImpl implements FeedbackDao {

	@Override
	public ArrayList<String> getAllFacultyNames() throws FeedbackException {
		
		System.out.println("in dao class ");
		ArrayList<String> list;
		try {
			list = new ArrayList<String>();
			String sql= "select facultyName from facultyDetails";
			Connection con= DBUtil.getConnection();
			Statement st= con.createStatement();
			ResultSet rs= st.executeQuery(sql);
			while(rs.next()){
				String name= rs.getString(1);
				list.add(name);
			}
			
		} catch (FeedbackException e) {
			e.printStackTrace();
			throw new FeedbackException(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new FeedbackException(e.getMessage());
		}
			
		return list;
	}

	@Override
	public int addComments(Feedback bean) throws FeedbackException {

			int feedbackId=0;
			String sql= "Insert into feedbackDetails values (feedbackId_seq.nextval,?,?)";
			try {
				Connection con=DBUtil.getConnection();
				PreparedStatement ps= con.prepareStatement(sql);
				ps.setString(1, bean.getFacultyName());
				ps.setString(2, bean.getComment());
				int row=ps.executeUpdate();
				if(row==1){
						 sql= "select feedbackId_seq.currval from dual";
						Statement st= con.createStatement();
						ResultSet rs= st.executeQuery(sql);
						if (rs.next()){
							feedbackId = rs.getInt(1);
							return feedbackId;
						}
				}
			} catch (FeedbackException e) {
				throw new FeedbackException(e.getMessage());
			} catch (SQLException e) {
				throw new FeedbackException(e.getMessage());
				}

		return feedbackId;
	}

}
