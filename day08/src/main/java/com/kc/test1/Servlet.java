package com.kc.test1;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String methodNamme = request.getParameter("method");

        System.out.println("------------:"+methodNamme);

        try {
            Method method = getClass().getDeclaredMethod(methodNamme, HttpServletRequest.class, HttpServletResponse.class);

            method.setAccessible(true);

            method.invoke(this,request,response);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }


    protected void get1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("get1------------------------------------------------");

        String no = request.getParameter("no");
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");

        System.out.println("no:"+no+",name:"+name+",gender:"+gender);

        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getInstance();

        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {


            TestMapper mapper = sqlSession.getMapper(TestMapper.class);

//            List<Classes> mapper1 = mapper.get1();
//            List<Students> mapper2 = mapper.get2();
//            Map<String, Object> mapper3 = mapper.get3();
//            System.out.println(mapper3);

            Students s = new Students();
            s.setNo(no);
            s.setName(name);
            s.setGender(gender);
            List<Students> mapper4 = mapper.get4(s);
            System.out.println(mapper4);


        }


    }



}
