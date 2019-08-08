/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import Beans.Food;
import Database.FoodDatabase;
import GUI.MainFrame;
import java.awt.Image;
import java.util.List;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ali Huseynov
 */
public class FoodUtil extends MainFrame{
    public static DefaultTableModel fillFoodTable(JTable table,String searchText){
        FoodDatabase fd = new FoodDatabase();
        List<Food> foods;
        if(searchText!=null&&!searchText.isEmpty())
            foods = fd.getBySearch(searchText);
        
        
        else
        foods = fd.getAll();
        
        String[] cols = new String[]{"Id","Name","Unit","Qty","Protein","Fat","Calori","Picture"};
        Object[][] data = new Object[foods.size()][9];
        
        for(int i = 0; i < foods.size(); i++){
            Food f = foods.get(i);
            data[i][0] = f.getId();
            data[i][1] = f.getName();
            data[i][2] = f.getUnit();
            data[i][3] = f.getQty();
            data[i][4] = f.getProtein()+" gr";
            data[i][5] = f.getFat()+" gr";
            data[i][6] = f.getCalori()+" gr";
            ImageIcon food_image = new ImageIcon(new ImageIcon(f.getPicture()).getImage()
             .getScaledInstance(50, 50, Image.SCALE_SMOOTH) ); 
            data[i][7] = food_image;
            data[i][8] = f.getPicture();
        }
        
        DefaultTableModel dtm = new DefaultTableModel(data,cols){
            public Class getColumnClass(int column){
            return getValueAt(0,column).getClass();
             }
        };
        table.setModel(dtm);
        table.setRowHeight(50);
        table.getColumnModel().getColumn(0).setMaxWidth(50);
        return dtm;
    }
    
}
