package com.kc.mybatis_3;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.IOException;

public class WebListener implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent sce) {

        try {
            SqlSessionFactoryUtils.init();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
