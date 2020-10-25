package com.demo;

import org.apache.ibatis.annotations.Param;

public interface IAgency {
    //displayHospital
    Agency showAgency(@Param("account") String account);

    //recommendHospitalByCity
    //List<Agency> selectCity(@Param("city") String city);

    void updateAgency(@Param("agency_name") String agency_name, @Param("agency_information") String agency_information);

}
