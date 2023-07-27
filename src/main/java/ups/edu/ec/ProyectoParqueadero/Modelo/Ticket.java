package ups.edu.ec.ProyectoParqueadero.Modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;


@Entity
public class Ticket {

	@Id
	@GeneratedValue
	@Column(name="tic_codigo")
	private int codigo;
	
	@Column(name="tic_numero")
	private String numero;
	
	@Column(name="tic_fecha")
	private Date fecha;
	
	@OneToOne
	@JoinColumn(name="per_cedula")
	private Persona cliente;
	
	//@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="tic_codigo")
	private List<DetalleTicket> detalles;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Persona getCliente() {
		return cliente;
	}

	public void setCliente(Persona cliente) {
		this.cliente = cliente;
	}

	public List<DetalleTicket> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleTicket> detalles) {
		this.detalles = detalles;
	}
	
	public void addDetalle(DetalleTicket detalleticket) {
		if(detalles==null)
			detalles= new ArrayList<DetalleTicket>();
		detalles.add(detalleticket);
	}
	
	@Override
	public String toString() {
		return "Ticket [codigo=" + codigo + ", numero=" + numero + ", fecha=" + fecha + ", cliente=" + cliente
				+ ", detalles=" + detalles + "]";
	}
	
}