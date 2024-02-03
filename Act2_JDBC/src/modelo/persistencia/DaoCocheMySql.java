package modelo.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
	
	

	@Override
	public boolean alta(Coche c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean baja(int idCoche) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Coche listarUnCoche(int idCoche) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Coche modificarCoche(Coche c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Coche> listarTodosLosCoches() {
		// TODO Auto-generated method stub
		return null;
	}

}
