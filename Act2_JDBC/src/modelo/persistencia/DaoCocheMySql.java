package modelo.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.entidad.Coche;
import modelo.persistencia.interfaces.DaoCoche;

public class DaoCocheMySql implements DaoCoche{
	
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
		String url = "jdbc:mysql://localhost:3306/Act2_Conectores";
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
	
	

	
	/**
	 * Método que da de alta un coche en la base de datos.
	 * 
	 * @param c Coche que damos de alta.
	 * @return true si el alta se ha hecho con éxito y false en caso de que no se haya podido completar.
	 */
	@Override
	public boolean alta(Coche c) {
		if(!abrirConexion()){
			return false;
		}
		boolean alta = true;
		
		String query = "insert into coches (ID,Marca,Year,YearFabricar,Km) "
				+ " values(?,?,?)";
		try {
			//preparamos la query con valores parametrizables(?)
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setInt(1, c.getId());
			ps.setString(2, c.getMarca());
			ps.setInt(3, c.getYear());
			ps.setInt(4, c.getYearFabricar());
			ps.setDouble(5, c.getKm());
			
			
			int numeroFilasAfectadas = ps.executeUpdate();
			if(numeroFilasAfectadas == 0) {
				alta = false;
			}
		} catch (SQLException e) {
			System.out.println("alta -> Error al insertar: " + c);
			alta = false;
			e.printStackTrace();
		} finally{
			cerrarConexion();
		}
		
		return alta;
	}
	
	
	
	/**
	 * Método que lista un coche de la base de datos según su ID.
	 * 
	 * @param idCoche ID a partir del cual obtenemos el coche.
	 * @return c coche obtenido tras la búsqueda, null en caso de que no se encuentre nada.
	 */
	@Override
	public Coche listarUnCoche(int idCoche) {
		if(!abrirConexion()){
			return null;
		}		
		Coche c = null;
		
		String query = "select ID,Marca,Year,YearFabricar,Km from coches "
				+ "where id = ?";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setInt(1, idCoche);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				c = new Coche();
				c.setId(rs.getInt(1));
				c.setMarca(rs.getString(2));
				c.setYear(rs.getInt(3));
				c.setYearFabricar(rs.getInt(4));
				c.setKm(rs.getDouble(5));
			}
		} catch (SQLException e) {
			System.out.println("obtener -> error al obtener el "
					+ "coche con id " + idCoche);
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}
		
		
		return c;
	}

	
	
	/**
	 * Método que da de baja un coche de la base de datos a partir de su ID
	 * 
	 * @param idCoche ID del coche a partir del cual damos de baja.
	 * @return true si la baja se completó con éxito y false si no se pudo realizar.
	 */
	@Override
	public boolean baja(int idCoche) {
		if(!abrirConexion()){
			return false;
		}
		
		boolean borrado = true;
		String query = "delete from coches where id = ?";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			//sustituimos la primera interrgante por la id
			ps.setInt(1, idCoche);
			
			int numeroFilasAfectadas = ps.executeUpdate();
			if(numeroFilasAfectadas == 0)
				borrado = false;
		} catch (SQLException e) {
			System.out.println("baja -> No se ha podido dar de baja el coche con id " + idCoche);
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}
		return borrado; 
	}


	/**
	 * Método para modificar un coche segun su ID.
	 * 
	 * @param c el coche que contiene la nueva información.
	 * @return true si la modificacion fue exitosa y false si no se pudo realizar.
	 */
	@Override
	public boolean modificarCoche(Coche c) {
		if(!abrirConexion()){
			return false;
		}
		boolean modificado = true;
		String query = "update coches set Marca=?, Year=?, YearFabricar=?, Km=? WHERE ID=?";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, c.getMarca());
			ps.setInt(2, c.getYear());
			ps.setInt(3, c.getYearFabricar());
			ps.setDouble(4, c.getKm());
			ps.setInt(5, c.getId());
			
			int numeroFilasAfectadas = ps.executeUpdate();
			if(numeroFilasAfectadas == 0)
				modificado = false;
			else
				modificado = true;
		} catch (SQLException e) {
			System.out.println("modificar -> error al modificar el coche " + c);
			modificado = false;
			e.printStackTrace();
		} finally{
			cerrarConexion();
		}
		
		return true;
	}

	
	
	/**
	 * Método para listar todos los coches almacenados en la base de datos.
	 *
	 * @return La lista de coches.
	 */
	@Override
	public List<Coche> listarTodosLosCoches() {
		if(!abrirConexion()){
			return null;
		}		
		List<Coche> listaCoches = new ArrayList<>();
		
		String query = "select ID,Marca,Year,YearFabricar,Km from coches";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Coche c = new Coche();
				c.setId(rs.getInt(1));
				c.setMarca(rs.getString(2));
				c.setYear(rs.getInt(3));
				c.setYearFabricar(rs.getInt(4));
				c.setKm(rs.getDouble(5));
				
				listaCoches.add(c);
			}
		} catch (SQLException e) {
			System.out.println("listar -> error al obtener los coches");
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}
		
		
		return listaCoches;
	}

}
