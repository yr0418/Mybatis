package com.yr;

import com.yr.mapper.menuMapper;
import com.yr.pojo.A;
import com.yr.pojo.B;
import com.yr.pojo.Menu;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import com.yr.util.mybatisUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test {
    @Test
    public void test01(){
        SqlSession sqlSession= mybatisUtil.getSession();
        menuMapper menuMapper=sqlSession.getMapper(com.yr.mapper.menuMapper.class);

        Menu menu=new Menu();
        menu.setName("羊杂汤");
        menu.setPrice(12);
        menuMapper.insert(menu);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test02(){
        SqlSession sqlSession= mybatisUtil.getSession();
        menuMapper menuMapper=sqlSession.getMapper(com.yr.mapper.menuMapper.class);

        List<Menu> list= menuMapper.findall();
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i).getName());
        }

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test03(){
        SqlSession sqlSession= mybatisUtil.getSession();
        menuMapper menuMapper=sqlSession.getMapper(com.yr.mapper.menuMapper.class);

        Menu menu=menuMapper.findone01("羊杂汤",12);
        System.out.println(menu.getName());

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test04(){
        SqlSession sqlSession= mybatisUtil.getSession();
        menuMapper menuMapper=sqlSession.getMapper(com.yr.mapper.menuMapper.class);

        Map<String,Object> map=new HashMap<>();
        map.put("name","羊杂汤");
        map.put("price",12);

        Menu menu=menuMapper.findone02(map);
        System.out.println(menu.getId());

        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void test05(){
        SqlSession sqlSession= mybatisUtil.getSession();
        menuMapper menuMapper=sqlSession.getMapper(com.yr.mapper.menuMapper.class);

        A a=new A(); B b=new B();
        a.setName("羊杂汤");
        b.setPrice(12);
        Menu menu=menuMapper.findone03(a,b);
        System.out.println(menu.getId());

        sqlSession.commit();
        sqlSession.close();
    }
}


