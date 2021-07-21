package am.itspace.userBook.servlet;

import am.itspace.userBook.manager.BookManager;
import am.itspace.userBook.model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/singleBook")
public class SingleBookServlet extends HttpServlet {

    private BookManager bookManager = new BookManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        Book book = bookManager.getBookById(id);

        req.setAttribute("book", book);
        req.getRequestDispatcher("/WEB-INF/singleBook.jsp").forward(req, resp);
    }
}
