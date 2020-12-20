/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPackage.classes;


public class Staff {
    private String Name;
    private String familyName ;
    private int CIN  ;
    private String DOB   ;
    private String Age  ;
    private String Gender;
    private String appDate ;
    private String job   ;
    private String adress  ;
    private String codeP   ;
    private String email  ;
    private String phone   ;

    public Staff(String Name, String familyName, int CIN, String DOB, String Age, String Gender, String appDate, String job, String adress, String codeP, String email, String phone ) {
        this.Name = Name;
        this.familyName = familyName;
        this.CIN = CIN;
        this.DOB = DOB;
        this.Age = Age;
        this.Gender = Gender;
        this.appDate = appDate;
        this.job = job;
        this.adress = adress;
        this.codeP = codeP;
        this.email = email;
        this.phone = phone;
        
    }

    public String getAdress() {
        return adress;
    }

    public String getAge() {
        return Age;
    }

    public int getCIN() {
        return CIN;
    }

    public String getAppDate() {
        return appDate;
    }

    public String getCodeP() {
        return codeP;
    }

    public String getDOB() {
        return DOB;
    }

    public String getEmail() {
        return email;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getGender() {
        return Gender;
    }

    public String getJob() {
        return job;
    }

    public String getName() {
        return Name;
    }

    public String getPhone() {
        return phone;
    }

    //-----------------------------------------------------------------
    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setAge(String Age) {
        this.Age = Age;
    }

    public void setAppDate(String appDate) {
        this.appDate = appDate;
    }

    public void setCIN(int   CIN) {
        this.CIN = CIN;
    }

    public void setCodeP(String codeP) {
        this.codeP = codeP;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

   
}

    
