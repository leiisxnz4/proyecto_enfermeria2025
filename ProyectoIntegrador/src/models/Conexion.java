package models;

/* Clase que representa una conexión a la base de datos. 
Esta clase puede ser utilizada para establecer y manejar conexiones a la base de datos en el contexto de la aplicación. */ 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String URL = "jdbc:postgresql://localhost:5432/Escuela";
    private static final String USER = "postgres";
    private static final String PASSWORD = "L04s12s2006";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
