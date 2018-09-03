package com.learncamel.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {
	private String id;
	private String name;
	private String joinDate;
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", joinDate=" + joinDate + "]";
	}
}
