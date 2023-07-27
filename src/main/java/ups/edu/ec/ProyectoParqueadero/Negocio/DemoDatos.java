package ups.edu.ec.ProyectoParqueadero.Negocio;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;
import ups.edu.ec.ProyectoParqueadero.Datos.DAODetalleTicket;
import ups.edu.ec.ProyectoParqueadero.Datos.DAOEstacionamiento;
import ups.edu.ec.ProyectoParqueadero.Datos.DAOPersona;
import ups.edu.ec.ProyectoParqueadero.Datos.DAOTicket;
import ups.edu.ec.ProyectoParqueadero.Datos.DAOVehiculo;
import ups.edu.ec.ProyectoParqueadero.Modelo.DetalleTicket;
import ups.edu.ec.ProyectoParqueadero.Modelo.Estacionamiento;
import ups.edu.ec.ProyectoParqueadero.Modelo.Persona;
import ups.edu.ec.ProyectoParqueadero.Modelo.Ticket;
import ups.edu.ec.ProyectoParqueadero.Modelo.Vehiculo;


@Startup
@Singleton
public class DemoDatos {

	@Inject
	private DAOPersona daopersona;
	
	@Inject
	private DAOVehiculo daovehiculo;
	
	@Inject
	private DAOEstacionamiento daoestacionamiento;
	
	@Inject
	private DAODetalleTicket daodetalleticket;
	
	@Inject
	private DAOTicket daoticket;
	
	@PostConstruct
	public void init()  {
		
		System.out.println("hola ups");
		
		Persona c= new Persona ();
		//c.setCodigo(1);
		c.setCedula("0105541510");
		c.setNombre("anibal abril");
		c.setDireccion("cuenca"); 
		daopersona.insertar(c);
		//daocliente.read("0105541510");
		
		Persona c1= new Persona ();
		//c.setCodigo(1);
		c1.setCedula("0123456789");
		c1.setNombre("Freddy Mercury");
		c1.setDireccion("baños"); 
		daopersona.insertar(c1);
		
		Persona c2= new Persona ();
		//c.setCodigo(1);
		c2.setCedula("9876543210");
		c2.setNombre("bob");
		c2.setDireccion("azuay"); 
		daopersona.insertar(c2);
		
		Persona c3= new Persona ();
		//c.setCodigo(1);
		c3.setCedula("9876543211");
		c3.setNombre("Silvia Loja");
		c3.setDireccion("San Roque"); 
		daopersona.insertar(c3);
		
		
		
		Vehiculo veh=new Vehiculo();
		veh.setColor("Rojo");
		veh.setMarca("Chevrolet");
		veh.setPlaca("AAA-123");
		daovehiculo.insertar(veh);
		
		Vehiculo veh1=new Vehiculo();
		veh1.setColor("Plomo");
		veh1.setMarca("Chevrolet");
		veh1.setPlaca("AAA-5677");
		daovehiculo.insertar(veh1);
		
		Vehiculo veh2=new Vehiculo();
		veh2.setColor("Negro");
		veh2.setMarca("Nissan");
		veh2.setPlaca("ABC-3444");
		daovehiculo.insertar(veh2);
		
		Vehiculo veh3=new Vehiculo();
		veh3.setColor("Blanco");
		veh3.setMarca("Hyundai");
		veh3.setPlaca("ACF-9878");
		daovehiculo.insertar(veh3);
		
		Estacionamiento est=new Estacionamiento();
		est.setEspacio("Ocupado");
		daoestacionamiento.insertar(est);
		
		Estacionamiento est1=new Estacionamiento();
		est1.setEspacio("Ocupado");
		daoestacionamiento.insertar(est1);
		
		Estacionamiento est2=new Estacionamiento();
		est2.setEspacio("Vacio");
		daoestacionamiento.insertar(est2);
		
		
		Ticket tic =new Ticket();
		tic.setNumero("001-001-0001");
		tic.setFecha(new Date());
		tic.setCliente(c);
		
		DetalleTicket det= new DetalleTicket();
		det.setEstacionamiento(est);
		det.setVehiculo(veh3);
		det.setHoraentrada(LocalTime.now());
		det.setHorasalida(LocalTime.now());
		daodetalleticket.insertar(det);
		
		tic.addDetalle(det);
		daoticket.insertar(tic);
		
		System.out.println("llego aqui");
		
		List<Ticket> tickets = daoticket.getAll();
		for(Ticket ti: tickets) {
			System.out.println("codigo: "+ti.getCodigo() + "ticket #: " + ti.getNumero() + "nombre cli " + ti.getCliente().getNombre() + 
					" detalles: " +" "+ti.getDetalles());
		}
	}
}
