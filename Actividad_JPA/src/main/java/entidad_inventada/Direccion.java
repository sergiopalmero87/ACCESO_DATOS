package entidad_inventada;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "direccion")
public class Direccion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String calle;
    private String ciudad;
    private String codigoPostal;
    
    @OneToOne
    @JoinColumn(name = "fk_id_colegio", referencedColumnName = "id")
    private Colegio colegio;

	public Direccion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Direccion(Integer id, String calle, String ciudad, String codigoPostal) {
		super();
		this.id = id;
		this.calle = calle;
		this.ciudad = ciudad;
		this.codigoPostal = codigoPostal;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	
	public Colegio getColegio() {
		return colegio;
	}

	public void setColegio(Colegio colegio) {
		this.colegio = colegio;
	}

	@Override
	public String toString() {
		return "Direccion [id=" + id + ", calle=" + calle + ", ciudad=" + ciudad + ", codigoPostal=" + codigoPostal
				+ ", colegio=" + colegio + "]";
	}

	

}
