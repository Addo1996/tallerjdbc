
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
				INSERT INTO vehiculos(placa, marca, modelo, anio, precio, color, disponible, kilometraje)
				VALUES(?, ?, ?, ?, ?, ?, ?, ?)
				""";

		try {
			con = Conexion.obtenerConexion();
			ps = con.prepareStatement(sql);

			ps.setString(1, "ABC5678");
			ps.setString(2, "Hyundai");
			ps.setString(3, "Tucson");
			ps.setInt(4, 2023);
			ps.setDouble(5, 22000.00);
			ps.setString(6, "Gris");
			ps.setBoolean(7, true);
			ps.setInt(8, 45000);

			int filas = ps.executeUpdate();

			log.info("Conexion Exitosa---");
			log.info("Filas insertadas: " + filas);

		} catch (SQLException e) {
			log.error("Conexion Fallida---" + e.getMessage());

		} finally {
			try {
				if (ps != null) {
					ps.close();
				}

				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				log.error("Error de Conexion---" + e.getMessage());
			}
		}

	}
}
