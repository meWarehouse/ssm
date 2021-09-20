package com.test.crud.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author zero
 * @create 2020-05-31 23:27
 */
@WebListener
public class PATHListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        //获取项目路径
        ServletContext servletContext = sce.getServletContext();
        String path = servletContext.getContextPath();

//        System.out.println("path:"+path);

        servletContext.setAttribute("PATH",path);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
