package entidad;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "editorial")
public class Editorial {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String direccion;
	
	@OneToMany(mappedBy = "editorial", cascade = CascadeType.ALL)
	private List<Libro> coleccionLibros = new ArrayList<>();

	public Editorial() {
		super();
	}

	public Editorial(int id, String name, String direccion, List<Libro> coleccionLibros) {
		super();
		this.id = id;
		this.name = name;
		this.direccion = direccion;
		this.coleccionLibros = coleccionLibros;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<Libro> getColeccionLibros() {
		return coleccionLibros;
	}

	public void setColeccionLibros(List<Libro> coleccionLibros) {
		this.coleccionLibros = coleccionLibros;
	}

	@Override
	public String toString() {
		return "Editorial [id=" + id + ", name=" + name + ", direccion=" + direccion + ", coleccionLibros="
				+ coleccionLibros + "]";
	}
	
	
	

}
