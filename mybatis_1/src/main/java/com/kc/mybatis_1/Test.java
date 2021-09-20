package com.kc.mybatis_1;

import com.kc.mybatis_1.bean.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author wen
 * @create 2020-05-19 20:49
 */
public class Test {
    public static void main(String[] args) throws IOException {

        String config = "mybatis_1/mybatis-config1.xml";
        InputStream is = Resources.getResourceAsStream(config);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);


        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {

//            TestMapper mapper = sqlSession.getMapper(TestMapper.class);

//            List<Mybatis1> mapper1 = mapper.get1();
//            System.out.println(mapper1);

//            Mybatis1 idAndLastName = mapper.getIdAndLastName(3,"tom");
//            System.out.println(idAndLastName);

//            Map map = new HashMap();
//            map.put("idMap",3);
//            map.put("nameMap","tom");
//            map.put("tableName","mybatis_1");
//            Mybatis1 idAndLastNameByMap = mapper.getIdAndLastNameByMap1(map);
//            System.out.println(idAndLastNameByMap);

//            Mybatis1 mybatis = new Mybatis1();
//            mybatis.setId(null);
//            mybatis.setLastName("sansansan");
//            mybatis.setAge(99);
//            mybatis.setEmail(null);
//
//            int i = mapper.addFromOracle(mybatis);
//            System.out.println(i);

//            Map<String, Object> mybatisMap = mapper.getMybatisMap(1);
////            System.out.println(mybatisMap);
////            for(Map.Entry<String,Object> entry : mybatisMap.entrySet()){
////                System.out.println(entry.getKey()+":"+entry.getValue());
////            }
////
////            System.out.println("-------------------------------------------");
////
////            List<Map<String, Object>> mybatisMap1 = mapper.getMybatisMap1();
////            System.out.println(mybatisMap1);


            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

//            List<Department> dept = mapper.getDept();
//            System.out.println(dept);


//            Employee employee = mapper.getEmployee(1);
//            System.out.println(employee);

            Employee employeeAndDept = mapper.getEmployeeAndDeptA(2);
            System.out.println(employeeAndDept);
//            System.out.println(employeeAndDept.getEmail());
//            System.out.println(employeeAndDept.getDept());

//            DeparmentMapper mapper1 = sqlSession.getMapper(DeparmentMapper.class);
//            List<Department> deptAndEmp = mapper1.getDeptAndEmp(1);
////            System.out.println(deptAndEmp);
//            System.out.println(deptAndEmp.get(0));


        }


    }
}
