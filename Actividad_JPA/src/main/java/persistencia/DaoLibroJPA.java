package persistencia;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Query;

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
	public List<Libro> getLibrosConEditoralYAutor() {
		if (!abrirConexion()) {
			return null;
		}
		
		List<Libro> lista = new ArrayList<>();
		Query query = em.createQuery("SELECT l FROM Libro l LEFT JOIN l.autor LEFT JOIN l.editorial");
	    
		try {
			lista = (List<Libro>)query.getResultList();
			
			for(Libro l : lista) {
				System.out.println(l);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public List<Libro> getlibrosYLibreria() {
		if (!abrirConexion()) {
			return null;
		}
		List<Libro> lista = new ArrayList<>();
		Query query = em.createQuery("SELECT l FROM Libro l LEFT JOIN l.librerias");
		try {
			lista = (List<Libro>)query.getResultList();
			
			for(Libro l : lista) {
				System.out.println(l);
			}
			
		} catch(Exception e){
			return null;
		}
		return lista;
	}
	
	
	
}
