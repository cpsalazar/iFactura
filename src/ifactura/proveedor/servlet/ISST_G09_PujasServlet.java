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
	
		List<IFactura> subasta = dao.readIFactura_id((long) mensaje);
		List<Users> usuariog = dao1.readCompania(subasta.get(0).getGanadorActual());
		if (subasta.get(0).getPujaActual() < Double.parseDouble(req.getParameter("puja"))) {
			alerta = "La puja introducida debe mejorar la actual";
		} else if ((Double.parseDouble(req.getParameter("puja")) > 0) && ((Double.parseDouble(req.getParameter("puja"))*4)%1 == 0)) {	
			subasta.get(0).setPujaActual(Double.parseDouble (req.getParameter("puja")));
			texto = subasta.get(0).getGanadorActual()+texto;
			String user = req.getUserPrincipal().getName();
			String compania = dao1.readCorreo(user).get(0).getCompania();
			if (usuariog.size() > 0) {
				dao2.create(usuariog.get(0).getCorreo().toString(), texto, titulo, imagen);
			}
			subasta.get(0).setGanadorActual(compania);
			dao.update(subasta.get(0));
			alerta = "Vas ganando la subasta";
		}

		req.getSession().setAttribute("puja", "true");
		req.getSession().setAttribute("alerta", alerta);
		req.getSession().setAttribute("subastas", new ArrayList<IFactura>(dao.readIFactura()));
		
		List<Users> usuarios = dao1.readCorreo(req.getUserPrincipal().getName());
		boolean aux = false;
		
		if (usuarios.size()>0){
			List<String> participantes = subasta.get(0).getParticipantes();
			if (participantes.size()>0){
				for (int i=0; i<participantes.size(); i++){
					if (participantes.get(i).equals(usuarios.get(0).getCorreo())){
						aux = true;
					}
				}
			}
			if (aux == false){
				subasta.get(0).setParticipantes(usuarios.get(0).getCorreo());
				dao.update(subasta.get(0));
			}
		}
		
		resp.sendRedirect("/isst_g09_ifactura");

	}
}