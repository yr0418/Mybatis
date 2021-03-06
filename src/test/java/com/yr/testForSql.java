package com.yr;

import com.yr.mapper.UserMapper;
import com.yr.mapper.UtestMapper;
import com.yr.pojo.UtestWithBlog;
import com.yr.pojo.UtestWithUdetails;
import com.yr.util.mybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class testForSql {
    @Test
    public void m1(){
        SqlSession sqlSession= mybatisUtil.getSession();
        UtestMapper utestMapper=sqlSession.getMapper(com.yr.mapper.UtestMapper.class);
        UtestWithUdetails utestWithUdetails = utestMapper.findByid(1);

        System.out.println(utestWithUdetails.getPassword());
        System.out.println(utestWithUdetails.getUdetails());

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void m2(){
        SqlSession sqlSession= mybatisUtil.getSession();
        UtestMapper utestMapper=sqlSession.getMapper(com.yr.mapper.UtestMapper.class);
        UtestWithUdetails utestWithUdetails = utestMapper.findByidBystep(1);

        System.out.println(utestWithUdetails.getPassword());
        System.out.println(utestWithUdetails.getUdetails());

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void m3(){
        SqlSession sqlSession= mybatisUtil.getSession();
        UtestMapper utestMapper=sqlSession.getMapper(com.yr.mapper.UtestMapper.class);
        UtestWithBlog utestWithBlog = utestMapper.findByidWithBlog(1);

        System.out.println(utestWithBlog.getPassword());
        System.out.println(utestWithBlog.getBlog());

        sqlSession.commit();
        sqlSession.close();
    }
}
