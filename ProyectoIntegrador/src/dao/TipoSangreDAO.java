package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import models.TipoSangre;
import util.Conexion;

public class TipoSangreDAO {
    private final Connection conn;

    public TipoSangreDAO() {
        this.conn = Conexion.getConexion();
    }

    public boolean insertar(TipoSangre tipo) {
        String sql = "INSERT INTO tipo_sangre(nombre) VALUES(?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, tipo.getNombre());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al insertar tipo de sangre: " + e.getMessage());
            return false;
        }
    }

    public List<TipoSangre> obtenerTodos() {
        List<TipoSangre> lista = new ArrayList<>();
        String sql = "SELECT * FROM tipo_sangre";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                TipoSangre tipo = new TipoSangre(
                    rs.getInt("id_tipo_sangre"),
                    rs.getString("nombre")
                );
                lista.add(tipo);
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener tipos de sangre: " + e.getMessage());
        }
        return lista;
    }
}
