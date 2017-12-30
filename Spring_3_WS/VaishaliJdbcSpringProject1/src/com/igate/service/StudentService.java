package com.igate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igate.bean.Student;
import com.igate.dao.StudentDAO;
@Service("studentService")
public class StudentService 
{
@Autowired
private StudentDAO studentDao;

public int addStudent(Student student)
{
	return studentDao.addStudent(student);
	
}

public int deleteStudent(Student student)
{
	return studentDao.deleteStudent(student);
	
}

public Student getStudentByRollNo(int rollno)
{
	return studentDao.getStudentByRollNo(111);
}
public List<Student> getAllStudent()
{
	return studentDao.getAllStudent();
}
	
}
