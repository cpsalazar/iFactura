package ifactura.proveedor.servlet;

import javax.servlet.http.*;

import ifactura.proveedor.dao.UsersDAO;
import ifactura.proveedor.dao.UsersDAOImpl;

@SuppressWarnings("serial")
public class ISST_G09_SubastasServlet extends HttpServlet {

	public void init(){
		
		UsersDAO dao1 = UsersDAOImpl.getInstance();
		
		dao1.create("hectorbm94@gmail.com", "Movistar");
		dao1.create("oscarvb94@gmail.com", "Vodafone");
		dao1.create("cobealex@gmail.com", "Orange");
		dao1.create("cpsalazar17@gmail.com", "Yoigo");
		dao1.create("ifacturag09@gmail.com", "iFactura");
		
		//AQUI LLENAMOS LOS MODELOS DE LA PARTE CLIENTE.
	}
}