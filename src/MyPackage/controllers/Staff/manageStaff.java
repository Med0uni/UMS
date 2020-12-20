/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPackage.controllers.Staff;
import MyPackage.classes.Staff;
import MyPackage.DBconnection;
import MyPackage.classes.Student;
import static MyPackage.controllers.Staff.addStaff.AddStaff;
import static MyPackage.controllers.Students.manageStudents.deleteStudent;
import static MyPackage.controllers.Students.manageStudents.searchStudent;


import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.Alert;

/**
 *
 * @author m
 */
public class manageStaff {

    @FXML
    private AnchorPane root;
    @FXML
    private Button Back;
    @FXML
    private Button Update;
    @FXML
    private Button Print;
    @FXML
    private TextField adress;
    @FXML
    private TextField codePostal;
    @FXML
    private TextField email;
    @FXML
    private TextField fax;
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
    private Button Delete;
    @FXML
    private Button Search1;
    @FXML
    private TextField Job;
    @FXML
    private TextField sarch;

    @FXML
    private void Back(ActionEvent event) {
    try {            
            AnchorPane home = FXMLLoader.load(getClass().getResource(("/MyPackage/fxml/Staff.fxml")));
            root.getChildren().setAll(home);
        }catch(IOException e){
            System.out.println(e);
    }
    }

    
    public static int UpdateStaff(Staff staff)throws ClassNotFoundException,SQLException {
        String SQL="UPDATE staff SET name= ? ,fname= ? ,cin= ? ,dob= ? ,age= ? ,gender= ? ,appdate = ? ,job= ? ,adress=? ,codep= ? ,email= ? ,tele= ? WHERE cin= " +staff.getCIN()+"";
        
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
    private void Update(ActionEvent event)  throws SQLException, ClassNotFoundException{
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
                    alert.setContentText("Staff ID " + cin + " updated Successfully..!");
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
    
    @FXML
    private void Print(ActionEvent event) {
    Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Student Search");
            alert.setHeaderText(null);
            alert.setContentText("Not available");
    }

    
    public static int deleteStaff(String cin) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM staff WHERE cin ="+cin+"";
        Connection conn = DBconnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);

        
        return  stm.executeUpdate();
    }
    @FXML
    private void Delete(ActionEvent event) throws SQLException, ClassNotFoundException{
    int cin = Integer.parseInt(CIN.getText());
         String c = String.valueOf(cin);
         
                 deleteStudent(c);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Staff Update");
                    alert.setHeaderText(null);
                    alert.setContentText("Staff ID " + cin + " deleted Successfully..!");
                    alert.showAndWait();
                    RESET(event); 
    }

    
    public static Staff Stafsearch(Integer cin) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM staff WHERE cin= ? ";
        Connection conn = DBconnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, cin);
        ResultSet rst=stm.executeQuery();
        if(rst.next()){
            Staff s = new Staff(rst.getString(1),rst.getString(2),rst.getInt(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getString(7), rst.getString(8), rst.getString(9), rst.getString(10), rst.getString(11),rst.getString(12));
            return s;
        }
        return null;
    } 
    @FXML
    private void Search1(ActionEvent event) {
    try {
            int cin = Integer.parseInt(sarch.getText());
            Staff s = Stafsearch(cin);
            
            if (s != null) {   
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Staff Search");
                alert.setHeaderText(null);
                alert.setContentText("Staff  Found");
                alert.showAndWait();
                Name.setText(s.getName());
                familyName.setText(s.getFamilyName());
                CIN.setText(String.valueOf(s.getCIN()));
                DOB.setText(s.getDOB());
                age.setText(s.getAge());
                gender.setText(s.getGender());
                appDate.setText(s.getAppDate());
                Job.setText(s.getJob());
                adress.setText(s.getAdress());
                codePostal.setText(s.getCodeP());
                email.setText(s.getEmail());
                fax.setText(s.getPhone());
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Staff Search");
                alert.setHeaderText(null);
                alert.setContentText("Staff Not Found");
                alert.showAndWait();
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
        catch (ClassNotFoundException | SQLException ex) {
           // Logger.getLogger(class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
