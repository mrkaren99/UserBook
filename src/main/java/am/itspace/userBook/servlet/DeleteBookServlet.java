package am.itspace.userBook.servlet;

import am.itspace.userBook.manager.BookManager;
import am.itspace.userBook.model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet(urlPatterns = "/deleteBook")
public class DeleteBookServlet extends HttpServlet {

    private BookManager bookManager = new BookManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bookId = Integer.parseInt(req.getParameter("id"));
        bookManager.deleteBook(bookId);
        req.getSession().setAttribute("msg", "book was removed");
        resp.sendRedirect("/home");
    }

}
