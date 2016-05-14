package ifactura.proveedor.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import ifactura.proveedor.dao.IFacturaDAO;
import ifactura.proveedor.dao.IFacturaDAOImpl;
import ifactura.proveedor.dao.NotificationDAO;
import ifactura.proveedor.dao.NotificationDAOImpl;
import ifactura.proveedor.model.IFactura;

@SuppressWarnings("serial")
public class ISST_G09_NuevaSubastaServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		IFacturaDAO dao = IFacturaDAOImpl.getInstance();
		NotificationDAO dao2 = NotificationDAOImpl.getInstance();
		
		String descripcion = req.getParameter("descripcion");
		String mov = "hectorbm94@gmail.com";
		String vod = "oscarvb94@gmail.com";
		String ora = "cobealex@gmail.com";
		String yoi = "cpsalazar17@gmail.com";
		String move = "Movistar";
		String vode = "Vodafone";
		String orae = "Orange";
		String yoie = "Yoigo";
		String texto = move+", hay una nueva subasta en la que puedes participar ("+descripcion+").";
		String titulo = "Nueva subasta";
		String imagen = "new.png";

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		sdf.setTimeZone(TimeZone.getTimeZone("Europe/Madrid"));
		/*for (String id : TimeZone.getAvailableIDs()) {
		    System.out.println(id);
		}*/
		String fecha = req.getParameter("fecha");
		
		List<IFactura> subastas = dao.readIFactura();


		int usuarios= Integer.parseInt(req.getParameter("usuarios"));
		double puja_inicial= Double.parseDouble(req.getParameter("puja_inicial"));

		Date fechaConHora = new Date();
		

		try {
				fechaConHora = sdf.parse(fecha);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		long milihastafin = fechaConHora.getTime();
		
		long id = subastas.size() + 1;
		List<String> participantes = new ArrayList<String>();
		
		
		dao.create(id, descripcion, usuarios, milihastafin, puja_inicial, null, participantes);
		dao2.create(mov, texto, titulo, imagen);
		texto = vode+", hay una nueva subasta en la que puedes participar ("+descripcion+").";
		dao2.create(vod, texto, titulo, imagen);
		texto = orae+", hay una nueva subasta en la que puedes participar ("+descripcion+").";
		dao2.create(ora, texto, titulo, imagen);
		texto = yoie+", hay una nueva subasta en la que puedes participar ("+descripcion+").";
		dao2.create(yoi, texto, titulo, imagen);
		
		resp.sendRedirect("/isst_g09_ifactura");

	}
}
