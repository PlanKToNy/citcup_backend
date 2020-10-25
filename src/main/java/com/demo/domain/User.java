package com.demo.domain;

import static sun.misc.Version.print;

public class User {
    private String account;
    private String password;
    private String username;
    private String gender;
    private String city;
    private String age;
    private String telephone;

    public User(){}

    public User(String account,String password,String username,String gender,String city,String age,String telephone){
        this.account=account;
        this.password=password;
        this.username=username;
        this.gender=gender;
        this.city=city;
        this.age=age;
        this.telephone=telephone;
    }

    public int verify(String password){
        if(this.password.equals(password))
            return 1;
        else
            return 2;
    }
    public void getInfo() {
        System.out.println(
                "username='" + username + '\'' +
                ", gender='" + gender + '\'' +
                ", city='" + city + '\'');
    }

    public void getFinancialInfo() {
        System.out.println(
                "customer_name='" + username + '\'' +
                        "，customer_gender='" + gender + '\'' +
                        "，customer_age='" + age + '\'' +
                        "，customer_telephone='" + telephone + '\'');
    }

    @Override
    public String toString() {
        return "User{" +
                "account=" + account +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", gender='" + gender + '\'' +
                ", city=" + city +'\'' +
                ", age='" + age + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }


}