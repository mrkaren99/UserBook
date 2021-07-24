package am.itspace.userBook.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ApplicationListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Welcome");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Bye bye");
    }
}
