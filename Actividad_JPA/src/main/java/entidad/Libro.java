package entidad;





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
@Table(name = "libros")
public class Libro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private double price;
	
	@ManyToOne()
	@JoinColumn(name="fk_id_editorial", referencedColumnName="id")
	private Editorial editorial;
	
	@ManyToOne
	@JoinColumn(name = "fk_id_autor", referencedColumnName = "id")
	private Autor autor;
	
	@ManyToOne()
	@JoinColumn(name="fk_id_libreria", referencedColumnName="id")
	private Libreria libreria;

	public Libro() {
		super();
	}

	public Libro(Integer id, String name, double price, Autor autor) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.autor = autor;
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

	public Libreria getLibreria() {
		return libreria;
	}

	public void setLibreria(Libreria libreria) {
		this.libreria = libreria;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", name=" + name + ", price=" + price + ", editorial=" + editorial + ", autor="
				+ autor + ", libreria=" + libreria + "]";
	}
	
	
	
}
