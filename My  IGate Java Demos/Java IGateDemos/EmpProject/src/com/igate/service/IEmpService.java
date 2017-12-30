package com.igate.service;
import java.util.ArrayList;
import com.igate.bean.Emp;
import com.igate.exception.EmpException;

public interface IEmpService 
{
	public void  addAllEmp(Emp emp)throws EmpException;
	public ArrayList<Emp> getAllEmp()throws EmpException;
	public boolean validateEmpId(String id);
	

}
