package com.learncamel.route.bean;

import org.apache.camel.builder.RouteBuilder;

import com.lreancamel.bean.CamelBean;

public class CamelModifyBeanRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("direct:beanInput")
		.log("messge before bean class called : ${body}")
		.bean(new CamelBean(),"map1")
		.log("message after bean class called : ${body}")
		.to("mock:output");
		
	}

}
