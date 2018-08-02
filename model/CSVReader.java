package model;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CSVReader {
	
	public ArrayList<Address> readFile(){
		
	String csvFile = "C:\\Users\\Carl James Raymundo\\eclipse-workspace\\Dasalgo Test\\src\\Map.csv";
    String line = "";
    String cvsSplitBy = ",";
    
    ArrayList<Address> AddressList = new ArrayList<Address>();

    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
    	br.readLine();
        while ((line = br.readLine()) != null) {
        	Address address = new Address();
            // use comma as separator
            String[] loc = line.split(cvsSplitBy);
            address.setPostoffice(loc[0]);
            address.setLocation(loc[1]);
            address.setDestination(loc[2]);
            float distance = Float.parseFloat(loc[3]);
            address.setDistance(distance);
            AddressList.add(address);
        }

    } catch (IOException e) {
        e.printStackTrace();
    }
    return AddressList;
	}
}
