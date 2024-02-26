package gestor;

import java.util.List;

import entidad.Autor;
import persistencia.DaoAutorJPA;
import persistencia.interfaz.DaoAutor;

public class GestorAutor {
	
	private DaoAutor daoAutor = new DaoAutorJPA();
	
	/**
	 * Metodo que sirve para dar de alta un autor en la BBDD
	 * 
	 * @param autor Objeto autor a dar de alta
	 * @return true si se ha agregado correctamente y false si no se ha agregado.
	 */
	public boolean agregar(Autor autor) {
		
			boolean estaAgregado = daoAutor.agregar(autor);
			
			if(estaAgregado) {
				return true; 
			}else {
				return false;
			}
		}
	
	
	public List<Autor> autoresLibros(){
		List<Autor> lista = daoAutor.autoresLibros();
		return lista;
		
	}
		
	}


