package ToDeleteLater;

import java.sql.*;

public class DataBaseAccess
{
    final String url = "jdbc:postgresql://localhost/postgres?currentSchema=museu";
    final String user = "postgres";
    final String password = "123";

    public Connection connect()
    {
        try {
            return DriverManager.getConnection(url, user, password);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return null;
    }
}
