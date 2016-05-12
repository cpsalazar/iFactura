package ifactura.proveedor.dao;

import java.util.List;

import ifactura.proveedor.model.Users;


public interface UsersDAO {
	
	public Users create(String correo, String compania);
	public List<Users> readAll();
	public Users readCorreo(String correo) throws Exception;
	public List<Users> readCompania(String compania);
	public void update(Users usuario);
	public void remove(String correo);
}
