package com.learncamel.routes.xml2json;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.xmljson.XmlJsonDataFormat;

public class Xml2JsonRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("direct:marshalEmployeexml2json")
		.to("log:?level=INFO&showBody=true")
		.marshal().xmljson()
		.to("log:?level=INFO&showBody=true");
		
		from("direct:unMarshalEmployeejson2xml")
		.to("log:?level=INFO&showBody=true")
		.unmarshal(populateStreamDef())
		.to("log:?level=INFO&showBody=true")
		.to("mock:output");
		
	}
	
	private XmlJsonDataFormat populateStreamDef() {
		XmlJsonDataFormat xmlJsonDataFormat=new XmlJsonDataFormat();
		xmlJsonDataFormat.setRootName("employee");
		return xmlJsonDataFormat;
		
	}

}
