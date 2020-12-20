/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPackage.controllers.Students;
import MyPackage.classes.Student;
import MyPackage.DBconnection;
import static MyPackage.controllers.Students.addStudents.AddStudent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.Alert;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
/**
 * FXML Controller class
 *
 * @author m
 */
public class manageStudents implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private Button Back;
    @FXML
    private Button Update;
    @FXML
    private Button Print;
    @FXML
    private TextField Classe;
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
    private TextField Grade;
    @FXML
    private TextField adress;
    
    @FXML
    private TextField city;
    @FXML
    private TextField email;
    @FXML
    private TextField fax;
    @FXML
    private Button Delete;
    private TextField search;
    @FXML
    private Button Search;
    @FXML
    private TextField searchCIN;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Back(ActionEvent event) {
    try {            
            AnchorPane home = FXMLLoader.load(getClass().getResource(("/MyPackage/fxml/Students.fxml")));
            root.getChildren().setAll(home);
        }catch(IOException e){
            System.out.println(e);
    }
    }

    

    public static Student searchStudent(Integer cin) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM student WHERE cin= ? ";
        Connection conn = DBconnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, cin);
        ResultSet rst=stm.executeQuery();
        if(rst.next()){
            Student s = new Student(rst.getString(1),rst.getString(2),rst.getInt(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getString(7), rst.getString(8), rst.getString(9), rst.getString(10), rst.getString(11),rst.getString(12));
            return s;
        }
        return null;
    } 
    @FXML
    private void Search(ActionEvent event)  {
    try {
            int cin = Integer.parseInt(searchCIN.getText());
            Student s = searchStudent(cin);
            
            if (s != null) {   
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Student Search");
                alert.setHeaderText(null);
                alert.setContentText("Student  Found");
                alert.showAndWait();
                Name.setText(s.getName());
                familyName.setText(s.getFamilyName());
                CIN.setText(String.valueOf(s.getCIN()));
                DOB.setText(s.getDOB());
                age.setText(s.getAge());
                gender.setText(s.getGender());
                Grade.setText(s.getGrade());
                Classe.setText(s.getClasse());
                adress.setText(s.getAdress());
                city.setText(s.getCity());
                email.setText(s.getEmail());
                fax.setText(s.getTelephone());
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Student Search");
                alert.setHeaderText(null);
                alert.setContentText("Student Not Found");
                alert.showAndWait();
                Name.setText(null);
                familyName.setText(null);
                CIN.setText(null);
                DOB.setText(null);
                age.setText(null);
                gender.setText(null);
                Grade.setText(null);
                Classe.setText(null);
                adress.setText(null);
                city.setText(null);
                email.setText(null);
                fax.setText(null);
            } 
   }
        catch (ClassNotFoundException | SQLException ex) {
           // Logger.getLogger(class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    
        
    public static int updateStudent(Student student)throws ClassNotFoundException,SQLException {
 
        String SQL="UPDATE student SET name= ? ,fname= ? ,cin= ? ,dob= ? ,age= ? ,gender= ? ,grade = ? ,classe= ? ,adress=? ,city= ? ,email= ? ,telephone= ? WHERE cin= " +student.getCIN()+"";
        
        Connection conn = DBconnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        
        stm.setObject(1, student.getName());
        stm.setObject(2, student.getFamilyName());
        stm.setObject(3, student.getCIN());
        stm.setObject(4, student.getDOB());
        stm.setObject(5, student.getAge());
        stm.setObject(6, student.getGender());
        stm.setObject(7, student.getGrade());
        stm.setObject(8, student.getClasse());
        stm.setObject(9, student.getAdress());
        stm.setObject(10, student.getCity());
        stm.setObject(11, student.getEmail());
        stm.setObject(12, student.getTelephone());

        return  stm.executeUpdate();
    }
    @FXML
    private void Update(ActionEvent event) throws SQLException, ClassNotFoundException {                 
         String name = Name.getText();
         String fname = familyName.getText();
         int cin = Integer.parseInt(CIN.getText());
         String dob = DOB.getText();
         String Age = age.getText();
         String Gender = gender.getText();
         String grade = Grade.getText();
         String classe = Classe.getText();
         String Adress = adress.getText();
         String City = city.getText();
         String mail = email.getText();
         String tele = fax.getText();
         Student s = new Student(name, fname, cin, dob, Age, Gender, grade, classe, Adress, City, mail, tele);
         updateStudent(s);
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Student Update");
                    alert.setHeaderText(null);
                    alert.setContentText("Student ID " + cin + " Updated Successfully..!");
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
    Grade.setText(null);
    Classe.setText(null);
    adress.setText(null);
    city.setText(null);
    email.setText(null);
    fax.setText(null);
    }
    public static int deleteStudent(String cin) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM Student WHERE cin ="+cin+"";
        Connection conn = DBconnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);

        
        return  stm.executeUpdate();
    }
    
    @FXML
    private void Delete(ActionEvent event) throws SQLException, ClassNotFoundException { 
         int cin = Integer.parseInt(CIN.getText());
         String c = String.valueOf(cin);
         
                 deleteStudent(c);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Student Update");
                    alert.setHeaderText(null);
                    alert.setContentText("Student ID " + cin + " deleted Successfully..!");
                    alert.showAndWait();
                    RESET(event); 
    }
      
    
    @FXML
    private void Print(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Student Search");
            alert.setHeaderText(null);
            alert.setContentText("Not available");
    }
}
    

    

