package ifactura.proveedor.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import ifactura.proveedor.model.Users;

public class UsersDAOImpl implements UsersDAO {
	
	private static UsersDAOImpl instance;

	public UsersDAOImpl() {
	}
	
	public static UsersDAOImpl getInstance(){
		if (instance == null)
			instance = new UsersDAOImpl();
		return instance;
	}
	
	@Override
	public Users create(String correo, String compania) {
		
		EntityManager em = EMFService.get().createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		Users user = new Users(correo, compania);
		transaction.begin();
		em.persist(user);
		transaction.commit();
		em.close();
		
		return user;
	}

	@Override
	public List<Users> readAll() {
		
		EntityManager em = EMFService.get().createEntityManager();
		
		Query q = em.createQuery("select t from Users t");

		List<Users> usuarios = q.getResultList();
		usuarios.size();
		em.close();
		return usuarios;
	}

	@Override
	public Users readCorreo(String correo) throws Exception{
		
		EntityManager em = EMFService.get().createEntityManager();
		Users user = em.find(Users.class, correo);
		if (user == null){
			throw new Exception("No se encuentra el User con correo: " + correo);
		}
		em.close();
		return user;
	}

	@Override
	public List<Users> readCompania(String compania) {
		
		EntityManager em = EMFService.get().createEntityManager();
		
		Query q = em.createQuery("select t from Users t where t.compania = :compania");
	    q.setParameter("compania", compania);

		List<Users> usuarios = q.getResultList();
		usuarios.size();
		em.close();
		return usuarios;
	}

	@Override
	public void update(Users usuario) {
		
		EntityManager em = EMFService.get().createEntityManager();
		
		em.merge(usuario);
				
		em.close();
	}

	@Override
	public void remove(String correo) {
		
		EntityManager em = EMFService.get().createEntityManager();
		try{
		   Users usuario = em.find(Users.class, correo);
		   em.remove(usuario);
		} finally{
		   em.close();
		}
	}

}
