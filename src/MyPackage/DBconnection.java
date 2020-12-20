
package MyPackage;

import java.sql.*;


public class DBconnection {
    private Connection conn;
    private static DBconnection dbConnection;
    
    private DBconnection()throws ClassNotFoundException,SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        conn=DriverManager.getConnection("jdbc:mysql://localhost/ums","root","");
    }
    public Connection getConnection(){

        return conn;
    }
    public static DBconnection getDBConnection()throws ClassNotFoundException,SQLException{
        if(dbConnection==null){
            dbConnection=new DBconnection();
        }
        return dbConnection;
    }
    
    
    
    
}
