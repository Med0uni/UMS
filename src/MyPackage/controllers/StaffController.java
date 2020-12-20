/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPackage.controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 *
 * @author m
 */
public class StaffController {

    @FXML
    private Button Back;
    @FXML
    private AnchorPane root;
    @FXML
    private Button btnAddStaff;
    @FXML
    private Button btnManageStaff;
    @FXML
    private Button btnListStaff;
    @FXML
     void Back() {
        try {            
            AnchorPane home = FXMLLoader.load(getClass().getResource(("/MyPackage/fxml/Home.fxml")));
            root.getChildren().setAll(home);
        }catch(IOException e){
            System.out.println(e);
    }
    }

    @FXML
    private void btnAddStaff(ActionEvent event) {
    try {            
            AnchorPane home = FXMLLoader.load(getClass().getResource(("/MyPackage/fxml/Staff/addStaff.fxml")));
            root.getChildren().setAll(home);
        }catch(IOException e){
            System.out.println(e);
    }    
    }

    @FXML
    private void btnManageStaff(ActionEvent event) {
    try {            
            AnchorPane home = FXMLLoader.load(getClass().getResource(("/MyPackage/fxml/Staff/manageStaff.fxml")));
            root.getChildren().setAll(home);
        }catch(IOException e){
            System.out.println(e);
    }
    }

    @FXML
    private void btnListStaff(ActionEvent event) {
    try {            
            AnchorPane home = FXMLLoader.load(getClass().getResource(("/MyPackage/fxml/Staff/listStaff.fxml")));
            root.getChildren().setAll(home);
        }catch(IOException e){
            System.out.println(e);
    }
    }
    
}
