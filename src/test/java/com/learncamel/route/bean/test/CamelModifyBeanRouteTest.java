package com.learncamel.route.bean.test;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import com.learncamel.route.bean.CamelModifyBeanRoute;

public class CamelModifyBeanRouteTest extends CamelTestSupport {
	
	@Override
	protected RoutesBuilder createRouteBuilder() throws Exception {
		return new CamelModifyBeanRoute();
	}
	
	@Test
	public void beanTest() {
		String expected = "123*kumaresan*31AUG2018";
		String input = "123,kumaresan,31AUG2018";
		String actual = (String) template.requestBody("direct:beanInput", input);
		assertEquals(expected, actual);
	}
	
	@Test
	public void beanMockTest() throws InterruptedException {
		String expected = "123*kumaresan*31AUG2018";
		String input = "123,kumaresan,31AUG2018";
		MockEndpoint mockEndpoint =getMockEndpoint("mock:output");
		mockEndpoint.expectedBodiesReceived(expected);
		template.sendBody("direct:beanInput", input);
		assertMockEndpointsSatisfied();
	}

}
