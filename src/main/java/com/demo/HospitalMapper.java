package com.demo;

import com.demo.domain.Hospital;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

public interface HospitalMapper {
    //displayHospital
    Hospital selectHospital(@Param("account") String account);

    //recommendHospitalByCity
    List<Hospital> selectCity(@Param("city") String city);
}
