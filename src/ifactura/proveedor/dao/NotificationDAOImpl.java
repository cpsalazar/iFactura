package ifactura.proveedor.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import ifactura.emf.EMFService;
import ifactura.proveedor.model.Notification;

public class NotificationDAOImpl implements NotificationDAO{
	
	private static NotificationDAOImpl instance;
	
	private NotificationDAOImpl(){
	}
	
	public static NotificationDAOImpl getInstance() {
		if (instance == null) {
			instance = new NotificationDAOImpl();
		}
		return instance;
	}
	
	@Override
	public Notification create(String correo, String texto, String titulo, String imagen) {
		EntityManager em = EMFService.get().createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		Notification notification = new Notification(correo, texto,titulo, imagen);
		transaction.begin();
		em.persist(notification);
		transaction.commit();
		em.close();
		
		return notification;
	}
	
	@Override
	public List<Notification> readAll() {
		EntityManager em = EMFService.get().createEntityManager();
		
		Query q = em.createQuery("select t from Notification t");

		List<Notification> notificaciones = q.getResultList();
		em.close();
		return notificaciones;
	}
	
	@Override
	public List<Notification> readCorreo(String correo) {
		
		EntityManager em = EMFService.get().createEntityManager();
		
		Query q = em.createQuery("select t from Notification t where t.correo = :correo");
	    q.setParameter("correo", correo);

		List<Notification> notificaciones = q.getResultList();
		em.close();
		return notificaciones;
	}
	
	@Override
	public void update(Notification notification) {
		
		EntityManager em = EMFService.get().createEntityManager();
		
		em.merge(notification);
				
		em.close();
	}
	
	@Override
	public void remove(String texto) throws Exception{
		
		EntityManager em = EMFService.get().createEntityManager();
		try{
		   Notification notificacion = em.find(Notification.class, texto);
		   if (notificacion == null){
				throw new Exception("No se encuentra la notificacion con id: " + texto);
			}
		   em.remove(notificacion);
		} finally{
		   em.close();
		}
	}

	@Override
	public Notification readID(String texto) throws Exception{
		EntityManager em = EMFService.get().createEntityManager();
		Notification not = em.find(Notification.class, texto);
		if (not == null){
			throw new Exception("No se encuentra la notificacion con id: " + texto);
		}
		return not;
	}
}