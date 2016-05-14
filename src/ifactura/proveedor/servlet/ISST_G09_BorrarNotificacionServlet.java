package ifactura.proveedor.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import ifactura.proveedor.dao.NotificationDAO;
import ifactura.proveedor.dao.NotificationDAOImpl;
import ifactura.proveedor.model.Notification;

@SuppressWarnings("serial")
public class ISST_G09_BorrarNotificacionServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		NotificationDAO daonot = NotificationDAOImpl.getInstance();

		if (req.getUserPrincipal() != null) {

			String user = req.getUserPrincipal().getName();
			if (daonot.readCorreo(user).size() > 0){
				try {
					List<Notification> comprobacion = daonot.readCorreo(user);
					for (Notification noti : comprobacion) {
						String texto = noti.getTexto();
						daonot.remove(texto);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}			
			} 
		}
		resp.sendRedirect("/isst_g09_ifactura");
	}
}
