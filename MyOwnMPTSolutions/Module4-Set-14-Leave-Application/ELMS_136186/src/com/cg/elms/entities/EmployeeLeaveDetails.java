package com.cg.elms.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee_leave_details")
public class EmployeeLeaveDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4426328465424971234L;

	@Id
	@Column(name = "leave_id")
	private int leaveId;

	@Column(name = "empid")
	private int empId;

	@Column(name = "start_date")
	private Date startDate;

	@Column(name = "end_date")
	private Date endDate;

	@Column(name = "description")
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "leaves_applied")
	private int leavesApplied;

	public int getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getLeavesApplied() {
		return leavesApplied;
	}

	public void setLeavesApplied(int leavesApplied) {
		this.leavesApplied = leavesApplied;
	}

	@Override
	public String toString() {
		return "EmployeeLeaveDetails [leaveId=" + leaveId + ", empId=" + empId
				+ ", startDate=" + startDate + ", endDate=" + endDate
				+ ", description=" + description + ", leavesApplied="
				+ leavesApplied + "]";
	}

}
