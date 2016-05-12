package ifactura.proveedor.servlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import ifactura.proveedor.dao.IFacturaDAO;
import ifactura.proveedor.dao.IFacturaDAOImpl;
import ifactura.proveedor.dao.NotificationDAO;
import ifactura.proveedor.dao.NotificationDAOImpl;
import ifactura.proveedor.dao.UsersDAO;
import ifactura.proveedor.dao.UsersDAOImpl;
import ifactura.proveedor.model.IFactura;
import ifactura.proveedor.model.Users;

@SuppressWarnings("serial")
public class ISST_G09_PujasServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		int mensaje = 0;
		String texto = ", han superado tu puja.";
		String titulo = "Puja Superada";
		String imagen = "superado.png";
		
		try {
			mensaje = Integer.parseInt (req.getParameter("id"));
		} catch (Exception e) {
	
		}

		IFacturaDAO dao = IFacturaDAOImpl.getInstance();
		UsersDAO dao1 = UsersDAOImpl.getInstance();
		NotificationDAO dao2 = NotificationDAOImpl.getInstance();
		
		String alerta = null;
		//alerta = "Para que tu puja sea válida debe debe ser múltiplo de 25 céntimos";
	
		IFactura subasta = null;
		try {
			subasta = dao.readIFactura_id((long) mensaje);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List<Users> usuariog = dao1.readCompania(subasta.getGanadorActual());
		if (subasta.getPujaActual() < Double.parseDouble(req.getParameter("puja"))) {
			alerta = "La puja introducida debe mejorar la actual";
		} else if ((Double.parseDouble(req.getParameter("puja")) > 0) && ((Double.parseDouble(req.getParameter("puja"))*4)%1 == 0)) {	
			subasta.setPujaActual(Double.parseDouble (req.getParameter("puja")));
			texto = subasta.getGanadorActual()+texto;
			String user = req.getUserPrincipal().getName();
			String compania = null;
			try {
				compania = dao1.readCorreo(user).getCompania();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (usuariog.size() > 0) {
				dao2.create(usuariog.get(0).getCorreo().toString(), texto, titulo, imagen);
			}
			subasta.setGanadorActual(compania);
			dao.update(subasta);
			alerta = "Vas ganando la subasta";
		}

		req.getSession().setAttribute("puja", "true");
		req.getSession().setAttribute("alerta", alerta);
		req.getSession().setAttribute("subastas", new ArrayList<IFactura>(dao.readIFactura()));
		
		Users usuario = null;
		try {
			usuario = dao1.readCorreo(req.getUserPrincipal().getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean aux = false;
		
		if (usuario != null){
			List<String> participantes = new ArrayList<String>();
			try {
				participantes = subasta.getParticipantes();
				if (participantes.size()>0){
					for (int i=0; i<participantes.size(); i++){
						if (participantes.get(i).equals(usuario.getCorreo())){
							aux = true;
						}
					}
				}
				if (aux == false){
					subasta.setParticipantes(usuario.getCorreo());
					dao.update(subasta);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		resp.sendRedirect("/isst_g09_ifactura");

	}
}