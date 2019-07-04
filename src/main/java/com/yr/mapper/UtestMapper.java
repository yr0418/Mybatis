package com.yr.mapper;

import com.yr.pojo.UtestWithBlog;
import com.yr.pojo.UtestWithUdetails;
import org.apache.ibatis.annotations.Param;

public interface UtestMapper {

    //多表查询
    UtestWithUdetails findByid( @Param("id") Integer id);

    UtestWithUdetails findByidBystep( @Param("id") Integer id);

    /**根据用户的id查询该用户的信息以及发布的所有博客以及博客下所有评论
     *用户与博客之间是 1：n 的关系
     * 博客与评论之间是 1：n 的关系
     */
    UtestWithBlog  findByidWithBlog(@Param("id") Integer id);
}