package com.demo.domain;

public class Hospital {
    private String account;
    private String hospital_name;
    private String hospital_city;
    private String hospital_program;
    private String hospital_doctor;

    public Hospital(){}

    public Hospital(String account,String hospital_name,String hospital_city,String hospital_program,String hospital_doctor){
        this.account=account;
        this.hospital_name=hospital_name;
        this.hospital_city=hospital_city;
        this.hospital_program=hospital_program;
        this.hospital_doctor=hospital_doctor;
    }


    @Override
    public String toString() {
        return "Hospital{" +
                "account=" + account +
                ", hospital_name='" + hospital_name + '\'' +
                ", hospital_city='" + hospital_city + '\'' +
                ", hospital_program='" + hospital_program + '\'' +
                ", hospital_doctor=" + hospital_doctor +
                '}';
    }

    public void getInfo() {
        System.out.println(
                "hospital_name='" + hospital_name + '\'' +
                        ", hospital_city='" + hospital_city + '\'' +
                        ", hospital_program='" + hospital_program + '\'' +
                        ", hospital_doctor=" + hospital_doctor
        );
    }
}
