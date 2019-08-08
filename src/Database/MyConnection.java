/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Ali Huseynov
 */
public class MyConnection {
        public static Connection connection(){
        
        String username = "root";
        String pass = "123456789";

        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection =
             (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/health_tracker",username,pass);
        return connection;}
        catch(Exception ex){
            System.out.println("Connection error");
        }
        return null;
    } 
}
