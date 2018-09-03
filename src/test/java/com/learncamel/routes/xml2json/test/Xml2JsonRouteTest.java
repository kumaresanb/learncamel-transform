package com.learncamel.routes.xml2json.test;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import com.learncamel.routes.xml2json.Xml2JsonRoute;

public class Xml2JsonRouteTest extends CamelTestSupport {

	@Override
	protected RoutesBuilder createRouteBuilder() throws Exception {
		return new Xml2JsonRoute();
	}
	
	@Test
	public void marshalEmployee2JsonXml() {
		String expected="{\"id\":\"123\",\"name\":\"kumaresan\",\"joinDate\":\"02SEP2018\"}";
		String inputXml="<employee><id>123</id><name>kumaresan</name><joinDate>02SEP2018</joinDate></employee>";
		String response= template.requestBody("direct:marshalEmployeexml2json", inputXml,String.class).toString();
		assertEquals(expected, response);
		
	}
	
	
	@Test
	public void unMarshalEmployee2XmlJson() {
		String expected="<?xml version=\"1.0\" encoding=\"UTF-8\"?><employee><id>123</id><joinDate>02SEP2018</joinDate><name>kumaresan</name></employee>";
		String inputXml="{\"id\":\"123\",\"name\":\"kumaresan\",\"joinDate\":\"02SEP2018\"}";
		
		String response= template.requestBody("direct:unMarshalEmployeejson2xml", inputXml,String.class).toString();
		System.out.println("Responce:"+response.replace("\n", "").replace("\r", ""));
		assertEquals(expected, response.replace("\n", "").replace("\r", ""));
		
	}
}
