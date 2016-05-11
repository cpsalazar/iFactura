package ifactura.proveedor.servlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import ifactura.proveedor.dao.IFacturaDAO;
import ifactura.proveedor.dao.IFacturaDAOImpl;
import ifactura.proveedor.model.IFactura;

@SuppressWarnings("serial")
public class ISST_G09_HistorialServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		IFacturaDAO dao = IFacturaDAOImpl.getInstance();
		
		String user = req.getUserPrincipal().getName();
		
		List<IFactura> subastas = dao.readIFactura();
		List<IFactura> historial = new ArrayList<IFactura>();
		
		for (int i = 0; i < subastas.size(); i++){
			if (subastas.get(i).getParticipantes().size() > 0){
				if (subastas.get(i).getParticipantes().contains(user)){
					historial.add(subastas.get(i));
				}
			}
		}
		
		req.getSession().setAttribute("miliActual", new Date().getTime());
		req.getSession().setAttribute("historial", historial);
		
		resp.sendRedirect("/proveedor/pages/historial.jsp");
		
	}

}
