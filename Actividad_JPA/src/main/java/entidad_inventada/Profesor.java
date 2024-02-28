package entidad_inventada;

import java.util.List;

import jakarta.persistence.JoinTable;

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
@Table(name = "profesor")
public class Profesor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nombre;
    private String especialidad;
    
    @ManyToOne
    @JoinColumn(name = "fk_id_colegio", referencedColumnName = "id")
    private Colegio colegio;
    
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name="profesores_estudiantes",
	   joinColumns= { @JoinColumn(name="fk_id_profesor", referencedColumnName="id") }, 
	   inverseJoinColumns= { @JoinColumn(name="fk_id_estudiante", referencedColumnName="id")})
    private List<Estudiante> estudiantes;

	public Profesor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Profesor(Integer id, String nombre, String especialidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.especialidad = especialidad;
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

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public Colegio getColegio() {
		return colegio;
	}

	public void setColegio(Colegio colegio) {
		this.colegio = colegio;
	}

	public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	@Override
	public String toString() {
		return "Profesor [id=" + id + ", nombre=" + nombre + ", especialidad=" + especialidad + ", colegio=" + colegio
				+ ", estudiantes=" + estudiantes + "]";
	}
    
    
    

}
