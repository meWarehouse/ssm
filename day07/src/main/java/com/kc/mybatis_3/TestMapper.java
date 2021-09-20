package com.kc.mybatis_3;

import java.util.List;
import java.util.Map;

public interface TestMapper {

    Students get(int id);


    List<Students> searchList(Students s);
    List<Students> searchList1(Students s);
    List<Students> searchList2(Students s);

    List<Students> get2(String searchContent,String searchType);


    int update(Students s);

    int delete(List<Integer> id);

    List<Students> get3(Map<String,Object> map);




}
