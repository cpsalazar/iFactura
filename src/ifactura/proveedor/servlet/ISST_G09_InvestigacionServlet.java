package ifactura.proveedor.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ifactura.cliente.dao.FacturaTelefonoDao;
import ifactura.cliente.dao.FacturaTelefonoDaoImpl;
import ifactura.cliente.model.FacturaTelefono;

@SuppressWarnings("serial")
public class ISST_G09_InvestigacionServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.setCharacterEncoding("UTF-8");

		// BUSQUEDA DE PATRONES

		req.getSession().setAttribute("DatosdeMas", null);
		req.getSession().setAttribute("VozdeMas", null);
		req.getSession().setAttribute("Tarde", null);
		req.getSession().setAttribute("Mananas", null);

		FacturaTelefonoDao dao = FacturaTelefonoDaoImpl.getInstance();

		List<FacturaTelefono> facturas = dao.readFacturas();

		double DatosMedia = 0;
		double VozMedia = 0;

		double totaldatos = 0;
		double totalvoz = 0;
		double totaltarde = 0;
		double totalmananas = 0;

		for (FacturaTelefono fac : facturas) {
			if (fac.getDatosConsumidos() != null && fac.getDatosContratados() != null){
				if (fac.getDatosConsumidos() > fac.getDatosContratados()) {
					DatosMedia += fac.getDatosConsumidos();
					totaldatos++;
				}
			}
			if (fac.getVozConsumida() != null && fac.getVozContratada() != null){
				if (fac.getVozConsumida() > fac.getVozContratada()) {
					VozMedia += fac.getVozConsumida();
					totalvoz++;
				}
			}
			if (fac.getEsTarde() != null){
				if (fac.getEsTarde()) {
					totaltarde++;
				}
				if (!fac.getEsTarde()) {
					totalmananas++;
				}
			}	
		}
		DatosMedia = DatosMedia / totaldatos;
		VozMedia = VozMedia / totalvoz;

		System.out.println(totaldatos);
		System.out.println(totalvoz);
		System.out.println(totaltarde);
		System.out.println(totalmananas);

		if (totaldatos > facturas.size() / 20) {
			String texto = "Se han detectado " + totaldatos
					+ " clientes que consumen más datos de los contratados, y que de media consumen " + DatosMedia
					+ " MB.";
			req.getSession().setAttribute("DatosdeMas", texto);
		}
		if (totalvoz > facturas.size() / 20) {
			String texto = "Se han detectado " + totalvoz
					+ " clientes que consumen más minutos de los contratados, y que de media consumen " + VozMedia
					+ " minutos.";
			req.getSession().setAttribute("VozdeMas", texto);
		}
		if (totaltarde > facturas.size() / 20) {
			String texto = "Se han detectado " + totaltarde
					+ " clientes que realizan llamadas exclusivamente por la tarde.";
			req.getSession().setAttribute("Tarde", texto);
		}
		if (totalmananas > facturas.size() / 20) {
			String texto = "Se han detectado " + totalmananas
					+ " clientes que realizan llamadas exclusivamente por la mañana.";
			req.getSession().setAttribute("Mananas", texto);
		}

		resp.sendRedirect("/proveedor/pages/investigacion.jsp");
	}
}