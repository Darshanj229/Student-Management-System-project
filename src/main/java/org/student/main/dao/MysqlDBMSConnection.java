package org.student.main.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlDBMSConnection {
    
    static final String DB_URL="jdbc:mysql://localhost:3306/";
    static final String DB_USER="root";
    static final String DB_PASSWORD="Srdh@1999";
    static final String DB_NAME="studentDBMS";

    public static Connection dbconnect() throws ClassNotFoundException
    {
        Connection connection=null;
        
        try 
        {       
            connection = DriverManager.getConnection(DB_URL+DB_NAME, DB_USER, DB_PASSWORD); 
           
        } 
        catch (SQLException e) 
        {       
            System.out.println("Connection Error!!");
        }
        
        return connection;
    
    }

}

