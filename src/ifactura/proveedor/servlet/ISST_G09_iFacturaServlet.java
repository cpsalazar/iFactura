package ifactura.proveedor.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import ifactura.proveedor.dao.IFacturaDAO;
import ifactura.proveedor.dao.IFacturaDAOImpl;
import ifactura.proveedor.dao.PeticionesDAO;
import ifactura.proveedor.dao.PeticionesDAOImpl;
import ifactura.proveedor.model.Peticiones;
import ifactura.proveedor.dao.UsersDAO;
import ifactura.proveedor.dao.UsersDAOImpl;
import ifactura.proveedor.model.IFactura;
import ifactura.proveedor.dao.NotificationDAO;
import ifactura.proveedor.dao.NotificationDAOImpl;
import ifactura.proveedor.model.Notification;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@SuppressWarnings("serial")
public class ISST_G09_iFacturaServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		resp.setCharacterEncoding("UTF-8");

		UserService userService = UserServiceFactory.getUserService();
		String url = userService.createLoginURL(req.getRequestURI());
		String urlLinktext = "Login";
		String user = null;
		String mov = "hectorbm94@gmail.com";
		String vod = "oscarvb94@gmail.com";
		String ora = "cobealex@gmail.com";
	    String yoi = "cpsalazar17@gmail.com";
	    String move = "Movistar";
	    String vode = "Vodafone";
	    String orae = "Orange";
	    String yoie = "Yoigo";
	    String texto = "";
	    String titulo = "Subasta finalizada";
	    String imagen = "end.png";
		List<IFactura> listsubas = null;
		String alerta = null;
		String compania = null;
		
		if (req.getSession().getAttribute("puja") == null) {
			req.getSession().setAttribute("alerta", alerta);
		} else {
			req.getSession().setAttribute("puja", null);
		}
		
		req.getSession().setAttribute("mensaje", null);
		
		NotificationDAO daonot = NotificationDAOImpl.getInstance();
		IFacturaDAO dao = IFacturaDAOImpl.getInstance();
		UsersDAO dao1 = UsersDAOImpl.getInstance();
		PeticionesDAO dao2 = PeticionesDAOImpl.getInstance();
		
		RequestDispatcher view = req.getRequestDispatcher("/proveedor/pages/login.jsp");

		if (req.getUserPrincipal() != null) {
			
			user = req.getUserPrincipal().getName();
	
			if  (dao.readIFactura().size() > 0){
				listsubas = dao.readIFactura();
				for (IFactura f : listsubas) {
					if(f.getFechaFin() < new Date().getTime() && !f.getInformado()) {
						f.setInformado(true);
						dao.update(f);
						texto = move+", ha finalizado la subasta ("+f.getDescripcion()+").";
						daonot.create(mov, texto, titulo, imagen);
						texto = vode+", ha finalizado la subasta ("+f.getDescripcion()+").";
						daonot.create(vod, texto, titulo, imagen);
						texto = orae+", ha finalizado la subasta ("+f.getDescripcion()+").";
						daonot.create(ora, texto, titulo, imagen);
						texto = yoie+", ha finalizado la subasta ("+f.getDescripcion()+").";
						daonot.create(yoi, texto, titulo, imagen);
						
						if (f.getGanadorActual() != null){
							Properties props = new Properties();
							Session session = Session.getDefaultInstance(props, null);

							String msgBody = "Ha ganado la subasta (" + f.getDescripcion() + "), nos pondremos en contacto con usted para que nos indique la oferta que le realizar� a los usuarios que comprenden la subasta. Recuerde que estos usuarios permanecer�n en el anonimato";

							try {
								Message msg = new MimeMessage(session);
								msg.setFrom(new InternetAddress("subasta@ifactura-integrado.appspotmail.com", "iFactura"));
								msg.addRecipient(Message.RecipientType.TO, new InternetAddress(dao1.readCompania(f.getGanadorActual()).get(0).getCorreo(), f.getGanadorActual()));
								msg.setSubject("Ganador subasta");
								msg.setText(msgBody);
								Transport.send(msg);

							    } catch (AddressException e) {
							        // ...
							    } catch (MessagingException e) {
							        // ...
							    }
						}
					}
				}
			}
			
			if (daonot.readCorreo(user).size() > 0){
				try {					
					req.getSession().setAttribute("notificaciones", new ArrayList<Notification>(daonot.readCorreo(user)));
				} catch (Exception e) {
					e.printStackTrace();
				}			
			} else {
				req.getSession().setAttribute("notificaciones", null);
			}
			if (dao1.readCorreo(user).size() > 0){
				try {
					List<Peticiones> comprobacion = dao2.readCorreo(user);
					if (comprobacion.size() > 0){
						req.getSession().setAttribute("peticion", new ArrayList<Peticiones>(dao2.readCorreo(user)));
					} else {
						req.getSession().setAttribute("peticion", null);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}			
				compania = dao1.readCorreo(user).get(0).getCompania();
				//req.getSession().setAttribute("notificaciones", new ArrayList<Notification>(daonot.readCorreo(user)));
			} else {
				user = null;
				req.getSession().setAttribute("mensaje", "No tiene permisos para acceder a esta aplicación");
			}
			
			url = userService.createLogoutURL(req.getRequestURI());
			urlLinktext = "Logout";
			view = req.getRequestDispatcher("/proveedor/pages/index.jsp");	
		} 
				
		req.getSession().setAttribute("user", compania);
		req.getSession().setAttribute("url", url);
		req.getSession().setAttribute("urlLinktext", urlLinktext);
		req.getSession().setAttribute("miliActual", new Date().getTime());
		req.getSession().setAttribute("subastas", new ArrayList<IFactura>(dao.readIFactura()));
		req.getSession().setAttribute("peticiones", new ArrayList<Peticiones>(dao2.readAll()));

		try {
			view.forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
}