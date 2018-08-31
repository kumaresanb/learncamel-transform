package com.learncamel.routes.tranform.test;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import com.learncamel.routes.tranform.CamelModifyTranformRoute;

public class CamelModifyTranformRouteTest extends CamelTestSupport {

	@Override
	protected RoutesBuilder createRouteBuilder() throws Exception {
		return new CamelModifyTranformRoute();
	}

	@Test
	public void tranformTest() {
		String expected = "123*kumaresan*31AUG2018";
		String input = "123,kumaresan,31AUG2018";
		String actual = (String) template.requestBody("direct:tranformInput", input);
		assertEquals(expected, actual);
	}

	@Test
	public void tranformMockTest() throws InterruptedException {
		String expected = "123*kumaresan*31AUG2018";
		String input = "123,kumaresan,31AUG2018";
		MockEndpoint mockEndpoint = getMockEndpoint("mock:output");
		mockEndpoint.expectedBodiesReceived(expected);
		template.sendBody("direct:tranformInput", input);
		assertMockEndpointsSatisfied();

	}

}
