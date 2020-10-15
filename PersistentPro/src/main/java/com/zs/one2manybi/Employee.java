package com.zs.one2manybi;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "myemp")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "emp_id")
	private int empId;
	@Column(name = "ename", length = 20)
	private String empName;
	private double salary;
	
	@ManyToOne
	@JoinColumn(name = "dept_id")
	private Department dept;
	
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
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
}
