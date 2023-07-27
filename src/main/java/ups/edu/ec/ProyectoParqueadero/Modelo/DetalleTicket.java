package ups.edu.ec.ProyectoParqueadero.Modelo;

import java.time.LocalTime;

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
	private LocalTime horaentrada;
	
	@Column(name="veh_horasalida")
	private LocalTime horasalida;
	
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

	public LocalTime getHoraentrada() {
		return horaentrada;
	}

	public void setHoraentrada(LocalTime horaentrada) {
		this.horaentrada = horaentrada;
	}

	public LocalTime getHorasalida() {
		return horasalida;
	}

	public void setHorasalida(LocalTime horasalida) {
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
