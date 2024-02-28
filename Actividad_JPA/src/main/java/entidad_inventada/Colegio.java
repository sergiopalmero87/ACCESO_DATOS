package entidad_inventada;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.OneToOne;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;

import jakarta.persistence.Table;


@Entity
@Table(name = "colegio")
public class Colegio {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String nombre;
    
    @OneToOne(mappedBy = "colegio", cascade=CascadeType.ALL)
	private Direccion direccion;
    
    @OneToMany(mappedBy = "colegio", cascade = CascadeType.ALL)
    private List<Estudiante> estudiantes = new ArrayList<>();
    
    @OneToMany(mappedBy = "colegio", cascade = CascadeType.ALL)
    private List<Profesor> profesores = new ArrayList<>();

	public Colegio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Colegio(Integer id, String nombre, Direccion direccion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	public List<Profesor> getProfesores() {
		return profesores;
	}

	public void setProfesores(List<Profesor> profesores) {
		this.profesores = profesores;
	}

	@Override
	public String toString() {
		return "Colegio [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", estudiantes=" + estudiantes
				+ ", profesores=" + profesores + "]";
	}
    
    

}
