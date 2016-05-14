package ifactura.proveedor.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Peticiones implements Serializable{
	
	private static final long serialVersionUID = 01L;
	@Id 
	private String peticion; //la peticion en si.
	private String compania; //compañía asociada al autor.
	private String correo; //el que envía la petición.
	
	public Peticiones(String correo, String compania, String peticion) {
		super();
		this.correo = correo;
		this.compania = compania;
		this.peticion = peticion;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public String getCompania() {
		return compania;
	}

	public void setCompania(String compania) {
		this.compania = compania;
	}

	public String getPeticion() {
		return peticion;
	}

	public void setPeticion(String peticion) {
		this.peticion = peticion;
	}
	
	
}
