package ifactura.proveedor.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class IFactura implements Serializable {
	private static final long serialVersionUID = 01L;
	@Id
	private Long id;
	private String descripcion;
	private int numUsuarios;
	private long fechaFin;
	private double pujaActual;
	private boolean informado;
	private String ganadorActual;
	private List<String> participantes;
	
	public IFactura(Long id, String descripcion, int numUsuarios, long fechaFin, double pujaActual, String ganadorActual, List<String> participantes) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.numUsuarios = numUsuarios;
		this.fechaFin = fechaFin;
		this.pujaActual = pujaActual;
		this.informado = false;
		this.ganadorActual = ganadorActual;
		this.participantes = participantes;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDescripcion(){
		return this.descripcion;
	}
	
	public void setDescripcion(String descripcion){
		this.descripcion = descripcion;
	}

	public int getNumUsuarios() {
		return this.numUsuarios;
	}

	public void setNumUsuarios(int numUsuarios) {
		this.numUsuarios = numUsuarios;
	}

	public long getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(long fechaFin) {
		this.fechaFin = fechaFin;
	}

	public double getPujaActual() {
		return this.pujaActual;
	}

	public void setPujaActual(double pujaActual) {
		this.pujaActual = pujaActual;
	}
	
	public boolean getInformado() {
		return this.informado;
	}

	public void setInformado(boolean informado) {
		this.informado = informado;
	}

	public String getGanadorActual() {
		return this.ganadorActual;
	}

	public void setGanadorActual(String ganadorActual) {
		this.ganadorActual = ganadorActual;
	}

	public List<String> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(String participante) {
		this.participantes.add(participante);
	}
	
}