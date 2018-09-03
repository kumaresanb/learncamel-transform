package com.learncamel.bean;

public class CamelBean {
	public String map(String input) {
		return input.replace(",", "*");
	}
	
	public String map1(String input) {
		System.out.println("Map1 method is executed");
		return input.replace(",", "*");
	}
}
