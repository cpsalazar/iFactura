package ifactura.cliente.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
public class NewFacturaServlet extends HttpServlet {

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
			saveFacturaTelefono(req, facturaTelefonoDao, idUsuario);
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
	 * Save factura telefono.
	 *
	 * @param req
	 *            the req
	 * @param FacturaTelefonoDao
	 *            the i factura dao
	 * @param idUsuario
	 */
	private void saveFacturaTelefono(HttpServletRequest req, FacturaTelefonoDao FacturaTelefonoDao, Long idUsuario) {
		Double importeTotal = Double.parseDouble(req.getParameter("importeTotal"));
		Double datosContratados = Double.parseDouble(req.getParameter("datosContratados"));
		Double datosConsumidos = Double.parseDouble(req.getParameter("datosConsumidos"));
		Boolean esTarde = Boolean.parseBoolean("esTarde");
		Double vozContratada = Double.parseDouble(req.getParameter("vozContratada"));
		Double vozConsumida = Double.parseDouble(req.getParameter("vozConsumida"));

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaFacturacion = new Date();
		try {
			fechaFacturacion = formatter.parse(req.getParameter("fechaFacturacion"));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		FacturaTelefono newFacturaTelefono = new FacturaTelefono();
		newFacturaTelefono.setIdUsuario(idUsuario);
		newFacturaTelefono.setImporteTotal(importeTotal);
		newFacturaTelefono.setDatosContratados(datosContratados);
		newFacturaTelefono.setDatosConsumidos(datosConsumidos);
		newFacturaTelefono.setEsTarde(esTarde);
		newFacturaTelefono.setVozContratada(vozContratada);
		newFacturaTelefono.setVozConsumida(vozConsumida);
		newFacturaTelefono.setFechaFacturacion(fechaFacturacion);

		FacturaTelefonoDao.create(newFacturaTelefono);

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
				facturaDevuelta.setEsTarde(factura.getEsTarde());

				facturasObtenidas.add(facturaDevuelta);
			}
			req.setAttribute("facturasTelefono", facturasObtenidas);
		}
	}

}
