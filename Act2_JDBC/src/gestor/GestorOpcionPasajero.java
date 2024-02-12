package gestor;

import java.util.List;
import java.util.Scanner;

import modelo.entidad.Pasajero;

public class GestorOpcionPasajero {

	private static GestorPasajero gp = new GestorPasajero();
	private static Scanner sc = new Scanner(System.in);
	
	
	/**
	 * Método para crear un pasajero.
	 * 
	 */
	public void crearPasajero() {
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
			System.out.println("Pasajero dado de alta " + p);
		} else {
			System.out.println("No se ha podido dar de alta al pasajero");
		}
	}
	
	
	/**
	 * Método para borrar un pasajero.
	 * 
	 */
	public void borrarPasajero() {
		System.out.println("Introduzca el id del pasajero a borrar.");

		System.out.print("ID:");
		int idPasajeroBorrar = sc.nextInt();
		sc.nextLine();

		boolean bajaPasajero = gp.baja(idPasajeroBorrar);
		if (bajaPasajero) {
			System.out.println("Pasajero con ID " + idPasajeroBorrar + " borrado");
		} else {
			System.out.println("No se ha podido completar la baja.");
		}
	}
	
	
	/**
	 * Método para consultar un pasajero a partir de su ID.
	 * 
	 */
	public void consultarPasajeroPorId() {
		System.out.println("Introduzca Id del pasajero a consultar.");

		int idPasajeroConsultar = sc.nextInt();
		sc.nextLine();

		Pasajero pasajero = gp.obtenerPasajero(idPasajeroConsultar);

		if (pasajero == null) {
			System.out.println("Pasajero no encontrado en la base de datos");
		} else {
			System.out.println("El pasajero con id " + idPasajeroConsultar + " es " + pasajero);
		}
	}
	
	
	/**
	 * Método que lista todos los pasajeros.
	 * 
	 */
	public void listarTodosLosPasajeros() {
		System.out.println("Listando todos los pasajeros...");
		List<Pasajero> listaPasajeros = gp.listarTodosLosPasasjeros();
		System.out.println(listaPasajeros);
	}
	
	
	/**
	 * Método que añade un pasajero a un coche. 
	 * 
	 */
	public void addPasajeroACoche() {
		System.out.println("Introduce Id del coche y del pasajero que quieras añadir");

		System.out.print("Id coche: ");
		int idCocheAdd = sc.nextInt();
		sc.nextLine();

		System.out.print("Id pasajero: ");
		int idPasajeroAdd = sc.nextInt();
		sc.nextLine();

		boolean add = gp.addPasajeroCoche(idCocheAdd, idPasajeroAdd);

		if (add) {
			System.out.println("Pasajero " + idPasajeroAdd + " asignado a coche " + idCocheAdd + " con éxito.");
		} else {
			System.out.println("No se ha podido asignar el pasajero al coche.");
		}
	}
	
	
	/**
	 * Método que elimina un pasajero de un coche. 
	 * 
	 */
	public void eliminarPasajeroDeCoche() {
		System.out.println("Introduce el ID del pasajero para desasignar");

		System.out.print("ID: ");
		int idDesasignar = sc.nextInt();
		sc.nextLine();

		boolean desasignar = gp.deletePasajeroCoche(idDesasignar);

		if (desasignar) {
			System.out.println("Pasajero con id " + idDesasignar + " eliminado del coche con éxito.");
		} else {
			System.out.println("No se ha podido eliminar al pasajero del coche");
		}
	}
	
	
	/**
	 * Método que lista todos los pasajeros asignados a un coche.
	 * 
	 */
	public void listarPasajerosDeCoche() {
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
		
	}

}
