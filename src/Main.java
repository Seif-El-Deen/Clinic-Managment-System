import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Seif
 */

public class Main {

    public static int LoginPageDB(String username,String password,String job){
        int page=-1;
        boolean userIsFound=false;
        try{
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/MyDataBase","root","root");
            java.sql.Statement st=con.createStatement();
            String adminStatement;
            adminStatement = "select * from admin";
            String doctorStatement;
            doctorStatement = "select * from doctor";
            String receptionistStatement;
            receptionistStatement="select * from receptionist";
            ResultSet rs;
            switch(job){
                case "admin":
                    rs=st.executeQuery(adminStatement);
                    while(rs.next()){
                        if(rs.getString("username").equals(username)&&rs.getString("password").equals(password)){
                            page=1;
                            userIsFound=true;
                            GUI.hiddenWrongLogin.setVisible(false);
                            break;
                        }
                    }
                break;
                    
                case "doctor":
                    rs=st.executeQuery(doctorStatement);
                    while(rs.next()){
                        if(rs.getString("username").equals(username)&&rs.getString("password").equals(password)){
                            page=2;
                            userIsFound=true;
                            GUI.hiddenWrongLogin.setVisible(false);
                            break;
                        }
                    }
                break;
                    
                case "receptionist":
                    rs=st.executeQuery(receptionistStatement);
                    while(rs.next()){
                        if(rs.getString("username").equals(username)&&rs.getString("password").equals(password)){
                            page=3;
                            userIsFound=true;
                            GUI.hiddenWrongLogin.setVisible(false);
                            break;
                        }
                    }
                break;
            }
            if(userIsFound==false){
                GUI.hiddenWrongLogin.setVisible(true);
            }

        }
        catch(SQLException e){
            System.out.println(e);
        }
        
        return page;
    }
    public static void DB(String username,int ID,String role){
                try{
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/orcl","scott","tiger");
              Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/MyDataBase","root","root");
            java.sql.Statement st=con.createStatement();
            String sql="select * from users";
            String sql2="insert into users (id,name,job) values (4,\'mohamed\',\'doctor\')";
            String sql3="delete from users where id=2";
            ResultSet rs=st.executeQuery(sql);
            st.executeUpdate(sql3);
            st.executeUpdate(sql2);
//            System.out.println(rs.getString("name") + " Is a "+rs.getString("job")+ " It's ID: "+rs.getInt("ID"));

//            while(rs.next()){
////                System.out.println(rs.getInt(1)+"  "+rs.getString(2));
////                con.close();
//                if(rs.getString("name").equals(username) && rs.getInt("ID")==(ID)&& rs.getString("job").equals(role)){
//                    System.out.println(rs.getString("name") + " Is a "+rs.getString("job")+ " It's ID: "+rs.getInt("ID"));
//                }
//            }
               
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public static void main(String[] args) {
        
        GUI myFrame=new GUI();
            int page;
            myFrame.LoginPage();
            
            while((myFrame.Username.equals("")&&myFrame.Password.equals("")&&myFrame.Job.equals("")
                    )||(LoginPageDB(myFrame.Username,myFrame.Password,myFrame.Job)==-1)){
                System.out.println("Waiting");
            }
            page=LoginPageDB(myFrame.Username,myFrame.Password,myFrame.Job);

            switch(page){
                case 1:
                    System.out.println("Admin Page");
                    myFrame.AdminPage(myFrame.Username);
                    break;
                case 2:
                    System.out.println("Doctor Page");
                    myFrame.doctorPage(myFrame.Username);
                    break;
                case 3:
                    System.out.println("Resiptianist Page");
                    myFrame.receptionistPage(myFrame.Username);
                    break;
            }        
    }
    
}
