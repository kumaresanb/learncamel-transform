package com.learncamel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class CamelDirectExampleProcessor implements Processor {

	public void process(Exchange exchange) throws Exception {
		try {
			String newValue=exchange.getIn().getBody().toString().replace(",", ":");
			exchange.getIn().setBody(newValue);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
