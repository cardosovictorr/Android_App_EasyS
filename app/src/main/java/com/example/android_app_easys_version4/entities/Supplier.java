package com.example.android_app_easys_version4.entities;

import java.io.Serializable;

public class Supplier implements Serializable {
    public static final String SUPPLIER_KEY = "supplier_key";

    private Long id;
    private String name;
    private String category;
    private String mobile;
    private String email;
    private String imageFileName;

    public Supplier(){

    }

    public Supplier ( Long id, String name, String category, String mobile, String email, String imageFileName){
        this.id = id;
        this.name = name;
        this.category = category;
        this.mobile = mobile;
        this.email = email;
        this.imageFileName = imageFileName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }


}
