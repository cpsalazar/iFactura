package ifactura.proveedor.servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import ifactura.proveedor.dao.NotificationDAO;
import ifactura.proveedor.dao.NotificationDAOImpl;
import ifactura.proveedor.dao.PeticionesDAO;
import ifactura.proveedor.dao.PeticionesDAOImpl;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@SuppressWarnings("serial")
public class ISST_G09_ValorarPropuestaServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		resp.setCharacterEncoding("UTF-8");
		String compania =  req.getParameter("compania");
		String peticion = req.getParameter("id");
		String aceptar = "Estimado " + compania + ", su propuesta (" + peticion + ") ha sido aceptada por el equipo de iFactura, cuando lancemos su subasta se le notificará por medio de la aplicación.";
		String rechazar = "Estimado " + compania + ", su propuesta (" + peticion + ") ha sido rechazada por el equipo de iFactura.";
		String aceptarn = "Su propuesta (" + peticion + ") ha sido aceptada.";
		String rechazarn = "Su propuesta (" + peticion + ") ha sido rechazada.";
		String aceptat= "Propuesta Aceptada";
		String rechazat = "Propuesta Rechazada";
		String textoe = "Pendiente de proponer la subasta (" + peticion+").";
		String peticionl = "Tienes una petición pendiente ("+peticion+")";
		String imagenn = "";
		String imagenp = "auction.png";
		String boton = req.getParameter("solicitud");

		PeticionesDAO dao = PeticionesDAOImpl.getInstance();
		NotificationDAO dao2 = NotificationDAOImpl.getInstance();
		
		String user = req.getUserPrincipal().getName();
		String correo = req.getParameter("correo");
		
		Properties props = new Properties();
	    Session session = Session.getDefaultInstance(props, null);

	      try {
	        Message msg = new MimeMessage(session);
	        msg.setFrom(new InternetAddress("valoracionSubasta@ifactura-proveedor.appspotmail.com", "Valoracion de subasta"));
	        msg.addRecipient(Message.RecipientType.TO, new InternetAddress(correo, "Estimado cliente"));
	        msg.setSubject("Valoracion de subasta");
	        if (boton.equals("aceptar")){
		        msg.setText(aceptar);
		        imagenn="aceptada.png";
		        dao2.create(correo,aceptarn, aceptat, imagenn);
		        dao2.create(user, textoe, "Propuesta Subasta", imagenp);
	        } else {
		        msg.setText(rechazar);
		        imagenn="rechazada.png";
		        dao2.create(correo, rechazarn, rechazat, imagenn);
	        }
	        Transport.send(msg);

	          } catch (AddressException e) {
	              // ...
	          } catch (MessagingException e) {
	              // ...
	          }

		if (user != null) {
			dao.remove(peticion);
		}		

		resp.sendRedirect("/isst_g09_ifactura");
	}
}