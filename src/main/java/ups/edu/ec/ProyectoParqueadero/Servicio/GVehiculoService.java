package ups.edu.ec.ProyectoParqueadero.Servicio;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import ups.edu.ec.ProyectoParqueadero.Modelo.Vehiculo;
import ups.edu.ec.ProyectoParqueadero.Negocio.GestionVehiculo;

@Path("vehiculos")
public class GVehiculoService {
	
	@Inject
	private GestionVehiculo gestionvechiculo;
	
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public Response guardarVechiculo(Vehiculo vehiculo) {
		try {
			gestionvechiculo.guardarVehiculo(vehiculo);
			return Response.status(Response.Status.OK).entity(vehiculo).build();
		} catch (Exception e) {
			e.printStackTrace();
			Error error = new Error();
			error.setError(99);
			error.setMensaje("Error al guardar: " +e.getMessage());
			return Response.status(Response.Status.OK).entity(error).build();
		}
	}
	
	@GET
	@Path("listadovehiculos")
	@Produces("application/json")
	public List<Vehiculo>listadovechiculos() {
		List<Vehiculo>vehiculos=gestionvechiculo.listadovehiculos();
		return vehiculos;
	}
}