package com.viaflow.manager.api.entity.employee;

import java.util.Date;

import org.hibernate.validator.constraints.Currency;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.viaflow.manager.api.entity.base.DTOBase;
import com.viaflow.manager.api.entity.person.Person;

@Document
public class Employee extends DTOBase {

	@Id
	private String employeeId;

	@DBRef
	private Person person;

	@DBRef
	private Role role;

	@Currency(value = "BRL")
	private double salary;

	private Date hireDate;

	private Date fireDate;

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public Date getFireDate() {
		return fireDate;
	}

	public void setFireDate(Date fireDate) {
		this.fireDate = fireDate;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", person=" + person + ", role=" + role + ", salary=" + salary
				+ ", hireDate=" + hireDate + ", fireDate=" + fireDate + "]";
	}
}
