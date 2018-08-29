package com.learncamel.routes.test;

import java.io.File;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import com.learncamel.routes.CamelModifyFileProcessorRoute;

public class CamelModifyFileProcessorRouteTest extends CamelTestSupport {
	
	@Override
	protected RoutesBuilder createRouteBuilder() throws Exception {
		return new CamelModifyFileProcessorRoute();
	}
	
	@Test
	public void processorTest() throws InterruptedException {	
		
		
		Thread.sleep(5000);
		
		File file =new File("data/output");
		assertTrue(file.isDirectory());
		
	}
	@Test
	public void mockEndPointTest() throws InterruptedException {
		String expectedValue="12345:kumarean:29thAUG\n" + 
				"23422:ram:29thAUG\n";
		MockEndpoint mockEndpoint =getMockEndpoint("mock:output");
		mockEndpoint.expectedBodiesReceived(expectedValue);
		assertMockEndpointsSatisfied();
	}

}
