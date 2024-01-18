package Actividad;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class LecturaFichero { //Con EndOfLine

	public static void main(String[] args) {
		// Abrimos fichero agenda.dat para lectura
		try (FileInputStream file = new FileInputStream(EscrituraFichero.NOMBRE_FICHERO);
				ObjectInputStream buffer = new ObjectInputStream(file);) {
			// Leemos la lista de articulos
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
	
}
