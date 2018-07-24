package controller;

import java.util.ArrayList;
import java.util.function.Consumer;

import javafx.animation.PathTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.scene.shape.Line;
import javafx.util.Duration;
import model.Mail;
import model.location;
import model.Address;

public class DisplayDelivery {

    @FXML
    private ImageView motor1;

    @FXML
    private Label location1;

    @FXML
    private Label location2;

    @FXML
    private Label location3;

    @FXML
    private Label location4;

    @FXML
    private ImageView point1;

    @FXML
    private ImageView point2;

    @FXML
    private ImageView point3;

    @FXML
    private ImageView point4;

    @FXML
    private Label distance1;

    @FXML
    private Label distance2;

    @FXML
    private Label distance3;

    @FXML
    private Label distance4;

    @FXML
    private Label postName;

    @FXML
    private ImageView motor2;

    @FXML
    private Label location5;

    @FXML
    private Label location6;

    @FXML
    private Label location7;

    @FXML
    private Label location8;

    @FXML
    private ImageView point5;

    @FXML
    private ImageView point6;

    @FXML
    private ImageView point7;

    @FXML
    private ImageView point8;

    @FXML
    private Label distance5;

    @FXML
    private Label distance6;

    @FXML
    private Label distance7;

    @FXML
    private Label distance8;

    @FXML
    private ImageView motor3;

    @FXML
    private Label location9;

    @FXML
    private Label location10;

    @FXML
    private Label location11;

    @FXML
    private Label location12;

    @FXML
    private ImageView point9;

    @FXML
    private ImageView point10;

    @FXML
    private ImageView point11;

    @FXML
    private ImageView point12;

    @FXML
    private Label distance9;

    @FXML
    private Label distance10;

    @FXML
    private Label distance11;

    @FXML
    private Label distance12;
    
    ArrayList <Label> distances;
    ArrayList <Label> locations;
    
    @FXML
    public void initialize() {
    	
    	System.out.println("X value: " + motor1.getX());
    	System.out.println("Y value: " + motor1.getY());
    	System.out.println();
    	
    	distances = new ArrayList<Label>();
    	locations = new ArrayList<Label>();
    	
    	distances.add(distance1);
    	distances.add(distance2);
    	distances.add(distance3);
    	distances.add(distance4);
    	distances.add(distance5);
    	distances.add(distance6);
    	distances.add(distance7);
    	distances.add(distance8);
    	distances.add(distance9);
    	distances.add(distance10);
    	distances.add(distance11);
    	distances.add(distance12);
    	
    	locations.add(location1);
    	locations.add(location2);
    	locations.add(location3);
    	locations.add(location4);
    	locations.add(location5);
    	locations.add(location6);
    	locations.add(location7);
    	locations.add(location8);
    	locations.add(location9);
    	locations.add(location10);
    	locations.add(location11);
    	locations.add(location12);
    	
//    	double value = 550.00;
//    	motor1.setX(value);
//    	System.out.println("X value: " + motor1.getX());
    	 
    		
//    		int position1 = 100;
//    		motor1.setX(position1);
    	
//    		PathTransition transition = new PathTransition();
//    		transition.setNode(motor1);
//    		transition.setDuration(Duration.seconds(0.1));
//    		transition.setPath(line);
//    		transition.setCycleCount(PathTransition.INDEFINITE);
//    		transition.play();
    	
    		TranslateTransition transition = new TranslateTransition();
    		transition.setDuration(Duration.seconds(3));
    		double value = 100;
    		transition.setToX(value);
    		transition.setNode(motor1);
    		
    		EventHandler <ActionEvent> run = new EventHandler <ActionEvent> () {
				
				@Override
				public void handle(ActionEvent arg) {
					final TranslateTransition transition = new TranslateTransition();
		    		transition.setDuration(Duration.seconds(3));
		    		double value = motor1.getTranslateX() + 100;
		    		transition.setToX(value);
		    		transition.setNode(motor1);
		    		
		    		if (value <= 400)
		    			transition.setOnFinished(this);
		    		
		    		transition.play();
				}
			};
			

    		transition.setOnFinished(run);
			
			
    		
    		transition.play();
    		
    		transition = new TranslateTransition();
    		transition.setDuration(Duration.seconds(3));
    		value = 100;
    		transition.setToX(value);
    		transition.setNode(motor2);
    		
    		run = new EventHandler <ActionEvent> () {
				
				@Override
				public void handle(ActionEvent arg) {
					final TranslateTransition transition = new TranslateTransition();
		    		transition.setDuration(Duration.seconds(3));
		    		double value = motor2.getTranslateX() + 100;
		    		transition.setToX(value);
		    		transition.setNode(motor2);
		    		
		    		if (value <= 400)
		    			transition.setOnFinished(this);
		    		
		    		transition.play();
				}
			};
			

    		transition.setOnFinished(run);
			
			
    		
    		transition.play();
    		//boolean played = false;
    		
//    		while (motor1.getX() < 300) {
//    			if (!played) {
//    				transition.play();
//    				played = true;
//    			}   			
//    			
//    			if (value == 100) {
//    				transition.stop();
//    				played = false;
//    				try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//    				transition.setToX(300);
//    			}
//    		}
    	
    
    }

	public void setData(ArrayList<Mail> mailContainer,ArrayList<Address> addressList, location Location) {
		//for (int i = 0; i < )
		
		if(Location.getPostName().equals("Manila City")){
			
			for (int i = 0; i < mailContainer.size(); i++) {
				if(addressList.get(i).getPostoffice().equals("Manila City")) {
					locations.get(i).setText(mailContainer.get(i).getMailDestination());
					distances.get(i).setText(mailContainer.get(i).getMailDistance() + "");
				}
			}
		}
	}

}
