package ifactura.proveedor.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Notification implements Serializable{

	private static final long serialVersionUID = 01L;
	@Id
	private String texto;
	private String correo;
	private String imagen;
	private String titulo;
	
	
	public Notification(String correo, String texto, String titulo, String imagen) {
		super();
		this.correo = correo;
		this.texto = texto;
		this.titulo = titulo;
		this.imagen = imagen;
	}
	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto=texto;
	}
	
	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	@Override
	public String toString() {
		return "Notification [texto=" + texto + ", correo=" + correo
				+ ", imagen=" + imagen + ", titulo=" + titulo + "]";
	}
}