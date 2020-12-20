/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 
package MyPackage.controllers;

import MyPackage.classes.Book;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author m
 
public class NewClass {
    
}
@Override
    public void initialize(URL location, ResourceBundle resources) {

        Name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        Author.setCellValueFactory(new PropertyValueFactory<>("Author"));
        Categorie.setCellValueFactory(new PropertyValueFactory<>("Categorie"));
        nbr.setCellValueFactory(new PropertyValueFactory<>("nbr"));
        tbData.setItems(Books);}
    

    private ObservableList<Book> Books = FXCollections.observableArrayList(
            new Book("the pragmatic programmer","Davae Thomas","yes", ""),
            new Book("Unwritting laws of engineering","W.J King","no", "15-01-2021"),
            new Book("Advanced Mathemathics","Erwin Kreys","yes", ""),
            new Book("Structural Abalysis","Russel Hibbeler","yes", "")
    );
    
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
    */