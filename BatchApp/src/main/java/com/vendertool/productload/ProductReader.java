package com.vendertool.productload;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

import au.com.bytecode.opencsv.CSVReader;

/**
 * {@link ItemReader} with hard-coded input data.
 */

@Component("productreader")
public class ProductReader implements ItemReader<String> {

	//Read CSV file .

	static String csvFilename = "C:\\1vtool\\Batch\\FileSpec\\testfile1.csv";
	static FileReader reader;
	static{
		try {
			reader = new FileReader(csvFilename);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	CSVReader csvReader = new CSVReader(reader);
			
	public int readFile() {
		String[] row = new String[20];
		try {
			while((row = csvReader.readNext()) != null) {
			    System.out.println(row[0]
			              + " # " + row[1]
			              + " #  " + row[2]);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//...
		try {
			csvReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return(0);
	}

	@Override
	public String read() throws Exception, UnexpectedInputException,
			ParseException, NonTransientResourceException {
		// TODO Auto-generated method stub
		readFile();
		return null;
	}

}
