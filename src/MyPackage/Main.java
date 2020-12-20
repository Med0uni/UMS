/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPackage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.stage.Stage;
// jfxtras.styles.jmetro8.JMetro;

/**
 *
 * @author Mohamed Ouni
 * colors : #1165a6	rgb(17, 101, 166)
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("fxml/Login.fxml"));
        Parent root =  loader.load();
        //Parent root = FXMLLoader.load(getClass().getResource("MyPackage.Home.fxml"));
        
        stage.setTitle("JavaProject");    
        /*stage.getIcons().add(new Image("src/MyPackage/icons/icon.png"));*/
        stage.setScene(new Scene(root));
        stage.show();
    }
    
    public static void main(String[] args){
        launch(args);
    }
    
}
