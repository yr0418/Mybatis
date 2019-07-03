package com.yr;

import com.yr.mapper.UserMapper;
import com.yr.pojo.User;
import com.yr.util.mybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
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

    @Test
    public void t3(){
        SqlSession sqlSession= mybatisUtil.getSession();
        UserMapper userMapper=sqlSession.getMapper(com.yr.mapper.UserMapper.class);

        User user=new User();
        user.setUsername(null);
        user.setPassword("11234567");
        user.setNickname("杨睿");
        user.setId(11);

        List<User> users = userMapper.finduser02(user);

        for (int i = 0; i <users.size() ; i++) {
            System.out.println(users.get(i));
        }

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void t4(){
        SqlSession sqlSession= mybatisUtil.getSession();
        UserMapper userMapper=sqlSession.getMapper(com.yr.mapper.UserMapper.class);

        List<Long> list=new ArrayList<>();
       list.add(11L);
        list.add(12L);
        list.add(13L);


        List<User> users = userMapper.findusersByid(list);

        for (int i = 0; i <users.size() ; i++) {
            System.out.println(users.get(i));
        }

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void t5(){
        SqlSession sqlSession= mybatisUtil.getSession();
        UserMapper userMapper=sqlSession.getMapper(com.yr.mapper.UserMapper.class);

        List<User> users = userMapper.finduserLike("睿");

        for (int i = 0; i <users.size() ; i++) {
            System.out.println(users.get(i));
        }

        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void t6(){
        SqlSession sqlSession= mybatisUtil.getSession();
        UserMapper userMapper=sqlSession.getMapper(com.yr.mapper.UserMapper.class);

        List<User> users = userMapper.selectall();

        for (int i = 0; i <users.size() ; i++) {
            System.out.println(users.get(i));
        }

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void t7(){
        SqlSession sqlSession= mybatisUtil.getSession();
        UserMapper userMapper=sqlSession.getMapper(com.yr.mapper.UserMapper.class);
        /**
         * 两次相同的操作，打印 debug 日志中只出现了一条 sql 语句 证明 使用了一级缓存
         */
        List<User> users = userMapper.selectall();
        List<User> users1=userMapper.selectall();

        for (int i = 0; i <users.size() ; i++) {
            System.out.println(users.get(i));
        }
        System.out.println();
        for (int i = 0; i <users1.size() ; i++) {
            System.out.println(users1.get(i));
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void t8(){
        SqlSession sqlSession= mybatisUtil.getSession();
        UserMapper userMapper=sqlSession.getMapper(com.yr.mapper.UserMapper.class);

        //【缓存失效方式一】在查询之后进行 增删改 操作将使缓存失效，[查看打印出来的 sql 语句]
        List<User> users = userMapper.selectall();

        User user=new User();
        user.setUsername(null);
        user.setPassword("11234567");
        user.setNickname("杨睿");
        user.setId(11);
        userMapper.update(user);


        List<User> users1=userMapper.selectall();

        for (int i = 0; i <users.size() ; i++) {
            System.out.println(users.get(i));
        }
        System.out.println();
        for (int i = 0; i <users1.size() ; i++) {
            System.out.println(users1.get(i));
        }
        sqlSession.commit();
        sqlSession.close();
    }

    //二级缓存示例
    // 对应实体类进行序列化，继承该接口 implements Serializable
    @Test
    public void t9(){
        SqlSession sqlSession= mybatisUtil.getSession();
        UserMapper userMapper=sqlSession.getMapper(com.yr.mapper.UserMapper.class);
        userMapper.selectall();
        sqlSession.commit();
        sqlSession.close();

        SqlSession sqlSession2= mybatisUtil.getSession();
        UserMapper userMapper2=sqlSession2.getMapper(com.yr.mapper.UserMapper.class);
        userMapper2.selectall();
        sqlSession2.commit();
        sqlSession2.close();
    }

}
