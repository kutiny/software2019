
package start;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.scene.text.Text;

public class ControllerGame {

    private Model model = new Model();

    @FXML
    private TextArea History;

    @FXML
    private TextArea Map;
    
    @FXML
    private Text CharacterName;

    @FXML
    private Text characterClass;


    @FXML
    void handleMoveDown(ActionEvent event) {

    }

    @FXML
    void handleMoveH2(ActionEvent event) {

    }

    @FXML
    void handleMoveH3(ActionEvent event) {

    }

    @FXML
    void handleMoveLeft(ActionEvent event) {

    }

    @FXML
    void handleMoveRight(ActionEvent event) {

    }

    @FXML
    void handleMoveS1(ActionEvent event) {

    }

    @FXML
    void handleMoveS2(ActionEvent event) {

    }

    @FXML
    void handleMoveS3(ActionEvent event) {

    }

    @FXML
    void handleMoveUH1(ActionEvent event) {

    }

    @FXML
    void handleMoveUp(ActionEvent event) {
        Map.setText(model.moverse());

    }
    
    public void setNombreAndClase(String nombre, String clase) {
    	CharacterName.setText(nombre);
    	characterClass.setText(clase);
    	
    }

}