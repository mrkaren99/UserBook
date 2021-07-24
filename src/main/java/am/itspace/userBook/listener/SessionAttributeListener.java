package am.itspace.userBook.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class SessionAttributeListener implements HttpSessionAttributeListener {

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        String name = event.getName();
        if(name.equals("user")){
            System.out.println(event.getValue() + " was logged in");
        }

    }


}
