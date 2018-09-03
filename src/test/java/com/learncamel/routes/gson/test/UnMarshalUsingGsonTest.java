package com.learncamel.routes.gson.test;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import com.learncamel.domain.Employee;
import com.learncamel.routes.gson.UnMarshalUsingGson;

public class UnMarshalUsingGsonTest extends CamelTestSupport {
	@Override
	protected RoutesBuilder createRouteBuilder() throws Exception {
		return new UnMarshalUsingGson();
	}
	
	@Test
	public void unMarshalUsingGson() {
		String input="{\"id\":\"1234\",\"name\":\"kumaresan\",\"joinDate\":\"02SEP2018\"}";
		Employee employee; 
		employee= template.requestBody("direct:unMarshalGSON", input,Employee.class);
		assertEquals("1234",employee.getId()) ;
		assertEquals("kumaresan",employee.getName()) ;
		assertEquals("02SEP2018",employee.getJoinDate()) ;
	}
	
}
