package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import model.location;

public class DisplayPostOffice {

    @FXML
    private Button quezon;

    @FXML
    private Button makati;

    @FXML
    private Button pasay;

    @FXML
    private Button manila;
    
    @FXML
    private Button exit;
    
    private location Location = new location();
    
    
    private MainController c = new MainController();
    
    @FXML
    public void Manila(ActionEvent event) {
    	Location.setPostName("Manila City");
    	System.out.println(Location.getPostName());
    	c.GetUserInput(event,Location);
    }
    
    @FXML
    public void Quezon(ActionEvent event) {
    	Location.setPostName("Quezon City");
    	System.out.println(Location.getPostName());
    	c.GetUserInput(event,Location);
    }
   
    @FXML
    public void Makati(ActionEvent event) {
    	Location.setPostName("Makati City");
    	System.out.println(Location.getPostName());
    	c.GetUserInput(event,Location);
    }
    
    @FXML
    public void Pasay(ActionEvent event) {
    	Location.setPostName("Pasay City");
    	System.out.println(Location.getPostName());
    	c.GetUserInput(event,Location);
    }
    @FXML
    public void Exit(ActionEvent event) {
    	c.Exit(event);
    }

}
