/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Seif
 */
public abstract class Person {

    private final String Name;
    private final String ID;
    private String Address;
    private String phoneNumber;
    
    public Person(){
        this.Name="";
        this.ID="";
    };
    public Person(String Name,String ID,String Address,String phoneNumber){
        this.Name=Name;
        this.ID=ID;
        this.Address=Address;
        this.phoneNumber=phoneNumber;
    }
    public String getName() {
        return Name;
    }

    public String getID() {
        return ID;
    }
    public String getAddress() {
        return Address;
    }
    public void setAddress(String Address){
        this.Address=Address;
    }
    public String getPhoneNumber(){
        return this.phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber=phoneNumber;
    }


}
