package com.learncamel.routes.process.test;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import com.learncamel.routes.process.CamelModifyDirectProcessorRoute;

public class CamelModifyDirectProcessorRouteTest extends CamelTestSupport {
	@Override
	protected RoutesBuilder createRouteBuilder() throws Exception {
		return new CamelModifyDirectProcessorRoute();
	}

	@Test
	public void processorDirectTest() {
		String expected = "12345:kumarean:29thAUG";
		String input = "12345,kumarean,29thAUG";
		String output = (String) template.requestBody("direct:processorInput", input);
		assertEquals(expected, output);
	}

	@Test
	public void processorDirectUsingMock() throws InterruptedException {
		String expected = "12345:kumarean:29thAUG";
		MockEndpoint mockEndpoint = getMockEndpoint("mock:output");
		mockEndpoint.expectedBodiesReceived(expected);
		String input="12345,kumarean,29thAUG";
		template.sendBody("direct:processorInput", input);
		assertMockEndpointsSatisfied();
	}
}
