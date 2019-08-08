/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Ali Huseynov 
 */
public class ImageUtil {
    private static final String uploadLocationProfil = "C:\\Users\\Acer\\Documents\\NetBeansProjects\\Health_Tracker\\src\\ProfilImg\\";
    private static final String uploadLocationFood = "C:\\Users\\Acer\\Documents\\NetBeansProjects\\Health_Tracker\\src\\FoodImgs\\";
    public String chooseAndSetImage(JLabel lbl_image){
        JFileChooser file = new JFileChooser("Upload Photo");
        file.setCurrentDirectory(new File(System.getProperty("user.home")+"/Desktop"));

        FileNameExtensionFilter filter = new FileNameExtensionFilter(".*Only jpg","jpg");
        file.addChoosableFileFilter(filter);
        file.setFileFilter(filter);

        int res = file.showOpenDialog(null);
        if(res==JFileChooser.APPROVE_OPTION){
            File selectedImage = file.getSelectedFile();
            String path = selectedImage.getAbsolutePath();
            setImage(path,lbl_image);
            return path;
        }
        return null;
    }
    
    public void setImage(String path,JLabel lbl_image){
        lbl_image.setIcon(ResizeImage(path,lbl_image));
    }
    
    public ImageIcon ResizeImage(String imgPath,JLabel lbl_image){
        ImageIcon myImage = new ImageIcon(imgPath);
        
        Image img = myImage.getImage();
        Image img2 = img.getScaledInstance(lbl_image.getWidth(), lbl_image.getHeight(), Image.SCALE_SMOOTH);
        
        ImageIcon image = new ImageIcon(img2);
        return image;
    }
    public String uploadImage(String imgPath,boolean food){
    Path oldFile = Paths.get(imgPath);
    String myFile;
    if(food){
    myFile = uploadLocationFood+UUID.randomUUID()+".jpg";
    }
    else
    myFile = uploadLocationProfil+UUID.randomUUID()+".jpg";
    
    
    File newFile = new File(myFile);
    try(FileOutputStream fos = new FileOutputStream(newFile)){
    Files.copy(oldFile,fos);
        }catch(Exception ex){
            System.out.println(ex);
        }
    return myFile;
    }
    
    public void deleteImage(String imgPath){
    try{
    Path oldFile = Paths.get(imgPath);
    Files.delete(oldFile);
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
}
