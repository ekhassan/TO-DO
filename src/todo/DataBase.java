package todo;

import java.sql.*;

public class DataBase {

    public static void main(String[] args) {
        Connection conn = null;
        try {
            String url = "jdbc:mysql://localhost:3306/sos"; // change "mydatabase" to your database name
            String user = "root"; // change "root" to your MySQL username
            String password = ""; // change "" to your MySQL password

            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Database connection established");

        } catch (SQLException e) {
            System.err.println("Cannot connect to database: " + e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                    System.out.println("Database connection terminated");
                }
            } catch (SQLException e) {
                System.err.println("Cannot close connection: " + e.getMessage());
            }
        }
    }

    public static boolean validateUser(String email, String password) {
        String url = "jdbc:mysql://localhost:3306/sos"; // change "mydatabase" to your database name
        String user = "root"; // change "root" to your MySQL username
        String dbPassword = ""; // change "" to your MySQL password

        String query = "SELECT * FROM users WHERE email = ? AND password = ?";

        try (Connection conn = DriverManager.getConnection(url, user, dbPassword);
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Error authenticating user: " + e.getMessage());
        }
        return false;
    }


    public static boolean registerUser(String name, String email, String password, String confirmPassword) {
        String url = "jdbc:mysql://localhost:3306/sos"; // change "mydatabase" to your database name
        String user = "root"; // change "root" to your MySQL username
        String dbPassword = ""; // change "" to your MySQL password

        if (!password.equals(confirmPassword)) {
            System.err.println("Passwords do not match");
            return false;
        }

        String query = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, dbPassword);
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Error registering user: " + e.getMessage());
        }
        return false;
    }
    public static boolean checkEmailExists(String email) {
        boolean exists = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sos", "root", "");
            PreparedStatement stmt = con.prepareStatement("SELECT COUNT(*) FROM users WHERE email = ?");
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                exists = (count > 0);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return exists;
    }
}
