package entidad;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "autores")
public class Autor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name, apellidos;
	
	@Temporal(TemporalType.DATE)
	private Date born;
	
	@OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
	private List<Libro> libros = new ArrayList<>();
	
	
	public Autor() {
		super();
	}


	public Autor(Integer id, String name, String apellidos, Date born) {
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


	public Date getBorn() {
		return born;
	}


	public void setBorn(Date born) {
		this.born = born;
	}


	public List<Libro> getLibros() {
		return libros;
	}


	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}


	@Override
	public String toString() {
		return "Autor [id=" + id + ", name=" + name + ", apellidos=" + apellidos + ", born=" + born + ", libros="
				+ libros + "]";
	}


	

	


	
}