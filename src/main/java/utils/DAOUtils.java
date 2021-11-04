package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOUtils {
    public static Connection getConnection() {
        Connection connection = null;

        try {
            // Charger le driver de la BDD MySQL
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Etablir la connexion
            //TODO Changer le nom de la DB qu'on tape
            connection = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost;databaseName=PokeBattle","sa","Pa$$w0rd"
            );
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }
}
