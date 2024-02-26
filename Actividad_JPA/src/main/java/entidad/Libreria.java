package entidad;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import jakarta.persistence.Table;

@Entity
@Table(name = "libreria")
public class Libreria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String nombreDuenio;
	private String direccion;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name="librerias_libros",
	   joinColumns= { @JoinColumn(name="fk_id_libreria", referencedColumnName="id") }, 
	   inverseJoinColumns= { @JoinColumn(name="fk_id_libro", referencedColumnName="id")})
	private List<Libro> libros = new ArrayList<>();

	public Libreria() {
		super();
		
	}

	public Libreria(int id, String name, String nombreDuenio, String direccion, List<Libro> libros) {
		super();
		this.id = id;
		this.name = name;
		this.nombreDuenio = nombreDuenio;
		this.direccion = direccion;
		this.libros = libros;
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

	public String getNombreDuenio() {
		return nombreDuenio;
	}

	public void setNombreDuenio(String nombreDuenio) {
		this.nombreDuenio = nombreDuenio;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

	@Override
	public String toString() {
		return "Libreria [id=" + id + ", name=" + name + ", nombreDuenio=" + nombreDuenio + ", direccion=" + direccion
				+ ", libros=" + libros + "]";
	}
	
	

}
