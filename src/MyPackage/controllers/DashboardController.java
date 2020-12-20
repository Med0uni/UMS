package MyPackage.controllers;

import MyPackage.DBconnection;
import MyPackage.classes.School;
//import MyPackage.DB.SchoolDB;

        
import MyPackage.classes.School;
import com.sun.javafx.logging.PlatformLogger.Level;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
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
import java.lang.System.Logger;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DashboardController implements Initializable {

    private Connection conn;
    
    
    
    @FXML
    private javafx.scene.control.TextField fullName;
    @FXML
    private javafx.scene.control.TextField briefName;
    @FXML
    private javafx.scene.control.TextField university;
    @FXML
    private javafx.scene.control.TextField type;
    @FXML
    private javafx.scene.control.TextField diplom;
    @FXML
    private javafx.scene.control.TextField year;
    @FXML
    private javafx.scene.control.TextField nStudents;
    @FXML
    private javafx.scene.control.TextField adress;
    @FXML
    private javafx.scene.control.TextField codePostal;
    @FXML
    private javafx.scene.control.TextField city;
    @FXML
    private javafx.scene.control.TextField email;
    @FXML
    private Button Update;
    @FXML
    private Button Print;
    @FXML
    private javafx.scene.control.TextField fax;
    @FXML
    private javafx.scene.control.TextField tel;
    @FXML
    private javafx.scene.control.TextField nStaff;
    
    public static School schoolInfo() throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM school";
        Connection conn = DBconnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        ResultSet rst=stm.executeQuery();
        if (rst.next()){
        School s;
            s = new School(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getString(7), rst.getString(8), rst.getString(9), rst.getString(10), rst.getString(11), rst.getString(12), rst.getString(13), rst.getString(14));
            return s;
        }
        return null;
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources){
            try {
            School s = schoolInfo();
            if (s != null) {
                fullName.setText(s.getFullName());
                briefName.setText(s.getBriefName());
                university.setText(s.getUniversity());
                type.setText(s.getType());
                diplom.setText(s.getDiplom());
                year.setText(s.getYear());
                nStudents.setText(s.getnStudents());
                nStaff.setText(s.getnStaff());
                adress.setText(s.getAdress());
                codePostal.setText(s.getCodePostal());
                city.setText(s.getCity());
                email.setText(s.getEmail());
                fax.setText(s.getFax());
                tel.setText(s.getTel());
                
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("School Information");
                alert.setHeaderText(null);
                alert.setContentText("No Information Found..!");
                alert.showAndWait();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            /*Logger.getLogger(SchoolDB.class.getName()).log(Level.SEVERE, null, ex*/
        }
    }
    
    @FXML
    private Button Back;
    
    @FXML
    private AnchorPane root;
    @FXML
     void Back() {
        try {            
            AnchorPane home = FXMLLoader.load(getClass().getResource(("/MyPackage/fxml/Home.fxml")));
            root.getChildren().setAll(home);
        }catch(IOException e){
            System.out.println(e);
    }
    }
     
   public static int AddDetails(School school)throws ClassNotFoundException,SQLException {
        String SQL = "UPDATE school SET fullname= ? ,briefname= ? ,uni= ? ,type= ? ,diplome= ? ,year= ? ,nstudents=? ,nstaff= ? ,adress= ? ,codepostal= ? ,city=? ,email=? ,fax=? ,tel=?";
                
        Connection conn = DBconnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        
        stm.setObject(1, school.getFullName());
        stm.setObject(2, school.getBriefName());
        stm.setObject(3, school.getUniversity());
        stm.setObject(4, school.getType());
        stm.setObject(5, school.getDiplom());
        stm.setObject(6, school.getYear());
        stm.setObject(7, school.getnStudents());
        stm.setObject(8, school.getnStaff());
        stm.setObject(9, school.getAdress());
        stm.setObject(10, school.getCodePostal());
        stm.setObject(11, school.getCity());
        stm.setObject(12, school.getEmail());
        stm.setObject(13, school.getFax());
        stm.setObject(14, school.getTel());
        
        return  stm.executeUpdate();
    }  

    @FXML
    private void Update(ActionEvent event) throws SQLException, ClassNotFoundException {       
        String fName = fullName.getText();
        String bName = briefName.getText();
        String uni = university.getText();
        String typ = type.getText();
        String diplome = diplom.getText();
        String Year = year.getText();
        String nStudent = nStudents.getText();
        String nStaffs = nStaff.getText();
        String adresss = adress.getText();
        String codeP = codePostal.getText();
        String ciTy = city.getText();
        String mail = email.getText();
        String faxx = fax.getText();
        String phone = tel.getText();
        
        School sch = new School(fName, bName, uni, typ, diplome, Year, nStudent, nStaffs, adresss, codeP, ciTy, mail, faxx, phone);
        AddDetails(sch);
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("School Information");
                alert.setHeaderText(null);
                alert.setContentText("Information Updated Successfully...!");
                alert.showAndWait();
    
    }
            
            
    
    
    
            @FXML
            private void Print(ActionEvent event) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("School Information");
            alert.setHeaderText(null);
            alert.setContentText("Not available yet...!");
            alert.showAndWait();
         
      } 
    }

     
   

