package com.learncamel.routes.xmlxstream;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import com.leanrcamel.routes.xmlxstream.UnMarshalRouteUsingXstream;
import com.learncamel.domain.Employee;

public class UnMarshalRouteUsingXstreamTest extends CamelTestSupport {

	@Override
	protected RoutesBuilder createRouteBuilder() throws Exception {
		return new UnMarshalRouteUsingXstream();
	}

	@Test
	public void unMarshalXtreamTest() throws InterruptedException {
		Employee employee = new Employee();
		employee.setId("123");
		employee.setName("kumaresan");
		employee.setJoinDate("02SEP2018");
		
		
		
		
		String xmlInput="<employee><id>123</id><name>kumaresan</name><joinDate>02SEP2018</joinDate></employee>";
		MockEndpoint mockEndpoint=getMockEndpoint("mock:output");
		mockEndpoint.expectedBodiesReceived(employee.toString());
		template.sendBody("direct:xmlInput", xmlInput);
		assertMockEndpointsSatisfied();
	}
}
