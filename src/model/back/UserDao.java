package model.back;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    public static void registerUser(User user) throws SQLException {
        if (user.getId() == 0) {
            Connection conn = DBUtils.getConn();
            String sql = "INSERT INTO user(firstName, lastName, email, password, regCode,role) VALUES (?,?,?,?,?,?)";
            String generatedColumns[] = {"ID"};

            PreparedStatement preparedStatement = conn.prepareStatement(sql, generatedColumns);
            preparedStatement.setString(1,"");
            preparedStatement.setString(2,"");

            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getRegCode());
            preparedStatement.setInt(6, 1);

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                user.setId((rs.getInt(1)));
            }
            conn.close();
        } else {

            Connection conn = DBUtils.getConn();
            String sql = "UPDATE user SET email=?, password=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.executeUpdate();

            conn.close();
        }
    }

    public static void addUser(User user) throws SQLException {
        if (user.getId() == 0) {
            Connection conn = DBUtils.getConn();
            String sql = "INSERT INTO user(firstName, lastName, email, hourlyRate, role) VALUES (?,?,?,?,?)";
            String generatedColumns[] = {"ID"};

            PreparedStatement preparedStatement = conn.prepareStatement(sql, generatedColumns);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setDouble(4, user.getHourlyRate());
            preparedStatement.setInt(5, user.getRole());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                user.setId((rs.getInt(1)));
            }
            conn.close();
        }

    }

    public static boolean checkUser(String email) throws SQLException {

        Connection conn = DBUtils.getConn();
        String sql = "SELECT email FROM user WHERE email=?";

        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        preparedStatement.setString(1, email);

        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            String email1 = rs.getString("email");
            conn.close();
            if (email1 != null) {
                return true;
            }
        }
        conn.close();
        return false;

    }

    public static User loginUser(String email, String password) throws SQLException {

        Connection conn = DBUtils.getConn();
        String sql = "SELECT * FROM user WHERE email=? AND password=?";

        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        preparedStatement.setString(1, email);
        preparedStatement.setString(2, password);

        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String email1 = rs.getString("email");
            String password1 = rs.getString("password");
            int roleId = rs.getInt("role");
            conn.close();

            return new User(id, email1, password1, roleId);

        }

        conn.close();
        return null;

    }

    public static void checkUserConfirmation(User user, String urlConfirm) throws SQLException {
        Connection conn = DBUtils.getConn();
        String sql = "UPDATE user SET activ=?, regcode=? WHERE regcode=?";

        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        preparedStatement.setInt(1, (int) 1);
        preparedStatement.setString(2, "");
        preparedStatement.setString(3, urlConfirm);


        preparedStatement.executeUpdate();
        conn.close();
    }

    public static List<User> getUsers() throws SQLException {
        List<User> users = new ArrayList<>();

        Connection conn = DBUtils.getConn();
        String sql = "SELECT * from user WHERE role=1 OR role=2";

        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            String email = rs.getString("email");
            int roleId = rs.getInt("role");
            String firstName = rs.getString("firstName");
            String lastName = rs.getString("lastname");
            double hourlyRate = rs.getDouble("hourlyRate");

            User tempUser = new User(id, email, roleId, lastName, firstName, hourlyRate);
            users.add(tempUser);
            //conn.close();
        }
        return users;

    }


}
