
package MyPackage.classes;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


public class Book {
    private String Name;
    private String Author;
    private String Categorie;
    private String nbr;


    public Book(String Name, String Author, String Categorie, String nbr ) {
        this.Name = Name;
        this.Author = Author;
        this.Categorie = Categorie;
        this.nbr = nbr;
        
    }
  
//------------------- GETTERS ------------------------------
      public String getNbr() {
        return nbr;
    }

    public String getName() {
        return Name;
    }

    public String getCategorie() {
        return Categorie;
    }

    public String getAuthor() {
        return Author;
    }  
//---------------- SETTERS -----------------------------
    public void setNbr(String nbr) {
        this.nbr = nbr;
    }

    public void setCategorie(String Categorie) {
        this.Categorie = Categorie;
    }
   
    public void setAuthor(String Author) {
        this.Author = Author;
    }
    
    public void setName(String Name) {
        this.Name = Name;
    }
   
    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
   

   
    
    
}

   
    
    
