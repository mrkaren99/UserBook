package am.itspace.userBook.manager;

import am.itspace.userBook.db.DBConnectionProvider;
import am.itspace.userBook.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserManager {

    private Connection connection = DBConnectionProvider.getProvider().getConnection();

    public void addUser(User user) {
        try {
            String query = "INSERT INTO `user` (`name`,`surname`,`email`,`password`) " +
                    "VALUES(?,?,?,?);";
            PreparedStatement pStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pStatement.setString(1, user.getName());
            pStatement.setString(2, user.getSurname());
            pStatement.setString(3, user.getEmail());
            pStatement.setString(4, user.getPassword());
            System.out.println(query);
            pStatement.executeUpdate();
            ResultSet generatedKeys = pStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int id = generatedKeys.getInt(1);
                user.setId(id);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateUser(User user) {
        try {
            Statement statement = connection.createStatement();
            String query = String.format("UPDATE user SET name = '%s', surname = '%s', email='%s',password='%s' WHERE id=" + user.getId(),
                    user.getName(), user.getSurname(), user.getEmail(), user.getPassword());
            System.out.println(query);
            statement.executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<User> getUsers() {
        String sql = "SELECT * from user";
        List<User> result = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                User user = User.builder()
                        .id(resultSet.getInt(1))
                        .name(resultSet.getString(2))
                        .surname(resultSet.getString(3))
                        .email(resultSet.getString(4))
                        .password(resultSet.getString(5))
                        .build();
                result.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    public User getUserById(int id) {
        String sql = "SELECT * FROM user WHERE id=" + id;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return User.builder()
                        .id(resultSet.getInt(1))
                        .name(resultSet.getString(2))
                        .surname(resultSet.getString(3))
                        .email(resultSet.getString(4))
                        .password(resultSet.getString(5))
                        .build();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public User getUserByEmailAndPassword(String email, String password) {
        String sql = "SELECT * FROM user WHERE email='" + email + "' and password = '" + password+"'";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return User.builder()
                        .id(resultSet.getInt(1))
                        .name(resultSet.getString(2))
                        .surname(resultSet.getString(3))
                        .email(resultSet.getString(4))
                        .password(resultSet.getString(5))
                        .build();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void deleteUser(int id) {
        String sql = "DELETE from user where id = " + id;
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
