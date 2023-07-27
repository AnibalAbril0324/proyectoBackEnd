package ups.edu.ec.ProyectoParqueadero.Negocio;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import ups.edu.ec.ProyectoParqueadero.Datos.DAODetalleTicket;
import ups.edu.ec.ProyectoParqueadero.Modelo.DetalleTicket;


@Stateless
public class GestionDetalle {

	@Inject 
	private DAODetalleTicket daodetalleticket;
	
	public GestionDetalle() {
		
	}
	
	public List<DetalleTicket>listadodetalletickets() {
		List<DetalleTicket>listdeta=daodetalleticket.getAll();
		return listdeta;
	}
}
