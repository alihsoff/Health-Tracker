package Database;

import Beans.Profil;
import Beans.User;
import Database.MyConnection;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.util.List;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserDatabase implements DatabaseInter<User>{
    
    @Override
    public List<User> getAll(){
        User u = null;
        List<User> list = new ArrayList<>();
        String Query = "SELECT * FROM users";
        try(Connection con = MyConnection.connection()) {
            Statement s =  (Statement) con.createStatement();
            ResultSet rs = s.executeQuery(Query);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String surname = rs.getString(3);
                String username = rs.getString(4);
                String password = rs.getString(5);
                int isActive = rs.getInt(6);
                u = new User(id, name, surname,username,password,isActive);
                list.add(u);
            }
        }catch(Exception ex){
        
        }
        return list;
    }

    @Override
    public User getById(int userId){
        User u = null;
        String Query = "SELECT * FROM users WHERE id = "+userId;
        try(Connection con = MyConnection.connection()) {
            Statement s =  (Statement) con.createStatement();
            ResultSet rs = s.executeQuery(Query);
            while (rs.absolute(1)) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String surname = rs.getString(3);
                String username = rs.getString(4);
                String password = rs.getString(5);
                int isActive = rs.getInt(6);
                u = new User(id, name, surname,username,password,isActive);
                return u;
            }
        }catch(Exception ex){
        
        }
        return u;
    }

    @Override
    public boolean update(User user){
        String Query = "UPDATE users SET name = ?, surname = ?, username = ?, password = ?,isActive = ? WHERE id =?";
        try(Connection con = MyConnection.connection()){
            PreparedStatement pSt = con.prepareStatement(Query);
            pSt.setString(1,user.getName());
            pSt.setString(2,user.getSurname());
            pSt.setString(3,user.getUsername());
            pSt.setString(4,user.getPassword());
            pSt.setInt(5,user.getIsActive());
            pSt.setInt(6, user.getId());

            int res = pSt.executeUpdate();

        }catch (Exception ex){
            return false;
        }
        return true;
    }

    @Override
    public boolean insert(User user){
        String Query = "insert into users(name,surname,username,password) values(?,?,?,?)";
        try(Connection con = MyConnection.connection()){
            PreparedStatement pSt = con.prepareStatement(Query);
            pSt.setString(1,user.getName());
            pSt.setString(2,user.getSurname());
            pSt.setString(3, user.getUsername());
            pSt.setString(4,user.getPassword());
            int res = pSt.executeUpdate();
        }catch (Exception ex){
            System.out.println(ex);
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteFromId(int id){
        String Query = "DELETE FROM users WHERE id = ?";
        try(Connection con = MyConnection.connection()){
            PreparedStatement pSt = con.prepareStatement(Query);
            pSt.setInt(1,id);
            int res = pSt.executeUpdate();
        }catch (Exception ex){
            System.out.println(ex);
            return false;
        }
        return true;
    }
    
    
    public User loginCheck(String username,String password){
    String Query = "SELECT * FROM users WHERE username = ? AND password = ?";
    try(Connection con = MyConnection.connection()){
        PreparedStatement pSt = con.prepareStatement(Query);
        pSt.setString(1, username);
        pSt.setString(2,password);
        ResultSet rs = pSt.executeQuery();
        if(rs.absolute(1)){
            return new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6));
        }
    return null;
    }catch(Exception ex){
    System.out.println(ex);
    return null;
        }
    }
    
    
    public static boolean checkUserByUsername(String username){
    String Query = "SELECT * FROM users WHERE username = ?";
    try(Connection con = MyConnection.connection()){
    PreparedStatement pSt = con.prepareStatement(Query);
    pSt.setString(1, username);
        ResultSet rs = pSt.executeQuery();
        if(rs.absolute(1))
            return false;
    }catch(Exception ex){
    System.out.println(ex);
        }
    return true;
    }
    
}
