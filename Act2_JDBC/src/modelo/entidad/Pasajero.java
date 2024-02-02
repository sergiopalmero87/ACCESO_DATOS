package modelo.entidad;

public class Pasajero {

	private int id;
	private String name;
	private int age;
	private double weight;

	public Pasajero() {
		super();
	}

	public Pasajero(int id, String name, int age, double weight) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.weight = weight;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Pasajero [id=" + id + ", name=" + name + ", age=" + age + ", weight=" + weight + "]";
	}

}
