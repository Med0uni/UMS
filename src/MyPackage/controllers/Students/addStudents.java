package MyPackage.controllers.Students;


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

import MyPackage.DBconnection;
import MyPackage.classes.Student;
//import MyPackage.DB.StudentsDB;


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

public class addStudents implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private Button Back;
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
    private Button Add;
    @FXML
    private TextField tel;
    @FXML
    private Button RESET;

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
 
    
    public static int AddStudent(Student student)throws ClassNotFoundException,SQLException {
        String SQL="INSERT INTO student VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
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
    private void Add(ActionEvent event) throws SQLException, ClassNotFoundException {
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
         String tele = tel.getText();
         Student s = new Student(name, fname, cin, dob, Age, Gender, grade, classe, Adress, City, mail, tele);
         AddStudent(s);
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Student Registration");
                    alert.setHeaderText(null);
                    alert.setContentText("Student ID " + cin + " Registered Successfully..!");
                    alert.showAndWait();
                        RESET(event);
    }
    
    @FXML
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
    tel.setText(null);
    }
    
}
