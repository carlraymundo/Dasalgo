package controller;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Address;
import model.CSVReader;

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
    
    

}
