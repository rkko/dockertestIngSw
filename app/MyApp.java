import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnector {
    private static final String URL = "jdbc:postgresql://postgres:5432/your_database";
    private static final String USER = "your_user";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            String query = "SELECT * FROM your_table";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                // Suponiendo que la tabla tiene columnas 'id' y 'name'
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println("ID: " + id + ", Name: " + name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
