package ups.edu.ec.ProyectoParqueadero.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Estacionamiento {
	
	@Id
	@GeneratedValue
	@Column(name="est_codigo")
	private int codigo;
	
	@Column(name="est_espacio")
	private String espacio;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getEspacio() {
		return espacio;
	}

	public void setEspacio(String espacio) {
		this.espacio = espacio;
	}

	@Override
	public String toString() {
		return "Estacionamiento [codigo=" + codigo + ", espacio=" + espacio + "]";
	}

	
}
