
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
public class Admin extends Person /*implements User*/ {
    private String Password;
    public Admin(){
        
    }
    public Admin(String Name,String ID,String Address,String phoneNumber,String Password){
        super( Name, ID, Address, phoneNumber);
        this.Password=Password;
    }
    
        public String getPassword(){
            return this.Password;
        }


    public static void changePassword(String username, String userOldPassword, String userNewPassword) {
        try{
                Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/MyDataBase","root","root");
                java.sql.Statement st=con.createStatement();
                String update;
                update = "UPDATE admin SET password = \'"+userNewPassword+"\' WHERE username = \'"+username+"\'";

                int result=st.executeUpdate(update);
                System.out.println(result);


        }
        catch(SQLException e){
                System.out.println(e);
        }
    }

    public void logout() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    





}
