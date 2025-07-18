package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import models.Medicamento;
import util.Conexion;

public class MedicamentoDAO {
    private Connection conn;

    public MedicamentoDAO() {
        conn = Conexion.getConexion();
    }

    public boolean insertar(Medicamento med) {
        String sql = "INSERT INTO medicamento (nombre, dosis, contraindicaciones) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, med.getNombre());
            stmt.setString(2, med.getDosis());
            stmt.setString(3, med.getContraindicaciones());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al insertar medicamento: " + e.getMessage());
            return false;
        }
    }

    public List<Medicamento> obtenerTodos() {
        List<Medicamento> lista = new ArrayList<>();
        String sql = "SELECT * FROM medicamento";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Medicamento med = new Medicamento(
                    rs.getInt("id_medicamento"),
                    rs.getString("nombre"),
                    rs.getString("dosis"),
                    rs.getString("contraindicaciones")
                );
                lista.add(med);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener medicamentos: " + e.getMessage());
        }
        return lista;
    }
}
