package modelo.entidad;

public class Coche {

	private int id;
	private String marca;
	private int year;
	private int yearFabricar;
	private double km;

	public Coche() {
		super();
	}

	public Coche(int id, String marca, int year, int yearFabricar, double km) {
		super();
		this.id = id;
		this.marca = marca;
		this.year = year;
		this.yearFabricar = yearFabricar;
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

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getYearFabricar() {
		return yearFabricar;
	}

	public void setYearFabricar(int yearFabricar) {
		this.yearFabricar = yearFabricar;
	}

	public double getKm() {
		return km;
	}

	public void setKm(double km) {
		this.km = km;
	}

	@Override
	public String toString() {
		return "Coche [id=" + id + ", marca=" + marca + ", year=" + year + ", yearFabricar=" + yearFabricar + ", km="
				+ km + "]";
	}

}
