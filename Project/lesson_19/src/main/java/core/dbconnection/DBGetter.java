package core.dbconnection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBGetter {
    public static List<User> getUsers() {
        String url = "jdbc:mysql://localhost:3306/auto_user?useSSL=false";
        String login = "root";
        String password = "1234";

        String query = "select * from auto_user.user;";
        List<User> users = new ArrayList<>();
        try (java.sql.Connection connection = DriverManager.getConnection(url, login, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                User user = new User();
                user.setId(Integer.parseInt(resultSet.getString("id")));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                users.add(user);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return users;
    }
}
