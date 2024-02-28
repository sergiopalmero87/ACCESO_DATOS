package entidad;





import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "libros")
public class Libro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private double price;
	
	@ManyToOne()
	@JoinColumn(name = "fk_id_editorial", referencedColumnName = "id")
	private Editorial editorial;
	
	@ManyToOne()
	@JoinColumn(name = "fk_id_autor", referencedColumnName = "id")
	private Autor autor;
	
	@ManyToMany(mappedBy = "libros", cascade = CascadeType.PERSIST)
	private List<Libreria> librerias;

	public Libro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Libro(Integer id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Editorial getEditorial() {
		return editorial;
	}

	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	
	public List<Libreria> getLibrerias() {
		return librerias;
	}

	public void setLibrerias(List<Libreria> librerias) {
		this.librerias = librerias;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", name=" + name + ", price=" + price + ", editorial=" + editorial + ", autor="
				+ autor + ", librerias=" + librerias + "]";
	}

	
}
