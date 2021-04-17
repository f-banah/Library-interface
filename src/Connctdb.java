



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connctdb {
	
   public static Connection mysqlconfig;
    public static Connection configDB(){
        try {
            String url="jdbc:mysql://localhost:3306/crudprojet"; 
            String user="root"; 
            String pass=""; 
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            mysqlconfig=DriverManager.getConnection(url, user, pass);  
            System.out.println("connected!!");
        } catch (Exception e) {
            System.err.println("non connectée "+e.getMessage()); 
        }
        return mysqlconfig;
        
    }  
    
}