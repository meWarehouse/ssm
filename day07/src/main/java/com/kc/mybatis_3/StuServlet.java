package com.kc.mybatis_3;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class StuServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("hello mybatis and servlet ------");

        request.setCharacterEncoding("UTF-8");

        String methodName = request.getParameter("method");
        System.out.println("method:::::::::::::" + methodName);

        try {
            Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);

            method.setAccessible(true);

            method.invoke(this, request, response);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<Integer> list = new ArrayList<>();

        String idStr = request.getParameter("ids");
        System.out.println("-----------------:"+idStr);

        String[] split = idStr.split(",");
        for (String s:split){
            list.add(Integer.parseInt(s));
        }

        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getInstance();

        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {

            TestMapper mapper = sqlSession.getMapper(TestMapper.class);

            int delete = mapper.delete(list);

            System.out.println("de-----:"+delete);

        }

    }


    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("2 update 2");

        String no = request.getParameter("no");
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String sidStr = request.getParameter("sid");

        int id = 1;

        try {
            id = Integer.parseInt(sidStr);
        } catch (Exception e) {
        }

        if (id > 0) {

            Students s = new Students();
            s.setSid(id);
            s.setSname(name);
            s.setSno(no);
            s.setSgender(gender);

            System.out.println(s);

            SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getInstance();

            try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {

                TestMapper mapper = sqlSession.getMapper(TestMapper.class);

                int update = mapper.update(s);

                System.out.println("update:" + update);

            }
        }


    }

    protected void get2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("2222222222222222222222222222222");

        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getInstance();

        String searchContent = request.getParameter("searchContent");
        String searchType = request.getParameter("searchType");

        System.out.println("searchContent:" + searchContent + ",searchType:" + searchType);

        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {

            TestMapper mapper = sqlSession.getMapper(TestMapper.class);

            List<Students> students = mapper.get2(searchContent, searchType);

            System.out.println("students2---:" + students);

        }


    }

    protected void get1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("000000000000000000000");
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getInstance();

        System.out.println("sqlSessionFactory:" + sqlSessionFactory);

        String name = request.getParameter("name");
        String no = request.getParameter("no");
        String gender = request.getParameter("gender");


        System.out.println("name:" + name + ",no:" + no + ",gender:" + gender);


        Students students = new Students();
        students.setSname(name);
        students.setSno(no);
        students.setSgender(gender);


        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {

            TestMapper mapper = sqlSession.getMapper(TestMapper.class);

//            List<Students> studentsList = mapper.searchList(students);

//            List<Students> studentsList = mapper.searchList1(students);
            List<Students> studentsList = mapper.searchList2(students);

            System.out.println("----searchList2------:" + studentsList);


        }
    }


}
