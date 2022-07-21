package com.edu;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Employee {

	private int employeeId;
	private String fisrtName;
	private String lastName;
	private String email;
	private int salary;
	
	private String hireDate;
	private String job;
	
}
