package com.learncamel.routes.gson;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.gson.GsonDataFormat;

import com.learncamel.domain.Employee;

public class MarshalUsingGson extends RouteBuilder {
	
	
	@Override
	public void configure() throws Exception {
		from("direct:marshalGSON")
		.log("Before Marshaling object is: ${body}")
		.marshal(new GsonDataFormat(Employee.class))
		.log("Marshaled object is: ${body}");
	}

}
