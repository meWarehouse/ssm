package com.kc.mybatis_2.test;


import com.kc.mybatis_2.bean.Department;
import com.kc.mybatis_2.bean.Employee;
import com.kc.mybatis_2.dao.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wen
 * @create 2020-05-20 20:51
 */
public class Test {

    private static SqlSessionFactory sqlSessionFactory;

    static {

        String config = "mybatis_2/mybatis-config2.xml";
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream(config);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
//
//    @org.junit.Test
//    public void test1() {
//
//        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
//
//            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
////            Employee emp = mapper.getEmp(1);
//
//            Employee emp = mapper.getDetail(1);
//
//
//            System.out.println(emp);
//
//        }
//
//    }

//    @org.junit.Test
//    public void test2() {
//
//
//        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
//
//            DeparmentMapper mapper = sqlSession.getMapper(DeparmentMapper.class);
//
//            Department deptDetials = mapper.getDeptDetials(1);
//
//            System.out.println(deptDetials);
//
//
//        }
//
//    }

//    @org.junit.Test
//    public void test3() {
//
//        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
//
//            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
//
//            Employee employee = new Employee();
//
////            5  卡迪那            34  男       at@kadina.com         2
//            employee.setId(5);
//            employee.setLastName("009");
////            employee.setLastName("t");
//            employee.setAge(34);
//            employee.setGender("男");
////            employee.setEmail("t");
//
////            List<Employee> employeeByConditionIf = mapper.getEmployeeByConditionIf(employee);
////            List<Employee> employeeByConditionIf = mapper.getEmployeeByConditionS(employee);
////            List<Employee> employeeByConditionIf = mapper.getEmployeeByConditionC(employee);
//            mapper.updateEmp1(employee);
//
//            sqlSession.commit();
//
////            for (Employee e : employeeByConditionIf){
////                System.out.println(e);
////            }
//
//        }
//
//    }
//
    @org.junit.Test
    public void test4() {

        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {

            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = new Employee();
//            employee.setId(5);
            employee.setLastName("卡迪那");
            employee.setAge(34);
            employee.setGender("男");
            employee.setEmail("at@kadina.com");

            List<Employee> employeeByConditionIf = mapper.getEmployeeByConditionW(employee);

            for (Employee e : employeeByConditionIf) {
                System.out.println(e);
            }

        }

    }

    @org.junit.Test
    public void test5(){

        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {

            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            List<Employee> byForeach = mapper.getByForeach(Arrays.asList(1,2,3,4));

            for (Employee e : byForeach){
                System.out.println(e);
            }

        }


    }

    @org.junit.Test
    public void test6(){

        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {

            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

            ArrayList<Employee> emps = new ArrayList<Employee>();

            emps.add(new Employee(null,"RR",9,"女","at@rr.com",new Department(1)));
            emps.add(new Employee(null,"RP",19,"女","at@rp.com",new Department(2)));
            emps.add(new Employee(null,"DV",4,"女","at@dv.com",new Department(1)));
            emps.add(new Employee(null,"VD",6,"男","at@vd.com",new Department(1)));

            mapper.addEmps(emps);

            sqlSession.commit();


        }
    }

    @org.junit.Test
    public void test7(){

        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {

            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

            List<Employee> emps = mapper.getEmpsTestInnerParameter(new Employee());

            for(Employee emp : emps ){
                System.out.println(emp);
            }

        }

    }



}
