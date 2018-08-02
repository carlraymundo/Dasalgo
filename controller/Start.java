package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Start extends Application{

		// TODO Auto-generated method stub
		@Override
		public void start(Stage primaryStage) {
			try {
			    Parent root = FXMLLoader.load(getClass().getResource("/view/Main_Screen.fxml")); 
				Scene scene = new Scene(root);
				
				primaryStage.setScene(scene);
				primaryStage.setTitle("Mailman Delivery Simulation Program");
				primaryStage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		public static void main(String[] args) {
			launch(args);
		}
}

