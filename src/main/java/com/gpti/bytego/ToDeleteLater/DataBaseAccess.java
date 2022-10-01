package com.gpti.bytego.ToDeleteLater;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
