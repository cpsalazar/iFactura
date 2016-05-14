package ifactura.proveedor.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import ifactura.proveedor.dao.NotificationDAO;
import ifactura.proveedor.dao.NotificationDAOImpl;
import ifactura.proveedor.dao.PeticionesDAO;
import ifactura.proveedor.dao.PeticionesDAOImpl;

@SuppressWarnings("serial")
public class ISST_G09_PeticionesServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.setCharacterEncoding("UTF-8");

		String peticion = req.getParameter("peticion");
		String compania =  (String) req.getSession().getAttribute("user");
		String master = "ifacturag09@gmail.com";
		String titulo = "Nueva Petición";
		String imagenp = "peticion.png";
		String peticionl = "Tienes una petición pendiente ("+peticion+")";
		
		PeticionesDAO dao = PeticionesDAOImpl.getInstance();
		NotificationDAO dao2 = NotificationDAOImpl.getInstance();
		
		String user = req.getUserPrincipal().getName();

		if (user != null) {
			dao.create(user, compania, peticion);
			dao2.create(master, peticionl, titulo, imagenp);
		}
				
		resp.sendRedirect("/isst_g09_ifactura");
	}
}