package am.itspace.userBook.servlet;

import am.itspace.userBook.manager.UserManager;
import am.itspace.userBook.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

    UserManager userManager = new UserManager();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String rePassword = req.getParameter("re-password");
        if (!password.equals(rePassword)) {
            req.getSession().setAttribute("msg", "passwords are not match");
            resp.sendRedirect("/");
        }else {
            User user = User.builder()
                    .name(name)
                    .surname(surname)
                    .email(email)
                    .password(password)
                    .build();
            userManager.addUser(user);

            req.getSession().setAttribute("msg", "user was register successfully");
            resp.sendRedirect("/");
        }


    }
}
