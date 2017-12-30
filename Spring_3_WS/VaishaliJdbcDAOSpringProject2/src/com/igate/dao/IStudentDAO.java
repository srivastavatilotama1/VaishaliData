package com.igate.dao;

import java.util.List;

import com.igate.bean.Student;

public interface IStudentDAO {
	public int addStudent(Student student);
	public int deleteStudent(Student stu);
	public int updateFees(Student stu);
	public Student getStudentByRollNo(int rollno);
	public List<Student> getAllStudent();
}
