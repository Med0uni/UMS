/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPackage.controllers.Staff;
import MyPackage.DBconnection;
import MyPackage.classes.Staff;
import MyPackage.classes.Student;
import static MyPackage.controllers.Students.addStudents.AddStudent;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.Alert;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


public class addStaff {

    @FXML
    private AnchorPane root;
    @FXML
    private Button Back;
    @FXML
    private TextField adress;
    @FXML
    private TextField codePostal;
    private TextField city;
    @FXML
    private TextField email;
    @FXML
    private TextField fax;
    @FXML
    private Button Add;
    @FXML
    private TextField Name;
    @FXML
    private TextField familyName;
    @FXML
    private TextField CIN;
    @FXML
    private TextField DOB;
    @FXML
    private TextField age;
    @FXML
    private TextField gender;
    @FXML
    private TextField appDate;
    @FXML
    private TextField Job;

    @FXML
    private void Back(ActionEvent event) {
    try {            
            AnchorPane home = FXMLLoader.load(getClass().getResource(("/MyPackage/fxml/Staff.fxml")));
            root.getChildren().setAll(home);
        }catch(IOException e){
            System.out.println(e);
    }
    }

    public static int AddStaff(Staff staff)throws ClassNotFoundException,SQLException {
        String SQL="INSERT INTO staff VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        Connection conn = DBconnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, staff.getName());
        stm.setObject(2, staff.getFamilyName());
        stm.setObject(3, staff.getCIN());
        stm.setObject(4, staff.getDOB());
        stm.setObject(5, staff.getAge());
        stm.setObject(6, staff.getGender());
        stm.setObject(7, staff.getAppDate());
        stm.setObject(8, staff.getJob());
        stm.setObject(9, staff.getAdress());
        stm.setObject(10, staff.getCodeP());
        stm.setObject(11, staff.getEmail());
        stm.setObject(12, staff.getPhone());
        
        return  stm.executeUpdate();
    }
    @FXML
    private void Add(ActionEvent event) throws SQLException, ClassNotFoundException {
         String name = Name.getText();
         String fname = familyName.getText();
         int cin = Integer.parseInt(CIN.getText());
         String dob = DOB.getText();
         String Age = age.getText();
         String Gender = gender.getText();
         String date = appDate.getText();
         String job = Job.getText();
         String Adress = adress.getText();
         String codep = codePostal.getText();
         String mail = email.getText();
         String tele = fax.getText();
         Staff s = new Staff(name, fname, cin, dob, Age, Gender, date, job, Adress, codep, mail, tele);
         AddStaff(s);
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Staff Registration");
                    alert.setHeaderText(null);
                    alert.setContentText("Staff ID " + cin + " Registered Successfully..!");
                    alert.showAndWait();
                        RESET(event);
    }
    private void RESET(ActionEvent event) {
    Name.setText(null);
    familyName.setText(null);
    CIN.setText(null);
    DOB.setText(null);
    age.setText(null);
    gender.setText(null);
    appDate.setText(null);
    Job.setText(null);
    adress.setText(null);
    codePostal.setText(null);
    email.setText(null);
    fax.setText(null);
    }

    
}
