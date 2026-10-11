
package com.krakedev.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UpdateVehiculo {

    private static final Logger log = LogManager.getLogger(UpdateVehiculo.class);

    public static void main(String[] args) {

        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = Conexion.obtenerConexion();

            String sql = """
                    UPDATE vehiculos
                    SET precio = ?, color = ?, kilometraje = ?
                    WHERE placa = ?
                    """;

            ps = con.prepareStatement(sql);

            ps.setDouble(1, 19000.00);
            ps.setString(2, "Negro");
            ps.setInt(3, 60000);
            ps.setString(4, "ABC5678");

            // Se ejecuta el update
            int filas = ps.executeUpdate();

            log.info("Filas actualizadas: " + filas);

        } catch (Exception e) {

            log.error("Los datos no se actualizaron", e);

        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                log.error("Error al cerrar la conexion", e);
            }
        }
    }
}
