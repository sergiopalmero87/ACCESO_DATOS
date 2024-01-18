package Actividad;


import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	 
	 
	static List<Articulos> coleccionArticulos = new ArrayList<>();
	static File file = new File(EscrituraFichero.NOMBRE_FICHERO);

	public static void main(String[] args) throws IOException{
		
		Articulos articulos = new Articulos();
		int opcion = 0;
		
		// Averiguamos si el fichero articulos.dat existe.
		// Si no existe lo creamos
		if (!file.exists()) {
			//Creamos el fichero
			System.out.println("El fichero no existe. Vamos a crearlo.");
			file.createNewFile();
			
			System.out.println("Creando el archivo " + file.getName() + "...");
			System.out.println("Archivo " + file.getName() + " creado correctamente.\n\n");
			
		} else {
			//Si existe lo leemos
			System.out.println("El archivo: " + file + " existe");
			
			//Leemos con autoclose
			// Abrimos fichero agenda.dat para lectura
			try (FileInputStream file = new FileInputStream(EscrituraFichero.NOMBRE_FICHERO);
					ObjectInputStream buffer = new ObjectInputStream(file);) {
				
				//Utilizamos bandera para saber si estamos al final de la linea
				boolean eof = false;
				
				//Creamos objeto donde guardar lo que leemos del archivo
				Articulos articulo = new Articulos();
				
				//Mientras que no sea el final de la linea
				while (!eof) {
					try {
						articulo = (Articulos) buffer.readObject();
						// puede arrojar excepciones de tipo EOFException
						// en caso de que no haya mas objetos que leer
						// es decir, estamos en EOF (End Of File)
						System.out.println("El contenido del fichero es: " + articulo);
					} catch (EOFException e1) {// si salta esta excepcion, es que hemos llegado a EOF
						eof = true;
						// break;
					} catch (IOException e2) {
						System.out.println("Error al leer los articulos del fichero");
						System.out.println(e2.getMessage());
					} catch (ClassNotFoundException e3) {
						System.out.println("La clase Articulos no esta cargada en memoria");
						System.out.println(e3.getMessage());
					}
				}
			} catch (IOException e) {
				System.out.println("No se ha podido leer el contenido del archivo. "
						+ "¿El archivo existe?");
				System.out.println(e.getMessage());
				return;
			}
			}
		

		
		menu(opcion);
		
		
	}
	
	//Menu
	public static void menu(int opcion) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Elige que quieres hacer: \n");
		System.out.println("Opcion 1: Añadir nuevo artículo");
		System.out.println("Opcion 2: Borrar artículo por id");
		System.out.println("Opcion 3: Consulta artículo por id");
		System.out.println("Opcion 4: Consulta artículo por id");
		System.out.println("Opcion 5: Exportar artículos a archivo CSV");
		System.out.println("Opcion 6: Salir del programa");

		opcion = sc.nextInt();
		
		switch(opcion) {
		
		 case 1: //Añadir nuevo articulo
			 Articulos nuevoArticulo = new Articulos();
			 //New ID
			 System.out.println("ID:");
			 int id = sc.nextInt();
			 sc.nextLine();
			 nuevoArticulo.setId(id);
			 
			 //New Name
			 System.out.println("NAME:");
			 String name = sc.nextLine();
			 nuevoArticulo.setName(name);
			 
			 //New Description
			 System.out.println("DESCRIPTION:");
			 String description = sc.nextLine();
			 nuevoArticulo.setDescription(description);
			 
			 //New Stock
			 System.out.println("STOCK:");
			 int stock = sc.nextInt();
			 sc.nextLine();
			 nuevoArticulo.setStock(stock);
			 
			 //New price
			 System.out.println("PRICE:");
			 double price = sc.nextDouble();
			 nuevoArticulo.setPrice(price);
			 
			 System.out.println("\nEl nuevo articulo creado es: " +nuevoArticulo +"\n");
			 try (FileOutputStream file = new FileOutputStream(EscrituraFichero.NOMBRE_FICHERO, true);
						ObjectOutputStream escritor = new ObjectOutputStream(file);) {
					escritor.writeObject(nuevoArticulo);
					
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("No se ha podido abrir el fichero");
					System.out.println(e.getMessage());
					return;
				}
			 break;
			 
		 case 2: // Borrar articulo por ID
			 break;
			 
		 case 3: //Consultar articulo por ID
			 break;
			 
		 case 4: // Listar articulos
			 break;
			 
		 case 5: //Terminar programa
			 break;
			 
			 default: //Mostrar error
		
		}
		
	}

}
