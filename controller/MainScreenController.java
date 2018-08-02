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
    private Button Start;
	 

    private MainController c = new MainController();
    
    @FXML
    void SelectCity(ActionEvent event) {
    	c.SelectCity(event);
    }
}
