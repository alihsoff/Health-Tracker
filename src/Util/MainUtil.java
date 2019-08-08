/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import GUI.LoginFrame;
import GUI.MainFrame;
import java.awt.Frame;
import javax.swing.JOptionPane;

/**
 *
 * @author Ali Huseynov 

 */
public class MainUtil {
   public static void logout(Frame f){
       if(askForOperation("Logout", "Cancel", "Are you sure", "Logout Account")==0){
   Config.ConfigUser.config = null;
   LoginFrame lf = new LoginFrame();
   lf.setVisible(true);
   lf.setLocationRelativeTo(null);
   f.dispose();
       }
   } 
   
   public static int askForOperation(String yes,String no,String message,String title){
    String[] options = {yes,no};
    int YesOrNo = JOptionPane.showOptionDialog(null,
    message,
    title,
    JOptionPane.OK_CANCEL_OPTION,
    JOptionPane.QUESTION_MESSAGE,
    null,     //do not use a custom Icon
    options,  //the titles of buttons
    options[0]); //default button title
   return YesOrNo;
   }
}
