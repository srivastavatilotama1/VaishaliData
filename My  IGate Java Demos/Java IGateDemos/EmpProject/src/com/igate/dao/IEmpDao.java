package com.igate.dao;
import java.util.ArrayList;
import com.igate.bean.Emp;
import com.igate.exception.EmpException;

public interface IEmpDao 
{
	public void insertEmp(Emp emp)throws EmpException;
	public ArrayList<Emp> getAllEmp()throws EmpException;
	public Emp getEmpById(int eid)throws EmpException;
	public int getEmpRowCount();
}
