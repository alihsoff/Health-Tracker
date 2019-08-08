/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Beans.Profil;
import Beans.User;
import Database.MyConnection;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ali Huseynov
 */
public class ProfilDatabase implements DatabaseInter<Profil>{
    
    @Override    
    public List<Profil> getAll(){
        List<Profil> list = new ArrayList<>();
        String Query = "SELECT * FROM profil";
        try(Connection con = MyConnection.connection()) {
            Statement s =  (Statement) con.createStatement();
            ResultSet rs = s.executeQuery(Query);
            while (rs.next()) {
                int id = rs.getInt(1);
                int user_id = rs.getInt(2);
                String gender = rs.getString(3);
                int age = rs.getInt(4);
                int height = rs.getInt(5);
                int weight = rs.getInt(6);
                String picture = rs.getString(7);
                Profil p = new Profil(id,user_id, gender, age,height,weight,picture);
                list.add(p);
            }
        }catch(Exception ex){
        
        }
        return list;
    }
    
    @Override
    public Profil getById(int Id){
        Profil p = null;
        String Query = "SELECT * FROM profil where id="+Id;
        try(Connection con = MyConnection.connection()) {
            Statement s =  (Statement) con.createStatement();
            ResultSet rs = s.executeQuery(Query);
            while (rs.absolute(1)) {
                int id = rs.getInt(1);
                int user_id = rs.getInt(2);
                String gender = rs.getString(3);
                int age = rs.getInt(4);
                int height = rs.getInt(5);
                int weight = rs.getInt(6);
                String picture = rs.getString(7);
                p = new Profil(id,user_id, gender, age,height,weight,picture);
                return p;
            }
        }catch(Exception ex){
        
        }
        return p;
    }
        
    public Profil getProfilByUserId(int userId){
        Profil p = null;
        String Query = "SELECT * FROM profil where user_id="+userId;
        try(Connection con = MyConnection.connection()) {
            Statement s =  (Statement) con.createStatement();
            ResultSet rs = s.executeQuery(Query);
            while (rs.absolute(1)) {
                int id = rs.getInt(1);
                int user_id = rs.getInt(2);
                String gender = rs.getString(3);
                int age = rs.getInt(4);
                int height = rs.getInt(5);
                int weight = rs.getInt(6);
                String picture = rs.getString(7);
                p = new Profil(id,user_id, gender, age,height,weight,picture);
                return p;
            }
        }catch(Exception ex){
        
        }
        return p;
    }

    
    @Override
    public boolean update(Profil profil){
        String Query = "UPDATE profil SET gender = ?, age = ?, height = ?, weight = ?, picture = ? WHERE id =?";
        try(Connection con = MyConnection.connection()){
            PreparedStatement pSt = con.prepareStatement(Query);
            pSt.setString(1,profil.getGender());
            pSt.setInt(2,profil.getAge());
            pSt.setInt(3,profil.getHeight());
            pSt.setInt(4,profil.getWeight());
            pSt.setString(5,profil.getPicture());
            pSt.setInt(6,profil.getId());
            int res = pSt.executeUpdate();

        }catch (Exception ex){
            return false;
        }
        return true;
    }
    
    
    @Override
    public boolean insert(Profil profil){
        String Query = "insert into profil(user_id,gender,age,height,weight,picture) values(?,?,?,?,?,?)";
        try(Connection con = MyConnection.connection()){
            PreparedStatement pSt = con.prepareStatement(Query);
            pSt.setInt(1,Config.ConfigUser.config.getUser().getId());
            pSt.setString(2,profil.getGender());
            pSt.setInt(3,profil.getAge());
            pSt.setInt(4,profil.getHeight());
            pSt.setInt(5,profil.getWeight());
            pSt.setString(6,profil.getPicture());
            int res = pSt.executeUpdate();
        }catch (Exception ex){
            System.out.println(ex);
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteFromId(int id){
        String Query = "DELETE FROM profil WHERE id = ?";
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

    
}
