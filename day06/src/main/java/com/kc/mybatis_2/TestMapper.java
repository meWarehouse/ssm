package com.kc.mybatis_2;

import java.util.List;

public interface TestMapper {

    Students get1(int id);

    Classes get2(int id);

    Classes get3(int id);

    Classes get4(int id);


    // N+1 问题
    List<Classes> get5();
    List<Classes> get6();

}
