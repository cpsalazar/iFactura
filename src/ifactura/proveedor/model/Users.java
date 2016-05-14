package ifactura.proveedor.model;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Users implements Serializable{
	
	private static final long serialVersionUID = 01L;
	@Id @OneToMany
	private String correo;
	private String compania;
	
	public Users(String correo, String compania) {
		super();
		this.correo = correo;
		this.compania = compania;
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
	
	
}
