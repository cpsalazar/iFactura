package ifactura.cliente.dao;

import java.util.List;

import ifactura.cliente.model.FacturaTelefono;

/**
 * The Interface FacturaTelefonoDao.
 */
public interface FacturaTelefonoDao {

	/**
	 * Creates the.
	 *
	 * @param facturaTelefono
	 *            the factura telefono
	 * @return the usuario cliente
	 */
	FacturaTelefono create(FacturaTelefono facturaTelefono);

	/**
	 * Removes the.
	 *
	 * @param idFactura
	 *            the id factura
	 */
	void remove(Long idFactura);

	/**
	 * Merge.
	 *
	 * @param facturaTelefono
	 *            the factura telefono
	 * @return the usuario cliente
	 */
	FacturaTelefono merge(FacturaTelefono facturaTelefono);

	/**
	 * Gets the usuario.
	 *
	 * @param idFactura
	 *            the id factura
	 * @return the usuario
	 */
	FacturaTelefono getUsuario(Long idFactura);

	/**
	 * Read facturas.
	 *
	 * @return the list
	 */
	public List<FacturaTelefono> readFacturas();

	/**
	 * Gets the facturas by id.
	 *
	 * @param idUsuario
	 *            the id usuario
	 * @return the facturas by id
	 */
	List<FacturaTelefono> getFacturasById(Long idUsuario);

}