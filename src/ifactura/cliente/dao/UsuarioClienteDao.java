package ifactura.cliente.dao;

import ifactura.cliente.model.UsuarioCliente;

/**
 * The Interface UsuarioClienteDao.
 */
public interface UsuarioClienteDao {

	/**
	 * Creates the.
	 *
	 * @param usuarioCliente
	 *            the usuario cliente
	 * @return the usuario cliente
	 */
	UsuarioCliente create(UsuarioCliente usuarioCliente);

	/**
	 * Removes the.
	 *
	 * @param idUsario
	 *            the id usario
	 */
	void remove(Long idUsario);

	/**
	 * Merge.
	 *
	 * @param usuarioCliente
	 *            the usuario cliente
	 * @return the usuario cliente
	 */
	UsuarioCliente merge(UsuarioCliente usuarioCliente);

	/**
	 * Gets the usuario.
	 *
	 * @param idUsuario
	 *            the id usuario
	 * @return the usuario
	 */
	UsuarioCliente getUsuario(Long idUsuario);

	/**
	 * Gets the usuario by name.
	 *
	 * @param user
	 *            the user
	 * @return the usuario by name
	 */
	UsuarioCliente getUsuarioByName(String user);

}
