package com.mindtree.entity.Employee;
import java.util.Date;

import com.mindtree.AnnotationsService.Column;
import com.mindtree.AnnotationsService.Id;
import com.mindtree.AnnotationsService.Table;

@Table(name="EMPLOYEE")
public class Employee {
	private int employeeId;
	private String employeeName;
	private Date hireDate;
	
	@Id
	@Column(name="EMP_ID", type="NUMBER(5)")
	public void setEmployeeId(int employeeId)
	{
		this.employeeId=employeeId;
	}
	@Column(name="EMP_NAME")
	public void setEmployeeName(String employeeName)
	{
		this.employeeName=employeeName;
	}
	@Column(name="HIRE_DATE", type="DATE")
	public void setHireDate(java.util.Date hireDate)
	{
		this.hireDate=(Date) hireDate;
	}
	public Employee()
	{
		setEmployeeId(0);
		setEmployeeName("");
		setHireDate(new Date(0));
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public String getEmployeeName() {
		return employeeName;
	}
}
