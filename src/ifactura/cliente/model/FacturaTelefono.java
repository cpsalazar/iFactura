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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datosConsumidos == null) ? 0 : datosConsumidos.hashCode());
		result = prime * result + ((datosContratados == null) ? 0 : datosContratados.hashCode());
		result = prime * result + ((esTarde == null) ? 0 : esTarde.hashCode());
		result = prime * result + ((fechaFacturacion == null) ? 0 : fechaFacturacion.hashCode());
		result = prime * result + ((idFactura == null) ? 0 : idFactura.hashCode());
		result = prime * result + ((idUsuario == null) ? 0 : idUsuario.hashCode());
		result = prime * result + ((importeTotal == null) ? 0 : importeTotal.hashCode());
		result = prime * result + ((vozConsumida == null) ? 0 : vozConsumida.hashCode());
		result = prime * result + ((vozContratada == null) ? 0 : vozContratada.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FacturaTelefono other = (FacturaTelefono) obj;
		if (datosConsumidos == null) {
			if (other.datosConsumidos != null)
				return false;
		} else if (!datosConsumidos.equals(other.datosConsumidos))
			return false;
		if (datosContratados == null) {
			if (other.datosContratados != null)
				return false;
		} else if (!datosContratados.equals(other.datosContratados))
			return false;
		if (esTarde == null) {
			if (other.esTarde != null)
				return false;
		} else if (!esTarde.equals(other.esTarde))
			return false;
		if (fechaFacturacion == null) {
			if (other.fechaFacturacion != null)
				return false;
		} else if (!fechaFacturacion.equals(other.fechaFacturacion))
			return false;
		if (idFactura == null) {
			if (other.idFactura != null)
				return false;
		} else if (!idFactura.equals(other.idFactura))
			return false;
		if (idUsuario == null) {
			if (other.idUsuario != null)
				return false;
		} else if (!idUsuario.equals(other.idUsuario))
			return false;
		if (importeTotal == null) {
			if (other.importeTotal != null)
				return false;
		} else if (!importeTotal.equals(other.importeTotal))
			return false;
		if (vozConsumida == null) {
			if (other.vozConsumida != null)
				return false;
		} else if (!vozConsumida.equals(other.vozConsumida))
			return false;
		if (vozContratada == null) {
			if (other.vozContratada != null)
				return false;
		} else if (!vozContratada.equals(other.vozContratada))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FacturaTelefono [idFactura=" + idFactura + ", fechaFacturacion=" + fechaFacturacion
				+ ", datosContratados=" + datosContratados + ", datosConsumidos=" + datosConsumidos + ", vozContratada="
				+ vozContratada + ", vozConsumida=" + vozConsumida + ", importeTotal=" + importeTotal + ", idUsuario="
				+ idUsuario + ", esTarde=" + esTarde + "]";
	}

}