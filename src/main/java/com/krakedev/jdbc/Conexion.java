
package com.krakedev.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Conexion {

    private static final Logger log = LoggerFactory.getLogger(Conexion.class);

    public static Connection obtenerConexion() {
        Connection con = null;

        try {
            con = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/tallerjdbc",
                    "postgres",
                    "Luffyzoro96.."
            );

            log.info("Conexion realizada correctamente");

        } catch (SQLException e) {
            log.error("Error en la coneccion", e);
        }

        return con;
    }
}
