
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
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

public class ControllerGame {

    public App app = new App();
    public String nombre;
	public String clase;

    @FXML
    public TextArea History;

    @FXML
    public TextArea Map;

    @FXML
    public Text CharacterName;

    @FXML
    public Text characterClass;

    @FXML
    public Button buttonUp;

    @FXML
    public Button buttonDown;

    @FXML
    public Button buttonRight;

    @FXML
    public Button buttonLeft;

    @FXML
    public Button buttonH3;

    @FXML
    public Button buttonS3;

    @FXML
    public Button buttonH2;

    @FXML
    public Button buttonS2;

    @FXML
    public Button buttonH1;

    @FXML
    public Button buttonS1;

    @FXML
    public Text Life;

    @FXML
    public Text Level;

    @FXML
    public Button buttonGameOver;

    @FXML
    void handleGameOver(ActionEvent event) {
    	this.app = new App();
    	this.setNombreAndClase(this.nombre, this.clase);
	}

	private void moveUp() {
		if(!this.buttonUp.isDisable())
		this.handleMoveUp(null);
	}

	private void moveDown() {
		if(!this.buttonDown.isDisable())
		this.handleMoveDown(null);
	}

	private void moveRight() {
		if(!this.buttonRight.isDisable())
		this.handleMoveRight(null);
	}

	private void moveLeft() {
		if(!this.buttonLeft.isDisable())
			this.handleMoveLeft(null);
	}

	private void runQ() {
		if(!this.buttonH1.isDisable())
			this.handleMoveH1(null);
	}

	private void runW() {
		if(!this.buttonH2.isDisable())
			this.handleMoveH2(null);
	}

	private void runE() {
		if(!this.buttonH3.isDisable())
			this.handleMoveH3(null);
	}

	private void runR() {
		if(!this.buttonS3.isDisable())
			this.handleMoveS3(null);
	}

	private void runEnter() {
		if(this.buttonGameOver.isVisible())
			this.handleGameOver(null);
	}
	private void runEscape() {
		if(!this.buttonS1.isDisable())
			this.handleMoveS1(null);
	}
	private void runSpace() {
		if(!this.buttonS2.isDisable())
			this.handleMoveS2(null);
	}

    @FXML
    void handleKeyReleseased(KeyEvent event) {
    	String key = event.getCode().toString();
    	switch(key) {
    		case "UP":
    			this.moveUp();
    			break;

    		case "DOWN":
    			this.moveDown();
    			break;

    		case "RIGHT":
    			this.moveRight();
    			break;

    		case "LEFT":
    			this.moveLeft();
    			break;

    		case "Q":
    			this.runQ();
    			break;

    		case "W":
    			this.runW();
    			break;

    		case "E":
    			this.runE();
    			break;

    		case "ENTER":
    			this.runEnter();
    			break;

    		case "ESCAPE":
    			this.runEscape();
    			break;

    		case "SPACE":
    			this.runSpace();
    			break;

    		case "R":
    			this.runR();
    			break;
    			//barra descanso; habilidades qwe; huir esq; atacar R
    	}
    }

    @FXML
    void handleMoveDown(ActionEvent event) {
    	app.move("Down");
    	this.update();
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
    	app.move("Left");
    	this.update();
    }

    @FXML
    void handleMoveRight(ActionEvent event) {
    	app.move("Right");
    	this.update();
    }

    @FXML
    void handleMoveS1(ActionEvent event) {
    	app.runAway();
    	this.update();

    }

    @FXML
    void handleMoveS2(ActionEvent event) {
    	app.rest();
    	this.update();
    }

    @FXML
    void handleMoveS3(ActionEvent event) {
    	app.fight();
    	this.update();
    }

    @FXML
    void handleMoveUp(ActionEvent event) {
        //Map.setText(model.moveUp());
    	app.move("Up");
    	this.update();
    }

    public void update() {
    	History.setText(app.getHistory());
    	Map.setText(app.getMap());
    	this.updateButtons();
    	Map.setWrapText(true);
    	Map.setStyle("-fx-fit-to-width: true;");
    	Map.setStyle("-fx-fit-to-height: true;");
    	History.setScrollTop(5000);
    	History.selectEnd();
    	History.deselect();
    	Life.setText("" + app.getVidaPersonaje());
    	Level.setText("" + app.getNivelPersonaje());
    }

    public void setNombreAndClase(String nombre, String clase) {
    	this.nombre = nombre;
    	this.clase = clase;
    	CharacterName.setText(this.nombre);
    	characterClass.setText(this.clase);
    	app.setcharaClass(this.clase);
    	app.setcharaName(this.nombre);
    	this.update();
    	//picture.setu
    }

    //Supondremos que S1: Escapar, S2: Descansar, S3:No Escapar H1,H2,H3 Skill
    public void updateButtons() {
    	String status = app.getStatus();
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
    			buttonGameOver.setVisible(false);
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
    			buttonUp.setDisable(true);
    			buttonDown.setDisable(true);
    			buttonRight.setDisable(true);
    			buttonLeft.setDisable(true);
    			buttonH1.setDisable(true);
    			buttonH2.setDisable(true);
    			buttonH3.setDisable(true);
    			buttonS1.setDisable(true);
    			buttonS2.setDisable(true);
    			buttonS3.setDisable(true);
				buttonGameOver.setVisible(true);
				break;
    	}
    }

}
