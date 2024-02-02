package modelo.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.entidad.Pasajero;
import modelo.persistencia.interfaces.DaoPasajero;



public class DaoPasajeroMysql implements DaoPasajero {

private Connection conexion;
	
	//Bloque estatico, los bloques estaticos son ejecutados
	//por java JUSTO ANTES de ejecutar el metodo main()
	//java busca todos los metodos staticos que haya en el programa
	//y los ejecuta
	/*
	static{
		try {
			//Esta sentencia carga del jar que hemos importado
			//una clase que se llama Driver que esta en el paqueta
			//com.mysql.jdbc. Esta clase se carga previamente en
			//java para m�s adelante ser llamada
			//Esto solo es necesario si utilizamos una versi�n java anterior
			//a la 1.7 ya que desde esta versi�n java busca automaticamente 
			//los drivers
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver cargado");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver NO cargado");
			e.printStackTrace();
		}
	}*/
	
	public boolean abrirConexion(){
		String url = "jdbc:mysql://localhost:3306/bbdd";
		String usuario = "root";
		String password = "";
		try {
			conexion = DriverManager.getConnection(url,usuario,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean cerrarConexion(){
		try {
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	
	@Override
	public boolean alta(Pasajero p) {
		if(!abrirConexion()){
			return false;
		}
		boolean alta = true;
		
		String query = "insert into personas (NOMBRE,EDAD,PESO) "
				+ " values(?,?,?)";
		try {
			//preparamos la query con valores parametrizables(?)
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, p.getName());
			ps.setInt(2, p.getAge());
			ps.setDouble(3, p.getWeight());
			
			int numeroFilasAfectadas = ps.executeUpdate();
			if(numeroFilasAfectadas == 0)
				alta = false;
		} catch (SQLException e) {
			System.out.println("alta -> Error al insertar: " + p);
			alta = false;
			e.printStackTrace();
		} finally{
			cerrarConexion();
		}
		
		return alta;
	}

	@Override
	public boolean baja(int id) {
		if(!abrirConexion()){
			return false;
		}
		
		boolean borrado = true;
		String query = "delete from personas where id = ?";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			//sustituimos la primera interrgante por la id
			ps.setInt(1, id);
			
			int numeroFilasAfectadas = ps.executeUpdate();
			if(numeroFilasAfectadas == 0)
				borrado = false;
		} catch (SQLException e) {
			borrado = false;
			System.out.println("baja -> No se ha podido dar de baja"
					+ " el id " + id);
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}
		return borrado; 
	}


	@Override
	public List<Pasajero> listar() {
		if(!abrirConexion()){
			return null;
		}		
		List<Pasajero> listaPasajeros = new ArrayList<>();
		
		String query = "select ID,NOMBRE,EDAD,PESO from personas";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Pasajero pasajero = new Pasajero();
				pasajero.setId(rs.getInt(1));
				pasajero.setName(rs.getString(2));
				pasajero.setAge(rs.getInt(3));
				pasajero.setWeight(rs.getDouble(4));
				
				listaPasajeros.add(pasajero);
			}
		} catch (SQLException e) {
			System.out.println("listar -> error al obtener las "
					+ "personas");
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}
		
		
		return listaPasajeros;
	}

	@Override
	public boolean addPasajeroCoche(int idPasajero, int idCoche) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePasajeroCoche(int idPasajero) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Pasajero> pasajerosCoche(int idCoche) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
