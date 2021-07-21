package am.itspace.userBook.servlet;

import am.itspace.userBook.manager.BookManager;
import am.itspace.userBook.model.Book;
import am.itspace.userBook.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = "/addBook")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10,      // 10 MB
        maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class AddBookServlet extends HttpServlet {

    private static final String UPLOAD_DIR = "/Users/karen/data/lessons/java2021/web/UserBook/uploadedImages/";

    private BookManager bookManager = new BookManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/addBook.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        Part filePart = req.getPart("picture");
        String fileName = filePart.getSubmittedFileName();
        String picUrl = System.currentTimeMillis() + "_" + fileName;
        filePart.write(UPLOAD_DIR + picUrl);

        String title = req.getParameter("title");
        String authorName = req.getParameter("authorName");
        double price = Double.parseDouble(req.getParameter("price"));

        Book book = Book.builder()
                .title(title)
                .authorName(authorName)
                .price(price)
                .createdDate(new Date())
                .picUrl(picUrl)
                .user(user)
                .build();

        bookManager.addBook(book);
        req.getSession().setAttribute("msg", "book was added");
        resp.sendRedirect("/addBook");
    }
}
