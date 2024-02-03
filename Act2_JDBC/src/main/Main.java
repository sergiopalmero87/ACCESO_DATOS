package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import gestor.GestorCoche;
import modelo.entidad.Coche;
import modelo.entidad.Pasajero;

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
				
				
				System.out.println("¡¡Bienvenidos a nuestra app de gestión de coches!!");
				Scanner sc = new Scanner(System.in);
				boolean fin = false;
				GestorCoche gc = new GestorCoche();
				
				
				do {
					menu();
					int opcion = sc.nextInt();
					sc.nextLine();
					switch (opcion) {
					case 1:
						System.out.println("Introduzca los datos del coche (Marca/Year/YearFabricar/Km)");
						System.out.print("Marca: ");
						String Marca = sc.nextLine();
						
						System.out.print("Year: ");
						int Year = sc.nextInt();
						sc.nextLine();
						
						System.out.print("Year fabricar: ");
						int YearFabricar = sc.nextInt();
						sc.nextLine();
						
						System.out.print("Km: ");
						double Km = sc.nextDouble();
						
						Coche c = new Coche();
						c.setMarca(Marca);
						c.setYear(Year);
						c.setYearFabricar(YearFabricar);
						c.setKm(Km);
						
						int alta = gc.alta(c);
						if(alta == 0) {
							System.out.println("Coche dado de alta en la BBDD");
						}else if(alta == 1) {
							System.out.println("Error de conexión con la BBDD");
						}else if(alta == 2){
							System.out.println("El usuario tiene menos de tres carateres");
						}
						break;
						
					case 2:
						System.out.println("Introduzca el ID del coche a borrar.");
						int idCoche = sc.nextInt();
						sc.nextLine();
						
						boolean baja = gc.baja(idCoche);
						if(baja == true) {
							System.out.println("Coche con ID " + idCoche + " dado de baja");
						}else {
							System.out.println("No se ha podido completar la baja.");
						}
						break;

					case 0:
						fin = true;
						break;
					}
				}while(!fin);
				
				System.out.println("Fin de programa");

			}

			private static void menu() {
				System.out.println("Elija una opción:");
				System.out.println("1. Alta coche");
				System.out.println("2. Borrar coche");
				System.out.println("3. Consultar coche por ID");
				System.out.println("4. Modificar coche por ID");
				System.out.println("5. Listar todos los coches");
				System.out.println("6. Salir del programa");
			}
				
		
	}


