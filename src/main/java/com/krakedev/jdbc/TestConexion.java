
package com.krakedev.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConexion {

    public static void main(String[] args) {

        Connection con = Conexion.obtenerConexion();

        if (con != null) {
            System.out.println("Conexion con PostgreSQL exitosa");

            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexion");
            }
        } else {
            System.out.println("No se pudo conectar con PostgreSQL");
        }
    }
}
