package controller;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Mail;
import model.location;
import model.Address;

public class MainController {

	
	public void changeScene(String link, ActionEvent e) {
    	Parent viewParent;
    	try {
    		viewParent = FXMLLoader.load(getClass().getResource(link));
    		Scene viewScene = new Scene(viewParent);
    		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
    		
    		window.setScene(viewScene);
    		window.show();
    		window.centerOnScreen();
    	}catch (IOException e1) {
    		e1.printStackTrace();
    	}
    }	
 
	 
	 
	void GetUserInput(ActionEvent event, location Location) {
		 	changeScene1("/view/MailInputs_Screen.fxml",event,Location);
		}
	 
	 @FXML
	 	void Start(ActionEvent event) {
		 changeScene("/view/Main_Screen.fxml",event);
	 }
	 
	 
		void ViewDelivery(ActionEvent event, ArrayList<Mail> mailContainer,ArrayList<Address> addressList,location Location) {
		 	changeScene("/view/Delivery_Screen.fxml",event, mailContainer,addressList,Location);
		}
	 
	 private void changeScene(String link, ActionEvent e, ArrayList<Mail> mailContainer,ArrayList<Address> addressList,location Location) {
		 Parent viewParent;
	    	try {
	    		
	    		FXMLLoader load = new FXMLLoader(getClass().getResource(link));
	    		viewParent = load.load();
	    		DisplayDelivery delivery = load.getController();
	    		
	    		delivery.setData(mailContainer,addressList, Location);
	    		Scene viewScene = new Scene(viewParent);
	    		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
	    		
	    		window.setScene(viewScene);
	    		window.show();
	    		window.centerOnScreen();
	    	}catch (IOException e1) {
	    		e1.printStackTrace();
	    	}
		}
	 
	 private void changeScene1(String link,ActionEvent e, location Location){
		 Parent viewParent;
	    	try {
	    		FXMLLoader load = new FXMLLoader(getClass().getResource(link));
	    		viewParent = load.load();
	    		MailInputs mailinputs = load.getController();
	    		
	    		mailinputs.setData(Location);
	    		Scene viewScene = new Scene(viewParent);
	    		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
	    		
	    		window.setScene(viewScene);
	    		window.show();
	    		window.centerOnScreen();
	    	}catch (IOException e1) {
	    		e1.printStackTrace();
	    	}
	 }
	 
	@FXML
	 	void SelectCity(ActionEvent event) {
		 changeScene("/view/postOffice_Screen.fxml",event);
	 }
	 
	 @FXML
	 void Exit(ActionEvent event) {
		 changeScene("/view/Main_Screen.fxml",event);
	 }
	 
	 
	
	 @FXML
	    void handleClose(ActionEvent event) {
	    	System.exit(0);
	    }

}
