/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start  ;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author alexi
 */
public class Start extends Application {

    @Override
    public void start(Stage stage) throws Exception {
    	try {
    		Parent root = FXMLLoader.load(getClass().getResource("/start/Login.fxml"));
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.setTitle("Tales of Euphona");
            stage.show();
 
    	}catch(Exception e) {
    		System.out.print(e.getMessage());
    		System.out.print("Falla");
    		return;
    	}
        


//        Parent root = FXMLLoader.load(getClass().getResource("Game.fxml"));
//        primaryStage.setTitle("Hello World");
//        primaryStage.setScene(new Scene(root, 1280, 720));
//        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}

