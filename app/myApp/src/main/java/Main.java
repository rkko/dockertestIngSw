import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class Main {
    private static final String URL = "jdbc:postgresql://postgres:5432/test";
    private static final String USER = "user";
    private static final String PASSWORD = "pass";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            String query = "SELECT * FROM test_table";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                System.out.println("ID: " + id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

