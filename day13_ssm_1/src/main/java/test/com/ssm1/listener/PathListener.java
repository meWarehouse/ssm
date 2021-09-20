package test.com.ssm1.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author zero
 * @create 2020-06-02 23:50
 */
@WebListener
public class PathListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        String path = servletContext.getContextPath();
        System.out.println("path:"+path);
        servletContext.setAttribute("PATH",path);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
