package com.demo;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IProduct {
    //recommendHospitalByCity
    List<Product> recommendProduct(@Param("account") String account);
    //showProductInfo
    List<Product> showProduct(@Param("account") String account);
    //selectType
    List<Product> selectType(@Param("classify") String classify);
    //findbyName
    List<Product> findName(@Param("keyword") String keyword);
    //updateProduct
    void updateProduct(@Param("product_name") String product_name, @Param("product_information") String product_information);

}
