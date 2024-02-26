package gestor;


import entidad.Editorial;
import persistencia.DaoEditorialJPA;
import persistencia.interfaz.DaoEditorial;

public class GestorEditorial {
	
	private DaoEditorial daoEditorial = new DaoEditorialJPA();
	
	
	/**
	 * Metodo que sirve para dar de alta una editorial en la BBDD
	 * 
	 * @param editorial Objeto editorial a dar de alta
	 * @return true si se ha agregado correctamente y false si no se ha agregado.
	 */
	public boolean agregar(Editorial editorial) {
		
			boolean estaAgregado = daoEditorial.agregar(editorial);
			
			if(estaAgregado) {
				return true; 
			}else {
				return false;
			}
		}

}
