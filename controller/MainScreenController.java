package controller;


import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MainScreenController {

    @FXML
    
    private Button startID;
	 

    @FXML
    public void startDisplay(ActionEvent event) {
    	try {
    	Parent DisplayPostOffice = FXMLLoader.load(getClass().getResource("/view/postOffice_Screen.fxml"));
    	Scene DisplayPostOfficeScene = new Scene(DisplayPostOffice);
    	
    	Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	
    	window.setScene(DisplayPostOfficeScene);
    	window.show();
    	} catch(Exception e) {
			e.printStackTrace();
		}
    }

}
