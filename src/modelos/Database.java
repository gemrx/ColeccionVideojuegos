package modelos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
        
/**
 *
 * @author gemrx
 */
public class Database {
    public static Connection getConnection(){
            try {
                // Registra el controlador
                Class.forName("org.mariadb.jdbc.Driver");
                
                // Conectarse a la base de datos
                Connection connection =  DriverManager.getConnection("jdbc:mariadb://localhost:3306/coleccion_videojuegos", "gilberto", "password");
                return connection;
            } catch (SQLException | ClassNotFoundException e) {
                return null;
            }
    }
}
