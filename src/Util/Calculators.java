/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import Config.ConfigUser;

/**
 *
 * @author Ali Huseynov
 */
public class Calculators {
    public static double bfp_calculatorForMale(int waist,int neck){
    double res;
    res = 495/( 1.0324-0.19077*Math.log10(waist-neck)+0.15456*Math.log10(ConfigUser.config.getProfil().getHeight()))-450;
    
    return res;
    }
    
    public static double bfp_calculatorForFemale(int waist,int neck,int hip){
    double res;
    res = 495/(1.29579 - 0.35004*Math.log10(waist+hip-neck) + 0.22100*Math.log10(ConfigUser.config.getProfil().getHeight()))-450;
    
    return res;
    }
    
    public static double bmi_calculator(){
    double res;
    int weight = ConfigUser.config.getProfil().getWeight();
    int height = ConfigUser.config.getProfil().getHeight();
    res = weight/Math.pow((double)height/100.0, 2);
    return res;
    }
    
    public static double bmr_calculatorForMale(){
    double res;
    int W = ConfigUser.config.getProfil().getWeight();
    int H = ConfigUser.config.getProfil().getHeight();
    int A = ConfigUser.config.getProfil().getAge();
    
    res = 10*W + 6.25*H - 5*A + 5;
    return res;
    }

    public static double bmr_calculatorForFemale(){
    double res;
    int W = ConfigUser.config.getProfil().getWeight();
    int H = ConfigUser.config.getProfil().getHeight();
    int A = ConfigUser.config.getProfil().getAge();
    
    res = 10*W + 6.25*H - 5*A - 161;
    return res;
    }
    
    public static double IW_calculatorForMale(){
    double res;
    int H = ConfigUser.config.getProfil().getHeight();
    
    res = 52 + 1.9*((H/2.54)-60);
    return res;
    }

    public static double IW_calculatorForFemale(){
    double res;
    int H = ConfigUser.config.getProfil().getHeight();
    
    res = 49 + 1.7*((H/2.54)-60);
    return res;
    }
    
}
