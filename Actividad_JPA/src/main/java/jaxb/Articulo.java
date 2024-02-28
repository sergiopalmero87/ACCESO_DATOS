package jaxb;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


//El objetivo de JAXB es convertir 

//Cuando trabajamos con JAXB para serializar y deserializar objetos necesitamos
//utilizar anotaciones para realizar la funcionalidad.

//Primero de todo, tenemos anotaciones a nivel de clase.

//Con esta anotación estamos estableciendo el nombre de el nodo raíz en el XML
//Es una anotación obligatoria
@XmlRootElement(name = "articulo")
//Por defecto, cuando serializamos un objeto, el orden de los nodos elemento
//Podemos hacer que las etiquetas salgan en un determinado orden con la siguiente
//anotación. Es opcional
@XmlType(propOrder = {
		"id",
		"name", 
		"description",
		"price",
		"stock"
	})
public class Articulo {

	//Por defecto, JAXB convertirá todos los atributos en nodos elemento en el
	//XML. El nombre del nodo elemento será el del atributo.
    private int id;
    private String name, description;
    private double price;
    private int stock;

    //JAXB necesita para funcionar del constructor por defecto de java
    public Articulo() {
    	
    }

    public Articulo(int id, String name, String description, double price, int stock) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    
  //Además de anotaciones a nivel de clase, tenemos anotaciones a nivel de 
  //métodos como @XmlAttribute, @XmlElement y @XmlTransient
  //Siempre las pondremos en el método "get"
  	
  //Esta anotación hace que el atributo de la persona se serialize 
  //como atributo en el XML
  //Ej: <articulo id="1">
  	@XmlAttribute(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//Esta anotación es opcional, sirve para si en algún momento no queremos 
	//serializar un atributo, es decir, el nodo no aparecerá en el XML resultante.
	//@XmlTransient
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	//Esta anotación es opcional, sirve para cambiar el nombre del nodo elemento
	//cuando se serialice la información. En este ejemplo, el nodo elemento
	//resultante se llamará "precio" en lugar de "price"
	@XmlElement(name="precio")
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

    

}
