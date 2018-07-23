package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
 
	 
	 @FXML
		void GetUserInput(ActionEvent event) {
		 	changeScene("howmanymails_Screen.fxml",event);
		}
	 
	 @FXML
	 	void Start(ActionEvent event) {
		 changeScene("mailmandelivery_Screen.fxml",event);
	 }
	 
	 
	 @FXML
		void ViewDelivery(ActionEvent event) {
		 	changeScene("movingmotor_Screen.fxml",event);
		}
	 
	 @FXML
	 	void SelectCity(ActionEvent event) {
		 changeScene("postOffice_Screen.fxml",event);
	 }
	 
	 
	
	 @FXML
	    void handleClose(ActionEvent event) {
	    	System.exit(0);
	    }

}
