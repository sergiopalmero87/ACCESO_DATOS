package entidad;


import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "autores")
public class Autor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name, apellidos;
	private LocalDate born;
	
	
	public Autor() {
		super();
	}


	public Autor(int id, String name, String apellidos, LocalDate born) {
		super();
		this.id = id;
		this.name = name;
		this.apellidos = apellidos;
		this.born = born;
	}


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


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public LocalDate getBorn() {
		return born;
	}


	public void setBorn(LocalDate born) {
		this.born = born;
	}


	@Override
	public String toString() {
		return "Autor [id=" + id + ", name=" + name + ", apellidos=" + apellidos + ", born=" + born + "]";
	}
	

	
	
	
}