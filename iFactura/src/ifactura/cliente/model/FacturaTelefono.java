package ifactura.cliente.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * The Class FacturaTelefono.
 */
@Entity
public class FacturaTelefono implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long idFactura;

	/** The fecha facturacion. */
	private Date fechaFacturacion;

	/** The datos contradados. */
	private Double datosContratados;

	/** The datos consumidos. */
	private Double datosConsumidos;

	/** The voz contradada. */
	private Double vozContratada;

	/** The voz consumida. */
	private Double vozConsumida;

	/** The importe total. */
	private Double importeTotal;

	/** The id usuario. */
	private Long idUsuario;

	/** The es tarde. */
	private Boolean esTarde;

	public FacturaTelefono() {
	}

	public FacturaTelefono(Date fechaFacturacion, Double datosContradados, Double datosConsumidos, Double vozContratada,
			Double vozConsumida, Double importeTotal, Long idUsuario, Boolean esTarde) {
		super();
		this.fechaFacturacion = fechaFacturacion;
		this.datosContratados = datosContradados;
		this.datosConsumidos = datosConsumidos;
		this.vozContratada = vozContratada;
		this.vozConsumida = vozConsumida;
		this.importeTotal = importeTotal;
		this.idUsuario = idUsuario;
		this.esTarde = esTarde;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getIdFactura() {
		return idFactura;
	}

	/**
	 * Sets the id.
	 *
	 * @param idFactura
	 *            the id to set
	 */
	public void setIdFactura(Long idFactura) {
		this.idFactura = idFactura;
	}

	/**
	 * Gets the fecha facturacion.
	 *
	 * @return the fechaFacturacion
	 */
	public Date getFechaFacturacion() {
		return fechaFacturacion;
	}

	/**
	 * Sets the fecha facturacion.
	 *
	 * @param fechaFacturacion
	 *            the fechaFacturacion to set
	 */
	public void setFechaFacturacion(Date fechaFacturacion) {
		this.fechaFacturacion = fechaFacturacion;
	}

	/**
	 * Gets the datos contradados.
	 *
	 * @return the datosContradados
	 */
	public Double getDatosContratados() {
		return datosContratados;
	}

	/**
	 * Sets the datos contradados.
	 *
	 * @param datosContratados
	 *            the datosContradados to set
	 */
	public void setDatosContratados(Double datosContratados) {
		this.datosContratados = datosContratados;
	}

	/**
	 * Gets the datos consumidos.
	 *
	 * @return the datosConsumidos
	 */
	public Double getDatosConsumidos() {
		return datosConsumidos;
	}

	/**
	 * Sets the datos consumidos.
	 *
	 * @param datosConsumidos
	 *            the datosConsumidos to set
	 */
	public void setDatosConsumidos(Double datosConsumidos) {
		this.datosConsumidos = datosConsumidos;
	}

	/**
	 * Gets the voz contradada.
	 *
	 * @return the vozContradada
	 */
	public Double getVozContratada() {
		return vozContratada;
	}

	/**
	 * Sets the voz contradada.
	 *
	 * @param vozContratada
	 *            the vozContradada to set
	 */
	public void setVozContratada(Double vozContratada) {
		this.vozContratada = vozContratada;
	}

	/**
	 * Gets the voz consumida.
	 *
	 * @return the vozConsumida
	 */
	public Double getVozConsumida() {
		return vozConsumida;
	}

	/**
	 * Sets the voz consumida.
	 *
	 * @param vozConsumida
	 *            the vozConsumida to set
	 */
	public void setVozConsumida(Double vozConsumida) {
		this.vozConsumida = vozConsumida;
	}

	/**
	 * Gets the importe total.
	 *
	 * @return the importeTotal
	 */
	public Double getImporteTotal() {
		return importeTotal;
	}

	/**
	 * Sets the importe total.
	 *
	 * @param importeTotal
	 *            the importeTotal to set
	 */
	public void setImporteTotal(Double importeTotal) {
		this.importeTotal = importeTotal;
	}

	/**
	 * @return the idUsuario
	 */
	public Long getIdUsuario() {
		return idUsuario;
	}

	/**
	 * @param idUsuario
	 *            the idUsuario to set
	 */
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	/**
	 * Gets the es tarde.
	 *
	 * @return the esTarde
	 */
	public Boolean getEsTarde() {
		return esTarde;
	}

	/**
	 * Sets the es tarde.
	 *
	 * @param esTarde
	 *            the esTarde to set
	 */
	public void setEsTarde(Boolean esTarde) {
		this.esTarde = esTarde;
	}

}