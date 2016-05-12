package ifactura.proveedor.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import ifactura.proveedor.model.IFactura;
import ifactura.proveedor.model.Notification;

public class IFacturaDAOImpl implements IFacturaDAO {

	private static IFacturaDAOImpl instance;
	
	private IFacturaDAOImpl() {
	}
	
	public static IFacturaDAOImpl getInstance() {
		if (instance == null)
			instance = new IFacturaDAOImpl();
		return instance;
	}
	
	@Override
	public IFactura create(Long id, String descripcion, int numUsuarios, long fechaFin, double pujaActual,
			String ganadorActual, List<String> participantes) {
		
		EntityManager em = EMFService.get().createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		IFactura subasta = new IFactura(id, descripcion, numUsuarios, fechaFin, pujaActual, ganadorActual, participantes);
		transaction.begin();
		em.persist(subasta);
		transaction.commit();
		em.close();
		
		return subasta;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IFactura> readIFactura() {
		
		EntityManager em = EMFService.get().createEntityManager();
		
		Query q = em.createQuery("select t from IFactura t");

		List<IFactura> subastas = q.getResultList();
		subastas.size();
		em.close();
		return subastas;
	}
	
	@Override
	public List<IFactura> readIFactura_descripcion(String descripcion) {
		
		EntityManager em = EMFService.get().createEntityManager();
		
		Query q = em.createQuery("select t from IFactura t where t.descripcion = :descripcion");
	    q.setParameter("descripcion", descripcion);

		List<IFactura> subastas = q.getResultList();
		subastas.size();
		em.close();
		return subastas;
	}

	@Override
	public List<IFactura> readIFactura_usuarios(int numUsuarios) {
		
		EntityManager em = EMFService.get().createEntityManager();
		
		Query q = em.createQuery("select t from IFactura t where t.numUsuarios = :numUsuarios");
	    q.setParameter("numUsuarios", numUsuarios);

		List<IFactura> subastas = q.getResultList();
		subastas.size();
		em.close();
		return subastas;
	}

	@Override
	public List<IFactura> readIFactura_compania(String ganadorActual) {

		EntityManager em = EMFService.get().createEntityManager();
		
		Query q = em.createQuery("select t from IFactura t where t.ganadorActual = :ganadorActual");
	    q.setParameter("ganadorActual", ganadorActual);

		List<IFactura> subastas = q.getResultList();
		subastas.size();
		em.close();
		return subastas;
	}

	@Override
	public List<IFactura> readIFactura_puja(double pujaActual) {

		EntityManager em = EMFService.get().createEntityManager();
		
		Query q = em.createQuery("select t from IFactura t where t.pujaActual = :pujaActual");
	    q.setParameter("pujaActual", pujaActual);

		List<IFactura> subastas = q.getResultList();
		subastas.size();
		em.close();
		return subastas;
	}
	
	@Override
	public List<IFactura> readIFactura_fecha(long fechaFin) {

		EntityManager em = EMFService.get().createEntityManager();
		
		Query q = em.createQuery("select t from IFactura t where t.fechaFin = :fechaFin");
	    q.setParameter("fechaFin", fechaFin);

		List<IFactura> subastas = q.getResultList();
		subastas.size();
		em.close();
		return subastas;
	}
	
	@Override
	public IFactura readIFactura_id(Long id) throws Exception{
		EntityManager em = EMFService.get().createEntityManager();
		IFactura subasta = em.find(IFactura.class, id);
		if (subasta == null){
			throw new Exception("No se encuentra la subasta con id: " + id);
		}
		em.close();
		return subasta;
	}

	@Override
	public void update(IFactura subasta) {
		
		EntityManager em = EMFService.get().createEntityManager();
		
		em.merge(subasta);
				
		em.close();
	}

	@Override
	public void delete(Long id) {
		
		EntityManager em = EMFService.get().createEntityManager();
		try{
		   IFactura subasta = em.find(IFactura.class, id);
		   em.remove(subasta);
		} finally{
		   em.close();
		}
	}
}
