package Actividad;

import java.io.Serializable;
import java.util.Objects;

public class Articulos implements Serializable{
	
	
	private static final long serialVersionUID = 1313199437890097878L;
	private int id;
	private String name, description;
	private double price;
	private int stock;

	
	//Empty constructor
	public Articulos() {
		super();
	}


	//Constructor with fields
	public Articulos(int id, String name, String description, double price, int stock) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.stock = stock;
	}


	
	//Getters and Setters
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


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


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


	
	//ToString
	@Override
	public String toString() {
		return "Articulos [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", stock=" + stock + "]";
	}


	
	//Hashcode equal para el id del producto
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Articulos other = (Articulos) obj;
		return id == other.id;
	}
	
	
	
	
	
	

}
