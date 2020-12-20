/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPackage.controllers;

import javafx.event.ActionEvent;
import java.awt.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.layout.AnchorPane;

public class HomeController implements Initializable {

    @FXML
    private Button btnDashboard;

    @FXML
    private Button btnStudents;

    @FXML
    private Button btn_Timetable;


    @FXML
    private Button btnClasses;
    
    @FXML
    private Button btnStaff;
    
    @FXML
    private Button btnLibary;
   
    @FXML
    private AnchorPane root;
    
        
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    
  
/*
    @FXML
    private void handleButtonClicks(javafx.event.ActionEvent mouseEvent) {
        if (mouseEvent.getSource() == btnDashboard) {
            loadStage("/MyPackage/fxml/Dashboard.fxml");
        } else if (mouseEvent.getSource() == btnStudents) {
            loadStage("/MyPackage/fxml/Students.fxml");
        } else if (mouseEvent.getSource() == btn_Timetable) {
            loadStage("/MyPackage/fxml/Timetable.fxml");}
        else if (mouseEvent.getSource() == btnClasses) {
            loadStage("/MyPackage/fxml/Classes.fxml");}
        else if (mouseEvent.getSource() == btnStaff) {
            loadStage("/MyPackage/fxml/Staff.fxml");}
        else if (mouseEvent.getSource() == btnLibary) {
            loadStage("/MyPackage/fxml/Libary.fxml");}
    }

    */
/*
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
    }*/
    @FXML
    void setBtnDashboard(ActionEvent mouseEvent){
        try{
            AnchorPane user = FXMLLoader.load(getClass().getResource("/MyPackage/fxml/Dashboard.fxml"));
            root.getChildren().setAll(user);
        
            }
        catch(IOException e){
            System.out.println(e);  
        }
    }

    @FXML
    private void setBtnStudents(javafx.event.ActionEvent event) {
        try{
            AnchorPane user = FXMLLoader.load(getClass().getResource("/MyPackage/fxml/Students.fxml"));
            root.getChildren().setAll(user);
            }
        catch(IOException e){
            System.out.println(e);  
        }
    }

    @FXML
    private void setBtnTimetable(ActionEvent event) {
        try{
            AnchorPane user = FXMLLoader.load(getClass().getResource("/MyPackage/fxml/Timetable.fxml"));
            root.getChildren().setAll(user);
            }
        catch(IOException e){
            System.out.println(e);  
        }
    }

    @FXML
    private void setbtnLibary(ActionEvent event) {
        try{
            AnchorPane user = FXMLLoader.load(getClass().getResource("/MyPackage/fxml/Libary.fxml"));
            root.getChildren().setAll(user);
            }
        catch(IOException e){
            System.out.println(e);  
        }
    }

    @FXML
    private void setBtnStaff(ActionEvent event) {
        try{
            AnchorPane user = FXMLLoader.load(getClass().getResource("/MyPackage/fxml/Staff.fxml"));
            root.getChildren().setAll(user);
            }
        catch(IOException e){
            System.out.println(e);  
        }
    }

    @FXML
    private void setBtnClasses(ActionEvent event) {
        try{
            AnchorPane user = FXMLLoader.load(getClass().getResource("/MyPackage/fxml/Classes.fxml"));
            root.getChildren().setAll(user);
            }
        catch(IOException e){
            System.out.println(e);  
        }
    }
}
