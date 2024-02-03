package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import gestor.GestorCoche;

public class Main {

	public static void main(String[] args) {
		
		// Paso 1: Establecer conexion con la base de datos
				String cadenaConexion = "jdbc:mysql://localhost:3306/Act2_Conectores";
				String user = "root";
				String pass = "";
				Connection con;
				try {
					con = DriverManager.getConnection(cadenaConexion, user, pass);
				} catch (SQLException e) {
					System.out.println("No se ha podido establecer la conexion con la BD");
					System.out.println(e.getMessage());
					return;
				}
				System.out.println("Se ha establecido la conexion con la Base de datos");
				
				
				System.out.println("Bienvenidos a nuestra CRUD de personas");
				Scanner sc = new Scanner(System.in);
				boolean fin = false;
				GestorCoche gc = new GestorCoche();
				
		
	}

}
