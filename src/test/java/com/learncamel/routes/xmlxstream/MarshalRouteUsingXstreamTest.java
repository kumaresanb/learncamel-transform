package com.learncamel.routes.xmlxstream;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import com.leanrcamel.routes.xmlxstream.MarshalRouteUsingXstream;

public class MarshalRouteUsingXstreamTest extends CamelTestSupport {
	
	@Override
	protected RoutesBuilder createRouteBuilder() throws Exception {
		return new MarshalRouteUsingXstream();
	}
	
	@Test
	public void marshalXtreamTest() throws InterruptedException {
		String input="123,kumaresan,02SEP2018";
		String expectedOutput="<?xml version='1.0' encoding='UTF-8'?><employee><id>123</id><name>kumaresan</name><joinDate>02SEP2018</joinDate></employee>";
		MockEndpoint mockEndpoint=getMockEndpoint("mock:output");
		mockEndpoint.expectedBodiesReceived(expectedOutput);
		template.sendBody("direct:csvInput", input);		
		assertMockEndpointsSatisfied();
	}
}
