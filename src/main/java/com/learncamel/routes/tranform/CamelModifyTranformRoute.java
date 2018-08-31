package com.learncamel.routes.tranform;

import org.apache.camel.builder.RouteBuilder;

public class CamelModifyTranformRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("direct:tranformInput")
		.transform(body().regexReplaceAll(",", "*"))
		.to("mock:output");
		
	}

}
