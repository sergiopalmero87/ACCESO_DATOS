package main;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import gestor.GestorCoche;
import gestor.GestorPasajero;
import modelo.entidad.Coche;
import modelo.entidad.Pasajero;

public class Main {

	private static String url, user, password;
	private static Connection con;
	private static Properties properties = new Properties();
	private static String fichero = "config.properties";

	public static void main(String[] args) {

		// Con FileInputStream creamos vinculo con fichero.
		// Con el objeto properties cargamos en la variable entrada el contendio del
		// fichero.
		try (FileInputStream entrada = new FileInputStream(fichero)) {
			properties.load(entrada);
		} catch (IOException e) {
			e.printStackTrace();

		}

		// Obtenemos la conexion a la bbdd atraves de los datos del fichero y los guardamos en las variables.
		url = properties.getProperty("jdbc.url");
		
		user = properties.getProperty("jdbc.user");
		
		password = properties.getProperty("jdbc.password");
		

		// Obtenemos la conexion.
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.out.println("No se ha podido establecer la conexion con la BBDD.\n¿Son correctos los datos de acceso?");
			return;
		}

		// La conexion ha sido exitosa.
		// System.out.println("Se ha establecido la conexion con la Base de datos");
		System.out.println("¡¡Bienvenidos a nuestra app de gestión de coches!!");
		Scanner sc = new Scanner(System.in);
		GestorCoche gc = new GestorCoche();
		GestorPasajero gp = new GestorPasajero();
		int opcion = 0;

