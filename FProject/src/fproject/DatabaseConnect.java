package fproject;

//import com.mysql.jdbc.Connection;
import java.sql.*;

public class DatabaseConnect 
{
    private static final String Username    = "root";
    private static final String Password    = " ";
    private static final String Conn_Str = "jdbc:mysql://localhost/FProject";
    com.mysql.jdbc.Connection conn = null;
    
    void connect()
    {
        try 
        {
            conn =(com.mysql.jdbc.Connection) DriverManager.getConnection(Conn_Str, Username, Password);
            System.out.println("************ You are now Connected for Reservations ********");
        } 
        catch(SQLException e)
        {
            System.err.println("***************  Oooops..... Connection Error ***************");
        }
    }
}
