package persistencia;

import java.util.ArrayList;
import java.util.List;

import entidad.Autor;
import entidad.Libreria;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import persistencia.interfaz.DaoLibreria;

public class DaoLibreriaJPA implements DaoLibreria {

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
	public boolean agregar(Libreria libreria) {
		if (!abrirConexion()) {
			return false;
		}

		// Siempre que cambiemos la BBDD en JPA es obligatorio abrir una
		// transacción
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(libreria);
		et.commit();
		cerrarConexion();
		return true;
	}

	@Override
	public List<Libreria> libreriasLibro() {
		if (!abrirConexion()) {
			return null;
		}
		
		List<Libreria> lista = new ArrayList<>();
		// para hacer la consulta debemos de usar JPQL
		Query query = em.createQuery("SELECT l from Libreria l left join l.libros");
		try {
			lista = (List<Libreria>) query.getResultList();
			
			for(Libreria l : lista) {
				System.out.println(l);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

}
