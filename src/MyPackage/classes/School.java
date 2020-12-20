/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPackage.classes;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class School {

    public School(String fullName, String briefName, String university, String type, String diplom, String year, String nStudents, String nStaff, String adress, String codePostal, String city, String email, String fax, String tel) {
        this.fullName = fullName;
        this.briefName = briefName;
        this.university = university ;
        this.type = type; 
        this.diplom = diplom;        
        this.year = year;        
        this.nStudents = nStudents;        
        this.nStaff = nStaff;        
        this.adress = adress;        
        this.codePostal = codePostal;   
        this.city = city;
        this.email = email;
        this.fax = fax;
        this.tel = tel;
    }

//-------------------- SETTERS --------------------------------------  
    public void setnStudents(String nStudents) {
        this.nStudents = nStudents;
    }

    public void setnStaff(String nStaff) {
        this.nStaff = nStaff;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDiplom(String diplom) {
        this.diplom = diplom;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setBriefName(String briefName) {
        this.briefName = briefName;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    //------------------ GETTERS -----------------------------------------
    public String getnStudents() {
        return nStudents;
    }

    public String getnStaff() {
        return nStaff;
    }

    public String getYear() {
        return year;
    }

    public String getUniversity() {
        return university;
    }

    public String getType() {
        return type;
    }

    public String getTel() {
        return tel;
    }

    public String getFullName() {
        return fullName;
    }

    public String getFax() {
        return fax;
    }

    public String getEmail() {
        return email;
    }

    public String getDiplom() {
        return diplom;
    }

    public String getCodePostal() {
        return codePostal;
    }
    
    public String getCity() {
        return city;
    }
    
    public String getAdress() {
        return adress;
    }

    public String getBriefName() {
        return briefName;
    }

    //-------------------------------------------------
    public School() {
    }
    private String fullName;
    private String briefName;
    private String university;
    private String type;
    private String diplom;
    private String year;
    private String nStudents;
    private String nStaff;
    private String adress;
    private String codePostal;
    private String city;
    private String email;
    private String fax;
    private String tel;
    
   /* public School(String fullName, String briefName, String university, String type, String diplom, String year, String nStudents, String nStaff, String adress, String codePostal, String city, String email, String fax, String tel  ){
        this.fullName = fullName;
        this.briefName = briefName;
        this.university = university ;
        this.type = type; 
        this.diplom = diplom;        
        this.year = year;        
        this.nStudents = nStudents;        
        this.nStaff = nStaff;        
        this.adress = adress;        
        this.codePostal = codePostal;   
        this.city = city;
        this.email = email;
        this.fax = fax;
        this.tel = tel;
        }
*/
    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }


}
