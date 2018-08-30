package com.learncamel.routes.process;

import org.apache.camel.builder.RouteBuilder;

import com.learncamel.processor.CamelDirectExampleProcessor;

public class CamelModifyDirectProcessorRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("direct:processorInput")
		.log("Recevied message before process is ${body} and headers are ${headers}")
		.process(new CamelDirectExampleProcessor())
		.log("Recevied message is ${body} and headers are ${headers}")
		//.to("file:data/output?fileName=output.txt");
		.to("mock:output");
	}

}
