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
public class Food {
    private int id;
    private String name;
    private String unit;
    private int qty;
    private int protein;
    private int fat;
    private int calori;
    private String picture;

    public Food(int id, String name, String unit, int qty, int protein, int fat, int calori, String picture) {
        this.id = id;
        this.name = name;
        this.unit = unit;
        this.qty = qty;
        this.protein = protein;
        this.fat = fat;
        this.calori = calori;
        this.picture = picture;
    }

    public Food(String name, String unit, int qty, int protein, int fat, int calori, String picture) {
        this.name = name;
        this.unit = unit;
        this.qty = qty;
        this.protein = protein;
        this.fat = fat;
        this.calori = calori;
        this.picture = picture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public int getCalori() {
        return calori;
    }

    public void setCalori(int calori) {
        this.calori = calori;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Food{" + "id=" + id + ", name=" + name + ", unit=" + unit + ", qty=" + qty + ", protein=" + protein + ", fat=" + fat + ", calori=" + calori + ", picture=" + picture + '}';
    }
    
    
}
