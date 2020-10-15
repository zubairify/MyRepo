package com.zs.one2manybi;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "mydept")
public class Department {
	@Id
	@Column(name = "dept_id")
	private int deptId;
	@Column(name = "dname", length = 15)
	private String deptName;
	
	@OneToMany(mappedBy = "dept", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	private List<Employee> employees = new ArrayList<Employee>();
	
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
}
