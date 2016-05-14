package ifactura.cliente.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ifactura.cliente.model.FacturaTelefono;

public class FacturaTelefonoDaoImpl implements FacturaTelefonoDao {
	/** The instance. */
	private static FacturaTelefonoDaoImpl instance;

	/**
	 * Instantiates a new i factura dao impl.
	 */
	private FacturaTelefonoDaoImpl() {

	}

	/**
	 * Gets the single instance of IFacturaDaoImpl.
	 *
	 * @return single instance of IFacturaDaoImpl
	 */
	public static FacturaTelefonoDaoImpl getInstance() {
		if (instance == null) {
			instance = new FacturaTelefonoDaoImpl();
		}
		return instance;
	}

	@Override
	public FacturaTelefono create(FacturaTelefono facturaTelefono) {
		EntityManager em = EMFService.get().createEntityManager();
		em.persist(facturaTelefono);
		em.close();
		return facturaTelefono;

	}

	@Override
	public void remove(Long idFactura) {
		EntityManager em = EMFService.get().createEntityManager();
		FacturaTelefono facturaToRemove = em.find(FacturaTelefono.class, idFactura);
		if (facturaToRemove != null) {
			em.remove(facturaToRemove);
		}
		em.close();
	}

	@Override
	public FacturaTelefono merge(FacturaTelefono facturaTelefono) {
		EntityManager em = EMFService.get().createEntityManager();
		em.merge(facturaTelefono);
		em.close();
		return facturaTelefono;
	}

	@Override
	public List<FacturaTelefono> readFacturas() {
		EntityManager em = EMFService.get().createEntityManager();

		Query q = em.createQuery("select t from FacturaTelefono t");

		List<FacturaTelefono> facturas = q.getResultList();
		em.close();
		return facturas;
	}

	@SuppressWarnings("unchecked")
	@Override
	public FacturaTelefono getUsuario(Long idFactura) {
		EntityManager em = EMFService.get().createEntityManager();
		Query query = em.createQuery("select f from FacturaTelefono f where idFactura = :idFactura");
		query.setParameter("idFactura", idFactura);
		List<FacturaTelefono> facturas = query.getResultList();
		FacturaTelefono facturaReturn = null;
		if (!facturas.isEmpty() && facturas.size() == 1) {
			facturaReturn = facturas.get(0);
		} else {
			// Si llega a este punto tenemos un problema
		}
		em.close();
		return facturaReturn;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FacturaTelefono> getFacturasById(Long idUsuario) {
		EntityManager em = EMFService.get().createEntityManager();
		Query query = em.createQuery("select f from FacturaTelefono f where idUsuario = :idUsuario");
		query.setParameter("idUsuario", idUsuario);
		return query.getResultList();
	}
}