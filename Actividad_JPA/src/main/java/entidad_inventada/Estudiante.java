package entidad_inventada;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "estudiante")
public class Estudiante {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String nombre;
    private int edad;
    
    @ManyToOne
    @JoinColumn(name = "fk_id_colegio", referencedColumnName = "id")
    private Colegio colegio;
    
    @ManyToMany(mappedBy = "estudiantes", cascade = CascadeType.PERSIST)
    private List<Asignatura> asignaturas;
    
    @ManyToMany(mappedBy = "estudiantes", cascade = CascadeType.PERSIST)
    private List<Profesor> profesores;

	public Estudiante() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Estudiante(Integer id, String nombre, int edad, Colegio colegio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.colegio = colegio;
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

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Colegio getColegio() {
		return colegio;
	}

	public void setColegio(Colegio colegio) {
		this.colegio = colegio;
	}

	public List<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(List<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}

	public List<Profesor> getProfesores() {
		return profesores;
	}

	public void setProfesores(List<Profesor> profesores) {
		this.profesores = profesores;
	}

	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", colegio=" + colegio
				+ ", asignaturas=" + asignaturas + ", profesores=" + profesores + "]";
	}
    
    

}
