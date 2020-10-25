package com.demo;

import com.demo.domain.Hospital;
import com.demo.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class CRUD {

    static public int register(String account, String password, String username) throws IOException {
        if(account.equals("") || password.equals("")||username.equals(""))
            return 1;//账号或密码或用户名为空
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user=mapper.selectUser(account);
            if(user!=null)
                return 2;//账号已存在
            else {
                mapper.insertUser(account, password);
                mapper.insertInfo(account, username);
            }
            //需要手动提交事务
            session.commit();
        }
        return 0;
    }

    static public int login(String account,String password) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = mapper.selectUser(account);
            if(user==null)
                return 0;
            else
                return user.verify(password);
        }
    }

    static public void displayInfo(String account) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = mapper.selectInfo(account);
            user.getInfo();
        }
    }

    static public int updateInfo(String account,String username,String gender,String city) throws IOException {
        if(username.equals(""))
            return 1;//用户名不能为空
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            mapper.updateInfo(account,username,gender,city);
            //需要手动提交事务
            session.commit();;
        }
        return 0;
    }

    static public void displayHopital(String account) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            HospitalMapper mapper = session.getMapper(HospitalMapper.class);
            Hospital hospital = mapper.selectHospital(account);
            hospital.getInfo();
        }
    }

    static public void recommendHospitalByCity(String city) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            HospitalMapper mapper = session.getMapper(HospitalMapper.class);
            List<Hospital> hospitals =mapper.selectCity(city);
            for (Hospital hospital:hospitals) {
                System.out.println(hospital);;
            }
        }
    }

    static public void displayFinancialUser(String financial_account) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            FinancialMapper mapper = session.getMapper(FinancialMapper.class);
            List<User> users =mapper.selectFinancialUser(financial_account);
            for (User user:users) {
                user.getFinancialInfo();
            }
        }
    }

    static public void displayFinancialHospital(String financial_account) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            FinancialMapper mapper = session.getMapper(FinancialMapper.class);
            List<String> hospital_names =mapper.selectFinancialHospital(financial_account);
            for (String name:hospital_names) {
                System.out.println(name);
            }
        }
    }

    static public void insert(String account,String password,String username) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            mapper.insertUser(account, password);
            mapper.insertInfo(account, username);
            //需要手动提交事务
            session.commit();
        }
    }
    static public void delete(String account) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            mapper.deleteUser(account);
            mapper.deleteInfo(account);
            //需要手动提交事务
            session.commit();
        }
    }

    static public void update(String account,String password) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            mapper.updateUser(account,password);
            //需要手动提交事务
            session.commit();
        }
    }

    static public void select(String account) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = mapper.selectUser(account);
            System.out.println(user);
        }
    }

    //产品信息编辑
    static public int updateProduct(String product_name,String product_information) throws IOException {
        if(product_name.equals(""))
            return 1;//产品名不能为空
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IProduct mapper = session.getMapper(IProduct.class);
            mapper.updateProduct(product_name,product_information);
            //需要手动提交事务
            session.commit();;
        }
        return 0;
    }
    //机构信息编辑
    static public int updateAgency(String agency_name,String agency_information) throws IOException {
        if(agency_name.equals(""))
            return 1;//机构名不能为空
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IAgency mapper = session.getMapper(IAgency.class);
            mapper.updateAgency(agency_name,agency_information);
            //需要手动提交事务
            session.commit();;
        }
        return 0;
    }
    //机构信息显示
    static public void displayAgency(String account) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IAgency mapper = session.getMapper(IAgency.class);
            Agency agency = mapper.showAgency(account);
            agency.showInfo();
        }
    }
    //产品信息显示
    static public void displayProduct(String account) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IProduct mapper = session.getMapper(IProduct.class);
            List<Product> products = mapper.showProduct(account);
            for (Product product:products) {
                product.showInfo();
            }
        }
    }
    //金融产品首页推荐
    static public void recommendProductByUser(String account) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IProduct mapper = session.getMapper(IProduct.class);
            List<Product> products = mapper.recommendProduct(account);
            for (Product product:products) {
                product.showInfo();
            }
        }
    }
    //金融产品分类
    static public void classifyProduct(String classify) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IProduct mapper = session.getMapper(IProduct.class);
            List<Product> products = mapper.selectType(classify);
            for (Product product:products) {
                product.showInfo();
            }
        }
    }
    //金融产品搜索
    static public void findProductbyKeyword(String keyword) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IProduct mapper = session.getMapper(IProduct.class);
            List<Product> products = mapper.findName(keyword);
            for (Product product:products) {
                product.showInfo();
            }
        }
    }


}
