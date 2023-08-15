package ups.edu.ec.ProyectoParqueadero.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;


@Entity
public class DetalleTicket {

	@Id
	@GeneratedValue
	@Column(name="det_codigo")
	private int codigo;
		
	@Column(name="veh_horaentrada")
	private String horaentrada;
	
	@Column(name="veh_horasalida")
	private String horasalida;
	
	@OneToOne
	@JoinColumn(name="est_codigo")
	private Estacionamiento estacionamiento;
	
	@OneToOne
	@JoinColumn(name="veh_codigo")
	private Vehiculo vehiculo;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getHoraentrada() {
		return horaentrada;
	}

	public void setHoraentrada(String horaentrada) {
		this.horaentrada = horaentrada;
	}

	public String getHorasalida() {
		return horasalida;
	}

	public void setHorasalida(String horasalida) {
		this.horasalida = horasalida;
	}

	public Estacionamiento getEstacionamiento() {
		return estacionamiento;
	}

	public void setEstacionamiento(Estacionamiento estacionamiento) {
		this.estacionamiento = estacionamiento;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	@Override
	public String toString() {
		return "DetalleTicket [codigo=" + codigo + ", horaentrada=" + horaentrada + ", horasalida=" + horasalida
				+ ", estacionamiento=" + estacionamiento + ", vehiculo=" + vehiculo + "]";
	}

}
