package com.yr.mapper;

import com.yr.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    List<User> finduser(@Param("password") String password, @Param("nickname") String nickname);

    void update(User user);

    List<User> finduser01(User user);
}