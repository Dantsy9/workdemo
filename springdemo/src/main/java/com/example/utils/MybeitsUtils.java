package com.example.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybeitsUtils {
    private static SqlSessionFactory factory = null;

    static {
        //读取mybatis.xml配置文件
        String config="config/mybatis-config.xml";
        try {
            //将配置文件加入到流中
            InputStream in = Resources.getResourceAsStream(config);
            //创建factory对象
            factory = new SqlSessionFactoryBuilder().build(in);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public  static SqlSession getSqlSession(){
        SqlSession sqlSession = null;
        if (factory!=null){
            //如果 factory!=null 就创建 sqlSession对象
            sqlSession = factory.openSession(false);//非自动提交事务
        }

        return sqlSession;
    }

}
