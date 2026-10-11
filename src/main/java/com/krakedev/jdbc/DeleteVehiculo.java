
package com.krakedev.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DeleteVehiculo {

    private static final Logger log = LogManager.getLogger(DeleteVehiculo.class);

    public static void main(String[] args) {

        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = Conexion.obtenerConexion();

            String sql = """
                    DELETE FROM vehiculos WHERE placa = ?
                    """;

            ps = con.prepareStatement(sql);

            ps.setString(1, "PCD1234");

            // Se ejecuta el delete
            int filas = ps.executeUpdate();

            log.info("Filas eliminadas: " + filas);

        } catch (Exception e) {

            log.error("El vehiculo no se elimino", e);

        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                log.error("Error al cerrar la conexion", e);
            }
        }
    }
}
