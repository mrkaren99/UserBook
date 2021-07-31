package am.itspace.userBook.servlet;

import am.itspace.userBook.manager.BookManager;
import am.itspace.userBook.model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/books")
public class GetBooksServlet extends HttpServlet {

    private BookManager bookManager = new BookManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = bookManager.getBooks();
        req.setAttribute("books", books);
        req.getRequestDispatcher("/WEB-INF/books.jsp").forward(req, resp);
    }
}
