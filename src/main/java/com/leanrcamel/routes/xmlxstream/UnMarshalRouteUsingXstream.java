package com.leanrcamel.routes.xmlxstream;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.xstream.XStreamDataFormat;

import com.learncamel.domain.Employee;

public class UnMarshalRouteUsingXstream extends  RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("direct:xmlInput")
		.unmarshal(populateStreamDef())
		.to("log:?level=INFO&showBody=true")
		.to("mock:output");
		}
	
	private XStreamDataFormat populateStreamDef() {
		XStreamDataFormat xStreamDataFormat=new XStreamDataFormat();
		Map<String, String> aliases=new HashMap<String, String>();
		aliases.put("employee", Employee.class.getName());
		xStreamDataFormat.setAliases(aliases);
		xStreamDataFormat.setPermissions(Employee.class.getName());
		return xStreamDataFormat;
		
	}

}
