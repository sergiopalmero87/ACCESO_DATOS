package modelo.entidad;

public class Coche {

	private int id;
	private String marca;
	private String modelo;
	private int anioFabricacion;
	private double km;

	public Coche() {
		super();
	}

	public Coche(int id, String marca, String modelo, int anioFabricacion, double km) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.anioFabricacion = anioFabricacion;
		this.km = km;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAnioFabricacion() {
		return anioFabricacion;
	}

	public void setAnioFabricacion(int anioFabricacion) {
		this.anioFabricacion = anioFabricacion;
	}

	public double getKm() {
		return km;
	}

	public void setKm(double km) {
		this.km = km;
	}

	@Override
	public String toString() {
		return "Coche [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", anioFabricacion=" + anioFabricacion
				+ ", km=" + km + "]";
	}

	

	

}
