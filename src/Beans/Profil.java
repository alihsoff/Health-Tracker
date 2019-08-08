/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author Ali Huseynov
 */
public class Profil {
    private int id;
    private int user_id;
    private String gender;
    private int age;
    private int height;
    private int weight;
    private String picture;

    public Profil() {
    }

    public Profil(int user_id, String gender, int age, int height, int weight, String picture) {
        this.user_id = user_id;
        this.gender = gender;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.picture = picture;
    }


    public Profil(int id, int user_id, String gender, int age, int height, int weight, String picture) {
        this.id = id;
        this.user_id = user_id;
        this.gender = gender;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.picture = picture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
    
    
}
