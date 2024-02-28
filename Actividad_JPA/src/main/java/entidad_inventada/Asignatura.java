package entidad_inventada;

import java.util.List;

import jakarta.persistence.JoinColumn;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "asignatura")
public class Asignatura {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nombre;
	
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name="asignaturas_estudiantes",
	   joinColumns= { @JoinColumn(name="fk_id_asignatura", referencedColumnName="id") }, 
	   inverseJoinColumns= { @JoinColumn(name="fk_id_estudiante", referencedColumnName="id")})
	private List<Estudiante> estudiantes;


	public Asignatura() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Asignatura(Integer id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
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


	public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}


	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}


	@Override
	public String toString() {
		return "Asignatura [id=" + id + ", nombre=" + nombre + ", estudiantes=" + estudiantes + "]";
	}
	
	
	

}
