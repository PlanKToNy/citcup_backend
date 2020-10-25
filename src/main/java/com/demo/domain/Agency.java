package com.demo.domain;

public class Agency {
    private String agency_name;
    private String agency_account;
    private String agency_information;

    public Agency(){}

    public Agency(String agency_name, String agency_account, String agency_information) {
        this.agency_name = agency_name;
        this.agency_account = agency_account;
        this.agency_information = agency_information;
    }

    public String toString() {
        return "agencyOrg{" +
                "agency_name='" + agency_name + '\'' +
                ", agency_account='" + agency_account + '\'' +
                ", agency_information='" + agency_information + '\'' +
                '}';
    }

    public void showInfo() {
        System.out.println("agency_information='" + this.agency_information);
    }
}

