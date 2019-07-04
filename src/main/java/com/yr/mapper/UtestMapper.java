package com.yr.mapper;

import com.yr.pojo.UtestWithUdetails;
import org.apache.ibatis.annotations.Param;

public interface UtestMapper {

    //多表查询
    UtestWithUdetails findByid( @Param("id") Integer id);

    UtestWithUdetails findByidBystep( @Param("id") Integer id);
}