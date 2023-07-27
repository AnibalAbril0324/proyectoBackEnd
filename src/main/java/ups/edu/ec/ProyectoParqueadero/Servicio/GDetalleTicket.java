package ups.edu.ec.ProyectoParqueadero.Servicio;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import ups.edu.ec.ProyectoParqueadero.Modelo.DetalleTicket;
import ups.edu.ec.ProyectoParqueadero.Negocio.GestionDetalle;

@Path("detalles")
public class GDetalleTicket {

	@Inject
	private GestionDetalle gestiondetalleticket;	
	
	@GET
	@Path("listadodetalles")
	@Produces("application/json")
	public List<DetalleTicket>listadodetalles() {
		List<DetalleTicket>listdetalle=gestiondetalleticket.listadodetalletickets();
		return listdetalle;
	}
}