		do {
			menu();
			opcion = sc.nextInt();
			sc.nextLine();
			switch (opcion) {
			case 1:
				System.out.println("Introduzca los datos del coche (Marca/Modelo/AnioFabricacion/Km)");
				System.out.print("Marca: ");
				String marca = sc.nextLine();

				System.out.print("Modelo: ");
				String modelo = sc.nextLine();

				System.out.print("Anio fabricacion: ");
				int anioFabricacion = sc.nextInt();
				sc.nextLine();

				System.out.print("Km: ");
				double km = sc.nextDouble();

				Coche c = new Coche();
				c.setMarca(marca);
				c.setModelo(modelo);
				c.setAnioFabricacion(anioFabricacion);
				c.setKm(km);

				boolean alta = gc.alta(c);
				if (alta) {
					System.out.println("Coche dado de alta en la BBDD");
				} else {
					System.out.println("El coche no se ha podido dar de alta en la BBDD");
				}

				break;

			case 2:
				System.out.println("Introduzca el ID del coche a borrar.");
				int idCocheBorarr = sc.nextInt();
				sc.nextLine();

				boolean baja = gc.baja(idCocheBorarr);
				if (baja == true) {
					System.out.println("Coche con ID " + idCocheBorarr + " dado de baja");
				} else {
					System.out.println("No se ha podido completar la baja.");
				}
				break;

			case 3:
				System.out.println("Introduzca el ID del coche a consultar");
				int idCocheConsultar = sc.nextInt();
				sc.nextLine();

				Coche coche = gc.consultaCocheID(idCocheConsultar);
				if (coche == null) {
					System.out.println("Coche no encontrado en la base de datos");
				} else {
					System.out.println("El coche con id " + idCocheConsultar + " es " + coche);
				}
				break;

			case 4:
				System.out.println("Introduzca todos los datos del nuevo coche.(Se modificará a partir de su ID.)");

				System.out.print("ID: ");
				int idModificar = sc.nextInt();
				sc.nextLine();

				System.out.print("Marca: ");
				String marcaModificiar = sc.nextLine();

				System.out.print("Modelo: ");
				String modeloModificar = sc.nextLine();

				System.out.print("Year fabricar: ");
				int anioFabricacionModificar = sc.nextInt();
				sc.nextLine();

				System.out.print("Km: ");
				double kmModificar = sc.nextDouble();

				Coche cocheNuevo = new Coche();
				cocheNuevo.setId(idModificar);
				cocheNuevo.setMarca(marcaModificiar);
				cocheNuevo.setModelo(modeloModificar);
				cocheNuevo.setAnioFabricacion(anioFabricacionModificar);
				cocheNuevo.setKm(kmModificar);

				boolean modificado = gc.modificarCoche(cocheNuevo);

				if (modificado = true) {
					System.out.println("Coche modificado en la BBDD");
				} else {
					System.out.println("No se ha podido modificar el nuevo coche");
				}
				break;

			case 5:
				List<Coche> listaCoches = new ArrayList<>();
				listaCoches = gc.listarTodosLosCoches();
				System.out.println("La lista de coches es: \n" + listaCoches);
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
						System.out.println("Introduzca los datos del pasajero.");

						System.out.print("ID: ");
						int idPasajero = sc.nextInt();
						sc.nextLine();

						System.out.print("Name: ");
						String name = sc.nextLine();

						System.out.print("Age: ");
						int age = sc.nextInt();
						sc.nextLine();

						System.out.print("Weight: ");
						double weight = sc.nextDouble();

						Pasajero p = new Pasajero();
						p.setId(idPasajero);
						p.setName(name);
						p.setAge(age);
						p.setWeight(weight);

						int altaPasajero = gp.alta(p);

						if (altaPasajero == 0) {
							System.out.println("Pasajero dado de alta");
						} else {
							System.out.println("No se ha podido dar de alta al pasajero");
						}
						break;

					case 2:
						System.out.println("Introduzca el id del pasajero a borrar.");

						System.out.print("ID:");
						int idPasajeroBorrar = sc.nextInt();
						sc.nextLine();

						boolean bajaPasajero = gp.baja(idPasajeroBorrar);
						if (bajaPasajero == true) {
							System.out.println("Pasajero con ID " + idPasajeroBorrar + " borrado");
						} else {
							System.out.println("No se ha podido completar la baja.");
						}
						break;

					case 3:
						System.out.println("Introduzca Id del pasajero a consultar.");

						int idPasajeroConsultar = sc.nextInt();
						sc.nextLine();

						Pasajero pasajero = gp.obtenerPasajero(idPasajeroConsultar);

						if (pasajero == null) {
							System.out.println("Pasajero no encontrado en la base de datos");
						} else {
							System.out.println("El pasajero con id " + idPasajeroConsultar + " es " + pasajero);
						}
						break;

					case 4:
						System.out.println("Listando todos los pasajeros...");
						List<Pasajero> listaPasajeros = gp.listarTodosLosPasasjeros();
						System.out.println(listaPasajeros);
						break;

					case 5:
						System.out.println("Introduce Id del coche y del pasajero que quieras añadir");

						System.out.print("Id coche: ");
						int idCocheAdd = sc.nextInt();
						sc.nextLine();

						System.out.print("Id pasajero: ");
						int idPasajeroAdd = sc.nextInt();
						sc.nextLine();

						boolean add = gp.addPasajeroCoche(idCocheAdd, idPasajeroAdd);

						if (add == true) {
							System.out.println("Pasajero asignado a coche con éxito.");
						} else {
							System.out.println("No se ha podido asignar el pasajero al coche.");
						}
						break;

					case 6:
						System.out.println("Introduce el ID del pasajero para desasignar");

						System.out.print("ID: ");
						int idDesasignar = sc.nextInt();
						sc.nextLine();

						boolean desasignar = gp.deletePasajeroCoche(idDesasignar);

						if (desasignar = true) {
							System.out.println("Pasajero eliminado del coche con éxito.");
						} else {
							System.out.println("No se ha podido eliminar al pasajero del coche");
						}
						break;

					case 7:
						System.out.println("Introduce el ID del coche");
						System.out.print("ID: ");
						int idCoche = sc.nextInt();
						sc.nextLine();

						List<Pasajero> listaPasajerosCoche = gp.todosPasajerosCoche(idCoche);

						if (listaPasajerosCoche.isEmpty()) {
							System.out.println("El coche no existe o no tiene ningún pasajero asignado");
						} else {
							System.out.println(listaPasajerosCoche);
						}
						break;

					case 8:
						System.out.println("Saliendo al menu principal...");
						opcionPasajeros = 8;

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

	private static void menu() {
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
