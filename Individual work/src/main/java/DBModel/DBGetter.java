package DBModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBGetter {

    public static List<Film> getDBFilm() {
        String url = "jdbc:mysql://localhost:3306/auto_hotel?useSSL=false";
        String login = "root";
        String password = "1234";

        String query = "select * from auto_hotel.hotel;";
        List<Film> films = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, login, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Film film = new Film();
                film.setId(Integer.parseInt(resultSet.getString("id")));
                film.setName(resultSet.getString("name"));
                films.add(film);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return films;
    }
}
