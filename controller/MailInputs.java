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
    	
    	display1();
    	
    	ObservableList<String> addresses = FXCollections.observableArrayList();
    	
    	
    	for(int i=0;i<AddressList.size();i++) {
    		String location = AddressList.get(i).getDestination();
    		addresses.add(location);
    	}
    	
    	comboBox1.setItems(addresses);
    }
    
    public void display1() {
		for(int i=0;i<AddressList.size();i++) {
				System.out.println("Post office: " + AddressList.get(i).getPostoffice());
				System.out.println("Location: " + AddressList.get(i).getLocation());
				System.out.println("Destination: " + AddressList.get(i).getDestination());
				System.out.println("Distance: " + AddressList.get(i).getDistance());
			}
		System.out.println();
		System.out.println();
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
	
	public void add() {
		String selected = comboBox1.getValue();
		System.out.println("Selected input: " + selected);
		for(int j=0;j<AddressList.size();j++) {
			if(AddressList.get(j).getDestination().equalsIgnoreCase(selected)) {
//				int found =j;
//				System.out.println("value of j = " + found);
				Mail mail = new Mail();
				mail.setMailLocation(AddressList.get(j).getLocation());
				mail.setMailDestination(AddressList.get(j).getDestination());
				mail.setMailDistance(AddressList.get(j).getDistance());
				mail.setMailPriority(1);
				MailContainer.add(mail);
			}
		}
		display();
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
