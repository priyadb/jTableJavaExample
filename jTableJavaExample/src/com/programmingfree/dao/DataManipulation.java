package com.programmingfree.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

import com.programmingfree.model.*;
public class DataManipulation {
	
	public static List<Customers> getAllCustomers() throws IOException{
		List<Customers> lstCustomer=new ArrayList<Customers>();
		String csvFilename = "customer.csv";
			   InputStream is =  Thread.currentThread().getContextClassLoader().getResourceAsStream(csvFilename);
			   BufferedReader br = new BufferedReader(new InputStreamReader(is));
			   CSVReader csvReader = new CSVReader(br,'|');
			   String[] row = null;
			   while((row = csvReader.readNext()) != null) {				  
			      lstCustomer.add(new Customers(row[0],row[1],row[2],row[3],row[4])); 
				   
				}
		return lstCustomer;
	}
}
