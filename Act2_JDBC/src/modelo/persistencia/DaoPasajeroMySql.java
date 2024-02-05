package modelo.persistencia;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import modelo.entidad.Pasajero;
import modelo.persistencia.interfaces.DaoPasajero;

public class DaoPasajeroMySql implements DaoPasajero {

	private Connection con;
	private Properties properties = new Properties();
	private String url, user, password;

	public boolean abrirConexion() {

		// Creamos un vinculo con el fichero a traves de la clase FileInputStream en la
		// variable entrada.
		// En el objeto properties se carga el contenido del fichero.
		try (FileInputStream entrada = new FileInputStream("config.properties")) {
			properties.load(entrada);

			// Obtenemos los valores del archivo properties
			url = properties.getProperty("jdbc.url");
			user = properties.getProperty("jdbc.user");
			password = properties.getProperty("jdbc.password");

		} catch (IOException e) {
			e.printStackTrace();

		}

		// Con el objeto con, obtenemos la conexion.
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// Con el objeto con cerramos la conexion.
	public boolean cerrarConexion() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean alta(Pasajero p) {
		if (!abrirConexion()) {
			return false;
		}
		boolean alta = true;

		//Inserta en la tabla pasajeros los valores:
		String query = "insert into pasajeros (ID,Name,Age,Weight) " + " values(?,?,?,?)";
		try {
			// preparamos la query con valores parametrizables(?)
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, p.getId());
			ps.setString(2, p.getName());
			ps.setInt(3, p.getAge());
			ps.setDouble(4, p.getWeight());

			int numeroFilasAfectadas = ps.executeUpdate();
			if (numeroFilasAfectadas == 0)
				alta = false;
		} catch (SQLException e) {
			System.out.println("alta -> Error al insertar: " + p);
			alta = false;
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}

		return alta;
	}

	@Override
	public boolean baja(int id) {
		if (!abrirConexion()) {
			return false;
		}

		boolean borrado = true;
		
		//Borra de la tabla pasajeros donde el id es:
		String query = "delete from pasajeros where id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			// sustituimos la primera interrogante por la id
			ps.setInt(1, id);

			int numeroFilasAfectadas = ps.executeUpdate();
			if (numeroFilasAfectadas == 0)
				borrado = false;
		} catch (SQLException e) {
			borrado = false;
			System.out.println("baja -> No se ha podido dar de baja" + " el id " + id);
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}
		return borrado;
	}

	@Override
	public Pasajero consultarPasajero(int id) {
		if (!abrirConexion()) {
			return null;
		}
		Pasajero p = null;

		//Dame todos los valores de la tabla pasajeros donde el id es:
		String query = "select ID,Name,Age,Weight from pasajeros " + "where id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);

			//Como hacemos un "get" y no introducimos, borramos, actualizamos usamos ResultSet
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				p = new Pasajero();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setAge(rs.getInt(3));
				p.setWeight(rs.getDouble(4));
			}
		} catch (SQLException e) {
			System.out.println("obtener -> error al obtener el " + "pasajero con id " + id);
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}

		return p;

	}

	@Override
	public List<Pasajero> listarTodosPasajeros() {
		if (!abrirConexion()) {
			return null;
		}
		List<Pasajero> listaPasajeros = new ArrayList<>();

		//Dame todos los datos de la tabla pasajeros:
		String query = "select ID,Name,Age,weight from pasajeros";
		try {
			PreparedStatement ps = con.prepareStatement(query);

			//Como hacemos un "get" y no introducimos, borramos, actualizamos usamos ResultSet
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Pasajero pasajero = new Pasajero();
				pasajero.setId(rs.getInt(1));
				pasajero.setName(rs.getString(2));
				pasajero.setAge(rs.getInt(3));
				pasajero.setWeight(rs.getDouble(4));

				listaPasajeros.add(pasajero);
			}
		} catch (SQLException e) {
			System.out.println("listar -> error al obtener los pasajeros");
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}

		return listaPasajeros;
	}

	@Override
	public boolean addPasajeroCoche(int idCoche, int idPasajero) {
		if (!abrirConexion()) {
			return false;
		}

		boolean add = true;
		
		//Inserta en la tabla coches_pasajeros esos valores:
		String query = "INSERT INTO coches_pasajeros (coche_id,pasajero_id) VALUES (?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, idCoche);
			ps.setInt(2, idPasajero);

			int filasAfectadas = ps.executeUpdate();

			if (filasAfectadas == 0) {
				add = false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return add;
	}

	@Override
	public boolean deletePasajeroCoche(int idPasajero) {
		if (!abrirConexion()) {
			return false;
		}

		boolean delete = true;

		//Borra de la tabla pasajeros donde el id es:
		String query = "DELETE FROM coches_pasajeros WHERE pasajero_id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, idPasajero);

			int filasAfectadas = ps.executeUpdate();

			if (filasAfectadas == 0) {
				delete = false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return delete;
	}

	@Override
	public List<Pasajero> todosPasajerosCoche(int idCoche) {
		if (!abrirConexion()) {
			return null;
		}

		List<Pasajero> listaPasajeros = new ArrayList<>();

		// Dame todo from pasajeros con alias p, lo uno con coches_pasajeros con alias
		// cp, con la condicion de que p.id sea = a cp.pasajero_id
		// donde cp.coche_id sea = al parametro de entrada de la funcion.
		String query = "SELECT * FROM pasajeros as p INNER JOIN coches_pasajeros as cp ON p.id = cp.pasajero_id WHERE cp.coche_id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, idCoche);

			//Como hacemos un "get" y no introducimos, borramos, actualizamos usamos ResultSet
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Pasajero pasajero = new Pasajero();
				pasajero.setId(rs.getInt(1));
				pasajero.setName(rs.getString(2));
				pasajero.setAge(rs.getInt(3));
				pasajero.setWeight(rs.getDouble(4));

				listaPasajeros.add(pasajero);
			}
		} catch (SQLException e) {
			System.out.println("listar -> error al obtener los pasajeros");
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}

		return listaPasajeros;

	}

}
