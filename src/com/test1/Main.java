package com.test1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/*
 * TASK1
 * 
 * Read and parse "testdata.csv"  into a list of POJOs. Increase
 * each POJO's "number" field by 1, and move the "date" field one day ahead.
 * Write the results to a file named "testdata.new.csv".
 */

public class Main {
	private static final List<User> users = new ArrayList<User>();

	private static final String DELIMITER = ";";
	private static final String ORIG_FILE = "testdata.csv";
	private static final String NEW_FILE = "testdata.new.csv";
	private static final String PATH = "";
	
	private static final DateFormat dateFormat= new SimpleDateFormat("dd/MM/yyyy");
	private static String HEADERLINE; 
	
	public static void main(String[] args) {
		getData();
		processData();
		writeData();
	  }

	/**
	 * read users from the csv file
	 */
	private static void getData() {
		try (BufferedReader reader = new BufferedReader(new FileReader(PATH+ORIG_FILE)); ) {
			String line;
			int lineNumber=0;

			while ((line = reader.readLine()) != null) {
				System.out.println("Reading the line:\t" +line);

				if(lineNumber == 0) {
					HEADERLINE = line;
					lineNumber++;
					continue;
				}
				getUserFromLine(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	  
	  /**
	   * get user from line
	   *
	   * @param line
	   */
	  private static void getUserFromLine(String line){
			String[] fields = line.split("\\s*" + DELIMITER + "\\s*");
			if (fields.length >=5) {
				try {
					User user = new User(fields[0],fields[1],fields[2], Integer.parseInt(fields[3]), dateFormat.parse(fields[4]));
					users.add(user);
				} catch (NumberFormatException | ParseException e) {
					e.printStackTrace();
				}
				
			} else {
				System.out.println("Data format not valid in string:" + line);
			}
	  }
	  
	  /**
	   * update users
	   */
	  private static void processData() {
		  if(! users.isEmpty()) {
			  users.forEach(user -> {
						  user.setNumber(user.getNumber()+1);
						  user.setDate(CSVUtils.changeDate(user.getDate(), 1));
					  }
			  );

		  } else {
			  System.out.println("There are no users!");
		  }
	  }

	  /**
	   * writes users to the csv file 
	   */
	  private static void writeData() {
		  try (	Writer writer  = new FileWriter(PATH+NEW_FILE)) {
			  	CSVUtils.writeLine(writer, DELIMITER, HEADERLINE);
				
				if (! users.isEmpty()) {
					for(User u : users){
						System.out.println("User after changes:" + u);
						CSVUtils.writeLine(writer, DELIMITER, u.getName(), u.getCity(), u.getCountry(),
								Integer.toString(u.getNumber()), dateFormat.format(u.getDate()));
					}
				} else {
					System.out.println("There are no users!");
				}

				System.out.println("CSV file " + NEW_FILE + " was created successfully !");
		  } catch (IOException e) {
				e.printStackTrace();
		  }
	  }
}
