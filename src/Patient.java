/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Seif
 */
public class Patient extends Person{
    private String tokenID="";
    private String Date="";
    private String doctorID="";
    public Patient(){}
    public Patient(String Name,String ID,String Address,String phoneNumber,String tokenID,String Date,String doctorID){
        super(Name, ID, Address, phoneNumber);
        this.tokenID=tokenID;
        this.Date=Date;
        this.doctorID=doctorID;
    }
    public String getTokenID(){
        return this.tokenID;
    }
    public void setTokenID(String tokenID){
        this.tokenID=tokenID;
    }
    public String getDate(){
        return this.Date;
    }
    public void setDate(String Date){
        this.Date=Date;
    }
    public String getDoctorID(){
        return this.doctorID;
    }
    public void setDoctorID(String doctorID){
        this.doctorID=doctorID;
    }
}
