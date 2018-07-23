package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Address;
import model.CSVReader;
import model.Mail;

public class MailInputs{

    @FXML
    private TextField noOfMails;

    @FXML
    private Button btnNext;

    @FXML
    private Button btnBack;

    @FXML
    private TextArea displayDestination;

    @FXML
    private ComboBox<String> comboBox1;

    @FXML
    private Button Add;
    
    ArrayList<Address> AddressList = new ArrayList<Address>();
    ArrayList<Mail> MailContainer = new ArrayList<Mail>();
    
    
    @FXML
    public void initialize() {
    	CSVReader csvreader = new CSVReader();
    	
    	for(Address a:csvreader.readFile())
			AddressList.add(a);
    	
    	ObservableList<String> addresses = FXCollections.observableArrayList();
    	
    	
    	for(int i=0;i<AddressList.size();i++) {
    		String location = AddressList.get(i).getDestination();
    		addresses.add(location);
    	}
    	
    	comboBox1.setItems(addresses);
    	
    }
    
	public void display() {
		for(int i=0;i<MailContainer.size();i++) {
			System.out.println("Mail Location: " + MailContainer.get(i).getMailLocation());
			System.out.println("Mail Destination: " + MailContainer.get(i).getMailDestination());
			System.out.println("Mail Distance: " + MailContainer.get(i).getMailDistance());
			System.out.println("Mail Priority: " + MailContainer.get(i).getMailPriority());
		}
		System.out.println();
		System.out.println();
	}
	
	public void sort() {
		
		Collections.sort(MailContainer, Comparator.comparing((Mail m)->m.getMailLocation()).thenComparing(new Comparator<Mail>() {
			@Override
			public int compare(Mail o1, Mail o2) {
					if (o1.getMailDistance() > o2.getMailDistance()) 
						return 1;
	                else if (o1.getMailDistance() < o2.getMailDistance()) 
	                	return -1;
	                else 
	                	return 0;
			}
		}));
	}

}
