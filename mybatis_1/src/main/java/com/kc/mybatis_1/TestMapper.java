package com.kc.mybatis_1;

import com.kc.mybatis_1.bean.Mybatis1;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author wen
 * @create 2020-05-19 20:52
 */
public interface TestMapper {

    List<Map<String,Object>> getMybatisMap1();
    Map<String,Object> getMybatisMap(Integer id);

    List<Mybatis1> get1();

    Mybatis1 getIdAndLastName(Integer id,String name);

    Mybatis1 getIdAndLastName1(@Param("id") Integer id, @Param("name") String name);

    Mybatis1  getIdAndLastNameByMap(Map<String,Object> map);

    Mybatis1  getIdAndLastNameByMap1(Map<String,Object> map);

    int addFromOracle(Mybatis1 mybatis);


}
