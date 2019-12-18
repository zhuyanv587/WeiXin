package com.example.weixin;

import java.io.Serializable;
//vo：value object
public class Address implements Serializable {
    private int img;
    private String name;
    //生成get/set方法

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //创建无参和有参的构造方法：alter+insert
    public Address(int img, String name) {
        this.img = img;
        this.name = name;
    }

    //重写toString()方法：alter+insert
    @Override
    public String toString() {
        return "Address{" +
                "img=" + img +
                ", name='" + name + '\'' +
                '}';
    }
}
