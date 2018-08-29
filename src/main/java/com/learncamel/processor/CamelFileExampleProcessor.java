package com.learncamel.processor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.file.GenericFile;

public class CamelFileExampleProcessor implements Processor {

	public void process(Exchange exchange) throws Exception {
		System.out.println("Exchange in processor:" + exchange.getIn().getBody());
		GenericFile<File> genericFile = (GenericFile<File>) exchange.getIn().getBody();

		String readLine = null;
		String newValue = "";
		BufferedReader bufferedReader=null;
		FileReader fileReader=null;
		try {
		if (genericFile != null) {
			fileReader = new FileReader(genericFile.getFile());
			bufferedReader = new BufferedReader(fileReader);
			while ((readLine = bufferedReader.readLine()) != null) {
				System.out.println("Read Line is:" + readLine);
				newValue = newValue.concat(readLine.replace(",", ":")).concat("\n");
				exchange.getIn().setBody(newValue);
			}
		}
		}finally {
			if(fileReader!=null) {
				fileReader.close();
			}
			if(bufferedReader!=null) {
				bufferedReader.close();
			}
			
			
		}
	}

}
