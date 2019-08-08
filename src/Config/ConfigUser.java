/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import Beans.Profil;
import Beans.User;

/**
 *
 * @author  Ali Huseynov

 */
public class ConfigUser {
    private User user = null;
    private Profil profil = null;
    public static ConfigUser config = null;

    public ConfigUser(User user) {
        this.user = user;
    }
    
    public ConfigUser(User user,Profil profil) {
        this.user = user;
        this.profil = profil;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }
    
    
    
    
    
}
