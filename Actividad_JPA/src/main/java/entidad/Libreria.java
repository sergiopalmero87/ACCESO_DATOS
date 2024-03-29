package entidad;


import java.util.List;



import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



import jakarta.persistence.Table;

@Entity
@Table(name = "libreria")
public class Libreria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String nombreDuenio;
	private String direccion;
	
	@ManyToMany
	@JoinTable(name="libreria_libros",
			   joinColumns= { @JoinColumn(name="fk_id_libreria", referencedColumnName="id") }, 
			   inverseJoinColumns= { @JoinColumn(name="fk_id_libro", referencedColumnName="id")})
    private List<Libro> libros;

	public Libreria() {
		super();
		
	}


	public Libreria(Integer id, String name, String nombreDuenio, String direccion) {
		super();
		this.id = id;
		this.name = name;
		this.nombreDuenio = nombreDuenio;
		this.direccion = direccion;

	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
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
				+ "]";
	}


	

}
