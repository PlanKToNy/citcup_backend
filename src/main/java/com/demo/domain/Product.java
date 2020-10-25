package com.demo.domain;

public class Product {
    private String product_name;
    private String product_type;
    private String product_information;

    public Product(){}

    public Product(String product_name, String product_type, String product_information) {
        this.product_name = product_name;
        this.product_type = product_type;
        this.product_information = product_information;
    }

    public String toString() {
        return "Product{" +
                "product_name='" + product_name + '\'' +
                ", product_type='" + product_type + '\'' +
                ", product_information='" + product_information + '\'' +
                '}';
    }

    public void showInfo() {
        System.out.println("product_name='" + product_name + '\'' +"product_information='" + this.product_information);
    }
}
