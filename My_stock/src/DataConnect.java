

import java.sql.Connection;
import java.sql.DriverManager;

public class DataConnect {

    public static String hostName = "localhost";
    public static String portNumber = "3306";
    public static String databaseName = "my_stock";
    public static String userName = "root";
    public static String password = "Admin";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://" + hostName + ":" + portNumber + "/" + databaseName, userName, password);
            return con;
        } catch (Exception ex) {
            System.out.println("Database.getConnection() Error -->" + ex.getMessage());
            return null;
        }
    }

    public static void close(Connection con) {
        try {
            con.close();
        } catch (Exception ex) {
        }
    }
}
