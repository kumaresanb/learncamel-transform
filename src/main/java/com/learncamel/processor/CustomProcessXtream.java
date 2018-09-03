package com.learncamel.processor;

import java.util.StringTokenizer;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.learncamel.domain.Employee;

public class CustomProcessXtream implements Processor {

	public void process(Exchange exchange) throws Exception {

		StringTokenizer stringTokenizer = new StringTokenizer(exchange.getIn().getBody().toString(), ",");
		Employee employee = new Employee();
		while (stringTokenizer.hasMoreElements()) {
			employee.setId(stringTokenizer.nextToken());
			employee.setName(stringTokenizer.nextToken());
			employee.setJoinDate(stringTokenizer.nextToken());
		}		
		exchange.getIn().setBody(employee);
	}

}
