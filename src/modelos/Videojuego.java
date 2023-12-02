package modelos;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author gemrx
 */
public class Videojuego {
    private int id;
    private String titulo;
    private byte[] imagen;
    private String desarrollador;
    private String fechaLanzamiento;

    public void setId(int id) {
        this.id = id;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public void setDesarrollador(String desarrollador) {
        this.desarrollador = desarrollador;
    }

    public void setFechaLanzamiento(String fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public int getId() {
        return id;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public String getDesarrollador() {
        return desarrollador;
    }

    public String getFechaLanzamiento() {
        return fechaLanzamiento;
    }
    
    public boolean insertar() {
        try {
            Connection connection = Database.getConnection();
            String query = "INSERT INTO videojuego (titulo, imagen, desarrollador, fecha_lanzamiento) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, this.titulo);
            preparedStatement.setBytes(2, this.imagen);
            preparedStatement.setString(3, this.desarrollador);
            preparedStatement.setString(4, this.fechaLanzamiento);
            int filasAfectadas = preparedStatement.executeUpdate();
            if (filasAfectadas > 0) {
                preparedStatement.close();
                connection.close();
                return true;
            }
            preparedStatement.close();
            connection.close();
            return false;
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
    
    public boolean actualizar() {
        try {
            Connection connection = Database.getConnection();
            String query = "UPDATE videojuego SET titulo = ?, imagen = ?, desarrollador = ?, fecha_lanzamiento = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, this.titulo);
            preparedStatement.setBytes(2, this.imagen);
            preparedStatement.setString(3, this.desarrollador);
            preparedStatement.setString(4, this.fechaLanzamiento);
            preparedStatement.setInt(5, this.id);
            int filasAfectadas = preparedStatement.executeUpdate();
            if (filasAfectadas > 0) {
                preparedStatement.close();
                connection.close();
                return true;
            }
            preparedStatement.close();
            connection.close();
            return false;
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
    
    public boolean eliminar() {
        try {
            Connection connection = Database.getConnection();
            String query = "DELETE FROM videojuego WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, this.id);
            int filasAfectadas = preparedStatement.executeUpdate();
            if (filasAfectadas > 0) {
                preparedStatement.close();
                connection.close();
                return true;
            }
            preparedStatement.close();
            connection.close();
            return false;
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
    
    public static Videojuego obtenerVideojuegoPorTitulo(String titulo) {
        try {
            Connection connection = Database.getConnection();
            String query = "SELECT id, titulo, imagen, desarrollador, fecha_lanzamiento FROM videojuego WHERE titulo = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, titulo);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Videojuego videojuego = new Videojuego();
                videojuego.setId(resultSet.getInt("id"));
                videojuego.setTitulo(resultSet.getString("titulo"));
                videojuego.setImagen(resultSet.getBytes("imagen"));
                videojuego.setDesarrollador(resultSet.getString("desarrollador"));
                videojuego.setFechaLanzamiento(resultSet.getString("fecha_lanzamiento"));
                preparedStatement.close();
                connection.close();
                return videojuego;
            }
            preparedStatement.close();
            connection.close();
            return null;
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
    
    public static void main(String[] args) {
        // actualizar
//        Videojuego juego = new Videojuego();
//        juego.setId(1);
//        juego.setTitulo("The Last of Us");
//        juego.setImagen(null);
//        juego.setDesarrollador("Naughty Dog");
//        juego.setFechaLanzamiento("2013-06-14");
//        juego.actualizar();
        
        // obtener videojuego
//        Videojuego obtenido = Videojuego.obtenerVideojuegoPorTitulo("The Last of Us");
//        System.out.println(obtenido.getId());
//        System.out.println(obtenido.getTitulo());
//        System.out.println(obtenido.getDesarrollador());
//        System.out.println(obtenido.getFechaLanzamiento());
    }
}
