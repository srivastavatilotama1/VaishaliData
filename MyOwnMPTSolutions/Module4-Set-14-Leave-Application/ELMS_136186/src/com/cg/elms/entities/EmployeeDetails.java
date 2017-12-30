package com.cg.elms.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "employee_details")
public class EmployeeDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7013080308969942193L;

	@Id
	@NotNull
	@Range(max=999999, min=100000,message="Enter valid Employee Id")
	@Column(name = "empid")
	private int empId;

	@Column(name = "ename")
	private String empName;

	@Column(name = "address")
	private String address;

	@Column(name = "leaves_avail")
	private String leaves;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLeaves() {
		return leaves;
	}

	public void setLeaves(String leaves) {
		this.leaves = leaves;
	}

	@Override
	public String toString() {
		return "EmployeeDetails [empId=" + empId + ", empName=" + empName
				+ ", address=" + address + ", leaves=" + leaves + "]";
	}

	
}
