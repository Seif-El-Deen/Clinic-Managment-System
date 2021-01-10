
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Seif
 */
public class Doctor extends Person /*implements User*/{
    private String Password;
    public Doctor(){
        super();
    }
    public Doctor(String Name,String ID,String Address,String phoneNumber,String Password){
        super(Name,ID,Address,phoneNumber);
        this.Password=Password;
    }
    public String getPassword(){
        return this.Password;
    }


    public static void changePassword(String username,String userOldPassword, String userNewPassword) {
            try{
                    Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/MyDataBase","root","root");
                    java.sql.Statement st=con.createStatement();
                    String update;
                    update = "UPDATE doctor SET password = \'"+userNewPassword+"\' WHERE username = \'"+username+"\'";
                    int result=st.executeUpdate(update);
                    System.out.println(result);


            }
            catch(SQLException e){
                    System.out.println(e);
            }
    }
}
