/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPackage.controllers;
import MyPackage.DBconnection;
import MyPackage.classes.Book;

import MyPackage.DBconnection;
import MyPackage.classes.Staff;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


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


public class addBook {

    @FXML
    private AnchorPane root;
    @FXML
    private Button Add;
    @FXML
    private TextField Categorie;
    @FXML
    private TextField Name;
    @FXML
    private TextField Author;
    @FXML
    private TextField nbr;

    
    public static int AddBook(Book book)throws ClassNotFoundException,SQLException {
        String SQL="INSERT INTO books VALUES(?,?,?,?)";
        Connection conn = DBconnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, book.getName());
        stm.setObject(2, book.getAuthor());
        stm.setObject(3, book.getCategorie());
        stm.setObject(4, book.getNbr());
         return  stm.executeUpdate();
    }
        
    @FXML
    private void Add(ActionEvent event) throws SQLException, ClassNotFoundException {
    String name = Name.getText();
    String author = Author.getText();
    String cat = Categorie.getText();
    String n = nbr.getText();
     Book b = new Book(name,author,cat,n);
     AddBook(b);
     Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Books");
                    alert.setHeaderText(null);
                    alert.setContentText("Book " + name + " Added Successfully..!");
                    alert.showAndWait();
                    RESET(event);
    }
    private void RESET(ActionEvent event) {
    Name.setText(null);
    Author.setText(null);
    Categorie.setText(null);
    nbr.setText(null);
    }
}
