package ifactura.proveedor.servlet;

import java.util.Date;

import javax.servlet.http.*;

import ifactura.cliente.dao.FacturaTelefonoDao;
import ifactura.cliente.dao.FacturaTelefonoDaoImpl;
import ifactura.proveedor.dao.UsersDAO;
import ifactura.proveedor.dao.UsersDAOImpl;
import ifactura.cliente.dao.UsuarioClienteDao;
import ifactura.cliente.dao.UsuarioClienteDaoImpl;
import ifactura.cliente.model.FacturaTelefono;
import ifactura.cliente.model.UsuarioCliente;

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
		
		UsuarioClienteDao dao2 = UsuarioClienteDaoImpl.getInstance();
		
		UsuarioCliente user1 = new UsuarioCliente("Jose Luis q");
		dao2.create(user1);
		UsuarioCliente user2 = new UsuarioCliente("Jose Luis w");
		dao2.create(user2);
		UsuarioCliente user3 = new UsuarioCliente("Jose Luis e");
		dao2.create(user3);
		UsuarioCliente user4 = new UsuarioCliente("Jose Luis r");
		dao2.create(user4);
		UsuarioCliente user5 = new UsuarioCliente("Jose Luis t");
		dao2.create(user5);
		UsuarioCliente user6 = new UsuarioCliente("Jose Luis y");
		dao2.create(user6);
		UsuarioCliente user7 = new UsuarioCliente("Jose Luis u");
		dao2.create(user7);
		UsuarioCliente user8 = new UsuarioCliente("Jose Luis i");
		dao2.create(user8);
		UsuarioCliente user9 = new UsuarioCliente("Jose Luis o");
		dao2.create(user9);
		UsuarioCliente user10 = new UsuarioCliente("Jose Luis p");
		dao2.create(user10);
		UsuarioCliente user11 = new UsuarioCliente("Jose Luis a");
		dao2.create(user11);
		UsuarioCliente user12 = new UsuarioCliente("Jose Luis s");
		dao2.create(user12);
		UsuarioCliente user13 = new UsuarioCliente("Jose Luis d");
		dao2.create(user13);
		UsuarioCliente user14 = new UsuarioCliente("Jose Luis f");
		dao2.create(user14);
		UsuarioCliente user15 = new UsuarioCliente("Jose Luis g");
		dao2.create(user15);
		UsuarioCliente user16 = new UsuarioCliente("Jose Luis h");
		dao2.create(user16);
		UsuarioCliente user17 = new UsuarioCliente("Jose Luis j");
		dao2.create(user17);
		UsuarioCliente user18 = new UsuarioCliente("Jose Luis k");
		dao2.create(user18);
		UsuarioCliente user19 = new UsuarioCliente("Jose Luis l");
		dao2.create(user19);
		UsuarioCliente user20 = new UsuarioCliente("Jose Luis jk");
		dao2.create(user20);
		UsuarioCliente user21 = new UsuarioCliente("Jose Luis z");
		dao2.create(user21);
		UsuarioCliente user22 = new UsuarioCliente("Jose Luis x");
		dao2.create(user22);
		UsuarioCliente user23 = new UsuarioCliente("Jose Luis c");
		dao2.create(user23);
		UsuarioCliente user24 = new UsuarioCliente("Jose Luis v");
		dao2.create(user24);
		UsuarioCliente user25 = new UsuarioCliente("Jose Luis b");
		dao2.create(user25);
		UsuarioCliente user26 = new UsuarioCliente("Jose Luis n");
		dao2.create(user26);
		UsuarioCliente user27 = new UsuarioCliente("Jose Luis m");
		dao2.create(user27);
		UsuarioCliente user28 = new UsuarioCliente("Jose Luis qq");
		dao2.create(user28);
		UsuarioCliente user29 = new UsuarioCliente("Jose Luis ww");
		dao2.create(user29);
		UsuarioCliente user30 = new UsuarioCliente("Jose Luis ee");
		dao2.create(user30);
		UsuarioCliente user31 = new UsuarioCliente("Jose Luis rr");
		dao2.create(user31);
		UsuarioCliente user32 = new UsuarioCliente("Jose Luis tt");
		dao2.create(user32);
		UsuarioCliente user33 = new UsuarioCliente("Jose Luis yy");
		dao2.create(user33);
		UsuarioCliente user34 = new UsuarioCliente("Jose Luis uu");
		dao2.create(user34);
		UsuarioCliente user35 = new UsuarioCliente("Jose Luis ii");
		dao2.create(user35);
		UsuarioCliente user36 = new UsuarioCliente("Jose Luis oo");
		dao2.create(user36);
		UsuarioCliente user37 = new UsuarioCliente("Jose Luis pp");
		dao2.create(user37);
		UsuarioCliente user38 = new UsuarioCliente("Jose Luis aa");
		dao2.create(user38);
		UsuarioCliente user39 = new UsuarioCliente("Jose Luis ss");
		dao2.create(user39);
		
		FacturaTelefonoDao dao3 = FacturaTelefonoDaoImpl.getInstance();
		
		Date fecha = new Date();
		
		FacturaTelefono factura1 = new FacturaTelefono(fecha, 1000.0, 1250.0, 30.0, 56.2, 14.2, user1.getId(), false);
		FacturaTelefono factura2 = new FacturaTelefono(fecha, 1000.0, 1250.0, 30.0, 56.2, 14.2, user2.getId(), true);
		FacturaTelefono factura3 = new FacturaTelefono(fecha, 1000.0, 1250.0, 30.0, 56.2, 14.2, user3.getId(), true);
		FacturaTelefono factura4 = new FacturaTelefono(fecha, 1000.0, 1250.0, 30.0, 56.2, 14.2, user4.getId(), false);
		FacturaTelefono factura5 = new FacturaTelefono(fecha, 1000.0, 1250.0, 30.0, 56.2, 14.2, user5.getId(), false);
		FacturaTelefono factura6 = new FacturaTelefono(fecha, 1000.0, 1250.0, 30.0, 56.2, 14.2, user6.getId(), false);
		FacturaTelefono factura7 = new FacturaTelefono(fecha, 1000.0, 1250.0, 30.0, 56.2, 14.2, user7.getId(), true);
		FacturaTelefono factura8 = new FacturaTelefono(fecha, 1000.0, 1250.0, 30.0, 56.2, 14.2, user8.getId(), false);
		FacturaTelefono factura9 = new FacturaTelefono(fecha, 1000.0, 1250.0, 30.0, 56.2, 14.2, user9.getId(), true);
		FacturaTelefono factura10 = new FacturaTelefono(fecha, 2000.0, 1250.0, 30.0, 56.2, 14.2, user10.getId(), true);
		FacturaTelefono factura11 = new FacturaTelefono(fecha, 2000.0, 1250.0, 30.0, 56.2, 14.2, user11.getId(), true);
		FacturaTelefono factura12 = new FacturaTelefono(fecha, 2000.0, 1250.0, 30.0, 56.2, 14.2, user12.getId(), false);
		FacturaTelefono factura13 = new FacturaTelefono(fecha, 2000.0, 1250.0, 30.0, 56.2, 14.2, user13.getId(), true);
		FacturaTelefono factura14 = new FacturaTelefono(fecha, 2000.0, 1250.0, 30.0, 56.2, 14.2, user14.getId(), true);
		FacturaTelefono factura15 = new FacturaTelefono(fecha, 2000.0, 1250.0, 30.0, 56.2, 14.2, user15.getId(), false);
		FacturaTelefono factura16 = new FacturaTelefono(fecha, 2000.0, 1250.0, 30.0, 56.2, 14.2, user16.getId(), true);
		FacturaTelefono factura17 = new FacturaTelefono(fecha, 2000.0, 1250.0, 30.0, 56.2, 14.2, user17.getId(), true);
		FacturaTelefono factura18 = new FacturaTelefono(fecha, 2000.0, 1250.0, 30.0, 56.2, 14.2, user18.getId(), false);
		FacturaTelefono factura19 = new FacturaTelefono(fecha, 2000.0, 1250.0, 30.0, 56.2, 14.2, user19.getId(), true);
		FacturaTelefono factura20 = new FacturaTelefono(fecha, 2000.0, 1250.0, 30.0, 56.2, 14.2, user20.getId(), true);
		FacturaTelefono factura21 = new FacturaTelefono(fecha, 2000.0, 1250.0, 30.0, 56.2, 14.2, user21.getId(), false);
		FacturaTelefono factura22 = new FacturaTelefono(fecha, 3000.0, 1250.0, 1000.0, 106.2, 30.2, user22.getId(), true);
		FacturaTelefono factura23 = new FacturaTelefono(fecha, 3000.0, 1250.0, 1000.0, 106.2, 30.2, user23.getId(), false);
		FacturaTelefono factura24 = new FacturaTelefono(fecha, 3000.0, 1250.0, 1000.0, 106.2, 30.2, user24.getId(), true);
		FacturaTelefono factura25 = new FacturaTelefono(fecha, 3000.0, 1250.0, 1000.0, 106.2, 30.2, user25.getId(), false);
		FacturaTelefono factura26 = new FacturaTelefono(fecha, 3000.0, 1250.0, 1000.0, 106.2, 30.2, user26.getId(), true);
		FacturaTelefono factura27 = new FacturaTelefono(fecha, 3000.0, 1250.0, 1000.0, 106.2, 30.2, user27.getId(), false);
		FacturaTelefono factura28 = new FacturaTelefono(fecha, 3000.0, 1250.0, 1000.0, 106.2, 30.2, user28.getId(), true);
		FacturaTelefono factura29 = new FacturaTelefono(fecha, 3000.0, 1250.0, 1000.0, 106.2, 30.2, user29.getId(), false);
		FacturaTelefono factura30 = new FacturaTelefono(fecha, 3000.0, 1250.0, 1000.0, 106.2, 30.2, user30.getId(), true);
		FacturaTelefono factura31 = new FacturaTelefono(fecha, 4000.0, 1250.0, 1000.0, 106.2, 30.2, user31.getId(), true);
		
		dao3.create(factura1);
		dao3.create(factura2);
		dao3.create(factura3);
		dao3.create(factura4);
		dao3.create(factura5);
		dao3.create(factura6);
		dao3.create(factura7);
		dao3.create(factura8);
		dao3.create(factura9);
		dao3.create(factura10);
		dao3.create(factura11);
		dao3.create(factura12);
		dao3.create(factura13);
		dao3.create(factura14);
		dao3.create(factura15);
		dao3.create(factura16);
		dao3.create(factura17);
		dao3.create(factura18);
		dao3.create(factura19);
		dao3.create(factura20);
		dao3.create(factura21);
		dao3.create(factura22);
		dao3.create(factura23);
		dao3.create(factura24);
		dao3.create(factura25);
		dao3.create(factura26);
		dao3.create(factura27);
		dao3.create(factura28);
		dao3.create(factura29);
		dao3.create(factura30);
		dao3.create(factura31);
		
	}
}