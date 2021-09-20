package com.smm.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author wen
 * @create 2020-05-27 16:32
 */
@WebListener
public class RootPathLinsener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        ServletContext servletContext = sce.getServletContext();

        String contextPath = servletContext.getContextPath();

        servletContext.setAttribute("path",contextPath);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
