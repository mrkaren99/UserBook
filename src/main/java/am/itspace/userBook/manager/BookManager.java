package am.itspace.userBook.manager;

import am.itspace.userBook.db.DBConnectionProvider;
import am.itspace.userBook.model.Book;
import am.itspace.userBook.model.User;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.SimpleTimeZone;

public class BookManager {

    private Connection connection = DBConnectionProvider.getProvider().getConnection();
    private UserManager userManager = new UserManager();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    public void addBook(Book book) {
        try {
            String query = "INSERT INTO `book` (`title`,`author_name`,`price`,`created_date`, `pic_url`, `user_id`) " +
                    "VALUES(?,?,?,?,?,?);";
            PreparedStatement pStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pStatement.setString(1, book.getTitle());
            pStatement.setString(2, book.getAuthorName());
            pStatement.setDouble(3, book.getPrice());
            pStatement.setString(4, sdf.format(book.getCreatedDate()));
            pStatement.setString(5, book.getPicUrl());
            pStatement.setInt(6, book.getUser().getId());
            System.out.println(query);
            pStatement.executeUpdate();
            ResultSet generatedKeys = pStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int id = generatedKeys.getInt(1);
                book.setId(id);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateBook(Book book) {
        try {
            Statement statement = connection.createStatement();
            String query = String.format("UPDATE book SET title = '%s', author_name = '%s', price ='%s', pic_url='%s' WHERE id=" + book.getId(),
                    book.getTitle(), book.getAuthorName(), book.getPrice(), book.getPicUrl());
            System.out.println(query);
            statement.executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Book> getBooks() {
        String sql = "SELECT * from book";
        List<Book> result = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Book book = Book.builder()
                        .id(resultSet.getInt(1))
                        .title(resultSet.getString(2))
                        .authorName(resultSet.getString(3))
                        .price(resultSet.getDouble(4))
                        .createdDate(resultSet.getDate(5))
                        .picUrl(resultSet.getString(6))
                        .user(userManager.getUserById(resultSet.getInt(7)))
                        .build();
                result.add(book);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    public Book getBookById(int id) {
        String sql = "SELECT * FROM book WHERE id=" + id;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return Book.builder()
                        .id(resultSet.getInt(1))
                        .title(resultSet.getString(2))
                        .authorName(resultSet.getString(3))
                        .price(resultSet.getDouble(4))
                        .createdDate(resultSet.getDate(5))
                        .picUrl(resultSet.getString(6))
                        .user(userManager.getUserById(resultSet.getInt(7)))
                        .build();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void deleteBook(int id) {
        String sql = "DELETE from book where id = " + id;
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
