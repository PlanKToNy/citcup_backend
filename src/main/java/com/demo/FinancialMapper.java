package com.demo;

import com.demo.domain.Hospital;
import com.demo.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FinancialMapper {
    List<User> selectFinancialUser(@Param("financial_account") String financial_account);
    List<String> selectFinancialHospital(@Param("financial_account") String financial_account);
}
