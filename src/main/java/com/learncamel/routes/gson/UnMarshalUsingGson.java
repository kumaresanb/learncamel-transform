package com.learncamel.routes.gson;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.gson.GsonDataFormat;

import com.learncamel.domain.Employee;

public class UnMarshalUsingGson extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("direct:unMarshalGSON")
		.log("Before UnMarshaling object is: ${body}")
		.unmarshal(new GsonDataFormat(Employee.class))
		.log("UnMarshaled object is: ${body}");
		
	}

}
