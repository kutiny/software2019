package start;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

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

public class ControllerLogin implements Initializable{

	private final int MINNAMELENGTH = 4;
	private final int MAXNAMELENGTH = 10;
	
    @FXML
    private TextField nombre;
	
    @FXML
    private ComboBox<String> clase;
    
    @FXML
    private Label error;

    @FXML
    private Label errorNombreCorto;

    @FXML
    private Label errorClase;

    @FXML
    private Label errorNombreLargo;

    @FXML
    void handleStart(ActionEvent event) {
    	//Se comprueba si hay algun problema con el nombre y/o clase
    	if(nombre.getText().trim().length() < MINNAMELENGTH || nombre.getText().trim().length() > MAXNAMELENGTH || clase.getValue() == null) {
    		error.setVisible(true);
    		if(clase.getValue() == null) {
    			errorClase.setVisible(true);
    			if(nombre.getText().trim().length() < MINNAMELENGTH ) {
    				errorNombreCorto.setVisible(true);
        			errorNombreLargo.setVisible(false);
    			}else if(nombre.getText().trim().length() > MAXNAMELENGTH ) {
    				errorNombreCorto.setVisible(false);
        			errorNombreLargo.setVisible(true);
    			}else {
    				errorNombreCorto.setVisible(false);
        			errorNombreLargo.setVisible(false);
    			}
    		}else if(nombre.getText().length() < MINNAMELENGTH) {
    			errorClase.setVisible(false);
    			errorNombreCorto.setVisible(true);
    			errorNombreLargo.setVisible(false);
    		}else{
    			errorClase.setVisible(false);
    			errorNombreCorto.setVisible(false);
    			errorNombreLargo.setVisible(true);
    		}
    	}else {
    		try{
    			Stage stage = new Stage();
	            FXMLLoader loader = new FXMLLoader();
	            Parent root = loader.load(getClass().getResource("Game.fxml").openStream());
	            ControllerGame controllNewWindows = (ControllerGame)loader.getController();
	            controllNewWindows.setNombreAndClase(nombre.getText().trim() , clase.getValue());
	            
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
    
    ObservableList<String> list = FXCollections.observableArrayList( "Maga", "Guerrero", "Arquera");
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	clase.setItems(list);
    }
}
