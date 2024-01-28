package Actividad;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ExportarCSV {

	// Exportar a CSV (Comma-separeted value)
	// Separar por comas

	/**
	 * Exporta la colección de artículos a un archivo CSV.
	 *
	 * @param coleccionArticulos La colección de artículos a exportar.
	 */
	public void exportarACSV(List<Articulos> coleccionArticulos) {
		// Con PrintWriter escribimos en el archivo "articulos.csv"
		// PrintWriter necesita en el constructor un archivo al que nosotros colocamos
		// la extension csv
		try (PrintWriter writer = new PrintWriter(new File("articulos.csv"))) {

			// Estos son los encabezados
			writer.write("ID,Nombre,Descripción,Precio,Stock\n");

			// Recorremos la colección de artículos
			for (Articulos articulo : coleccionArticulos) {

				// Escribimos los datos del artículo
				// Al separar por comas, se pondran debajo de ID,Nombre,Descrpcion,Precio,Stock
				// cuando creemos el archivo
				writer.write(articulo.getId() + "," + articulo.getName() + "," + articulo.getDescription() + ","
						+ articulo.getPrice() + "," + articulo.getStock() + "\n");
			}

			// Imprimimos un mensaje de confirmación indicando que la exportación se ha
			// completado correctamente.
			System.out.println("Exportación a CSV completada correctamente.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
