package com.smm.service;

import com.smm.ben.Employee;
import com.smm.dao.EmpMappper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @author wen
 * @create 2020-05-25 0:36
 */
@Service
public class EmpService {

    private SqlSession sqlSession;

    @Autowired
    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Transactional
    public List<Employee> getTest(){

        EmpMappper mapper = sqlSession.getMapper(EmpMappper.class);

        List<Employee> test = mapper.getTest();
//
//        if(0 == 0){
//            throw new RuntimeException("一个异常");
//        }
//
//        List<Employee> test1 = mapper.getTest();

        return test;

    }


    public boolean add(Employee employee) {

        EmpMappper mapper = sqlSession.getMapper(EmpMappper.class);

        int add = mapper.add(employee);

        System.out.println(add >= 1);

        return add >= 1;
    }

    public int getCount(){
        int count = sqlSession.getMapper(EmpMappper.class).getCount();
//        System.out.println("count:------------"+count);
        return count;
    }

    public List<Employee> getEmployeeListPage(Map<String,Object> map){
        List<Employee> employees = sqlSession.getMapper(EmpMappper.class).emploeeListPage(map);
//        System.out.println(employees);
        return employees;
    }

    public Employee getEmployeeById(Integer id){
        return sqlSession.getMapper(EmpMappper.class).getById(id);
    }

    public boolean delete(Integer id) {

        int i = sqlSession.getMapper(EmpMappper.class).deleteById(id);

        return i == 1;

    }

    public boolean getEmpBylastnameAndIdcard(String lastName, String idcard, HttpSession session) {

        Employee emp = sqlSession.getMapper(EmpMappper.class).getEmpBylastnameAndIdcard(lastName,idcard);
//        System.out.println(emp);
        if(emp != null){
            session.setAttribute("emp",emp);
            return  true;
        }else{
            return  false;
        }

    }

    public boolean update(Employee employee) {

        //获取修改后的 emp 的 idcard
        String idcard = employee.getIdcard();
        //通过 id 获取原有的 emp
        Employee employeeById = getEmployeeById(employee.getId());

        if(employeeById.getIdcard().equals(idcard)){//idcard 与原来的相同则直接修改数据

            int i = sqlSession.getMapper(EmpMappper.class).update(employee);

            return i == 1;
        }else{
            //不同通则判断数据库中是否有与这个已经修改的 idCard 相同的 emp 有则直接返回 false
            Employee emp = sqlSession.getMapper(EmpMappper.class).getEmpByIdcard(idcard);
            System.out.println("相同的 idcard : " + emp);
            return false;
        }


    }
}
