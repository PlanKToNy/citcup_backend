package com.demo;

import java.io.IOException;
import java.util.Scanner;

public class DemoTest {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

//        //register
//        String account=scanner.nextLine();
//        String password=scanner.nextLine();
//        String username=scanner.nextLine();
//        int success=CRUD.register(account,password,username);
//        System.out.println("success="+success);

//        //login
//        String account=scanner.nextLine();
//        String password=scanner.nextLine();
//        int success=CRUD.login(account,password);
//        System.out.println("success="+success);

//        //displayInfo
//        String account=scanner.nextLine();
//        CRUD.displayInfo(account);

        //updateInfo
//        String account=scanner.nextLine();
//        String username=scanner.nextLine();
//        String gender=scanner.nextLine();
//        String city=scanner.nextLine();
//        int success=CRUD.updateInfo(account,username,gender,city);
//        System.out.println("success="+success);


//        //displayHospital
//        String account=scanner.nextLine();
//        CRUD.displayHopital(account);

//        //displayFinancialUser
//        String financial_account=scanner.nextLine();
//        CRUD.displayFinancialUser(financial_account);

        //displayFinancialHospital
        String financial_account=scanner.nextLine();
        CRUD.displayFinancialHospital(financial_account);

    }
}

