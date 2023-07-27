package ups.edu.ec.ProyectoParqueadero.Servicio;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import ups.edu.ec.ProyectoParqueadero.Modelo.Estacionamiento;
import ups.edu.ec.ProyectoParqueadero.Negocio.GestionEstacionamiento;

@Path("estacionamiento")
public class GEstacionamientoService {

	@Inject
	private GestionEstacionamiento gestionEst;	
	
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public Response guardarEstacionamiento(Estacionamiento estacionamiento) {
		try {
			gestionEst.GuardarEstacionamiento(estacionamiento);
			return Response.status(Response.Status.OK).entity(estacionamiento).build();
		} catch (Exception e) {
			e.printStackTrace();
			Error error = new Error();
			error.setError(99);
			error.setMensaje("Error al guardar: " +e.getMessage());
			return Response.status(Response.Status.OK).entity(error).build();
		}
	}
	
	@GET
	@Path("listadoestacionamiento")
	@Produces("application/json")
	public List<Estacionamiento>listadoestacionamiento() {
		List<Estacionamiento>listestacionamiento=gestionEst.listadoestacionamiento();
		return listestacionamiento;
	}
}
