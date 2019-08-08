/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Beans.Food;
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
public class FoodDatabase implements DatabaseInter<Food>{
    
        @Override
        public List<Food> getAll(){
        List<Food> list = new ArrayList<>();
        String Query = "SELECT * FROM foods";
        try(Connection con = MyConnection.connection()) {
            Statement s =  (Statement) con.createStatement();
            ResultSet rs = s.executeQuery(Query);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String unit = rs.getString(3);
                int qty = rs.getInt(4);
                int protein = rs.getInt(5);
                int fat = rs.getInt(6);
                int calori = rs.getInt(7);
                String picture = rs.getString(8);
                Food f = new Food(id, name, unit, qty, protein, fat, calori, picture);
                list.add(f);
            }
        }catch(Exception ex){
        
        }
        return list;
    }
        
        @Override
        public Food getById(int Id){
        Food f = null;
        String Query = "SELECT * FROM foods where id="+Id;
        try(Connection con = MyConnection.connection()) {
            Statement s =  (Statement) con.createStatement();
            ResultSet rs = s.executeQuery(Query);
            while (rs.absolute(1)) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String unit = rs.getString(3);
                int qty = rs.getInt(4);
                int protein = rs.getInt(5);
                int fat = rs.getInt(6);
                int calori = rs.getInt(7);
                String picture = rs.getString(8);
                f = new Food(id, name, unit, qty, protein, fat, calori, picture);
                return f;
            }
        }catch(Exception ex){
        
        }
        return f;
    }

    @Override
    public boolean update(Food food){
        String Query = "UPDATE foods SET name = ?, unit = ?, qty = ?, protein = ?, fat = ?, calori = ?, picture = ? WHERE id =?";
        try(Connection con = MyConnection.connection()){
            PreparedStatement pSt = con.prepareStatement(Query);
            pSt.setString(1,food.getName());
            pSt.setString(2,food.getUnit());
            pSt.setInt(3,food.getQty());
            pSt.setInt(4,food.getProtein());
            pSt.setInt(5,food.getFat());
            pSt.setInt(6,food.getCalori());
            pSt.setString(7,food.getPicture());
            pSt.setInt(8,food.getId());
            int res = pSt.executeUpdate();

        }catch (Exception ex){
            return false;
        }
        return true;
    }
    
    public List<Food> getBySearch(String txt){
        List<Food> list = new ArrayList<>();
        String Query = "SELECT * FROM foods WHERE name LIKE ?";
        try(Connection con = MyConnection.connection()) {
            PreparedStatement pSt =  con.prepareStatement(Query);
            pSt.setString(1, "%" + txt + "%");
            ResultSet rs = pSt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String unit = rs.getString(3);
                int qty = rs.getInt(4);
                int protein = rs.getInt(5);
                int fat = rs.getInt(6);
                int calori = rs.getInt(7);
                String picture = rs.getString(8);
                Food food = new Food(id, name, unit, qty, protein, fat, calori, picture);
                list.add(food);
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
        return list;
    }
    
    

    @Override
    public boolean insert(Food food){
        String Query = "insert into foods(name,unit,qty,protein,fat,calori,picture) values(?,?,?,?,?,?,?)";
        try(Connection con = MyConnection.connection()){
            PreparedStatement pSt = con.prepareStatement(Query);
            pSt.setString(1,food.getName());
            pSt.setString(2,food.getUnit());
            pSt.setInt(3,food.getQty());
            pSt.setInt(4,food.getProtein());
            pSt.setInt(5,food.getFat());
            pSt.setInt(6,food.getCalori());
            pSt.setString(7,food.getPicture());
            int res = pSt.executeUpdate();
        }catch (Exception ex){
            System.out.println(ex);
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteFromId(int id){
        String Query = "DELETE FROM foods WHERE id = ?";
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
