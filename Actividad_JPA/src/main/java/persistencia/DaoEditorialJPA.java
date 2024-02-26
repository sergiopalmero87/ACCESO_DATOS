package persistencia;

import entidad.Autor;
import entidad.Editorial;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import persistencia.interfaz.DaoEditorial;



public class DaoEditorialJPA implements DaoEditorial{
	
	private EntityManager em;
	
	private boolean abrirConexion(){
		try {
			EntityManagerFactory factoria = Persistence.createEntityManagerFactory("ActividadJPA");
			em = factoria.createEntityManager();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private boolean cerrarConexion(){
		try {
			em.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean agregar(Editorial editorial) {
		if(!abrirConexion()) {
			return false;
		}
		//Siempre que cambiemos la BBDD en JPA es obligatorio abrir una
		//transacción
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(editorial);
		et.commit();
		cerrarConexion();
		return true;
	}

}
