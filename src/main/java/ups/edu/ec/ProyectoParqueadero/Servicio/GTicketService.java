package ups.edu.ec.ProyectoParqueadero.Servicio;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import ups.edu.ec.ProyectoParqueadero.Modelo.Persona;
import ups.edu.ec.ProyectoParqueadero.Modelo.Ticket;
import ups.edu.ec.ProyectoParqueadero.Negocio.GestionCliente;
import ups.edu.ec.ProyectoParqueadero.Negocio.GestionTicket;

@Path("ticket")
public class GTicketService {

	
	@Inject
	private GestionTicket gestionticket;
	
	
	@GET
	@Path("listadotickets")
	@Produces("application/json")
	public List<Ticket>listadoTickets() {
		List<Ticket>listtickets=gestionticket.listadotickets();
		
		//for(Ticket ti:listtickets) {
			//System.out.println("GTicketService====> "+ti.getCliente());
		//}
		//return null;
		return listtickets;
		
	}
}