package com.yr.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;


public class mybatisUtil {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        String resourse="mybatis-config.xml";

        InputStream in=null;
        try {
            in=Resources.getResourceAsStream(resourse);
            sqlSessionFactory =new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (in!=null){
                    in.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static SqlSession getSession(){
        return sqlSessionFactory.openSession();
    }
}
