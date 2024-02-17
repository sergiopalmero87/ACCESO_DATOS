package gestor;

import entidad.Autor;
import persistencia.DaoAutorJPA;
import persistencia.interfaz.DaoAutor;

public class GestorAutor {
	
	private DaoAutor daoAutor = new DaoAutorJPA();
	
	
	public boolean agregar(Autor autor) {
		
			boolean estaAgregado = daoAutor.agregar(autor);
			
			if(estaAgregado) {
				return true; 
			}else {
				return false;
			}
		}
		
	}


