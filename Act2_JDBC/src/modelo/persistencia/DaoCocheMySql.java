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
	
	
	@Override
	public boolean alta(Coche c) {
	    if (!abrirConexion()) {
	        return false;
	    }
	    boolean alta = true;

	    String query = "insert into coches (ID, Marca, Modelo, AnioFabricacion, Km) values (?, ?, ?, ?, ?)";
	    try {
	        // Preparamos la query con valores parametrizables (?)
	        PreparedStatement ps = conexion.prepareStatement(query);
	        ps.setInt(1, c.getId());
	        ps.setString(2, c.getMarca());
	        ps.setString(3, c.getModelo());
	        ps.setInt(4, c.getAnioFabricacion());
	        ps.setDouble(5, c.getKm());

	        int numeroFilasAfectadas = ps.executeUpdate();
	        if (numeroFilasAfectadas == 0) {
	            alta = false;
	        }
	    } catch (SQLException e) {
	        System.out.println("alta -> Error al insertar: " + c);
	        alta = false;
	        e.printStackTrace();
	    } finally {
	        cerrarConexion();
	    }

	    return alta;
	}

	
	@Override
	public Coche listarUnCoche(int idCoche) {
		if(!abrirConexion()){
			return null;
		}		
		Coche c = null;
		
		String query = "select ID, Marca, Modelo, AnioFabricacion, Km from coches "
				+ "where id = ?";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setInt(1, idCoche);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				c = new Coche();
				c.setId(rs.getInt(1));
				c.setMarca(rs.getString(2));
				c.setModelo(rs.getString(3));
				c.setAnioFabricacion(rs.getInt(4));
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


	@Override
	public boolean modificarCoche(Coche c) {
		if(!abrirConexion()){
			return false;
		}
		
		String query = "update coches set Marca=?, Modelo=?, AnioFabricacion=?, Km=? WHERE ID=?";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, c.getMarca());
			ps.setString(2, c.getModelo());
			ps.setInt(3, c.getAnioFabricacion());
			ps.setDouble(4, c.getKm());
			ps.setInt(5, c.getId());
			
			int numeroFilasAfectadas = ps.executeUpdate();
			if(numeroFilasAfectadas == 0) {
				return false;
			}else {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("modificar -> error al modificar el coche " + c);
			return false;
		} finally{
			cerrarConexion();
		}
	}

	
	@Override
	public List<Coche> listarTodosLosCoches() {
		if(!abrirConexion()){
			return null;
		}		
		List<Coche> listaCoches = new ArrayList<>();
		
		String query = "select ID, Marca, Modelo, AnioFabricacion, Km from coches";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Coche c = new Coche();
				c.setId(rs.getInt(1));
				c.setMarca(rs.getString(2));
				c.setModelo(rs.getString(3));
				c.setAnioFabricacion(rs.getInt(4));
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
