
package start;

import game.App;
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
    private App app = new App();

    @FXML
    private TextArea History;

    @FXML
    private TextArea Map;

    @FXML
    private Text CharacterName;

    @FXML
    private Text characterClass;

    @FXML
    private Button buttonUp;

    @FXML
    private Button buttonDown;

    @FXML
    private Button buttonRight;

    @FXML
    private Button buttonLeft;

    @FXML
    private Button buttonH3;

    @FXML
    private Button buttonS3;

    @FXML
    private Button buttonH2;

    @FXML
    private Button buttonS2;

    @FXML
    private Button buttonH1;

    @FXML
    private Button buttonS1;


    @FXML
    void handleMoveDown(ActionEvent event) {

    }
    @FXML
    void handleMoveH1(ActionEvent event) {
    	app.skill(1);
    	this.update();
    }

    @FXML
    void handleMoveH2(ActionEvent event) {
    	app.skill(2);
    	this.update();
    }

    @FXML
    void handleMoveH3(ActionEvent event) {
    	app.skill(3);
    	this.update();
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
    void handleMoveUp(ActionEvent event) {
        //Map.setText(model.moveUp());
    	app.moveUp();
    	Map.setText(app.getMap());
    	History.setText(app.getHistory());
    	this.update();
    }
    
    private void update() {
    	History.setText(app.getHistory());
    	Map.setText(app.getMap());
    	this.updateButtons();
    	Map.setWrapText(true);
    	Map.setStyle("-fx-fit-to-width: true;");
    	Map.setStyle("-fx-fit-to-height: true;");
    	History.setScrollTop(5000);
    }
    
    public void setNombreAndClase(String nombre, String clase) {
    	CharacterName.setText(nombre);
    	characterClass.setText(clase);
    	app.setcharaClass(clase);
    	app.setcharaName(nombre);
    	this.update();
    	
    }
    
    //Supondremos que S1: Escapar, S2: Descansar, S3:No Escapar H1,H2,H3 Skill
    public void updateButtons() {
    	String status = app.getStatus();
    	System.out.println("status = " + status);
    	switch (status) {
    		case "Libre":
    			buttonUp.setDisable(false);
    			buttonDown.setDisable(false);
    			buttonRight.setDisable(false);
    			buttonLeft.setDisable(false);
    			buttonH1.setDisable(true);
    			buttonH2.setDisable(true);
    			buttonH3.setDisable(true);
    			buttonS1.setDisable(true);
    			buttonS2.setDisable(false);
    			buttonS3.setDisable(true);
    			break;
    			
    		case "Descanso":
    			buttonUp.setDisable(false);
    			buttonDown.setDisable(false);
    			buttonRight.setDisable(false);
    			buttonLeft.setDisable(false);
    			buttonH1.setDisable(true);
    			buttonH2.setDisable(true);
    			buttonH3.setDisable(true);
    			buttonS1.setDisable(true);
    			buttonS2.setDisable(true);
    			buttonS3.setDisable(true);
    			break;
    			
    		case "PreDuelo":
    			System.out.println("lalal");
    			buttonUp.setDisable(true);
    			buttonDown.setDisable(true);
    			buttonRight.setDisable(true);
    			buttonLeft.setDisable(true);
    			buttonH1.setDisable(true);
    			buttonH2.setDisable(true);
    			buttonH3.setDisable(true);
    			buttonS1.setDisable(false);
    			buttonS2.setDisable(true);
    			buttonS3.setDisable(false);
    			break;
    			
    		case "Duelo":
    			buttonUp.setDisable(true);
    			buttonDown.setDisable(true);
    			buttonRight.setDisable(true);
    			buttonLeft.setDisable(true);
    			buttonH1.setDisable(false);
    			buttonH2.setDisable(false);
    			buttonH3.setDisable(false);
    			buttonS1.setDisable(true);
    			buttonS2.setDisable(true);
    			buttonS3.setDisable(true);
    			break;
    		case "GameOver":
    			System.out.println("");
    	}
    }

}