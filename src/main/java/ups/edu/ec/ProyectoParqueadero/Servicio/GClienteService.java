package ups.edu.ec.ProyectoParqueadero.Servicio;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import ups.edu.ec.ProyectoParqueadero.Modelo.Persona;
import ups.edu.ec.ProyectoParqueadero.Negocio.GestionCliente;


@Path("clientes")
public class GClienteService {
	
	@Inject
	private GestionCliente gestioncliente;
	
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public Response guardarCliente(Persona persona) {
		try {
			gestioncliente.guardarPersona(persona);
			return Response.status(Response.Status.OK).entity(persona).build();
		} catch (Exception e) {
			e.printStackTrace();
			Error error = new Error();
			error.setError(99);
			error.setMensaje("Error al guardar: " +e.getMessage());
			return Response.status(Response.Status.OK).entity(error).build();
		}
	}
	

	@DELETE
	@Path("eliminar")
	@Produces("application/json")
	@Consumes("application/json")
	public Response eliminar(@QueryParam("cedula")String cedula) {
		try {
			
			gestioncliente.eliminarPersona(cedula);
			System.out.println("se elimino");
			return Response.status(Response.Status.OK).entity("Persona eliminda con cedula="+cedula).build();
		} catch (Exception e) {
			//e.printStackTrace();
			Error error = new Error();
			error.setError(99);
			error.setMensaje("Error al eliminar: ");
			System.out.println(error);
			return Response.status(Response.Status.OK).entity(error).build();
		}
	}
	
	
	@GET
	@Path("listado")
	@Produces("application/json")
	public List<Persona>listadopersonas() {
		List<Persona>personas=gestioncliente.listadopersonas();
		return personas;
	}
	
	@GET
	@Path("all")
	@Produces("application/json")
	public Response getClientes() {
		List<Persona> listado = gestioncliente.listadopersonas();
		return Response.status(Response.Status.OK).entity(listado).build();
	}
}