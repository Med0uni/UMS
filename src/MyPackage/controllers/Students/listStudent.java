/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPackage.controllers.Students;
import MyPackage.classes.Book;
import MyPackage.classes.Student;
import MyPackage.DBconnection;

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
public class listStudent implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private Button Back;
    @FXML
    private TableView<Student> tbData;
    @FXML
    private TableColumn<Student, String> Name;
    @FXML
    private TableColumn<Student, String> FamilyName;
    @FXML
    private TableColumn<Student, Integer> CIN;
    @FXML
    private TableColumn<Student, String> DOB;
    @FXML
    private TableColumn<Student, String> Age;
    @FXML
    private TableColumn<Student, String> Grade;
    @FXML
    private TableColumn<Student, String> Classe;
    @FXML
    private TableColumn<Student, String> Adress;
    @FXML
    private TableColumn<Student, String> City;
    @FXML
    private TableColumn<Student, String> Email;
    @FXML
    private TableColumn<Student, String> Phone;

    @FXML
    private void Back(ActionEvent event) {
        try {            
            AnchorPane home = FXMLLoader.load(getClass().getResource(("/MyPackage/fxml/Students.fxml")));
            root.getChildren().setAll(home);
        }catch(IOException e){
            System.out.println(e);
    }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources)  {
        
        Connection conn;    
        try {
            conn = DBconnection.getDBConnection().getConnection();
            String sql = "select * from student " ;
            PreparedStatement stm = conn.prepareStatement(sql);
            //stm.setObject(1,"2");
            ResultSet rst = stm.executeQuery(sql);
             while (rst.next()){
            Student s = new Student(rst.getString(1),rst.getString(2),rst.getInt(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getString(7), rst.getString(8), rst.getString(9), rst.getString(10), rst.getString(11),rst.getString(12));
             StudentsList.add(s);}
        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(listStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex) {
            Logger.getLogger(listStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        Name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        FamilyName.setCellValueFactory(new PropertyValueFactory<>("FamilyName"));
        CIN.setCellValueFactory(new PropertyValueFactory<>("CIN"));
        DOB.setCellValueFactory(new PropertyValueFactory<>("DOB"));
        Age.setCellValueFactory(new PropertyValueFactory<>("Age"));
        Grade.setCellValueFactory(new PropertyValueFactory<>("Grade"));
        Classe.setCellValueFactory(new PropertyValueFactory<>("Classe"));
        Adress.setCellValueFactory(new PropertyValueFactory<>("Adress"));
        City.setCellValueFactory(new PropertyValueFactory<>("City"));
        Email.setCellValueFactory(new PropertyValueFactory<>("Email"));
        Phone.setCellValueFactory(new PropertyValueFactory<>("Phone"));
        tbData.setItems(StudentsList);
       }
        
    private ObservableList<Student> StudentsList = FXCollections.observableArrayList(
          new Student("Mohamed","ouni",07232040, "14-05-98","22","2éme","grp C","Mourouj","Ben Arous","","med@gmail.com","92927990"),
            new Student("Ahmed","Ahmed",07242570, "14-11-99","20","3éme","grp A","Ariana","Ariana","","med@gmail.com","92927990"),
            new Student("Mahmoud","Mahmoud",07232041, "14-05-98","22","2éme","grp C","Mourouj","Ben Arous","","med@gmail.com","92927990"),
            new Student("Amine","Ahmed",07242571, "14-11-99","20","3éme","grp A","Ariana","Ariana","","med@gmail.com","92927990")
                   
    );
  
    /*
    void generate() throws ClassNotFoundException, SQLException{
    
    Connection conn = DBconnection.getDBConnection().getConnection();    
    String sql = "select * from student " ;
    PreparedStatement stm = conn.prepareStatement(sql);
    //stm.setObject(1,"2");
    ResultSet rst = stm.executeQuery(sql);
    
    while (rst.next()){
        Student s = new Student(rst.getString(1),rst.getString(2),rst.getInt(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getString(7), rst.getString(8), rst.getString(9), rst.getString(10), rst.getString(11),rst.getString(12));
        StudentsList.add(s);
    }

    
    }*/
    
}
