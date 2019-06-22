/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.Node;
import javafx.stage.Stage;

/**
 *
 * @author alexi
 */
public class ControllerLogin implements Initializable {

    @FXML
    private Label label;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }

    @FXML
    private void firstClick(ActionEvent event){
        label.setText("has clickiado perro");
        System.out.println("Has hecho click");

        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("Game.fxml"));

            Scene escena = new Scene(root);
            stage.setScene(escena);
            stage.show();
            ( (Node) (event.getSource() ) ).getScene().getWindow().hide();
        }
        catch(IOException e){
            return;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
