/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPackage.controllers.Staff;
import MyPackage.DBconnection;
import MyPackage.classes.Staff;
import MyPackage.classes.Student;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.Alert;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

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

/**
 *
 * @author m
 */
public class listStaff implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private Button Back;
    @FXML
    private TableView<Staff> tbData;
    @FXML
    private TableColumn<Staff, String> Name;
    @FXML
    private TableColumn<Staff, String> FamilyName;
    @FXML
    private TableColumn<Staff, String> CIN;
    @FXML
    private TableColumn<Staff, String> DOB;
    @FXML
    private TableColumn<Staff, String> Age;
    @FXML
    private TableColumn<Staff, String> Gender;
    @FXML
    private TableColumn<Staff, String> AppDate;
    @FXML
    private TableColumn<Staff, String> Job;
    @FXML
    private TableColumn<Staff, String> Adress;
    @FXML
    private TableColumn<Staff, String> CodePostal;
    @FXML
    private TableColumn<Staff, String> Email;
    @FXML
    private TableColumn<Staff, String> Phone;

    public void initialize(URL location, ResourceBundle resources)  {
        Connection conn = null;  
        try {
            conn = DBconnection.getDBConnection().getConnection();
            String sql = "select * from staff " ;
            PreparedStatement stm = conn.prepareStatement(sql);
            //stm.setObject(1,"2");
            ResultSet rst = stm.executeQuery(sql);
            while (rst.next()){
            Staff s = new Staff(rst.getString(1),rst.getString(2),rst.getInt(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getString(7), rst.getString(8), rst.getString(9), rst.getString(10), rst.getString(11),rst.getString(12));
             StaffList.add(s);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(listStaff.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(listStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
            
             
             
        Name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        FamilyName.setCellValueFactory(new PropertyValueFactory<>("FamilyName"));
        CIN.setCellValueFactory(new PropertyValueFactory<>("CIN"));
        DOB.setCellValueFactory(new PropertyValueFactory<>("DOB"));
        Age.setCellValueFactory(new PropertyValueFactory<>("Age"));
        Gender.setCellValueFactory(new PropertyValueFactory<>("Gender"));
        AppDate.setCellValueFactory(new PropertyValueFactory<>("Adress"));
        Job.setCellValueFactory(new PropertyValueFactory<>("job"));
        Email.setCellValueFactory(new PropertyValueFactory<>("Email"));
        Phone.setCellValueFactory(new PropertyValueFactory<>("Phone"));
        tbData.setItems(StaffList);
    
    }
    private ObservableList<Staff> StaffList = FXCollections.observableArrayList(  );
    @FXML
    private void Back(ActionEvent event) {
    try {            
            AnchorPane home = FXMLLoader.load(getClass().getResource(("/MyPackage/fxml/Staff.fxml")));
            root.getChildren().setAll(home);
        }catch(IOException e){
            System.out.println(e);
    }
    }
    
}
