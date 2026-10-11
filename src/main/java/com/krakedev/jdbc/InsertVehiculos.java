
package com.krakedev.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InsertVehiculos {

    private static final Logger log = LogManager.getLogger(InsertVehiculos.class);

    public static void main(String[] args) {

        Connection con = null;
        PreparedStatement ps = null;

        String sql = """
                INSERT INTO vehiculos(placa, marca, modelo, anio, precio, color, disponible)
                VALUES(?, ?, ?, ?, ?, ?, ?)
                """;

        try {
            con = Conexion.obtenerConexion();
            ps = con.prepareStatement(sql);

            ps.setString(1, "PCD1234");
            ps.setString(2, "Toyota");
            ps.setString(3, "Corolla");
            ps.setInt(4, 2024);
            ps.setDouble(5, 18500.00);
            ps.setString(6, "Blanco");
            ps.setBoolean(7, true);

            int filas = ps.executeUpdate();

            log.info("Conexion Exitosa---");
            log.info("Filas insertadas: " + filas);

        } catch (SQLException e) {
            log.error("Conexion Fallida---" + e.getMessage());

        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException e) {
                log.error("Error de Conexion---" + e.getMessage());
            }
        }
    }
}
