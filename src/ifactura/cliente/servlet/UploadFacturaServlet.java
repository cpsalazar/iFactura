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
public class UploadFacturaServlet extends HttpServlet {

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
			uploadFacturaTelefono(req, facturaTelefonoDao, idUsuario);
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
	private void uploadFacturaTelefono(HttpServletRequest req, FacturaTelefonoDao FacturaTelefonoDao, Long idUsuario) {
		Double importeTotal = null;
		Double datosContratados = null;
		Double datosConsumidos = null;
		Boolean esTarde = null;
		Double vozConsumida = null;
		Double vozContratada = null;
		Date fechaFacturacion = null;
		String arrayData[] = req.getParameterValues("arraydata[]");
		if (arrayData != null) {
			int size = arrayData.length;
			for (int i = 0; i <= size - 1; i++) {
				String[] obtenido = arrayData[i].split(":");
				String[] datos = null;
				if (obtenido.length == 2) {
					switch (obtenido[0]) {
					case "Importe":
						datos = obtenido[1].trim().split(" ");
						importeTotal = Double.parseDouble(datos[0]);
						break;
					case "Datos Contratados":
						datos = obtenido[1].trim().split(" ");
						datosContratados = Double.parseDouble(datos[0]);
						break;
					case "Datos Consumidos":
						datos = obtenido[1].trim().split(" ");
						datosConsumidos = Double.parseDouble(datos[0]);
						break;
					case "Voz Contratada":
						datos = obtenido[1].trim().split(" ");
						vozContratada = Double.parseDouble(datos[0]);
						break;
					case "Voz Consumida":
						datos = obtenido[1].trim().split(" ");
						vozConsumida = Double.parseDouble(datos[0]);
						break;
					case "Horario":
						if (obtenido[1].trim().equalsIgnoreCase("Tarde")) {
							esTarde = true;
						} else {
							esTarde = false;
						}
						break;
					case "Fecha Emision":
						String fecha = obtenido[1].trim();
						SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
						try {
							fechaFacturacion = formatter.parse(fecha);
						} catch (ParseException e) {
							e.printStackTrace();
						}
						break;

					default:
						break;
					}
				}
			}

		}
		if (idUsuario != null && importeTotal != null && datosContratados != null && datosConsumidos != null
				&& esTarde != null && vozContratada != null && vozConsumida != null && fechaFacturacion != null) {
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
