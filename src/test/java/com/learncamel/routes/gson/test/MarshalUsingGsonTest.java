package com.learncamel.routes.gson.test;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import com.learncamel.domain.Employee;
import com.learncamel.routes.gson.MarshalUsingGson;

public class MarshalUsingGsonTest extends CamelTestSupport {
	
	@Override
	protected RoutesBuilder createRouteBuilder() throws Exception {
		return new MarshalUsingGson();
	}
	
	@Test
	public void marshalUsingGson() {
		String expected="{\"id\":\"1234\",\"name\":\"kumaresan\",\"joinDate\":\"02SEP2018\"}";
		Employee employee =new Employee();
		employee.setId("1234");
		employee.setName("kumaresan");
		employee.setJoinDate("02SEP2018");
		String response=template.requestBody("direct:marshalGSON", employee,String.class);
		assertEquals(expected, response);
	}

}
