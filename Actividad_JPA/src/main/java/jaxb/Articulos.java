package jaxb;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "articulos")
public class Articulos {

	
	private List<Articulo> listaArticulos;

	public Articulos() {
		listaArticulos = new ArrayList<>();
		
	}

	//Establecemos que cada elemento del array se serialice a una etiqueta XML
	//cuyo nombre sea "articulo" en vez de listaArticulos
	@XmlElement(name = "articulo")
	//Podemos crear una anotación que envuelva las etiquetas articulo, de 
	//esta manera agrupamos todos los "articulo" en la etiqueta "Lista de articulos"
	@XmlElementWrapper(name = "Lista_de_articulos")
	public List<Articulo> getListaArticulos() {
		return listaArticulos;
	}

	public void setListaArticulos(List<Articulo> listaArticulos) {
		this.listaArticulos = listaArticulos;
	}
	
	

	
	
	

	

}
