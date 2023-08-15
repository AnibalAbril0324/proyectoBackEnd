package ups.edu.ec.ProyectoParqueadero.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Vehiculo {
	
	@Id
	@GeneratedValue
	@Column(name="veh_codigo")
	private int codigo;
	
	@Column(name="veh_color")
	private String color;
	
	@Column(name="veh_marca")
	private String marca;
	
	@Column(name="veh_placa")
	private String placa;
	
	@OneToOne
	@JoinColumn(name="per_cedula")
	private Persona persona;

	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@Override
	public String toString() {
		return "Vehiculo [codigo=" + codigo + ", color=" + color + ", marca=" + marca + ", placa=" + placa
				+ ", persona=" + persona + "]";
	}
		
}
