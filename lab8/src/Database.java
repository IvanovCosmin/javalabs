import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class Database {
    private static Connection connectionInstance;
    Database() {
    }
    public Connection getConnectionInstance() throws SQLException {
        if(connectionInstance == null) {
            connectionInstance = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","dbau","sql");
            return connectionInstance;
        }
        return connectionInstance;
    }
}
