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

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import ifactura.cliente.dao.FacturaTelefonoDao;
import ifactura.cliente.dao.FacturaTelefonoDaoImpl;
import ifactura.cliente.dao.UsuarioClienteDao;
import ifactura.cliente.dao.UsuarioClienteDaoImpl;
import ifactura.cliente.dto.FacturaTelefonoDto;
import ifactura.cliente.model.FacturaTelefono;
import ifactura.cliente.model.UsuarioCliente;

@SuppressWarnings("serial")
public class LoginClienteServlet extends HttpServlet {

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		FacturaTelefonoDao FacturaTelefonoDao = FacturaTelefonoDaoImpl.getInstance();
		UserService userService = UserServiceFactory.getUserService();
		UsuarioClienteDao usuarioClienteDao = UsuarioClienteDaoImpl.getInstance();
		String url = userService.createLoginURL(req.getRequestURI());
		String urlLinktext = "Login";
		String user = null;
		Long idUsuario = (Long) req.getSession().getAttribute("idUser");

		RequestDispatcher view = req.getRequestDispatcher("/cliente/pages/login.jsp");

		if (req.getUserPrincipal() != null) {
			user = req.getUserPrincipal().getName();

			UsuarioCliente usuarioSesion = usuarioClienteDao.getUsuarioByName(user);
			UsuarioCliente userActive = null;
			if (usuarioSesion == null) {
				UsuarioCliente newUser = new UsuarioCliente(user);
				userActive = usuarioClienteDao.create(newUser);
			} else {
				userActive = usuarioSesion;
			}

			req.getSession().setAttribute("idUser", userActive.getId());

			obtenerFacturasTelefono(req, FacturaTelefonoDao, idUsuario);

			url = userService.createLogoutURL(req.getRequestURI());
			urlLinktext = "Logout";

			view = req.getRequestDispatcher("/cliente/pages/home.jsp");

		}

		req.getSession().setAttribute("user", user);
		req.getSession().setAttribute("url", url);
		req.getSession().setAttribute("urlLinktext", urlLinktext);

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
	@SuppressWarnings("unused")
	private void saveFacturaTelefono(HttpServletRequest req, FacturaTelefonoDao FacturaTelefonoDao, Long idUsuario) {
		Double importeTotal = Double.parseDouble(req.getParameter("importeTotal"));
		Double datosContratados = Double.parseDouble(req.getParameter("datosContratados"));
		Double datosConsumidos = Double.parseDouble(req.getParameter("datosConsumidos"));
		Boolean esTarde = Boolean.parseBoolean("esTarde");
		Double vozContratada = Double.parseDouble(req.getParameter("vozContratada"));
		Double vozConsumida = Double.parseDouble(req.getParameter("vozConsumida"));

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
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
				facturaDevuelta.setEsTarde(factura.getEsTarde() ? "Tarde" : "Mañana");

				facturasObtenidas.add(facturaDevuelta);
			}
			req.setAttribute("facturasTelefono", facturasObtenidas);
		}
	}

}
