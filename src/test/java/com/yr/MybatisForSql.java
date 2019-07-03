package com.yr;

import com.yr.mapper.UserMapper;
import com.yr.pojo.User;
import com.yr.util.mybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MybatisForSql {

    @Test
    public void t1(){
        SqlSession sqlSession= mybatisUtil.getSession();
        UserMapper userMapper=sqlSession.getMapper(com.yr.mapper.UserMapper.class);

        List<User> userList = userMapper.finduser("","111");
        for (int i = 0; i <userList.size() ; i++) {
            System.out.println(userList.get(i).toString());
        }

        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void t2(){
        SqlSession sqlSession= mybatisUtil.getSession();
        UserMapper userMapper=sqlSession.getMapper(com.yr.mapper.UserMapper.class);

        User user=new User();
        user.setUsername(null);
        user.setPassword("11234567");
        user.setNickname("杨睿");
        user.setId(11);

        userMapper.update(user);

        sqlSession.commit();
        sqlSession.close();
    }
}
