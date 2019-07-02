package com.yr.mapper;

import com.yr.pojo.A;
import com.yr.pojo.B;
import com.yr.pojo.Menu;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface menuMapper {

    List<Menu> findall();

    /**
     *使用 javaBean 的方式传入参数，即实例化的实体类对象
     */
    boolean insert(Menu menu);

    boolean Update(Menu menu);

    @Select("select * from menu where id=#{id}")
    Menu findById(Long id);

  /*@Select("select * from menu where name=#{name} and price =#{price}")
  * 注解错误，传入的参数将无法识别,
  * 正确注解如下：
  * @Select("select * from menu where name=#{param1} and price =#{param2}")
  * 在 menu.xml 文件中写法一致
  * */
    Menu findone(String name,int price);

    /**上述问题通用解决方法：
     * 添加注解,给传入的参数添加注解，即手动改变 mybatis 的默认参数类型
     */
    @Select("select * from menu where name=#{name} and price =#{price}")
    Menu findone01(@Param("name") String name, @Param("price") int price);

    /**
     *通过 Map 传值
     * 注意 Map 的赋值
     */
    Menu findone02(Map<String,Object> menu);

    /**
     * 传入多个 javaBean
     */
    @Select("select * from menu where name=#{a.name} and price =#{b.price}")
    Menu findone03(@Param("a") A a, @Param("b") B b);


}
