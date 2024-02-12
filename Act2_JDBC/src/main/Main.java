package main;


import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import gestor.GestorCoche;
import gestor.GestorOpcionCoche;
import gestor.GestorOpcionPasajero;




public class Main {

	private static String url, user, password;
	private static Connection con;
	private static Properties properties = new Properties();
	private static String fichero = "config.properties";
	private static Scanner sc = new Scanner(System.in);
	private static GestorOpcionPasajero gop = new GestorOpcionPasajero(); 
	private static GestorCoche gc = new GestorCoche();
	private static GestorOpcionCoche goc = new GestorOpcionCoche(); 
	
	
	public static void main(String[] args) {

		// Con FileInputStream creamos vinculo con fichero.
		// Con el objeto properties cargamos en la variable entrada el contendio del
		// fichero.
		try (FileInputStream entrada = new FileInputStream(fichero)) {
			properties.load(entrada);
		} catch (IOException e) {
			e.printStackTrace();

		}

		// Obtenemos la conexion a la bbdd atraves de los datos del fichero y los
		// guardamos en las variables.
		url = properties.getProperty("jdbc.url");

		user = properties.getProperty("jdbc.user");

		password = properties.getProperty("jdbc.password");

		// Obtenemos la conexion.
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.out.println(
					"No se ha podido establecer la conexion con la BBDD.\n¿Son correctos los datos de acceso?\n¿Está activa la BBDD?");
			return;
		}

		// La conexion ha sido exitosa.
		// System.out.println("Se ha establecido la conexion con la Base de datos");
		System.out.println("¡¡Bienvenidos a nuestra app de gestión de coches!!");
		int opcion = 0;

		do {
			menuCoche();
			opcion = sc.nextInt();
			sc.nextLine();
			switch (opcion) {
			case 1:
				goc.alta();
				break;

			case 2:
				goc.baja();
				break;

			case 3:
				goc.consultaCochePorId();
				break;

			case 4:
				goc.modificarCoche();
				break;

			case 5:
				goc.listarTodosLosCoches();
				break;

			case 6:
				System.out.println("Gestión de pasajeros:");

				int opcionPasajeros = 0;
				do {
					menuPasajeros();
					opcionPasajeros = sc.nextInt();
					sc.nextLine();

					switch (opcionPasajeros) {
					case 1:
						gop.crearPasajero();
						break;

					case 2:
						gop.borrarPasajero();
						break;

					case 3:
						gop.consultarPasajeroPorId();
						break;

					case 4:
						gop.listarTodosLosPasajeros();
						break;

					case 5:
						gop.addPasajeroACoche();
						break;

					case 6:
						gop.eliminarPasajeroDeCoche();
						break;

					case 7:
						gop.listarPasajerosDeCoche();
						break;

					case 8:
						System.out.println("Saliendo al menu principal...");
						break;

					default:
						System.out.println("Elija una opción válida.");
					}
				} while (opcionPasajeros != 8);
				break;

			case 7:
				opcion = 7;
				System.out.println("Saliendo del programa. Adiós");
				break;

			default:
				System.out.println("Introduzca una opción válida.\n");
			}
		} while (opcion != 7);
		return;

	}
	
	
	private static void menuCoche() {
		System.out.println("\nElija una opción:");
		System.out.println("1. Alta coche");
		System.out.println("2. Borrar coche");
		System.out.println("3. Consultar coche por ID");
		System.out.println("4. Modificar coche por ID");
		System.out.println("5. Listar todos los coches");
		System.out.println("6. Gestionar los pasajeros");
		System.out.println("7. Salir del programa");
	}

	private static void menuPasajeros() {
		System.out.println("\nElija una opción:");
		System.out.println("1. Crear pasajero");
		System.out.println("2. Borrar pasajero por ID");
		System.out.println("3. Consultar pasajero por ID");
		System.out.println("4. Listar todos los pasajeros");
		System.out.println("5. Add pasajero a coche");
		System.out.println("6. Eliminar pasajero de un coche");
		System.out.println("7. Listar todos los pasajeros de un coche");
		System.out.println("8. Volver al menu principal");
	}

}
