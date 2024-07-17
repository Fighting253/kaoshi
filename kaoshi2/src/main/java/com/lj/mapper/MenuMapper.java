package com.lj.mapper;

import com.lj.pojo.Menu;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.sql.SQLException;
import java.util.List;

/**
 * 功能描述：
 * 作者：lj
 * 时间：2024/7/4
 */
public interface MenuMapper {
    @Select("select * from dish")
    List<Menu> getMenuList() throws SQLException;

    @Delete("delete from dish where id=#{did}")
    void deleteById(@Param("did") String id) throws SQLException;

    @Select("select * from dish where id=#{pid}")
    List<Menu> getAllMenus(@Param("pid") int pid) throws SQLException;

    @Delete("delete from dish where id=#{id}")
    int deleteMenuById(@Param("id") int id) throws SQLException;

    @Select("select * from dish where id=#{did}")
    Menu getMenuById(@Param("did")String did)throws SQLException;

    @Update("update dish set price=#{price},code=#{code},classification=#{classification} where dname=#{dname}")
    void updateMenu(Menu menu)throws SQLException;;

    @Select("select count(id) from dish where code=#{code}")
    int checkCode(String code)throws SQLException;
}
