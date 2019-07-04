package com.yr.mapper;

import com.yr.pojo.Udetails;
import org.apache.ibatis.annotations.Param;

public interface UdetailsMapper {
    Udetails findByUid(@Param("uid") Integer uid);
}