package start;

import start.ControllerGame;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ControllerLogin2 implements Initializable{

    @FXML
    private TextField nombre;
	
    @FXML
    private ComboBox<String> clase;

    @FXML
    void handleStart(ActionEvent event) {
    	if(nombre.getText().trim().length() < 4 || nombre.getText().trim().length() > 10) {
    		System.out.print("Longitud Incorrecta");
    	}else {
    		if(clase.getValue()!=null) {
    			try{
	                Stage stage = new Stage();
	                FXMLLoader loader = new FXMLLoader();
	               // AnchorPane root = (AnchorPane)loader.load(getClass().getResource("Game.fxml").openStream());
	                Parent root = loader.load(getClass().getResource("Game.fxml").openStream());
	                ControllerGame controllNewWindows = (ControllerGame)loader.getController();
	                controllNewWindows.setNombreAndClase(nombre.getText() , clase.getValue());
	
	                Scene escena = new Scene(root);
	                stage.setScene(escena);
	                stage.setTitle("Tales of Euphona");
	                stage.show();
	                ( (Node) (event.getSource() ) ).getScene().getWindow().hide();
	            }catch(IOException e){
	                return;
	            }
    		}
    		
    	}
    }
    
    ObservableList<String> list = FXCollections.observableArrayList("Mago", "Maga", "Guerrero", "Guerrera", "Arquero", "Arquera");
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	clase.setItems(list);
    }
}
