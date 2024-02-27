package persistencia;

import java.util.List;

import entidad.Libro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import persistencia.interfaz.DaoLibro;

public class DaoLibroJPA implements DaoLibro {

	private EntityManager em;

	private boolean abrirConexion() {
		try {
			EntityManagerFactory factoria = Persistence.createEntityManagerFactory("ActividadJPA");
			em = factoria.createEntityManager();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	private boolean cerrarConexion() {
		try {
			em.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean agregar(Libro libro) {
		if (!abrirConexion()) {
			return false;
		}

		// Siempre que cambiemos la BBDD en JPA es obligatorio abrir una
		// transacción
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(libro);
		et.commit();
		cerrarConexion();
		return true;

	}

	@Override
	public List<Libro> librosEditoralAutor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Libro> librosLibreria() {
		// TODO Auto-generated method stub
		return null;
	}

}
