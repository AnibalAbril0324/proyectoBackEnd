package ups.edu.ec.ProyectoParqueadero.Negocio;

import java.util.List;


import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import ups.edu.ec.ProyectoParqueadero.Datos.DAOTicket;
import ups.edu.ec.ProyectoParqueadero.Modelo.Ticket;


@Stateless
public class GestionTicket {

	@Inject
	private DAOTicket daoticket;
	
	public List<Ticket>listadotickets() {
		//System.out.println("buscando al ticket  "+daoticket.read(1));
		
		List<Ticket>listtickets=daoticket.getAll();
		
		
		for(Ticket ti: listtickets) {
			System.out.println(" gestion ticket  "+ti.getDetalles());
										
		}
		return listtickets;
	}
	
}
