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


import modelo.entidad.Coche;
import modelo.persistencia.interfaces.DaoCoche;

public class DaoCocheMySql implements DaoCoche{
	
private Connection con;
private Properties properties = new Properties();
private String url, user, password;

	
	public boolean abrirConexion(){
		
		// Creamos un vinculo con el fichero a traves de la clase FileInputStream en la variable entrada.
		// En el objeto properties se carga el contenido del fichero.
		try (FileInputStream entrada = new FileInputStream("config.properties")) {
            properties.load(entrada);

            // Obtenemos los valores del archivo properties
            url = properties.getProperty("jdbc.url");
            user= properties.getProperty("jdbc.user");
            password = properties.getProperty("jdbc.password");

        } catch (IOException e) {
            e.printStackTrace();
            
        }
		
		
		// Con el objeto con, obtenemos la conexion.
		try {
			con = DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	// Con el objeto con cerramos la conexion.
	public boolean cerrarConexion(){
		try {
			con.close();
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

	    //Inserta en la tabla coches esos valores:
	    String query = "insert into coches (ID, Marca, Modelo, AnioFabricacion, Km) values (?, ?, ?, ?, ?)";
	    try {
	        // Preparamos la query con valores parametrizables (?)
	        PreparedStatement ps = con.prepareStatement(query);
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
		
		//Dame los valores de la tabla coches donde el id es:
		String query = "select ID, Marca, Modelo, AnioFabricacion, Km from coches "
				+ "where id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, idCoche);
			
			//Como hacemos un "get" y no introducimos, borramos, actualizamos usamos ResultSet
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
		
		//Borra de la tabla coches donde el id es:
		String query = "delete from coches where id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
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
		
		//Actualiza la tabla coches. Pon esos valores donde el id es:
		String query = "update coches set Marca=?, Modelo=?, AnioFabricacion=?, Km=? WHERE ID=?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
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
		
		//Dame todos los valores de la tabla coches:
		String query = "select ID, Marca, Modelo, AnioFabricacion, Km from coches";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			
			//Como hacemos un "get" y no introducimos, borramos, actualizamos usamos ResultSet
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
