/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPackage.controllers;

import java.net.URL;
import javafx.fxml.FXMLLoader;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.time.Duration;
import javafx.animation.PauseTransition;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author m
 */
public class Controller implements Initializable {

    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField pwdField;
    @FXML
    private Button loginBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleKeyPressed(KeyEvent event) {
    }

    @FXML
    private void handleLoginBtn(javafx.event.ActionEvent mouseEvent) {
        if (mouseEvent.getSource() == loginBtn) {
            loadStage("/MyPackage/fxml/Home.fxml");
        /*stage.close();
        PauseTransition delay = new PauseTransition(Duration.seconds(5));
        delay.setOnFinished( event -> Stage.close());
        delay.play();*/
            
    }
    }
         
    private void loadStage(String fxml) {
        try {
            
            Parent root = FXMLLoader.load(getClass().getResource(fxml));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            //stage.getIcons().add(new Image("/home/icons/icon.png"));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
