package jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;



public class ArticulosToXML {

	public static void main(String[] args) {

		JAXBContext contexto;
		try {
			contexto = JAXBContext.newInstance(Articulos.class, Articulo.class);
		} catch (JAXBException e) {
			System.out.println("Error creando el contexto");
			e.printStackTrace();
			return;
		}

		Marshaller m;

		try {
			m = contexto.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			Articulos articulos = new Articulos();
			articulos.getListaArticulos().add(new Articulo(1, "Articulo 1", "Descripcion 1", 10, 2));
			articulos.getListaArticulos().add(new Articulo(2, "Articulo 2", "Descripcion 2", 10, 4));
			articulos.getListaArticulos().add(new Articulo(3, "Articulo 3", "Descripcion 3", 10, 6));
			articulos.getListaArticulos().add(new Articulo(4, "Articulo 4", "Descripcion 4", 10, 8));
			
			m.marshal(articulos, new File("articulos.xml"));
			System.out.println("El archivo Articulos.xml ha sido creado con exito," + " refresque su Eclipse :)");
		} catch (JAXBException e) {
			System.out.println("Error convertiendo el objeto a formato XML");
			e.printStackTrace();
		}

	}

}
