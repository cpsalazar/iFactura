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
	private Float datosContradados;

	/** The datos consumidos. */
	private Float datosConsumidos;

	/** The voz contradada. */
	private Float vozContradada;

	/** The voz consumida. */
	private Float vozConsumida;

	/** The importe total. */
	private Float importeTotal;

	/** The id usuario. */
	private Long idUsuario;

	/** The es tarde. */
	private Boolean esTarde;

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
	public Float getDatosContradados() {
		return datosContradados;
	}

	/**
	 * Sets the datos contradados.
	 *
	 * @param datosContradados
	 *            the datosContradados to set
	 */
	public void setDatosContradados(Float datosContradados) {
		this.datosContradados = datosContradados;
	}

	/**
	 * Gets the datos consumidos.
	 *
	 * @return the datosConsumidos
	 */
	public Float getDatosConsumidos() {
		return datosConsumidos;
	}

	/**
	 * Sets the datos consumidos.
	 *
	 * @param datosConsumidos
	 *            the datosConsumidos to set
	 */
	public void setDatosConsumidos(Float datosConsumidos) {
		this.datosConsumidos = datosConsumidos;
	}

	/**
	 * Gets the voz contradada.
	 *
	 * @return the vozContradada
	 */
	public Float getVozContradada() {
		return vozContradada;
	}

	/**
	 * Sets the voz contradada.
	 *
	 * @param vozContradada
	 *            the vozContradada to set
	 */
	public void setVozContradada(Float vozContradada) {
		this.vozContradada = vozContradada;
	}

	/**
	 * Gets the voz consumida.
	 *
	 * @return the vozConsumida
	 */
	public Float getVozConsumida() {
		return vozConsumida;
	}

	/**
	 * Sets the voz consumida.
	 *
	 * @param vozConsumida
	 *            the vozConsumida to set
	 */
	public void setVozConsumida(Float vozConsumida) {
		this.vozConsumida = vozConsumida;
	}

	/**
	 * Gets the importe total.
	 *
	 * @return the importeTotal
	 */
	public Float getImporteTotal() {
		return importeTotal;
	}

	/**
	 * Sets the importe total.
	 *
	 * @param importeTotal
	 *            the importeTotal to set
	 */
	public void setImporteTotal(Float importeTotal) {
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