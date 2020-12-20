package MyPackage.controllers;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author m
 */
public class StudentsController implements Initializable {

    @FXML
    private Button Back;
    @FXML
    private Button btnAddStudent;
    @FXML
    private Button btnManageStudent;
    @FXML
    private Button btnListStudent;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

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

    @FXML
    private void btnAddStudent(ActionEvent event) {
        try{
            AnchorPane user = FXMLLoader.load(getClass().getResource("/MyPackage/fxml/Students/addStudent.fxml"));
            root.getChildren().setAll(user);
            }
        catch(IOException e){
            System.out.println(e);  
        }
    }

    @FXML
    private void btnManageStudent(ActionEvent event) {
    try{
            AnchorPane user = FXMLLoader.load(getClass().getResource("/MyPackage/fxml/Students/manageStudent.fxml"));
            root.getChildren().setAll(user);
            }
        catch(IOException e){
            System.out.println(e);  
        }
    }

    @FXML
    private void btnListStudent(ActionEvent event) {
    try{
            AnchorPane user = FXMLLoader.load(getClass().getResource("/MyPackage/fxml/Students/listStudent.fxml"));
            root.getChildren().setAll(user);
            }
        catch(IOException e){
            System.out.println(e);  
        }
    }
}
