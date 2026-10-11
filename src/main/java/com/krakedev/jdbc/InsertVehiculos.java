
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

            ps.setString(1, "PCD2345");
            ps.setString(2, "Chevrolet");
            ps.setString(3, "Camaro");
            ps.setInt(4, 2020);
            ps.setDouble(5, 19500.00);
            ps.setString(6, "Rojo");
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
