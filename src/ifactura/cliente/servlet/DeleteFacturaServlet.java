package ifactura.cliente.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ifactura.cliente.dao.FacturaTelefonoDao;
import ifactura.cliente.dao.FacturaTelefonoDaoImpl;
import ifactura.cliente.dto.FacturaTelefonoDto;
import ifactura.cliente.model.FacturaTelefono;

@SuppressWarnings("serial")
public class DeleteFacturaServlet extends HttpServlet {

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		FacturaTelefonoDao facturaTelefonoDao = FacturaTelefonoDaoImpl.getInstance();
		Long idUsuario = (Long) req.getSession().getAttribute("idUser");

		RequestDispatcher view = req.getRequestDispatcher("/cliente/pages/login.jsp");

		if (req.getUserPrincipal() != null) {
			Long idFactura = Long.parseLong(req.getParameter("id"));

			facturaTelefonoDao.remove(idFactura);

			obtenerFacturasTelefono(req, facturaTelefonoDao, idUsuario);
			view = req.getRequestDispatcher("/cliente/pages/home.jsp");
		}

		try {
			view.forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Obtener facturas telefono.
	 *
	 * @param req
	 *            the req
	 * @param facturaTelefonoDao
	 *            the ifactura dao
	 * @param idUsuario
	 */
	private void obtenerFacturasTelefono(HttpServletRequest req, FacturaTelefonoDao facturaTelefonoDao,
			Long idUsuario) {
		List<FacturaTelefono> facturasTelefono = facturaTelefonoDao.getFacturasById(idUsuario);
		List<FacturaTelefonoDto> facturasObtenidas = new ArrayList<FacturaTelefonoDto>();
		if (facturasTelefono != null && !facturasTelefono.isEmpty()) {
			req.setAttribute("existenFacturasTelefono", true);
			for (FacturaTelefono factura : facturasTelefono) {
				FacturaTelefonoDto facturaDevuelta = new FacturaTelefonoDto();
				facturaDevuelta.setIdFactura(factura.getIdFactura());
				facturaDevuelta.setIdUsuario(factura.getIdUsuario());
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

				facturaDevuelta.setFechaFacturacion(formatter.format(factura.getFechaFacturacion()));
				facturaDevuelta.setDatosContratados(factura.getDatosContratados());
				facturaDevuelta.setDatosConsumidos(factura.getDatosConsumidos());
				facturaDevuelta.setImporteTotal(factura.getImporteTotal());
				facturaDevuelta.setVozConsumida(factura.getVozConsumida());
				facturaDevuelta.setVozContratada(factura.getVozContratada());
				facturaDevuelta.setEsTarde(factura.getEsTarde() ? "Tarde" : "Mañana");

				facturasObtenidas.add(facturaDevuelta);
			}
			req.setAttribute("facturasTelefono", facturasObtenidas);
		}
	}

}
