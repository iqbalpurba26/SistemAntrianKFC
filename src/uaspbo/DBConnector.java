/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uaspbo;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author M IQBAL
 */
public class DBConnector {
    static Connection connection;
    
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/db_kfc";
    static final String USER = "root";
    static final String PASSWORD = "";
    
   public static Connection initDBConnection(){
        try {
            Class.forName(JDBC_DRIVER);
            
            connection = DriverManager.getConnection(DB_URL,USER,PASSWORD);
            return connection;
               
           
            
        } catch (Exception ex) {
           System.out.println(ex);
        }
         return null;
   }
}
