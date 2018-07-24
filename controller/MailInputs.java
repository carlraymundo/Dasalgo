package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Address;
import model.CSVReader;
import model.Mail;
import model.location;

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
    
    @FXML
    ListView<String> list = new ListView<>();
    
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
//    	comboBox1.setOnAction((e) ->{
//    		list.getItems().add(comboBox1.getSelectionModel().getSelectedItem());
//    	});
//    	add();
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
		
		//comboBox1.setOnAction((e) ->{
    		list.getItems().add(selected);
    	//});
		
		for(int j=0;j<AddressList.size();j++) {
			if(AddressList.get(j).getDestination().equalsIgnoreCase(selected)) {
				Mail mail = new Mail();
				mail.setMailLocation(AddressList.get(j).getLocation());
				mail.setMailDestination(AddressList.get(j).getDestination());
				mail.setMailDistance(AddressList.get(j).getDistance());
				mail.setMailPriority(1);
				MailContainer.add(mail);
			}
		}
		//display();
		sort();
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
	
	private MainController c = new MainController();
	    
	    @FXML
	    void SelectCity(ActionEvent event) {
	    	c.SelectCity(event);
	    }
	    
	    @FXML
	    void ViewDelivery(ActionEvent event) {
	    	c.ViewDelivery(event, MailContainer,AddressList,location);
	    }

		public void setData(location location) {
			this.location = location;
		}
		
		private location location = null;

}
