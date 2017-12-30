package com.igatepatni.rest.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class EmployeeDS {

	private static Map<Integer, Employee> allEmployees;
	static {
		allEmployees = new HashMap<Integer, Employee>();
		
		Employee e1 = new Employee(12345, "Rahul Dravid", "rahul@ipl.com");
		Employee e2 = new Employee(17889, "Virat Kohli", "viratk@ipl.com");
		allEmployees.put(e1.getId(), e1);
		allEmployees.put(e2.getId(), e2);
		System.out.println("in static constr :" + allEmployees);
	}
	
	public void add(Employee e) {
		allEmployees.put(e.getId(), e);
	}

	public Employee getEmployee(int id) {
		System.out.println("in DS : " + id );
	    System.out.println(allEmployees.get(id));
		return allEmployees.get(id);
	}

	public List<Employee> getAll() {
		List<Employee> employees = new ArrayList<Employee>();
		for( Iterator<Employee> it = allEmployees.values().iterator(); it.hasNext(); ) {
			Employee e = it.next();
			employees.add(e);
		}
		return employees;
	}

	public void remove(int id) {
		allEmployees.remove(id);
	}

	public void update(Employee e) {
		allEmployees.put(e.getId(), e);
	}

}
