package gestor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.entidad.Coche;

public class GestorOpcionCoche {

	private static GestorCoche gc = new GestorCoche();
	private static Scanner sc = new Scanner(System.in);

	
	/**
	 * Método que da de alta un coche en la bbdd.
	 * 
	 */
	public void alta() {
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
		sc.nextLine();

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
	}

	
	/**
	 * Método que da de baja un coche de la bbdd.
	 * 
	 */
	public void baja() {
		System.out.println("Introduzca el ID del coche a borrar.");
		int idCocheBorarr = sc.nextInt();
		sc.nextLine();

		boolean baja = gc.baja(idCocheBorarr);
		if (baja) {
			System.out.println("Coche con ID " + idCocheBorarr + " dado de baja");
		} else {
			System.out.println("No se ha podido completar la baja.");
		}
	}

	
	/**
	 * Método para consultar un coche por su ID.
	 * 
	 */
	public void consultaCochePorId() {
		System.out.println("Introduzca el ID del coche a consultar");
		int idCocheConsultar = sc.nextInt();
		sc.nextLine();

		Coche coche = gc.consultaCocheID(idCocheConsultar);
		if (coche == null) {
			System.out.println("Coche no encontrado en la base de datos");
		} else {
			System.out.println("El coche con id " + idCocheConsultar + " es " + coche);
		}
	}

	
	/**
	 * Método para moficar un coche.
	 * 
	 */
	public void modificarCoche() {
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

		if (modificado) {
			System.out.println("Coche modificado en la BBDD " + cocheNuevo);
		} else {
			System.out.println("No se ha podido modificar el nuevo coche");
		}
	}

	
	/**
	 * Método para listar todos los coches.
	 * 
	 */
	public void listarTodosLosCoches() {
		List<Coche> listaCoches = new ArrayList<>();
		listaCoches = gc.listarTodosLosCoches();
		System.out.println("La lista de coches es: \n" + listaCoches);
	}

}
