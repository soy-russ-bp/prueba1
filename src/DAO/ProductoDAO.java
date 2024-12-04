package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import modelo.Producto;

public class ProductoDAO {
    public static void agregarProducto(String nombre, double precio, String descripcion) {
        String sql = "INSERT INTO productos (nombre, precio, descripcion) VALUES (?, ?, ?)";

        try (Connection conn = ConexionBaseDatos.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nombre);
            stmt.setDouble(2, precio);
            stmt.setString(3, descripcion);
            stmt.executeUpdate();
            System.out.println("Producto agregado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Producto> mostrarProductos() {
    	List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM productos";

        try (Connection conn = ConexionBaseDatos.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                double precio = rs.getDouble("precio");
                double calificacion = rs.getDouble("calificacion");
                
                productos.add(new Producto(id, nombre, precio,calificacion));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }
    
    public static void actualizarProducto(int id, String nombre, double precio, String descripcion) {
        String sql = "UPDATE productos SET nombre = ?, precio = ?, descripcion = ? WHERE id_producto = ?";

        try (Connection conn = ConexionBaseDatos.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nombre);
            stmt.setDouble(2, precio);
            stmt.setString(3, descripcion);
            stmt.setInt(4, id);
            stmt.executeUpdate();
            System.out.println("Producto actualizado.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void actualizarCalificacion(int id, double calificacion) {
    	String sql = "UPDATE productos SET calificacion = ? WHERE id_producto = ?";

        try (Connection conn = ConexionBaseDatos.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, calificacion);
            stmt.setInt(2, id);
            stmt.executeUpdate();
            System.out.println("Calificación actualizada.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void eliminarProducto(int id) {
        String sql = "DELETE FROM productos WHERE id_producto = ?";

        try (Connection conn = ConexionBaseDatos.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Producto eliminado.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
