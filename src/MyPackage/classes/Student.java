/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPackage.classes;


import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Student {

    public Student( String Name, String familyName, int CIN, String DOB, String age, String gender, String grade, String classe, String adress, String city, String email, String telephone) {
        this.Name = new SimpleStringProperty(Name);
        this.familyName = new SimpleStringProperty(familyName);
        this.CIN = CIN;
        this.DOB = new SimpleStringProperty(DOB);
        this.age = new SimpleStringProperty(age);
        this.gender = new SimpleStringProperty(gender);
        this.grade = new SimpleStringProperty(grade);
        this.classe = new SimpleStringProperty(classe);
        this.adress = new SimpleStringProperty(adress);
        this.city = new SimpleStringProperty(city);
        this.email = new SimpleStringProperty(email);
        this.telephone = new SimpleStringProperty(telephone);
    }

    private SimpleStringProperty Name;
    private SimpleStringProperty familyName;
    private int CIN;
    private SimpleStringProperty DOB;
    private SimpleStringProperty age;
    private SimpleStringProperty gender;
    private SimpleStringProperty grade;
    private SimpleStringProperty classe;
    private SimpleStringProperty adress;
    private SimpleStringProperty city;
    private SimpleStringProperty email;
    private SimpleStringProperty telephone;

    public String getName() {
        return Name.get();
    }

    public String getFamilyName() {    
        return familyName.get();
    }

    public int getCIN() {
        return CIN;
    }

    public String getDOB() {
        return DOB.get();
    }

    public String getAge() {
        return age.get();
    }

    public String getGender() {
        return gender.get();
    }

    public String getGrade() {
        return grade.get();
    }

    public String getClasse() {
        return classe.get();
    }

    public String getAdress() {
        return adress.get();
    }

    public String getCity() {
        return city.get();
    }

    public String getEmail() {
        return email.get();
    }

    public String getTelephone() {
        return telephone.get();
    }
    
//////////-------------------------------------------------------------------------
    
    public void setName(String Name) {
        this.Name = new SimpleStringProperty(Name);
    }

    public void setFamilyName(String familyName) {
        this.familyName = new SimpleStringProperty(familyName);
    }

    public void setCIN(int CIN) {
        this.CIN = CIN; 
    }

    public void setDOB(String DOB) {
        this.DOB = new SimpleStringProperty(DOB);
    }

    public void setAge(String age) {
        this.age = new SimpleStringProperty(age);
    }

    public void setGender(String gender) {
        this.gender = new SimpleStringProperty(gender);
    }

    public void setGrade(String grade) {
        this.grade = new SimpleStringProperty(grade);
    }

    public void setClasse(String classe) {
        this.classe = new SimpleStringProperty(classe);
    }

    public void setAdress(String adress) {
        this.adress = new SimpleStringProperty(adress);
    }

    public void setCity(String city) {
        this.city = new SimpleStringProperty(city);
    }

    public void setEmail(String email) {
        this.email = new SimpleStringProperty(email);
    }

    public void setTelephone(String telephone) {
        this.telephone = new SimpleStringProperty(telephone);
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}