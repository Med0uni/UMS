
package MyPackage.controllers;

import MyPackage.DBconnection;
import MyPackage.classes.Book;
import MyPackage.classes.Student;
import MyPackage.controllers.Students.listStudent;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;    
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class LibaryController implements Initializable{
    
    @FXML
    private TableView<Book> tbData ;
    @FXML
    private TableColumn<Book, String> Name;
    @FXML
    private TableColumn<Book, String> Author;
    @FXML
    private TableColumn<Book, String> nbr;
    @FXML
    private Button addBook;
    @FXML
    private AnchorPane root;
    @FXML
    private Button Back;
    @FXML
    private TableColumn<Book, String> Available;

    public LibaryController()
    {
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    Connection conn;
    try {
            conn = DBconnection.getDBConnection().getConnection();
            String sql = "select * from books " ;
            PreparedStatement stm = conn.prepareStatement(sql);
            //stm.setObject(1,"2");
            ResultSet rst = stm.executeQuery(sql);
             while (rst.next()){
            Book s = new Book(rst.getString(1),rst.getString(2),rst.getString(3), rst.getString(4));
            BookList.add(s);}
        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(listStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex) {
            Logger.getLogger(listStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
    Name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        Author.setCellValueFactory(new PropertyValueFactory<>("Author"));
        Available.setCellValueFactory(new PropertyValueFactory<>("Categorie"));
        nbr.setCellValueFactory(new PropertyValueFactory<>("Nbr of copies"));
        tbData.setItems(BookList);
        
    }
    private ObservableList<Book> BookList = FXCollections.observableArrayList(
            );
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
    private void addBook(ActionEvent event) {
    if (event.getSource() == addBook) {
            loadStage("/MyPackage/fxml/add-book.fxml");}
    }

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
    }
}
