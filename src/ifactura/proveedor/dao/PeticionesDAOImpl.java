package ifactura.proveedor.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import ifactura.proveedor.model.Peticiones;

public class PeticionesDAOImpl implements PeticionesDAO {
	
	private static PeticionesDAOImpl instance;
	
	public PeticionesDAOImpl(){
	}
	
	public static PeticionesDAOImpl getInstance() {
		if (instance == null) {
			instance = new PeticionesDAOImpl();
		}
		return instance;
	}

	@Override
	public Peticiones create(String correo, String compania, String texto) {
		EntityManager em = EMFService.get().createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		Peticiones peticion = new Peticiones(correo, compania, texto);
		transaction.begin();
		em.persist(peticion);
		transaction.commit();
		em.close();
		
		return peticion;
	}

	@Override
	public List<Peticiones> readAll() {
		EntityManager em = EMFService.get().createEntityManager();
		
		Query q = em.createQuery("select t from Peticiones t");

		List<Peticiones> peticiones = q.getResultList();
		em.close();
		return peticiones;
	}

	@Override
	public List<Peticiones> readCorreo(String correo) {
		EntityManager em = EMFService.get().createEntityManager();
		
		Query q = em.createQuery("select t from Peticiones t where t.correo = :correo");
	    q.setParameter("correo", correo);

		List<Peticiones> peticiones = q.getResultList();
		em.close();
		return peticiones;
	}
	
	@Override
	public List<Peticiones> readCompania(String compania) {
		EntityManager em = EMFService.get().createEntityManager();
		
		Query q = em.createQuery("select t from Peticiones t where t.compania = :compania");
	    q.setParameter("compania", compania);

		List<Peticiones> peticiones = q.getResultList();
		em.close();
		return peticiones;
	}

	@Override
	public void update(Peticiones peticion) {
		EntityManager em = EMFService.get().createEntityManager();
		
		em.merge(peticion);
				
		em.close();

	}

	@Override
	public void remove(String peticion) {
		EntityManager em = EMFService.get().createEntityManager();
		try{
		   Peticiones borrar = em.find(Peticiones.class, peticion);
		   em.remove(borrar);
		} finally{
		   em.close();
		}

	}

}