package com.kc.mybatis_4;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface TestMapper {

    List<Classes> get1();

    @Select("SELECT * FROM classes WHERE c_id = 1")
    Map<String,Object> get2();

    @Select("SELECT * FROM classes")
    List<Map<String,Object>> get3();

    @Insert("INSERT INTO classes(c_name) VALUES(#{name})")
    @Options(useGeneratedKeys = true,keyProperty = "cid")
    int insert(Classes c);

    @Results(id = "classResult" ,value={
            @Result(id = true,property = "cid",column = "c_id"),
            @Result(property = "name",column = "c_name")
    })
    @Select("SELECT * FROM classes WHERE c_name=#{name}")
    List<Classes> get4(Map<String,Object> map);

    @ResultMap("classResult")
    @Select("SELECT * FROM classes WHERE c_id=#{id}")
    Classes get5(int id);


}
